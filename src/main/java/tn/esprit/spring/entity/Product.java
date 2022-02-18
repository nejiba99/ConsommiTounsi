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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Product")
public class Product implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_prod ;
	
	private String name_prod ;
	
	private String description_prod ;
	
	private int quantity ;
	
	private float price_prod ;
	
	private int barcode_prod ;
	
	private String weight_prod ;
	
	private int minvalue_stock ;
	
	@ManyToMany(mappedBy="products", cascade = CascadeType.ALL)
	private Set<Orders> orders;

	
	@OneToMany(mappedBy="product")
	private Set<Claim> claims ;

	@ManyToOne
	private Line line;
	
	@ManyToOne
	private Category category; 
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="product")
	private Set<Publicity> publicity;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="product")
	private Set<Orders> orderss;
	
	public Product() {
		super();
	}

	public Product(long id_prod, String name_prod, String description_prod, int quantity, float price_prod,
			int barcode_prod, String weight_prod) {
		super();
		this.id_prod = id_prod;
		this.name_prod = name_prod;
		this.description_prod = description_prod;
		this.quantity = quantity;
		this.price_prod = price_prod;
		this.barcode_prod = barcode_prod;
		this.weight_prod = weight_prod;
	}

	public Product(String name_prod, String description_prod, int quantity, float price_prod, int barcode_prod,
			String weight_prod) {
		super();
		this.name_prod = name_prod;
		this.description_prod = description_prod;
		this.quantity = quantity;
		this.price_prod = price_prod;
		this.barcode_prod = barcode_prod;
		this.weight_prod = weight_prod;
	}

	public long getId_prod() {
		return id_prod;
	}

	public void setId_prod(long id_prod) {
		this.id_prod = id_prod;
	}

	public String getName_prod() {
		return name_prod;
	}

	public void setName_prod(String name_prod) {
		this.name_prod = name_prod;
	}

	public String getDescription_prod() {
		return description_prod;
	}

	public void setDescription_prod(String description_prod) {
		this.description_prod = description_prod;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice_prod() {
		return price_prod;
	}

	public void setPrice_prod(float price_prod) {
		this.price_prod = price_prod;
	}

	public int getBarcode_prod() {
		return barcode_prod;
	}

	public void setBarcode_prod(int barcode_prod) {
		this.barcode_prod = barcode_prod;
	}

	public String getWeight_prod() {
		return weight_prod;
	}

	public void setWeight_prod(String weight_prod) {
		this.weight_prod = weight_prod;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + barcode_prod;
		result = prime * result + ((description_prod == null) ? 0 : description_prod.hashCode());
		result = prime * result + (int) (id_prod ^ (id_prod >>> 32));
		result = prime * result + ((name_prod == null) ? 0 : name_prod.hashCode());
		result = prime * result + Float.floatToIntBits(price_prod);
		result = prime * result + quantity;
		result = prime * result + ((weight_prod == null) ? 0 : weight_prod.hashCode());
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
		Product other = (Product) obj;
		if (barcode_prod != other.barcode_prod)
			return false;
		if (description_prod == null) {
			if (other.description_prod != null)
				return false;
		} else if (!description_prod.equals(other.description_prod))
			return false;
		if (id_prod != other.id_prod)
			return false;
		if (name_prod == null) {
			if (other.name_prod != null)
				return false;
		} else if (!name_prod.equals(other.name_prod))
			return false;
		if (Float.floatToIntBits(price_prod) != Float.floatToIntBits(other.price_prod))
			return false;
		if (quantity != other.quantity)
			return false;
		if (weight_prod == null) {
			if (other.weight_prod != null)
				return false;
		} else if (!weight_prod.equals(other.weight_prod))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [id_prod=" + id_prod + ", name_prod=" + name_prod + ", description_prod=" + description_prod
				+ ", quantity=" + quantity + ", price_prod=" + price_prod + ", barcode_prod=" + barcode_prod
				+ ", weight_prod=" + weight_prod + "]";
	}

	public Set<Claim> getClaims() {
		return claims;
	}

	public void setClaims(Set<Claim> claims) {
		this.claims = claims;
	}

	

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Set<Publicity> getPublicity() {
		return publicity;
	}

	public void setPublicity(Set<Publicity> publicity) {
		this.publicity = publicity;
	}

	public int getMinvalue_stock() {
		return minvalue_stock;
	}

	public void setMinvalue_stock(int minvalue_stock) {
		this.minvalue_stock = minvalue_stock;
	}

	public Set<Orders> getOrders() {
		return orders;
	}

	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	
	
}
