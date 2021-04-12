package tn.esprit.spring.entity;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Messaging {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idMessaging;
	private String subject;
	private String message;
	  @Temporal (TemporalType.DATE)
	  private Date dateDispatch;
	  private Date dateReception;
	private String fileType;
	private int qrcode;

	
	//-------------------------------------------------------
	public Messaging(String subject, String message, Date dateDispatch, Date dateReception, String fileType,
			int qrcode) {
		super();
		this.subject = subject;
		this.message = message;
		this.dateDispatch = dateDispatch;
		this.dateReception = dateReception;
		this.fileType = fileType;
		this.qrcode = qrcode;
	}
	//-------------------------------------------------------
	public Messaging() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	//-------------------------------------------------------
	public int getIdMessaging() {
		return idMessaging;
	}
	public void setIdMessaging(int idMessaging) {
		this.idMessaging = idMessaging;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getDateDispatch() {
		return dateDispatch;
	}
	public void setDateDispatch(Date dateDispatch) {
		this.dateDispatch = dateDispatch;
	}
	public Date getDateReception() {
		return dateReception;
	}
	public void setDateReception(Date dateReception) {
		this.dateReception = dateReception;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public int getQrcode() {
		return qrcode;
	}
	public void setQrcode(int qrcode) {
		this.qrcode = qrcode;
	}

	
}
