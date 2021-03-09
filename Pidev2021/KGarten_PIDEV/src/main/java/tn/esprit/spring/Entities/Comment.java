package tn.esprit.spring.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name= "T_Comment")
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idComment;
	private String commentt;
	private int nLike;
	private int nDislike;
	@ManyToOne
	private Comment comment ;
	
	
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(String commentt, int nLike, int nDislike) {
		super();
		this.commentt= commentt;
		this.nLike = nLike;
		this.nDislike = nDislike;
	}

	public int getIdComment() {
		return idComment;
	}

	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}

	public String getCommentt() {
		return commentt;
	}

	public void setCommentt(String commentt) {
		this.commentt = commentt;
	}

	public int getnLike() {
		return nLike;
	}

	public void setnLike(int nLike) {
		this.nLike = nLike;
	}

	public int getnDislike() {
		return nDislike;
	}

	public void setnDislike(int nDislike) {
		this.nDislike = nDislike;
	}
	
	
	
	

}
