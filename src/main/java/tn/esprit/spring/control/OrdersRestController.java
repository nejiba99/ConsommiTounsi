package tn.esprit.spring.control;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Orders;
import tn.esprit.spring.entity.Product;
import tn.esprit.spring.entity.User;
import tn.esprit.spring.repository.OrdersRepository;
import tn.esprit.spring.service.IBasketService;
import tn.esprit.spring.service.IOrdersService;
import tn.esprit.spring.service.MailService;

@RestController
public class OrdersRestController {

	@Autowired
	IOrdersService ordersService;
	@Autowired
	 IBasketService basketService;

	@Autowired
	private OrdersRepository orderrepository;

	@Autowired
	private MailService notificationService;


	private User user;
	// afficher les orders with product
	// http://localhost:8086/ConsomiTounsi/servlet/ordersproduct/{id_prod}
	@GetMapping("/ordersproduct/{id_prod}")
	@ResponseBody
	public List<Orders> getordersbyproducts(@PathVariable("id_prod") Product product) {
		List<Orders> list = ordersService.GetOrderrsByProduct(product);
		return list;
	}
	
	
	//CRUD ORDERS
	
	 // ADD Order : 
	//http://localhost:8086/add-orders
 @PostMapping("/add-orders")
 @ResponseBody
 public Orders addorders(@RequestBody Orders o) {
	  Orders order = ordersService.addorders(o);
 return order;
 }

// http://localhost:8086/remove-orders/{orders-id}
  @DeleteMapping("/remove-orders/{orders-id}")
  @ResponseBody
  public void removeorders(@PathVariable("orders-id") String ordersId) {
	   ordersService.removeorders(ordersId);
  }
 
  // http://localhost:8086/modify-orders
  @PutMapping("/modify-orders")
  @ResponseBody
  public Orders modifyOrder(@RequestBody Orders ordersId) {
  return ordersService.updateorders(ordersId);
  }


// http://localhost:8086/retrieve-all-orders
@GetMapping("/retrieve-all-orders")
@ResponseBody
public List<Orders> getOrders() {
List<Orders> list = ordersService.retrieveAll();
return list;
}

// http://localhost:8086/retrieve-orders/{orders-id}
 @GetMapping("/retrieve-orders/{orders-id}")
 @ResponseBody
 public Orders retrieveOrder(@PathVariable("orders-id") String ordersId) {
 return ordersService.retrieveorders(ordersId);
 }
 
 // Affecter order to basket  :
 	// http://localhost:8086/affectOrderToBasket/{id_basket}/{id_order}
@PutMapping("/affectOrderToBasket/{id_basket}/{id_order}")
@ResponseBody
public void affectOrderToBasket(@PathVariable("id_basket") int basketId, @PathVariable("id_order") int orderId) {
	ordersService.affecterOrdertoBasket(orderId, basketId);
}

//PDF
// http://localhost:8083/orders/export/pdf
@RequestMapping("/orders/export/pdf")
public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
   response.setContentType("application/pdf");
   DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
   String currentDateTime = dateFormatter.format(new Date());
    
   String headerKey = "Content-Disposition";
   String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
   response.setHeader(headerKey, headerValue);
    
   List<Orders> listorders = ordersService.findAll();
    
   PDFExporter exporter = new PDFExporter(listorders);
   exporter.export(response);
    
}
//MAIL
// http://localhost:8083/send-mail-attachment
@RequestMapping("send-mail-attachment")
public String sendWithAttachment() throws MessagingException {

	/*
	 * Creating a User with the help of User class that we have declared and setting
	 * Email address of the sender.
	 */
	user.setEmail_user("nejibalazzem@gmail.com"); //Receiver's email address

	/*
	 * Here we will call sendEmailWithAttachment() for Sending mail to the sender
	 * that contains a attachment.
	 */
	try {
		notificationService.sendEmailWithAttachment(user);
	} catch (MailException mailException) {
		System.out.println(mailException);
	}
	return "Congratulations! Your mail has been send to the user.";
}
}
