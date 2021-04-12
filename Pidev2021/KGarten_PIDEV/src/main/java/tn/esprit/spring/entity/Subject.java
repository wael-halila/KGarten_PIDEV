package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.fasterxml.jackson.annotation.JsonIgnore;






@Entity
public class Subject implements Serializable{
	
	private static final long serialVersionUID = -6236517548335858347L
			;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	@Column
	 private String type;
	
	@Column
	 private String title;
	@Column
	 private String poster;
	
	public Subject(String poster) {
		super();
		this.poster = poster;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}


	@Column
	 private String description;
	
	@Temporal(TemporalType.DATE)
    private Date creation_date;
	
	//@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy="subject",cascade=CascadeType.REMOVE)
	public List<Comment> comments;
	
	///evaluation
	
		@OneToMany(mappedBy="subject" , cascade=CascadeType.REMOVE)
	    private List<Subject_evaluation> ratings;

	
public List<Subject_evaluation> getRatings() {
			return ratings;
		}
public void setRatings(List<Subject_evaluation> ratings) {
			this.ratings = ratings;
		}
public Subject() {
		super();
	}






	public Subject(long id, String type, String title, String description, Date creation_date) {
	super();
	this.id = id;
	this.type = type;
	this.title = title;
	this.description = description;
	this.creation_date = creation_date;
}
	public Subject(String type, String title, String description, Date creation_date
		) {
	super();
	this.type = type;
	this.title = title;
	this.description = description;
	this.creation_date = creation_date;
	
}






	public Subject(long id, String type, String title, String description, Date creation_date,List<Comment> comments ) {
	super();
	this.id = id;
	this.type = type;
	this.title = title;
	this.description = description;
	this.creation_date = creation_date;
	this.comments = comments ;
}






	public List<Comment> getComments() {
	return comments;
}



public void setComments(List<Comment> comments) {
	this.comments = comments;
}



	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getCreation_date() {
		return creation_date;
	}


	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}


	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Subject [id=" + id + ", type=" + type + ", description=" + description + ", creation_date="
				+ creation_date  +  "]";
	}


	
	
	
	
	
	
}
