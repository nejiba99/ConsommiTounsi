package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Premium implements Serializable{
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private float premium;
	private String month ;
	private int year;
	
	@ManyToOne
	private DeliveryMan deliveryman;
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public float getPremium() {
		return premium;
	}
	public void setPremium(float premium) {
		this.premium = premium;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}


	public DeliveryMan getDeliveryman() {
		return deliveryman;
	}


	public void setDeliveryman(DeliveryMan deliveryman) {
		this.deliveryman = deliveryman;
	}
	
	
}
