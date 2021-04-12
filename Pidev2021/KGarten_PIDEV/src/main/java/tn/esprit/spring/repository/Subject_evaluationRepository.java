package tn.esprit.spring.repository;



import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.Subject;
import tn.esprit.spring.entity.Subject_evaluation;
@Repository
public interface Subject_evaluationRepository extends CrudRepository<Subject_evaluation,Long> {
	
	@Query("select max(s.value) from Subject_evaluation s where s.subject=:varsub")
	 public int maxrate(@Param("varsub") Subject varsub);
	
	@Query("select min(s.value) from Subject_evaluation s where s.subject=:varsub")
	 public int minrate(@Param("varsub") Subject varsub);
	
	@Query("select distinct(s.subject) from Subject_evaluation s")
	 public List<Subject> Listsubev();
	
	 
	
	 
	
	 
	 
	 

	
}



