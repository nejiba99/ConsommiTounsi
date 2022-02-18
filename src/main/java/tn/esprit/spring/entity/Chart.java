package tn.esprit.spring.entity;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class Chart {
	@JsonSerialize(using = NestedDeliveryManSerializer.class)
 private DeliveryMan deliveryman;
 private double sumPremium;
 private long countPremium;

 
public DeliveryMan getDeliveryman() {
	return deliveryman;
}
public void setDeliveryman(DeliveryMan deliveryman) {
	this.deliveryman = deliveryman;
}
public double getSumPremium() {
	return sumPremium;
}
public void setSumPremium(double sumPremium) {
	this.sumPremium = sumPremium;
}
public long getCountPremium() {
	return countPremium;
}
public void setCountPremium(long countPremium) {
	this.countPremium = countPremium;
}
public Chart(DeliveryMan deliveryman, double sumPremium, long countPremium) {
	super();
	this.deliveryman = deliveryman;
	this.sumPremium = sumPremium;
	this.countPremium = countPremium;
}
 

public static class NestedDeliveryManSerializer extends StdSerializer<DeliveryMan> {

    public NestedDeliveryManSerializer() {
        this(null);
    }

    public NestedDeliveryManSerializer(Class<DeliveryMan> t) {
        super(t);
    }

    @Override
    public void serialize(DeliveryMan account, JsonGenerator generator, SerializerProvider provider) throws IOException {
        generator.writeObject(new DeliveryManView(account.getId_user(), account.getFirst_name_user()));
    }

    private static class DeliveryManView {
        @JsonProperty
        private final String name;
        @JsonProperty
        private final long id;

        public DeliveryManView( long id,String name) {
            this.name = name;
            this.id = id;
        }
    }
}
 
}
