package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Comment")
public class Comment implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_comment ;
	
	private String desc_comment ;
	
	private int rating_comment ;
	
	@ManyToOne
	private Subject subject; 

	public Comment() {
		super();
	}

	public Comment(long id_comment, String desc_comment) {
		super();
		this.id_comment = id_comment;
		this.desc_comment = desc_comment;
	}

	public Comment(String desc_comment) {
		super();
		this.desc_comment = desc_comment;
	}

	public long getId_comment() {
		return id_comment;
	}

	public void setId_comment(long id_comment) {
		this.id_comment = id_comment;
	}

	public String getDesc_comment() {
		return desc_comment;
	}

	public void setDesc_comment(String desc_comment) {
		this.desc_comment = desc_comment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desc_comment == null) ? 0 : desc_comment.hashCode());
		result = prime * result + (int) (id_comment ^ (id_comment >>> 32));
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
		Comment other = (Comment) obj;
		if (desc_comment == null) {
			if (other.desc_comment != null)
				return false;
		} else if (!desc_comment.equals(other.desc_comment))
			return false;
		if (id_comment != other.id_comment)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [id_comment=" + id_comment + ", desc_comment=" + desc_comment + "]";
	}

	@JsonBackReference
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public int getRating_comment() {
		return rating_comment;
	}

	public void setRating_comment(int rating_comment) {
		this.rating_comment = rating_comment;
	}
	
	
	
	
}
