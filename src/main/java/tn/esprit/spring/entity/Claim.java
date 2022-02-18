package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Claim implements Serializable{

	@EmbeddedId
	private ClaimPk claimpk ;
	
	private String description ;
	
	@Enumerated(EnumType.STRING)
	private Status_Claim status;
	
	@ManyToOne
    @MapsId("id_prod")
    @JoinColumn(name = "id_prod")
	private Product product ;
	
	@ManyToOne
    @MapsId("id_user")
    @JoinColumn(name = "id_user")
	private User user ;

	public ClaimPk getClaimpk() {
		return claimpk;
	}

	public void setClaimpk(ClaimPk claimpk) {
		this.claimpk = claimpk;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status_Claim getStatus() {
		return status;
	}

	public void setStatus(Status_Claim status) {
		this.status = status;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Claim(ClaimPk claimpk, String description, Status_Claim status, Product product, User user) {
		super();
		this.claimpk = claimpk;
		this.description = description;
		this.status = status;
		this.product = product;
		this.user = user;
	}

	public Claim() {
		super();
	}

	@Override
	public String toString() {
		return "Claim [claimpk=" + claimpk + ", description=" + description + ", status=" + status + ", product="
				+ product + ", user=" + user + "]";
	}
	
	
}
