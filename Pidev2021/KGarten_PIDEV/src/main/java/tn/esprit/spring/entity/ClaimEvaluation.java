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
public class ClaimEvaluation implements Serializable{ 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	//Verry disppointed 
	@Column
	 private int vd;
	//disppointed
	@Column
	 private int d;
	//medium
	@Column
	 private int m;


	@JsonIgnore 
    @ManyToOne(cascade=CascadeType.ALL)
    private Claim claim;


	public ClaimEvaluation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ClaimEvaluation(long id, int vd, int d, int m, Claim claim) {
		super();
		this.id = id;
		this.vd = vd;
		this.d = d;
		this.m = m;
		this.claim = claim;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getVd() {
		return vd;
	}


	public void setVd(int vd) {
		this.vd = vd;
	}


	public int getD() {
		return d;
	}


	public void setD(int d) {
		this.d = d;
	}


	public int getM() {
		return m;
	}


	public void setM(int m) {
		this.m = m;
	}


	public Claim getClaim() {
		return claim;
	}


	public void setClaim(Claim claim) {
		this.claim = claim;
	}

}
