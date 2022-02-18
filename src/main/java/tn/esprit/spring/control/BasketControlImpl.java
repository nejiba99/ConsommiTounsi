package tn.esprit.spring.control;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Basket;
import tn.esprit.spring.entity.Orders;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.service.IBasketService;
import tn.esprit.spring.service.IOrdersService;


@Controller

public class BasketControlImpl  {
	@Autowired
	 IOrdersService ordersService;
	@Autowired
	 IBasketService basketService;
	
	public BasketControlImpl(IOrdersService ordersService) {
		super();
		this.ordersService = ordersService;
	}

	//http://localhost:8086/add-basket
	 @PostMapping("/add-basket")
	  @ResponseBody
	  public Basket addorders(@RequestBody Basket b) {
			

		  Basket order = basketService.addBasket(b);
	  return order;
	  }
	
	  // ValidateBasket  :
	  	// http://localhost:8086/ValidateBasket/{id_basket}/{id_client}/{type-tp}
	@PutMapping("/ValidateBasket/{id_basket}/{id_client}/{type-tp}")
	@ResponseBody
	public void ValidateOrder(@PathVariable("id_basket") int basketId, @PathVariable("id_client") int clientId,@PathVariable("type-tp") String tp) {
		basketService.ValidateBasket(basketId, clientId, tp);
	}
	  //Reduction  :
		// http://localhost:8086/Reduction/{id_basket}
		@PutMapping("/Reduction/{id_basket}")
		@ResponseBody
		public void Reduction(@PathVariable("id_basket") int basketId) {
			basketService.Reduction(basketId);
		}
	
		
		
     }
