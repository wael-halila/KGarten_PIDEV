package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.entity.ClaimCategory;
import tn.esprit.spring.entity.ClaimStatus;



@Repository
public interface ClaimRepository extends CrudRepository<Claim, Long> {
	   @Query("SELECT count(*) FROM Claim")
	   int countClaims();
	  
	    @Modifying
	    @Transactional
	    @Query("DELETE from Claim")
	    void deleteAllClaimsJPQL();
	    
	    @Query("select c from Claim c where CURRENT_DATE - c.dateClaim <=:mydate")
	    public List<Claim> getRecentClaim(@Param("mydate") Double mydate);
	    
	    @Query("SELECT ff FROM Claim ff WHERE ff.category=:category")
		List<Claim> filterByCategory(@Param ("category") ClaimCategory category);

	  

		@Query("SELECT c FROM Claim c WHERE c.kindergarten.name =:name")
		public List<Claim> getClaimByKindergarden(@Param("name")String k);

		

		@Query("SELECT count(k) FROM Kindergarten k WHERE k.name =:name")
        public int iskindergarden(@Param("name")String kindergarden);
		
		@Query("SELECT c FROM Claim c WHERE c.kindergarten.name =:name and c.status=:status")
		public List<Claim> getClaimByKindergardenAndStatus(@Param("name")String name,@Param("status") ClaimStatus status   );
		

	
		
}
