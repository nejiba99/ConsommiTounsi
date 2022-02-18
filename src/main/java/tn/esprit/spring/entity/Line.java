package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Line implements Serializable{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id ;
	
	@Column(name="Name")
	private String name ;
	
	@Column(name="Number_Places")
	private int number_places ;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Type")
	private Type TypeLine ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="line")
	private Set<Product> products;
	
	@OneToOne(mappedBy="line")
	private LineManager linemanager; 


	public Line() {
		super();
	}

	public Line(Long id, String name, int number_places, Type typeLine) {
		super();
		this.id = id;
		this.name = name;
		this.number_places = number_places;
		TypeLine = typeLine;
	}

	public Line(String name, int number_places, Type typeLine) {
		super();
		this.name = name;
		this.number_places = number_places;
		TypeLine = typeLine;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber_places() {
		return number_places;
	}

	public void setNumber_places(int number_places) {
		this.number_places = number_places;
	}

	public Type getTypeLine() {
		return TypeLine;
	}

	public void setTypeLine(Type typeLine) {
		TypeLine = typeLine;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((TypeLine == null) ? 0 : TypeLine.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number_places;
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
		Line other = (Line) obj;
		if (TypeLine != other.TypeLine)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number_places != other.number_places)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Line [id=" + id + ", name=" + name + ", number_places=" + number_places + ", TypeLine=" + TypeLine
				+ "]";
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public LineManager getLinemanager() {
		return linemanager;
	}

	public void setLinemanager(LineManager linemanager) {
		this.linemanager = linemanager;
	}
	
	
	
}
