package tn.esprit.spring.sevice.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.repository.PostRep;
import tn.esprit.spring.sevice.interfece.PostService;
import tn.esprit.spring.entity.Post;
@Service
public class PostServiceImp implements PostService {

	@Autowired
	private PostRep postrepo;


	
	@Override
	public int ajouterPost(Post post) {
		postrepo.save(post);
		return post.getId();
	}

	@Override
	public void deletePostById(int id) {
		Post postManagedEntity = postrepo.findById(id).get();
		postrepo.delete(postManagedEntity);
	}

	@Override
	public void mettreAjourPostById(String post, int id) {
		Post tpost = postrepo.findById(id).get();
		tpost.setId(id);
		postrepo.save(tpost);
		
	}

	@Override
	public String getPostById(int id) {
		Post postManagedEntity = postrepo.findById(id).get();
		return postManagedEntity.getMessage();
	}

	@Override
	public List<Post> getAllPosts() {
		return (List<Post>) postrepo.findAll();
		
	}
	

	


}
