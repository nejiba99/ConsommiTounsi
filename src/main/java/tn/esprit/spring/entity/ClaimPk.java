package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ClaimPk implements Serializable {

	private long id_prod ;
	
	private long id_user ;
	
	private long id_claim ;

	public long getId_prod() {
		return id_prod;
	}

	public void setId_prod(long id_prod) {
		this.id_prod = id_prod;
	}

	public long getId_user() {
		return id_user;
	}

	public void setId_user(long id_user) {
		this.id_user = id_user;
	}

	public long getId_claim() {
		return id_claim;
	}

	public void setId_claim(long id_claim) {
		this.id_claim = id_claim;
	}
	
	
}
