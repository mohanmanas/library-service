package com.jpop.libraryservice.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.stereotype.Service;
import com.jpop.libraryservice.model.Library;
import com.jpop.libraryservice.repository.LibraryRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;

@Service
@Transactional
@Slf4j
public class LibraryServiceImpl implements LibraryService{

	@Autowired
	private LibraryRepository libraryRepository;
	
	@Autowired
	private KafkaTemplate<String, BookEvent> kafkaTemplate;
	
	private static final String BOOK = "book";

	@Override
	public void issueBookToUser(int userId, int bookId) {
		try {
			Library library = Library.builder().userId(userId).bookId(bookId).startDate(LocalDateTime.now()).build();
			libraryRepository.save(library);
			publishBookEvent(bookId, true);
		} catch(Exception exception) {
			
		}
	}
	
	@Override
	public void returnBookFromUser(int userId, int bookId) {
		Library library = libraryRepository.findByUserIdAndBookId(userId, bookId);
		library.setEndDate();
		publishBookEvent(bookId, false);
	}
	
	private void publishBookEvent(int bookId, boolean bookAssigned) {
		BookEvent bookEvent = BookEvent.builder().bookId(bookId).bookAssigned(bookAssigned).build();
		Message<BookEvent> message = MessageBuilder.withPayload(bookEvent).setHeader(KafkaHeaders.TOPIC, BOOK).build();
		kafkaTemplate.setMessageConverter(new StringJsonMessageConverter());
		kafkaTemplate.send(message).addCallback(
				result-> log.info("message successfully published to topic {}",BOOK),
				exception-> log.error("message failed to publish to topic {}", BOOK));
	}
}