package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Event")
public class Event implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_event ;
	
	@Temporal (TemporalType.DATE)
	private Date date_event ;
	
	private String place_event ;
	
	private int nbr_participant_event ;
	
	private float price_event ;
	
	private String description_event ;
	
	
	
	@OneToMany(mappedBy="event")
	private Set<Donation> donations ;


	public Event() {
		super();
	}

	public Event(long id_event, Date date_event, String place_event, int nbr_participant_event, float price_event,
			String description_event) {
		super();
		this.id_event = id_event;
		this.date_event = date_event;
		this.place_event = place_event;
		this.nbr_participant_event = nbr_participant_event;
		this.price_event = price_event;
		this.description_event = description_event;
	}

	public Event(Date date_event, String place_event, int nbr_participant_event, float price_event,
			String description_event) {
		super();
		this.date_event = date_event;
		this.place_event = place_event;
		this.nbr_participant_event = nbr_participant_event;
		this.price_event = price_event;
		this.description_event = description_event;
	}

	public long getId_event() {
		return id_event;
	}

	public void setId_event(long id_event) {
		this.id_event = id_event;
	}

	public Date getDate_event() {
		return date_event;
	}

	public void setDate_event(Date date_event) {
		this.date_event = date_event;
	}

	public String getPlace_event() {
		return place_event;
	}

	public void setPlace_event(String place_event) {
		this.place_event = place_event;
	}

	public int getNbr_participant_event() {
		return nbr_participant_event;
	}

	public void setNbr_participant_event(int nbr_participant_event) {
		this.nbr_participant_event = nbr_participant_event;
	}

	public float getPrice_event() {
		return price_event;
	}

	public void setPrice_event(float price_event) {
		this.price_event = price_event;
	}

	public String getDescription_event() {
		return description_event;
	}

	public void setDescription_event(String description_event) {
		this.description_event = description_event;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date_event == null) ? 0 : date_event.hashCode());
		result = prime * result + ((description_event == null) ? 0 : description_event.hashCode());
		result = prime * result + (int) (id_event ^ (id_event >>> 32));
		result = prime * result + nbr_participant_event;
		result = prime * result + ((place_event == null) ? 0 : place_event.hashCode());
		result = prime * result + Float.floatToIntBits(price_event);
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
		Event other = (Event) obj;
		if (date_event == null) {
			if (other.date_event != null)
				return false;
		} else if (!date_event.equals(other.date_event))
			return false;
		if (description_event == null) {
			if (other.description_event != null)
				return false;
		} else if (!description_event.equals(other.description_event))
			return false;
		if (id_event != other.id_event)
			return false;
		if (nbr_participant_event != other.nbr_participant_event)
			return false;
		if (place_event == null) {
			if (other.place_event != null)
				return false;
		} else if (!place_event.equals(other.place_event))
			return false;
		if (Float.floatToIntBits(price_event) != Float.floatToIntBits(other.price_event))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [id_event=" + id_event + ", date_event=" + date_event + ", place_event=" + place_event
				+ ", nbr_participant_event=" + nbr_participant_event + ", price_event=" + price_event
				+ ", description_event=" + description_event + "]";
	}



	public Set<Donation> getDonations() {
		return donations;
	}

	public void setDonations(Set<Donation> donations) {
		this.donations = donations;
	}
	
	
}
