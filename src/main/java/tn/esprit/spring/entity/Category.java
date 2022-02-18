package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Category")
public class Category implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_cat ;
	
	private String name_cat ;
	
	private String desc_cat ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="category")
	private Set<Product> product;


	public Category() {
		super();
	}

	public Category(long id_cat, String name_cat, String desc_cat) {
		super();
		this.id_cat = id_cat;
		this.name_cat = name_cat;
		this.desc_cat = desc_cat;
	}

	public Category(String name_cat, String desc_cat) {
		super();
		this.name_cat = name_cat;
		this.desc_cat = desc_cat;
	}

	public long getId_cat() {
		return id_cat;
	}

	public void setId_cat(long id_cat) {
		this.id_cat = id_cat;
	}

	public String getName_cat() {
		return name_cat;
	}

	public void setName_cat(String name_cat) {
		this.name_cat = name_cat;
	}

	public String getDesc_cat() {
		return desc_cat;
	}

	public void setDesc_cat(String desc_cat) {
		this.desc_cat = desc_cat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desc_cat == null) ? 0 : desc_cat.hashCode());
		result = prime * result + (int) (id_cat ^ (id_cat >>> 32));
		result = prime * result + ((name_cat == null) ? 0 : name_cat.hashCode());
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
		Category other = (Category) obj;
		if (desc_cat == null) {
			if (other.desc_cat != null)
				return false;
		} else if (!desc_cat.equals(other.desc_cat))
			return false;
		if (id_cat != other.id_cat)
			return false;
		if (name_cat == null) {
			if (other.name_cat != null)
				return false;
		} else if (!name_cat.equals(other.name_cat))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Category [id_cat=" + id_cat + ", name_cat=" + name_cat + ", desc_cat=" + desc_cat + "]";
	}

	@JsonBackReference
	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	
	
}
