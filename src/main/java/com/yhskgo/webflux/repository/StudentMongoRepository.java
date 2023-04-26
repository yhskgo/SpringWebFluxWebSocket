package com.yhskgo.webflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.yhskgo.webflux.model.Student;

import reactor.core.publisher.Mono;

public interface StudentMongoRepository extends ReactiveMongoRepository<Student, String> {
	public Mono<Student> findByRollNo(Integer rollNo);
	public Mono<Student> findByName(String name);

}
