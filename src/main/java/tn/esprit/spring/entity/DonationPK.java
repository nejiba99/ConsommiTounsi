package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class DonationPK implements Serializable{

	private long id_event ;
	
	private long id_user ;
	
	private long id_donation ;

	public long getId_event() {
		return id_event;
	}

	public void setId_event(long id_event) {
		this.id_event = id_event;
	}

	public long getId_user() {
		return id_user;
	}

	public void setId_user(long id_user) {
		this.id_user = id_user;
	}

	public long getId_donation() {
		return id_donation;
	}

	public void setId_donation(long id_donation) {
		this.id_donation = id_donation;
	}
	
	
}
