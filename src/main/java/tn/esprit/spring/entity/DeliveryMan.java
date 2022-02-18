package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class DeliveryMan extends User implements Serializable{
   
	
	@Temporal(TemporalType.TIME)
	private Date StartTime;
	 @Temporal(TemporalType.TIME)
	private Date EndTime;
	
	 @OneToMany(mappedBy="deliveryman", cascade=CascadeType.ALL)
	    private  Set<Premium> premiums;
		  @OneToMany(mappedBy="deliveryman" , cascade=CascadeType.ALL)
		  private Set<Delivery>deliveries ;
	 
	public Date getStartTime() {
		return StartTime;
	}
	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}
	public Date getEndTime() {
		return EndTime;
	}
	public void setEndTime(Date endTime) {
		EndTime = endTime;
	}
	public Set<Premium> getPremiums() {
		return premiums;
	}
	public void setPremiums(Set<Premium> premiums) {
		this.premiums = premiums;
	}
	public Set<Delivery> getDeliveries() {
		return deliveries;
	}
	public void setDeliveries(Set<Delivery> deliveries) {
		this.deliveries = deliveries;
	}
	
	 
	
}
