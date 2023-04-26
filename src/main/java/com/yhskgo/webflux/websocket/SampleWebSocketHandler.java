package com.yhskgo.webflux.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yhskgo.webflux.model.Student;
import com.yhskgo.webflux.repository.StudentMongoRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class SampleWebSocketHandler implements WebSocketHandler {
	
	private ObjectMapper objMapper = new ObjectMapper();
	
	@Autowired
	StudentMongoRepository studentMongoRepository;
	

	@Override
	public Mono<Void> handle(WebSocketSession webSocketSession) {
		// TODO Auto-generated method stub
		Flux<Student> allStudentSource = studentMongoRepository.findAll();
		System.out.println("***** Incoming message ***** ");
		webSocketSession.receive().subscribe(System.out::println);
		
		System.out.println(" ***** Sending Student data *****");
		
		return webSocketSession.send(allStudentSource.map(student->{
				return writeValueAsSTring(student);
			}).map(webSocketSession::textMessage)
		);
	}
	
	
	private String writeValueAsSTring(Object obj) {
		// TODO Auto-generated method stub
		try {
			return objMapper.writeValueAsString(obj);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return "No data";
	}

}
