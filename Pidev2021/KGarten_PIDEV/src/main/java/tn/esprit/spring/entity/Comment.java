package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Comment implements Serializable{
	
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	@Column
	 private String mot;
	
	///evaluation
	
@JsonIgnore
	@OneToMany(mappedBy="comment" , cascade=CascadeType.MERGE)
	
	private List<Comment_evaluation> ratings;
	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="idSubject",referencedColumnName="id")
	private Subject subject;
	
	@ManyToOne
	private Post post;


	public Comment(long id, String mot, List<Comment_evaluation> ratings, Post post ,Subject subject) {
		super();
		this.id = id;
		this.mot = mot;
		this.ratings = ratings;
		this.post = post;
		this.subject = subject;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMot() {
		return mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	public List<Comment_evaluation> getRatings() {
		return ratings;
	}

	public void setRatings(List<Comment_evaluation> ratings) {
		this.ratings = ratings;
	}
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((mot == null) ? 0 : mot.hashCode());
		result = prime * result + ((ratings == null) ? 0 : ratings.hashCode());
		result = prime * result + ((post == null) ?0 : post.hashCode());
		result = prime * result + ((subject == null) ?0 : subject.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (id != other.id)
			return false;
		if (mot == null) {
			if (other.mot != null)
				return false;
		} else if (!mot.equals(other.mot))
			return false;
		if (ratings == null) {
			if (other.ratings != null)
				return false;
		} else if (!ratings.equals(other.ratings))
			return false;
		if (post == null) {
			if (other.post != null)
				return false;
		} else if (!post.equals(other.post))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

	
}
