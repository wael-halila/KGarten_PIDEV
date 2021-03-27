package tn.esprit.spring.Entities;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;




@Entity
@Table(name = "T_Feed")

public class Feedback implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Feed-id")
    private int id;
	@Column(name="Feed-note")
	private int note;
	@Column(name="Feed-sub")
	private String Subject;
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feedback(int id, int note, String subject) {
		super();
		this.id = id;
		this.note = note;
		Subject = subject;
	}
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", note=" + note + ", Subject=" + Subject + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Subject == null) ? 0 : Subject.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + note;
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
		Feedback other = (Feedback) obj;
		if (Subject == null) {
			if (other.Subject != null)
				return false;
		} else if (!Subject.equals(other.Subject))
			return false;
		if (id != other.id)
			return false;
		if (note != other.note)
			return false;
		return true;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	
	

}
