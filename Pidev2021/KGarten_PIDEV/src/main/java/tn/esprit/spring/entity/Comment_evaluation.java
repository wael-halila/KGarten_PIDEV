package tn.esprit.spring.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity

public class Comment_evaluation implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	//like
	@Column
	 private int l;
	//dislike
	@Column
	 private int d;
	//happy
	@Column
	 private int h;
	//sad
	@Column
	 private int s;
	//medium
	@Column
	 private int m;

	
	
    @ManyToOne(cascade=CascadeType.ALL)
    @JsonManagedReference
    private Comment comment;

	
	
	
	
	
	
	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	

	public Comment_evaluation( int l, int d, int h, int s, int m) {
		super();
		this.l = l;
		this.d = d;
		this.h = h;
		this.s = s;
		this.m = m;
	}
	public Comment_evaluation() {
		super();
		this.l = 0;
		this.d = 0;
		this.h = 0;
		this.s = 0;
		this.m = 0;
	}
	
	
	public Comment_evaluation(long id, int l, int d, int h, int s, int m) {
		super();
		this.id = id;
		this.l = l;
		this.d = d;
		this.h = h;
		this.s = s;
		this.m = m;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getL() {
		return l;
	}

	public void setL(int l) {
		this.l = l;
	}

	public int getD() {
		return d;
	}

	public void setD(int d) {
		this.d = d;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public int getS() {
		return s;
	}

	public void setS(int s) {
		this.s = s;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
	
	
	
}
