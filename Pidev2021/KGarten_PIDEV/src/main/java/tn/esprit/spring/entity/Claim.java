package tn.esprit.spring.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Claim implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 

	  @Temporal (TemporalType.DATE)
	  private Date dateClaim;

	  @Enumerated(EnumType.STRING)
	   private ClaimStatus status ;
	 
	    private String mot ;
	    @Column(name = "createdAt")
	    private LocalDateTime createdAt;
		
		@Column(name = "updatedAt")
	    private LocalDateTime updatedAt;

		@Enumerated(EnumType.STRING)
		  private ClaimCategory category;
		  
		  @OneToMany(mappedBy="claim")
		  private List<ClaimEvaluation> claimevaluation ;	  
		
		 
		  @ManyToOne(cascade=CascadeType.MERGE)
		  @JoinColumn(name="idSubject",referencedColumnName="id")
		  private Subject subject;
		  @ManyToOne(cascade=CascadeType.MERGE)
		  @JoinColumn(name="idUser")
		  private User user;
		  @ManyToOne(cascade=CascadeType.MERGE)
		  private Kindergarten kindergarten ; 
		  
		
		
	
	    public LocalDateTime getCreatedAt() {
			return createdAt;
		}


		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}


		public LocalDateTime getUpdatedAt() {
			return updatedAt;
		}


		public void setUpdatedAt(LocalDateTime updatedAt) {
			this.updatedAt = updatedAt;
		}


	 
	  
	  
	  public List<ClaimEvaluation> getClaimevaluation() {
			return claimevaluation;
		}
		  
		  
		public void setClaimevaluation(List<ClaimEvaluation> claimevaluation) {
			this.claimevaluation = claimevaluation;
		}
	  public Kindergarten getKindergarten() {
		return kindergarten;
	}




	public void setKindergarten(Kindergarten kindergarten) {
		this.kindergarten = kindergarten;
	}




	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDateClaim() {
		return dateClaim;
	}
	public void setDateClaim(Date dateClaim) {
		this.dateClaim = dateClaim;
	}
	
	public String getMot() {
		return mot;
	}
	public void setMot(String mot) {
		this.mot = mot;
	}
	public ClaimCategory getCategory() {
		return category;
	}
	public void setCategory(ClaimCategory category) {
		this.category = category;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	   
	
	public ClaimStatus getStatus() {
		return status;
	}

    public void setStatus(ClaimStatus status) {
		this.status = status;
	}
    public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Claim [id=" + id + ", dateClaim=" + dateClaim + ", status=" + status + ", mot=" + mot + ", category="
				+ category + ", claimevaluation=" + claimevaluation + ", subject=" + subject + ", user=" + user
				+ ", kindergarten=" + kindergarten + "]";
	}


	public Claim(long id, Date dateClaim, ClaimStatus status, String mot, ClaimCategory category,
			List<ClaimEvaluation> claimevaluation, Subject subject, User user, Kindergarten kindergarten , LocalDateTime updatedAt,LocalDateTime createdAt) {
		super();
		this.id = id;
		this.dateClaim = dateClaim;
		this.status = status;
		this.mot = mot;
		this.category = category;
		this.claimevaluation = claimevaluation;
		this.subject = subject;
		this.user = user;
		this.kindergarten = kindergarten;
		this.updatedAt = updatedAt ;
		this.createdAt = createdAt ; 
	}







	
	


	
	
}