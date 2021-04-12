package tn.esprit.spring.repository;



import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DictionaryRepository extends CrudRepository<tn.esprit.spring.entity.Dictionary,String>{

	@Query("select d.mot from Dictionary d")
	 public List<String> dictionaryList();
	
	
	
}



