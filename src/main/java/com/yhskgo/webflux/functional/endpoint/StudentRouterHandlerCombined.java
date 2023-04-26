package com.yhskgo.webflux.functional.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.yhskgo.webflux.model.Student;
import com.yhskgo.webflux.repository.StudentMongoRepository;

@Configuration
public class StudentRouterHandlerCombined {
	
	@Autowired
	private StudentMongoRepository studentMongoRepository;
	
	@Bean
	RouterFunction<ServerResponse> returnStudentWithCombineFun() {
		HandlerFunction<ServerResponse> studentHandler = serverRequest -> {
			int rollNo = getInt(serverRequest.pathVariable("rollNo"));
			return ServerResponse.ok().body(studentMongoRepository.findByRollNo(rollNo), Student.class);
		};
		
		RouterFunction<ServerResponse> studentResponse = RouterFunctions.route(RequestPredicates.GET("/api/f/combine/getStudent/{rollNo}"), studentHandler);
		
		return studentResponse;
		
	}
	
	@Bean
	RouterFunction<ServerResponse> returnAllStudentWithCombineFun() {
		HandlerFunction<ServerResponse> studentHandler = serverRequest -> 
			ServerResponse.ok().body(studentMongoRepository.findAll(), Student.class);
			
		RouterFunction<ServerResponse> studentResponse = RouterFunctions.route(RequestPredicates.GET("/api/f/combine/getAllStudent"), studentHandler);

		return studentResponse;
	}

	private int getInt(String intStr) {
		// TODO Auto-generated method stub
		int returnVal = 0;
		if(intStr!=null && !intStr.isEmpty()) {
			try {
				returnVal = Integer.parseInt(intStr);
			} catch(Exception e) {
				e.printStackTrace();
				
			}
		}
		return returnVal;
	}
	
	

}
