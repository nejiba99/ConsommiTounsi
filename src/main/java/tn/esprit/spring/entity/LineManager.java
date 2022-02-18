package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class LineManager extends User implements Serializable{

	private String Status ;
	
	@OneToOne
	private Line line; 


	public LineManager(String status) {
		super();
		Status = status;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "LineManager [Status=" + Status + "]";
	}

	public LineManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Line getLine() {
		return line;
	}

	public void setLine(Line line) {
		this.line = line;
	}
	
	
}
