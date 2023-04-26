package com.yhskgo.webflux.websocket;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;

@Configuration
@EnableWebFlux
public class SampleWebSocketConfiguration implements WebFluxConfigurer {
	
	@Autowired
	SampleWebSocketHandler studentWebSocketHandler;
	
	@Bean
	public HandlerMapping webSocketHandlerMapping() {
		Map<String, WebSocketHandler> map = new HashMap<>();
		map.put("/student", studentWebSocketHandler);
		
		SimpleUrlHandlerMapping mapping = new SimpleUrlHandlerMapping();
		mapping.setUrlMap(map);
//		mapping.setOrder(-1);//
		return mapping;
	}
	
	@Bean
	public WebSocketHandlerAdapter handlerAdapter() {
		
		return new WebSocketHandlerAdapter();
		
	}
	

}
