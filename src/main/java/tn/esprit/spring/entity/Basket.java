package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Basket implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_basket ;
	
	@Temporal (TemporalType.DATE)
	private Date date_basket ;
	
	private float total ;
	
    @Enumerated(EnumType.STRING)
	private Paiement type_paiement;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="basket")
    private Set<Orders> orders;
    
    @OneToOne
    private Client client; 

	public long getId_basket() {
		return id_basket;
	}

	public void setId_basket(long id_basket) {
		this.id_basket = id_basket;
	}

	public Date getDate_basket() {
		return date_basket;
	}

	public void setDate_basket(Date date_basket) {
		this.date_basket = date_basket;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Paiement getType_paiement() {
		return type_paiement;
	}

	public void setType_paiement(Paiement type_paiement) {
		this.type_paiement = type_paiement;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
    
    
    

}
