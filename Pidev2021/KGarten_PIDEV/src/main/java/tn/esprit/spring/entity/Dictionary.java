package tn.esprit.spring.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity
public class Dictionary implements Serializable{
	
	private static final long serialVersionUID = -6236517548335858347L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String mot;
	
	
	
	
	public Dictionary(Long id, String mot) {
		super();
		this.id = id;
		this.mot = mot;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMot() {
		return mot;
	}
	public void setMot(String mot) {
		this.mot = mot;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Dictionary(String mot) {
		super();
		this.mot = mot;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mot == null) ? 0 : mot.hashCode());
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
		Dictionary other = (Dictionary) obj;
		if (mot == null) {
			if (other.mot != null)
				return false;
		} else if (!mot.equals(other.mot))
			return false;
		return true;
	}

	
	
	
	
	
}
