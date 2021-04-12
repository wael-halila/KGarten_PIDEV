package tn.esprit.spring.sevice.interfece;

import java.util.List;


import tn.esprit.spring.entity.Post;


public interface PostService {
	public int ajouterPost(Post post);
	public void deletePostById(int idpost);
	public void mettreAjourPostById(String post, int id);
	public String getPostById(int id);
	public List<Post> getAllPosts();


}
