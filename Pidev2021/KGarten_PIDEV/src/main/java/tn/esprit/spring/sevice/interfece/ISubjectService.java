package tn.esprit.spring.sevice.interfece;


import java.util.List;

import tn.esprit.spring.entity.Subject;


public interface ISubjectService {
	 List<Subject> listSubject();
	 Subject addSubject(Subject subject);
	 Subject findbyid(long id);
	 void deleteSubject(long id) ;
	 Subject updateSubject(Subject user2);
	 Subject test(String type , String description);
	  List<Subject> sub() ;
	  Subject listbytitle(String title);
	  List<Subject> findbyType(String type);
	  List<Long> notcommented() ;
	  List<Subject> autodeleteSubject() ;
	  void addrate(int value,long id);
	  int maxrate(long id) ;
	  int minrate(long id);
	  List<Subject> Subevaluated();
	  public void deleteOldPost();
	  

	  
}
