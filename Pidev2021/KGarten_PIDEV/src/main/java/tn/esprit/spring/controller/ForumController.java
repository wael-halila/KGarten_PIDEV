package tn.esprit.spring.controller;



import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import tn.esprit.spring.entity.Comment;
import tn.esprit.spring.entity.Comment_evaluation;
import tn.esprit.spring.entity.Post;
import tn.esprit.spring.entity.Subject;
import tn.esprit.spring.sevice.interfece.ICommentService;
import tn.esprit.spring.sevice.interfece.ISubjectService;
import tn.esprit.spring.sevice.interfece.PostService;;

@CrossOrigin("*")
@RestController
@RequestMapping("/forum")
public class ForumController {
	@Autowired
	PostService postService;
	@Autowired
	ISubjectService subjectService;
	@Autowired
	ICommentService commentService;
	
	ObjectMapper objectMapper = new ObjectMapper();
		//ajouter post :
// http://localhost:8085/forum/ajouterPost
		@PostMapping("/ajouterPost")
		@ResponseBody
		public Post ajouterPost (@RequestBody Post post) 
		{
		postService.ajouterPost(post);
		return post;
		}
		//Modifier Post : 
// http://localhost:8085/forum/modifyPost/1/newpost
		@PutMapping(value = "/modifyPost/{id}/{newpost}") 
		@ResponseBody
		public void mettreAjourPostById(@PathVariable("newpost") String post, @PathVariable("id") int id)
		{
		postService.mettreAjourPostById(post, id);
		}
		//delet post
// URL : http://localhost:8085/forum/deletePostById/1
	    @DeleteMapping("/deletePostById/{id}") 
		@ResponseBody 
		public void deletePostById(@PathVariable("id")int id) 
	    {
	    postService.deletePostById(id);
	    	
		}
	    //get post by id
// URL : http://localhost:8085/forum/getPostById/1
	    @GetMapping(value = "/getPostById/{id}")
	    @ResponseBody
	    public String getPostById(@PathVariable("id")int id) 
	    {
	 	return postService.getPostById(id);
		}
	    //get all posts
//URL : http://localhost:8085/forum/getAllPosts
	    @GetMapping(value = "/getAllPosts")
	    @ResponseBody
	    public List<Post> GetAllPosts()
	    {
	    return postService.getAllPosts();
		}
	    //ajouter un sujet
//URL : http://localhost:8085/forum/addSubject
	    @PostMapping("/addSubject")
	    @ResponseBody
	    public Subject addSubject(@RequestBody Subject u) {
	    	  
	        subjectService.addSubject(u);
	        return u;
	        
	    }
	    //afficher tt les sujets
// URL : http://localhost:8085/forum/subjects
	    @GetMapping("/subjects")
	    @ResponseBody
	    public List<Subject> listSubject() {
	    	List<Subject> l = subjectService.listSubject();
	    	return l ;
	    }
	    //modifier un sujet
// URL : http://localhost:8085/forum/modify-subject
	    @PutMapping("/modify-subject")
	    @ResponseBody
	    public Subject updateSubject(@RequestBody Subject s) {
	    	return subjectService.updateSubject(s);
	    }
				////////afficher sujets à la une//////////
	    //afficher le sujet le plus recent
// URL : http://localhost:8085/forum/listsubject
		@GetMapping("/listsubject")
		@ResponseBody
		public List<Subject> getSubjectByLastDate() {
			List<Subject> list = subjectService.sub();
			return list;
		}
		////////supprimer sujet recent //////////
	    //supp sujet le sujet le plus recent
//http://localhost:8085/forum/suppsub
		@DeleteMapping("/suppsub")
		@ResponseBody
		public  List <Subject> suppSubjectByLastDate() {
		List<Subject> list = subjectService.autodeleteSubject();
		return list;	
		}
		
		//Comments sections//
//http://localhost:8085/forum/ListComment/{subjectId}
		@GetMapping("/ListComment/{subjectId}")
		@ResponseBody
		public Response listOfCommnetsById(@PathVariable("subjectId") Long subjectId) 
		{
		List<Comment> l = commentService.list(subjectId);
		if (l.size()==0)
			{
			return Response.status(Status.NOT_FOUND).entity("There's no comment related to this subject !").build();
			}
		else 
			{
			return Response.status(Status.OK).entity(l).build();
			}
		}
		
			//////////////commentaires + pertinents /////////////////// 	
// get all comment 
		@GetMapping(value = "/getAllComments")
	    @ResponseBody
		public List<Comment> getAllComments() {
		return commentService.getAllComment();
		}
	
		//-------------------add comment with dictionaire--------------------------------
		
 //URL : http://localhost:8085/forum/addComment/{subjectId}
		@PostMapping("/addComment/{subjectId}")
		@ResponseBody
		public String addComment
		(@RequestBody Comment u,@PathVariable("subjectId") Long subjectId  ) 
			{
			String msg = commentService.addComment(u, subjectId);
			return  msg;
		    }
		//----------------------DELET COMMENT----------------------------------
 //URL : http://localhost:8085/forum/deleteAllCommentJPQL
		@DeleteMapping("/deleteAllCommentJPQL") 
		@ResponseBody
		public String deleteAllCommentJPQL() {
		 commentService.deleteAllCommentJPQL();
		 String msg = "deleted successfully";
		 return msg;
			
		}
	 
			@GetMapping("/BestComments")
			@ResponseBody
			public List<Comment> BestComments() {
				return commentService.Bestcomments();
			}
			
			@GetMapping("/retrieve-all-Subjects")
			public List<Subject> getAllSubject(){
				List<Subject> list = subjectService.listSubject();
				return list;
			}
			//DELET WITH condition published one year later 
			 //URL : http://localhost:8085/forum/deletOldPost
			//a revoire
			 @DeleteMapping("/deletOldPost") 
				@ResponseBody
				public void deleteOldPost() {
				 subjectService.deleteOldPost();
					
				}
			// URL : http://localhost:8085/forum/deleteSubject/1
			    @PutMapping("/deleteSubject/{id}") 
				@ResponseBody 
				public void deletSubject(@PathVariable("date")Date date) {
			    	subjectService.sub();
			    	
			    }
	
			    
			    @PostMapping("/evaluate/{commentId}")
			    @ResponseBody
			    public Response addevaluation(@RequestBody Comment_evaluation u,@PathVariable("commentId") Long commentId) {
			    	
			    	commentService.addEv(u, commentId);
			    return Response.status(Status.OK).entity("add successful").build();

			        }
			   
	  
	   }

