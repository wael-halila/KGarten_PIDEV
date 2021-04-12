package tn.esprit.spring.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Kindergarten implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	private String name;
	private String mail;
	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}
	private boolean isBlocked;
	private LocalDate blockDate;
	private LocalDate unBlockDate;
	 private String telNum;
	public String getTelNum() {
		return telNum;
	}


	public void setTelNum(String telNum) {
		this.telNum = telNum;
	}


	public boolean isBlocked() {
		return isBlocked;
	}


	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}


	public LocalDate getBlockDate() {
		return blockDate;
	}


	public void setBlockDate(LocalDate blockDate) {
		this.blockDate = blockDate;
	}


	public LocalDate getUnBlockDate() {
		return unBlockDate;
	}


	public void setUnBlockDate(LocalDate unBlockDate) {
		this.unBlockDate = unBlockDate;
	}
	@OneToOne
	@JoinColumn(name= "idUser")
	private User user ;
	@OneToMany(mappedBy="kindergarten")
	private List<Claim> claim ;
	

	
	
	public Kindergarten(Long id, String name, boolean isBlocked, LocalDate blockDate, LocalDate unBlockDate, User user,
			List<Claim> claim) {
		super();
		this.id = id;
		this.name = name;
		this.isBlocked = isBlocked;
		this.blockDate = blockDate;
		this.unBlockDate = unBlockDate;
		this.user = user;
		this.claim = claim;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public void setClaim(List<Claim> claim) {
		this.claim = claim;
	}
	public Kindergarten() {
		super();
		// TODO Auto-generated constructor stub
	} 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}
	public List<Claim> getClaim() {
		return claim;
		
	}
	public void setClaim(List<Claim> claim , String name) {
		this.claim = claim;
		this.name=name; 
	}

}
