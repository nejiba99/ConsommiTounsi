package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Message;

public interface IChatMessageService {
	List<Message> retrieveHistory();
	Message addMessage(Message message);

}
