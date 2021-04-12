package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Comment_evaluation;





@Repository
public interface Comment_evaluationRepository extends CrudRepository<Comment_evaluation,Long>{
	
	@Query("select distinct e.comment from Comment_evaluation e ")
	public List<Comment> evsave();
	
	@Query("select e from Comment_evaluation e where e.comment=:comment")
	public Comment_evaluation findev(@Param("comment") Comment comment);

	 ////comments + pertinents//////
	@Query("select max(e.l) from Comment_evaluation e")
	public int best1();
	
	@Query("select max(e.h) from Comment_evaluation e")
	public int best2();
	
	Comment_evaluation findByL(int l);
	Comment_evaluation findByH(int h);
	
	@Query("select e.comment from Comment_evaluation e where e.l=:nbrl or e.h=:nbrh")
	public List<Comment> myfind(@Param("nbrl") int nbrl , @Param("nbrh") int nbrh);
	
	
	
	
	 
	 
	 
	 
	 

}
