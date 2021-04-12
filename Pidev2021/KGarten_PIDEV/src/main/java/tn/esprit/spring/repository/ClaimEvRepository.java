package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Claim;
import tn.esprit.spring.entity.ClaimEvaluation;



@Repository
public interface ClaimEvRepository extends CrudRepository<ClaimEvaluation, Long> {
	@Query("select distinct e.claim from ClaimEvaluation e ")
	public List<Claim> evsave();
	@Query("select e from ClaimEvaluation e where e.claim=:claim")
	public ClaimEvaluation findev(@Param("claim") Claim claim);
	@Query("select max(e.d) from ClaimEvaluation e")
	public int accept1();
	@Query("select max(e.m) from ClaimEvaluation e")
	public int accept2();
	@Query("select e.claim from ClaimEvaluation e where e.d=:nbrd or e.m=:nbrm")
	public List<Claim> myfind(@Param("nbrd") int nbrd, @Param("nbrm") int nbrm);
	
	
	
}
