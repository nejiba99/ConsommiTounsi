package tn.esprit.spring.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.DeliveryMan;
import tn.esprit.spring.repository.DeliveryManRepository;
import tn.esprit.spring.repository.Premium_Repository;


@Service
public class DeliveryManService implements IDeliveryManService {

	
	@Autowired	
	DeliveryManRepository dlmrepo; 
	
	
	
	@Override
	public DeliveryMan addDeliveryMan(DeliveryMan dlm) {
	
		return dlmrepo.save(dlm);
	}

	@Override
	public List<DeliveryMan> getallDeliveryMan() {
		
		return (List<DeliveryMan>) dlmrepo.findAll();
	}

	@Override
	public DeliveryMan getDelivery_manById(long id) {
		
		return dlmrepo.findById(id).orElse(null);
	}

	@Override
	public void deleteDeliveryMan(long id) {
		dlmrepo.deleteById(id);
		
	}

	@Override
	public DeliveryMan updateDeliveryMan(DeliveryMan dlm) {
		
		return dlmrepo.save(dlm);
	}

	@Override
	public Pair<String, String> getTimeDeliveryMan(long id) {
		DeliveryMan d=getDelivery_manById(id);
		if(d!=null){
			DateFormat df=new SimpleDateFormat("hh:mm");
			String startdate=df.format( d.getStartTime());
			String enddate=df.format(d.getEndTime());
			Pair<String,String> ps=Pair.of(startdate, enddate);			
			return ps;
			
		}
		return null;
	}

	
	
}
