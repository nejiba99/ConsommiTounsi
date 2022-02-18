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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Orders")
public class Orders implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_order;
	private String  Status_order;
	private float fees_order;

	@Temporal (TemporalType.DATE)
	private Date date_order;
	
	private int quantity ;
	
	@OneToOne(mappedBy="orders")
	private Delivery delivery ; 
	
	@ManyToOne
	private Product product;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Product> products;
	
	@ManyToOne
	Basket basket; 
	
	
	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	

	
	

	public Orders() {
		super();	
	}



	public long getId_order() {
		return id_order;
	}

	public void setId_order(long id_order) {
		this.id_order = id_order;
	}

	public String getStatus_order() {
		return Status_order;
	}

	public void setStatus_order(String status_order) {
		Status_order = status_order;
	}

	public float getFees_order() {
		return fees_order;
	}

	public void setFees_order(float fees_order) {
		this.fees_order = fees_order;
	}

	

	public Date getDate_order() {
		return date_order;
	}

	public void setDate_order(Date date_order) {
		this.date_order = date_order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Basket getBasket() {
		return basket;
	}

	public void setBasket(Basket basket) {
		this.basket = basket;
	}


	
	
}
