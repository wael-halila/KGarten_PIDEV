package tn.esprit.spring.sevice.impl;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.entity.ClaimCategory;
import tn.esprit.spring.entity.ClaimEvaluation;
import tn.esprit.spring.entity.ClaimStatus;
import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Comment_evaluation;
import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Subject;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.ClaimEvRepository;
import tn.esprit.spring.repository.ClaimRepository;
import tn.esprit.spring.repository.DictionaryRepository;
import tn.esprit.spring.repository.KindergartenRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.sevice.interfece.IClaimService;


@Service
public class ClaimServiceImpl implements IClaimService{
	public String msg;
	@Autowired
	ClaimRepository claimrepo;
	@Autowired
	SubjectService subserv ;
	@Autowired
	DictionaryRepository dictrepo	;
	@Autowired
	UserRepository userepo ;
	@Autowired
	ClaimEvRepository claimevrepo;
	@Autowired
	KindergartenRepository kinderrepo; 
	

	 private final static String ACCOUNT_SID = "AC6241403c506f64570e2eead5494891f0";
	   private final static String AUTH_ID = "2d6c0633c8bd526f6919c27dbefd0530";

	@Override
	public long addClaim(Claim claim) {
		claimrepo.save(claim);
		return claim.getId();
	}

	@Override
	public void deleteClaimById(long claimId) {
		Claim claim = claimrepo.findById(claimId).get();
		claimrepo.delete(claim);
	}

	@Override
	public List<Claim> getAllClaims() {
		return (List <Claim>) claimrepo.findAll();
	}

	

	@Override
	public String addClaimDict(Claim claim, Long sub_id) {
		
         Subject s = subserv.findbyid(sub_id);
		
         claim.setSubject(s);
		 if(claim.getMot().equals("")) {	
				msg= "This is  an empty claim . please try to send a constructive one " ;
			}
		 else {
		
			 //dictionary//
		List<String> mydictionary = dictrepo.dictionaryList();
		ArrayList<String> listOfStrings = new ArrayList<>(mydictionary.size());
		listOfStrings.addAll(mydictionary);
		     //liste des mots du commentaire
		String[] words = claim.getMot().split("\\s+");
			for (int i = 0; i < words.length; i++) {
			    
			words[i] = words[i].replaceAll("[^\\w]", "");
				
			
			}
			boolean found = false;
			
			for (String element:words ) {
				for(String elt:listOfStrings) {	
					
					if ( (elt.trim()).equals(element)) {
				        found = true;
				        msg= "This word can't be inserted . Your claim won't be sent  : " + element ;
					}
					}}
	 if(!found) {	
			
		    claimrepo.save(claim); 
	 		msg= "Success . we gonna treat your claim as soon as possible ";
			 } }
		
	return msg ;
	
	}

	@Override
	public List<Claim> getRecentClaim() {
		
		Double mydate = (double) 3;
		return claimrepo.getRecentClaim(mydate);
	}
	@Override
	public List filterClaim(ClaimCategory claim_type) {
		return  claimrepo.filterByCategory(claim_type);
		
	}


	@Transactional
	public void addEv(ClaimEvaluation e, Long id) {
		

				Claim c = claimrepo.findById(id).get();
				
				List<Claim> l = claimevrepo.evsave();

				if (l.contains(c)) {
					ClaimEvaluation v = claimevrepo.findev(c);
					
					v.setD(v.getD() + e.getD());
					
					v.setVd(v.getVd() + e.getVd());
					v.setM(v.getM() + e.getM());
					claimevrepo.save(v);

				
				}else {

					e.setClaim(c);
					claimevrepo.save(e);
				}

			}
	@Override
	public List<Claim> AcceptableClaims() {
		List<Claim> list1 = claimevrepo.myfind(claimevrepo.accept1(), claimevrepo.accept2());
		return list1;
	}

	

	@Override
	public int CountClaimByKindergarden(String k) {
		List<Claim> claim = (List<Claim>) claimrepo.getClaimByKindergarden(k);
		
		return claim.size() ;
		
		
		
		   
		  
	}
	
	
	
    public boolean isKindergarden(String kindergarden){
		
		if(claimrepo.iskindergarden(kindergarden)==0)
			return false;
		else

		return true;
	}

	@Override
	public List<Claim> getClaimByKindergarden(String k) {
		
		return claimrepo.getClaimByKindergarden(k);
	}

	@Override
	public int CountSkipedClaimByKindergarden(String name) {
		List <Claim> claim=(List<Claim>) claimrepo.getClaimByKindergardenAndStatus(name, ClaimStatus.skipped);
		return claim.size();
	}

	@Override
	public int CountProcessingClaimByKindergarden(String name) {
		List <Claim> claim=(List<Claim>) claimrepo.getClaimByKindergardenAndStatus(name,ClaimStatus.processing);
		return claim.size();
	}
	@Override
	public void blockSubscription(String kinder) {
		Kindergarten k=kinderrepo.findByName(kinder);
		
		
		User us =userepo.findByidUser(k.getUser().getIdUser());
		int nb =0;
			 nb=(CountClaimByKindergarden( k.getName()));
			
			if (nb>=2){
				
				k.setBlocked(true);
				k.setBlockDate(LocalDate.now());
				kinderrepo.save(k) ;  
				
				
				}
			
	}

	@Override
	public void unBlockSubscription(String kinder) {
       Kindergarten k=kinderrepo.findByName(kinder);
		
		
		User us =userepo.findByidUser(k.getUser().getIdUser());

			System.out.println("user= +++++" + us.getFirstName());
			System.out.println("kinder= +++++" + k.getName());

			k.setUnBlockDate(LocalDate.now());

			
				k.setBlocked(false);
				userepo.save(us);

				Twilio.init(ACCOUNT_SID, AUTH_ID);
				Message.creator(new PhoneNumber(k.getTelNum()), new PhoneNumber("+18563932333"),
				  "Dear Kindergarten  Your subscription with us is unblocked now, please respect our conditions to keep your kindergarden on our platform.").create();

		
	}
/*
	@Override
	public void Sendmail( String name) {
		Kindergarten k=kinderrepo.findByName(name);
		int nb =0;
		 nb=(CountClaimByKindergarden( k.getName()));
		 if (nb>=3){
				
				ms.sendEmail( name);
				
				kinderrepo.save(k) ;  
				
				
				}
		

	@Override
	public void Sendmail(String name) {
		// TODO Auto-generated method stub
		
	}*/
		
	}

	

	

	
	

	

	



	

	
