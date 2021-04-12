package tn.esprit.spring.sevice.interfece;

import java.util.List;


import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.entity.ClaimCategory;
import tn.esprit.spring.entity.ClaimEvaluation;
import tn.esprit.spring.entity.Comment_evaluation;
import tn.esprit.spring.entity.Kindergarten;






public interface IClaimService {
	public long addClaim(Claim claim);
	public void deleteClaimById(long claimId);
	public List<Claim> getAllClaims();
	public int CountSkipedClaimByKindergarden(String name);
	String addClaimDict(Claim claim, Long sub_id) ;
	public List<Claim> getRecentClaim() ;
	public List filterClaim(ClaimCategory category);
	public void addEv(ClaimEvaluation e, Long id);
	public List<Claim> AcceptableClaims();
	public int CountProcessingClaimByKindergarden(String name);
	public int CountClaimByKindergarden(String k );
	public List<Claim> getClaimByKindergarden(String k);
	public boolean isKindergarden(String kindergarden);
	public void blockSubscription(String kinder);
	public void unBlockSubscription(String kinder);
	//public void Sendmail( String name ); 
	
	
	
}
