package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Weight_fees implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
   private float min;
   private float max;
   private float fees;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public float getMin() {
	return min;
}
public void setMin(float min) {
	this.min = min;
}
public float getMax() {
	return max;
}
public void setMax(float max) {
	this.max = max;
}
public float getFees() {
	return fees;
}
public void setFees(float fees) {
	this.fees = fees;
}
   
   
  
}

