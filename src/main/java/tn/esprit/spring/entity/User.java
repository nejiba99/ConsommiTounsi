package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="User")
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_user ;
	
	private String last_name_user ;
	
	private String first_name_user ;
	
	@Temporal (TemporalType.DATE)
	private Date date_of_birth_user ;
	
	private String address_user ;
	
	private String email_user ;
	
	private String username ;
	
	private String password_user ;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy="user")
	private Set<Claim> claims ;

	public User() {
		super();
	}

	public User(long id_user, String last_name_user, String first_name_user, Date date_of_birth_user,
			String address_user, String email_user, String password_user) {
		super();
		this.id_user = id_user;
		this.last_name_user = last_name_user;
		this.first_name_user = first_name_user;
		this.date_of_birth_user = date_of_birth_user;
		this.address_user = address_user;
		this.email_user = email_user;
		this.password_user = password_user;
	}

	public User(String last_name_user, String first_name_user, Date date_of_birth_user, String address_user,
			String email_user, String password_user) {
		super();
		this.last_name_user = last_name_user;
		this.first_name_user = first_name_user;
		this.date_of_birth_user = date_of_birth_user;
		this.address_user = address_user;
		this.email_user = email_user;
		this.password_user = password_user;
	}

	public long getId_user() {
		return id_user;
	}

	public void setId_user(long id_user) {
		this.id_user = id_user;
	}

	public String getLast_name_user() {
		return last_name_user;
	}

	public void setLast_name_user(String last_name_user) {
		this.last_name_user = last_name_user;
	}

	public String getFirst_name_user() {
		return first_name_user;
	}

	public void setFirst_name_user(String first_name_user) {
		this.first_name_user = first_name_user;
	}

	public Date getDate_of_birth_user() {
		return date_of_birth_user;
	}

	public void setDate_of_birth_user(Date date_of_birth_user) {
		this.date_of_birth_user = date_of_birth_user;
	}

	public String getAddress_user() {
		return address_user;
	}

	public void setAddress_user(String address_user) {
		this.address_user = address_user;
	}

	public String getEmail_user() {
		return email_user;
	}

	public void setEmail_user(String email_user) {
		this.email_user = email_user;
	}

	public String getPassword_user() {
		return password_user;
	}

	public void setPassword_user(String password_user) {
		this.password_user = password_user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address_user == null) ? 0 : address_user.hashCode());
		result = prime * result + ((date_of_birth_user == null) ? 0 : date_of_birth_user.hashCode());
		result = prime * result + ((email_user == null) ? 0 : email_user.hashCode());
		result = prime * result + ((first_name_user == null) ? 0 : first_name_user.hashCode());
		result = prime * result + (int) (id_user ^ (id_user >>> 32));
		result = prime * result + ((last_name_user == null) ? 0 : last_name_user.hashCode());
		result = prime * result + ((password_user == null) ? 0 : password_user.hashCode());
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
		User other = (User) obj;
		if (address_user == null) {
			if (other.address_user != null)
				return false;
		} else if (!address_user.equals(other.address_user))
			return false;
		if (date_of_birth_user == null) {
			if (other.date_of_birth_user != null)
				return false;
		} else if (!date_of_birth_user.equals(other.date_of_birth_user))
			return false;
		if (email_user == null) {
			if (other.email_user != null)
				return false;
		} else if (!email_user.equals(other.email_user))
			return false;
		if (first_name_user == null) {
			if (other.first_name_user != null)
				return false;
		} else if (!first_name_user.equals(other.first_name_user))
			return false;
		if (id_user != other.id_user)
			return false;
		if (last_name_user == null) {
			if (other.last_name_user != null)
				return false;
		} else if (!last_name_user.equals(other.last_name_user))
			return false;
		if (password_user == null) {
			if (other.password_user != null)
				return false;
		} else if (!password_user.equals(other.password_user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", last_name_user=" + last_name_user + ", first_name_user="
				+ first_name_user + ", date_of_birth_user=" + date_of_birth_user + ", address_user=" + address_user
				+ ", email_user=" + email_user + ", password_user=" + password_user + "]";
	}

	public Set<Claim> getClaims() {
		return claims;
	}

	public void setClaims(Set<Claim> claims) {
		this.claims = claims;
	}
	
	
}
