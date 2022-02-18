package tn.esprit.spring.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Distance_fees  implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
   private int id;
   private int min;
   private int max;
   private float fees;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getMin() {
	return min;
}
public void setMin(int min) {
	this.min = min;
}
public int getMax() {
	return max;
}
public void setMax(int max) {
	this.max = max;
}
public float getFees() {
	return fees;
}
public void setFees(float fees) {
	this.fees = fees;
}
   
   
  
}
