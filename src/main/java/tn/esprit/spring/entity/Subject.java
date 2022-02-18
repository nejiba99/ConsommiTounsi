package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Subject")
public class Subject implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_subject ;
	
	private String desc_subject ;
	
	private int rating_subject ;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Product product; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="subject")
	private Set<Comment> comments;


	@ManyToOne
	Client client; 
	
	public Subject() {
		super();
	}

	public Subject(long id_subject, String desc_subject) {
		super();
		this.id_subject = id_subject;
		this.desc_subject = desc_subject;
	}

	public Subject(String desc_subject) {
		super();
		this.desc_subject = desc_subject;
	}

	public long getId_subject() {
		return id_subject;
	}

	public void setId_subject(long id_subject) {
		this.id_subject = id_subject;
	}

	public String getDesc_subject() {
		return desc_subject;
	}

	public void setDesc_subject(String desc_subject) {
		this.desc_subject = desc_subject;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desc_subject == null) ? 0 : desc_subject.hashCode());
		result = prime * result + (int) (id_subject ^ (id_subject >>> 32));
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
		Subject other = (Subject) obj;
		if (desc_subject == null) {
			if (other.desc_subject != null)
				return false;
		} else if (!desc_subject.equals(other.desc_subject))
			return false;
		if (id_subject != other.id_subject)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subject [id_subject=" + id_subject + ", desc_subject=" + desc_subject + "]";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getRating_subject() {
		return rating_subject;
	}

	public void setRating_subject(int rating_subject) {
		this.rating_subject = rating_subject;
	}
	
	
	
}
