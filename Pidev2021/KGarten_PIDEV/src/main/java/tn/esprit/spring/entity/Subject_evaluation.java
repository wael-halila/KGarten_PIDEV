package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Subject_evaluation implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	@Column
	 private int value;
	
	
	
	@JsonIgnore 
    @ManyToOne(cascade=CascadeType.MERGE)
    private Subject subject;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public Subject getsubject() {
		return subject;
	}


	public void setsubject(Subject subject) {
		this.subject = subject;
	}


	public Subject_evaluation(long id, int value, Subject subject) {
		super();
		this.id = id;
		this.value = value;
		this.subject = subject;
	}


	public Subject_evaluation() {
		super();
	}
	
	
	
	
	
	
	
	
	

}
