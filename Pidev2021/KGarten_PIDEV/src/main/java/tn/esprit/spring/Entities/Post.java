package tn.esprit.spring.Entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_Post")
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPost;
	@Enumerated (EnumType.STRING)
	private  Favorite favorite;
	public enum Favorite {LIKE, DISLIKE	}
	private int view_number;
	private float statistic;


	@ManyToOne
    private User user; 
	@OneToMany(mappedBy="post",cascade={ CascadeType.ALL},fetch=FetchType.EAGER)
	private List<Comment> comments =  new ArrayList<>();
	
	//constructeur paramétré
	
	public Post(int idPost, Favorite favorite, int view_number, float statistic) {
		super();
		this.idPost = idPost;
		this.favorite = favorite;
		this.view_number = view_number;
		this.statistic = statistic;
	}
	//vide
	
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//getter & setter 
	
	public int getIdPost() {
		return idPost;
	}
	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}
	public Favorite getFavorite() {
		return favorite;
	}
	public void setFavorite(Favorite favorite) {
		this.favorite = favorite;
	}
	public int getView_number() {
		return view_number;
	}
	public void setView_number(int view_number) {
		this.view_number = view_number;
	}
	public float getStatistic() {
		return statistic;
	}
	public void setStatistic(float statistic) {
		this.statistic = statistic;
	}

	
	
	
	
	
	

}
