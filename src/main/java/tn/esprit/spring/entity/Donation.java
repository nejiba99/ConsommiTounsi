package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Donation implements Serializable{

	@EmbeddedId
	private DonationPK donationPK ;
	
	private float amount_money_collection ;
	
	@ManyToOne
    @MapsId("id_event")
    @JoinColumn(name = "id_event")
	private Event event ;
	
	@ManyToOne
    @MapsId("id_user")
    @JoinColumn(name = "id_user")
	private Client client ;

	public Donation() {
		super();
	}

	public Donation(DonationPK donationPK, float amount_money_collection, Event event, Client client) {
		super();
		this.donationPK = donationPK;
		this.amount_money_collection = amount_money_collection;
		this.event = event;
		this.client = client;
	}

	public DonationPK getDonationPK() {
		return donationPK;
	}

	public void setDonationPK(DonationPK donationPK) {
		this.donationPK = donationPK;
	}

	public float getAmount_money_collection() {
		return amount_money_collection;
	}

	public void setAmount_money_collection(float amount_money_collection) {
		this.amount_money_collection = amount_money_collection;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public String toString() {
		return "Donation [donationPK=" + donationPK + ", amount_money_collection=" + amount_money_collection
				+ ", event=" + event + ", client=" + client + "]";
	}
	
	
	
}
