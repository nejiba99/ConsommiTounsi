package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Client")
public class Client extends User implements Serializable{

	private int status_client ;
	

	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy="sender")
	private Set<Message> messages;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="client")
	private Set<Donation> donations ;
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy="client")
	private Set<Subject> subjects;
	
	@OneToOne(fetch = FetchType.EAGER,mappedBy="client")
	private Basket basket; 

	
	public Client() {
		super();
	}


	public Client(int status_client) {
		super();
		this.status_client = status_client;
	}

	public int getStatus_client() {
		return status_client;
	}

	public void setStatus_client(int status_client) {
		this.status_client = status_client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + status_client;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (status_client != other.status_client)
			return false;
		return true;
	}

	public Basket getBasket() {
		return basket;
	}


	public void setBasket(Basket basket) {
		this.basket = basket;
	}


	@Override
	public String toString() {
		return "Client [status_client=" + status_client + "]";
	}

	
	@JsonBackReference
	public Set<Message> getMessages() {
		return messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}


	public Set<Donation> getDonations() {
		return donations;
	}

	public void setDonations(Set<Donation> donations) {
		this.donations = donations;
	}
	
	
}
