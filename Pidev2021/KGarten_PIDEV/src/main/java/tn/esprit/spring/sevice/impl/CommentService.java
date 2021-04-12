package tn.esprit.spring.sevice.impl;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.repository.CommentRepository;
import tn.esprit.spring.repository.Comment_evaluationRepository;
import tn.esprit.spring.repository.DictionaryRepository;
import tn.esprit.spring.repository.PostRep;
import tn.esprit.spring.sevice.interfece.ICommentService;

import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Comment_evaluation;
import tn.esprit.spring.entity.Post;
import tn.esprit.spring.entity.Subject;



@Service
public class CommentService implements ICommentService {
	public String msg;
	@Autowired
	private CommentRepository cmtrepo;

	@Autowired
	private SubjectService subserv;

	@Autowired
	private Comment_evaluationRepository cmntevalrepo;

	@Autowired
	private DictionaryRepository dictrepo;
	
	@Autowired
	private PostRep postrepo;

	////////////////////// add a comment/////////Dictionnaire mots interdits/////////////////////

	@Override
	public String addComment(Comment com,Long sub_id) {
	
		
		Subject s = subserv.findbyid(sub_id);
		
		com.setSubject(s);
		 if(com.getMot().equals("")) {	
				msg= "you can't insert an empty comment" ;
			}
		 else {
		
			 //dictionary//
		List<String> mydictionary = dictrepo.dictionaryList();
		ArrayList<String> listOfStrings = new ArrayList<>(mydictionary.size());
		listOfStrings.addAll(mydictionary);
		     //liste des mots du commentaire
		String[] words = com.getMot().split("\\s+");
			for (int i = 0; i < words.length; i++) {
			    
			words[i] = words[i].replaceAll("[^\\w]", "");
				
			
			}
			boolean found = false;
			
			for (String element:words ) {
				for(String elt:listOfStrings) {	
					
					if ( (elt.trim()).equals(element)) {
				        found = true;
				        msg= "you can't insert this word : " + element ;
					}
					}}
	 if(!found) {	
			
			cmtrepo.save(com); 
	 		msg= "add successful ";
			 } }
		
	return msg ;
	
	}

	@Override
	public List<Comment> list(Long sub_id) {

		Subject s = subserv.findbyid(sub_id);
		return cmtrepo.list(s);

	}

	@Override
	public void deleteComment(long id) {

		cmtrepo.deleteById(id);

	}

	//-------------------

	//....................
	@Override
	public List<Comment> mylist(int id) {

		Post p = postrepo.findById(id).get();

		List<Comment> l = cmtrepo.mylist(p);
		return l;

	}
	/// modify comment ////

	@Override
	public Comment updateComment(Long id, String mot) {

		Comment com1 = cmtrepo.findById(id).get();
		com1.setMot(mot);

		cmtrepo.save(com1);
		return com1;

	}

	/////// evaluation/////////
	
	@Override
@Transactional
public void addEv(Comment_evaluation e, Long id) {

		Comment c = cmtrepo.findById(id).get();
		
		List<Comment> my = cmntevalrepo.evsave();

		if (my.contains(c)) {
			Comment_evaluation v = cmntevalrepo.findev(c);
			v.setL(v.getL() + e.getL());
			v.setD(v.getD() + e.getD());
			v.setH(v.getH() + e.getH());
			v.setS(v.getS() + e.getS());
			v.setM(v.getM() + e.getM());
			cmntevalrepo.save(v);

		
		}else {

			e.setComment(c);
			cmntevalrepo.save(e);
		}

	}

	/////////////////// list get evaluation by comment id//////////////////
	public Comment_evaluation Evatuation(Long id) {

		Comment c = cmtrepo.findById(id).get();
		return  cmntevalrepo.findev(c);
		

	}

	/////////////////// comments + pertinents/////////////////////
	@Override
	public List<Comment> Bestcomments() {
		List<Comment> list1 = cmntevalrepo.myfind(cmntevalrepo.best1(), cmntevalrepo.best2());
		return list1;
	}

	@Override
	public Comment findbyid(long id) {

		return cmtrepo.findById(id).get();

	}

	@Override
	public void deleteAllCommentJPQL() {
		cmtrepo.deleteAllCommentJPQL();
		
	}

	@Override
	public List<Comment> getAllComment() {
		return (List<Comment>) cmtrepo.findAll();
	}



	

}
