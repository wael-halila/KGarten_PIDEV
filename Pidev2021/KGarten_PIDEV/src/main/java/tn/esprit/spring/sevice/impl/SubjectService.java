package tn.esprit.spring.sevice.impl;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Subject;
import tn.esprit.spring.entity.Subject_evaluation;
import tn.esprit.spring.repository.CommentRepository;
import tn.esprit.spring.repository.SubjectRepository;
import tn.esprit.spring.repository.Subject_evaluationRepository;
import tn.esprit.spring.sevice.interfece.ISubjectService;






@Service
public class SubjectService implements  ISubjectService{
	
@Autowired
private SubjectRepository subrepo;

@SuppressWarnings("unused")
@Autowired
private CommentRepository comrepos;

@Autowired
private Subject_evaluationRepository subevalrepo;



@SuppressWarnings("unused")
private static final Logger logger = LogManager.getLogger(SubjectService.class);
@Override	
public Subject addSubject(Subject subject){
		subrepo.save(subject) ;
		return subject;
		
	}

@Override
public Subject findbyid(long id){
	
		return subrepo.findById(id).get() ;
	}

@Override
public List<Subject> listSubject(){
	
	
	
	return (List<Subject>)subrepo.findAll();
	
	
		
	}

@Override	
public void deleteSubject(long id){
	
		subrepo.deleteById(id); 
	
	}
@Override	
public Subject updateSubject(Subject subject2){
	
	Subject subject1 =subrepo.findById(subject2.getId()).get(); 
	subject1.setType(subject2.getType());
	subject1.setTitle(subject2.getTitle());
	subject1.setDescription(subject2.getDescription());
	subject1.setCreation_date(subject2.getCreation_date());
		
		subrepo.save(subject1);
		return subject1;
	
	}
@Override	
public Subject test(String type , String description){
	Subject u = subrepo.findByTypeAndDescription(type, description);
		return u;
}

@Override	
public List<Subject> sub(){
	Double mydate = (double) 3;
	return subrepo.sub(mydate);
	
	
}


@Override
public Subject listbytitle(String title){
	
	return subrepo.findByTitle(title);
	
}
@Override
public List<Subject> findbyType(String type){
	
		return subrepo.findByType(type);
	}


/////////subject sans interaction//////////

@Override
public List<Long> notcommented() {
	 List<Long> mylist = subrepo.list1() ; //1
	 Double a = (double) 10;
	 List<Long> mylist1 = subrepo.subs(a);  //1 2 3
	for(Long i : mylist) {
		
		if(mylist1.contains(i)) {
			mylist1.remove(i);
			
		}
	}
	
 return mylist1 ;
 
	  
}

/////////////supprimer automatiquement les sujet sans commentaire
/////////////--------------- chaque 15 j du mois a 12h AM///////////
@Scheduled(cron = "0 12 00 15 * ?")
@Override
 public List<Subject> autodeleteSubject() {
	
	for(Long i : notcommented()) {
		
		subrepo.deleteById(i);
		
	}
	return null;
	
	
}
/////////////////////subject rating /////////////////////
public void addrate(int value,long id) {
	
	Subject s = subrepo.findById(id).get();
	Subject_evaluation e = new Subject_evaluation();
	e.setValue(value);
	e.setsubject(s);
	subevalrepo.save(e);
	
	
}
/////////////////////affichage subject rating /////////////////////	
@Override
public int maxrate(long id) {
Subject s = subrepo.findById(id).get();
return subevalrepo.maxrate(s);


}
@Override
public int minrate(long id) {
Subject s = subrepo.findById(id).get();
return subevalrepo.minrate(s);


}

@Override
public List<Subject> Subevaluated() {
	return subevalrepo.Listsubev();


}

@Override
public void deleteOldPost() {
	subrepo.deleteOldPost();
	
}



	
		
}
	

		
		
		
		
	
	
	


