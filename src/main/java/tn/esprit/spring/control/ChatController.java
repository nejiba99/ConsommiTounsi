package tn.esprit.spring.control;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import tn.esprit.spring.entity.Client;
import tn.esprit.spring.entity.Message;
import tn.esprit.spring.service.IChatMessageService;



@Controller
public class ChatController {

    @Autowired
    IChatMessageService chatService;
    
    
	@MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message message) throws ParseException {
        Date date=new Date();
        date.setHours(date.getHours()+1);
        message.setDate(date);
        return chatService.addMessage(message);
        
    }

    @MessageMapping("/chat.getHistory")
    @SendTo("/topic/public")
    public List<Message> history(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) throws ParseException {
    headerAccessor.getSessionAttributes().put("username", message.getSender().getFirst_name_user()+message.getSender().getLast_name_user());
    return chatService.retrieveHistory();
    }
    
    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Message addUser(@Payload Message message, SimpMessageHeaderAccessor headerAccessor) {
    headerAccessor.getSessionAttributes().put("username", message.getSender().getFirst_name_user()+message.getSender().getLast_name_user());
    return message;
    }
}