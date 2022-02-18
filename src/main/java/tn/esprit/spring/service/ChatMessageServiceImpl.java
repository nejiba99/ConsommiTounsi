package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Message;
import tn.esprit.spring.repository.ChatMessageRepository;

@Service
public class ChatMessageServiceImpl implements IChatMessageService {

	@Autowired
	ChatMessageRepository chatRepo;

	@Override
	public List<Message> retrieveHistory() {
		// TODO Auto-generated method stub
		List<Message> result = new ArrayList<Message>();
		for (Message current : chatRepo.findHistory()) {
			if (current != null) {
				Message newMessage=new Message();
				newMessage.setContent(current.getContent());
				newMessage.setDate(current.getDate());
				newMessage.setType(current.getType());
				newMessage.setSender(current.getSender());
				result.add(newMessage);
			}
		}
		return chatRepo.findHistory();
	}

	@Override
	public Message addMessage(Message message) {
		// TODO Auto-generated method stub
		return chatRepo.save(message);
	}

}
