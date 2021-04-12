package tn.esprit.spring.controller;

import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.entity.ClaimCategory;
import tn.esprit.spring.entity.ClaimEvaluation;
import tn.esprit.spring.sevice.impl.ClaimServiceImpl;
import tn.esprit.spring.sevice.impl.KindergartenServiceImpl;
import tn.esprit.spring.sevice.interfece.IClaimService;

@CrossOrigin("*")
@RestController
@RequestMapping("/Claim")
public class RestControllerClaim {
	@Autowired
	IClaimService iClaimSer; 

	@Autowired
	ClaimServiceImpl claimService;
	@Autowired
	KindergartenServiceImpl kinderService; 
	

// URL: http://localhost:8089/Pidev/servlet/addClaim
	@PostMapping("/addClaim")
	@ResponseBody
	public Claim addClaim(@RequestBody Claim claim)
	{
		iClaimSer.addClaim(claim);
		return claim;

}
	// URL: http://localhost:8089/Pidev/servlet/deleteClaimById/{idclaim}
	@DeleteMapping("/deleteClaimById/{idclaim}") 
	@ResponseBody
	public void deleteClaimById(@PathVariable("idclaim")int claimId) {
		iClaimSer.deleteClaimById(claimId);
	}
	
	// URL: http://localhost:8089/Pidev/servlet/getAllClaims
	 @GetMapping(value = "/getAllClaims")
	    @ResponseBody
		public List<Claim> getAllClaims() {
			List<Claim> c = claimService.getAllClaims();
			return c;
		}
	
	//URL : http://localhost:8089/Pidev/servlet/addClaimDict/{subjectId}
			@PostMapping("/addClaimDict/{subjectId}")
			@ResponseBody
			public String  addClaimDict
			(@RequestBody Claim c,@PathVariable("subjectId") Long subjectId) 
				{
				
				String msg = claimService.addClaimDict(c, subjectId);
				return msg ;

			    }
		// 	URL : http://localhost:8089/Pidev/servlet/getRecentClaim
        @GetMapping("/getRecentClaim")
        @ResponseBody
        public List<Claim> getRecentClaim() {
	     List<Claim> list = claimService.getRecentClaim();
         return list;
}
//     	URL : http://localhost:8089/Pidev/servlet/retrieve-Claims-ByCategory/{claimType}
      
        @GetMapping("/retrieve-Claims-ByCategory/{category}")
    	public List<Claim> findClaimByCategory(@PathVariable ClaimCategory category) {
    		List<Claim> list = claimService.filterClaim(category);
    		return list;
        }
       
        //EVALUATION 
        @PostMapping("/evaluate/{claimId}")
        @ResponseBody
        public Response addevaluation(@RequestBody ClaimEvaluation u,@PathVariable("claimId") Long claimId) {
        	
        	claimService.addEv(u, claimId);
        return Response.status(Status.OK).entity(" Success").build();

            }
        
        //AcceptableClaims
        @GetMapping("/AcceptableClaims")
        @ResponseBody
         public List<Claim> Acceptable() {
        	return claimService.AcceptableClaims();

}
        // Afficher les reclamations by name kinder
        @GetMapping("/retrieve-claim-kindergarden/{name}")
		public String getClaimByKindergarden(@PathVariable String name) {
		
		if (claimService.isKindergarden(name)){
			List<Claim> claim = claimService.getClaimByKindergarden(name);
			
			
			if(!claim.isEmpty())
				return claim.toString();
				
			else
			return "No Claim found for this kindergarden";
			
		}
		return "Sorry this kindergarden name not found.";
		
	}
        //afficher le nb des reclamations by name kinder
        @GetMapping("/kindergarden-Claims-number/{name}")
		 @ResponseBody
		public int CountClaimByKindergarden(@PathVariable String name) {
			 
				return claimService.CountClaimByKindergarden(name);
				
			}
        // afficher nb skipped claims 
        @GetMapping("/kindergarden-skipped-claims/{name}")
   	 @ResponseBody
   	public int CountSkipedClaimByKindergarden(@PathVariable String name) {
   		 
   			return claimService.CountSkipedClaimByKindergarden(name);
   		}
   		
   	
   
     // afficher nb processing claims 
   	@GetMapping("/kindergarden-processing-claims/{name}")
   	 @ResponseBody
   	public int CountProcessingClaimByKindergarden(@PathVariable String name) {
   		 
   			return claimService.CountProcessingClaimByKindergarden(name);
   		}
   	// bloquer kinder inscription
	//URL : http://localhost:8089/Pidev/servlet/blocksubscription/{name}
   	@PostMapping("/blocksubscription/{name}")
	 @ResponseBody
	public  void blockSubscription(@PathVariable String name) {
	
		claimService.blockSubscription(name);
	
		
		 		}
	// deblocker kinder inscription
          @PostMapping("/unblocksubscription/{name}")
           @ResponseBody
            public void unBlockSubscription(@PathVariable String name) {

	          claimService.unBlockSubscription(name);
}
          // 
        /*  @PostMapping("/send-mail")
      	public String send() {

      		  kindergarten.setName("");
      		
      		kindergarten.setMail("siwar.awadhi1@esprit.tn"); //Receiver's email address

      		/*
      		 * Here we will call sendEmail() for Sending mail to the sender.
      		 
      		try {
      			mailService.sendEmail(kindergarten);
      		} catch (MailException mailException) {
      			System.out.println(mailException);
      		}
      		return "Congratulations! Your mail has been sent to the kindergarten.";
      	}  
          //SENDMAIL
          @PostMapping("/sendmail")
     	 @ResponseBody
     	public  void sendMail(@PathVariable String name) {
                  
     		mailService.sendEmail( name);
     	
          }*/
          
			
}