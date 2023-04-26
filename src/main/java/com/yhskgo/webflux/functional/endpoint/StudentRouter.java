package com.yhskgo.webflux.functional.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


import com.yhskgo.webflux.websocket.SampleWebSocketHandler;

@Configuration
public class StudentRouter {
	
	@Autowired
	private StudentHandler studentHandler;
	
	@Autowired
	SampleWebSocketHandler studentWebSocketHandler;
	
	@Bean
	RouterFunction<ServerResponse> returnStudent() {
		return RouterFunctions.route(RequestPredicates.GET("/api/f/getStudent/{rollNol}"), studentHandler::getStudent);
		
	}
	
	@Bean
	RouterFunction<ServerResponse> returnAllStudent() {
		return RouterFunctions.route(RequestPredicates.GET("/api/f/getAllStudent"), studentHandler::getAllStudent);
	}

}
