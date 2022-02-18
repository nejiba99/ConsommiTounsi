package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Admin")
public class Admin extends User implements Serializable{

	private String grade_admin ;

	public Admin() {
		super();
	}

	public Admin(String grade_admin) {
		super();
		this.grade_admin = grade_admin;
	}

	public String getGrade_admin() {
		return grade_admin;
	}

	public void setGrade_admin(String grade_admin) {
		this.grade_admin = grade_admin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((grade_admin == null) ? 0 : grade_admin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (grade_admin == null) {
			if (other.grade_admin != null)
				return false;
		} else if (!grade_admin.equals(other.grade_admin))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Admin [grade_admin=" + grade_admin + "]";
	}
	
	
}
