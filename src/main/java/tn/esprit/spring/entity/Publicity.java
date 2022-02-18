package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Publicity")
public class Publicity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_pub ;
	
	private String name_pub ;
	
	@ManyToOne
	private Product product;
	


	public Publicity() {
		super();
	}

	public Publicity(long id_pub, String name_pub) {
		super();
		this.id_pub = id_pub;
		this.name_pub = name_pub;
	}

	public Publicity(String name_pub) {
		super();
		this.name_pub = name_pub;
	}

	public long getId_pub() {
		return id_pub;
	}

	public void setId_pub(long id_pub) {
		this.id_pub = id_pub;
	}

	public String getName_pub() {
		return name_pub;
	}

	public void setName_pub(String name_pub) {
		this.name_pub = name_pub;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id_pub ^ (id_pub >>> 32));
		result = prime * result + ((name_pub == null) ? 0 : name_pub.hashCode());
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
		Publicity other = (Publicity) obj;
		if (id_pub != other.id_pub)
			return false;
		if (name_pub == null) {
			if (other.name_pub != null)
				return false;
		} else if (!name_pub.equals(other.name_pub))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Publicity [id_pub=" + id_pub + ", name_pub=" + name_pub + "]";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	
	
	
}
