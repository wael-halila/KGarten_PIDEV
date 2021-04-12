package tn.esprit.spring.sevice.interfece;


import java.util.List;


import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Comment_evaluation;






public interface ICommentService {
	
	
	String addComment(Comment com,Long sub_id) ;
	 List<Comment> list(Long sub_id);
	 List<Comment> mylist(int id);
	 void deleteComment(long id) ;
	 Comment updateComment(Long id,String mot);
	 void addEv(Comment_evaluation e, Long id);
	 List<Comment> Bestcomments();
	 Comment findbyid(long id);
	 Comment_evaluation Evatuation(Long id);
	 public void deleteAllCommentJPQL();
	 public List<Comment> getAllComment();
	
	
	 
	

	 

}
