package com.yhskgo.webflux.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document(collection="Student")
public class Student {
	@Id
	@JsonIgnore
	private String id;
	
	@NotNull(message="Roll no can not be empty")
	private Integer rollNo;
	
	@NotNull(message="Name can not be empty")
	private String name;
	
	@NotNull(message="Standard can not be empty")
	private Integer standard;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the rollNo
	 */
	public Integer getRollNo() {
		return rollNo;
	}

	/**
	 * @param rollNo the rollNo to set
	 */
	public void setRollNo(Integer rollNo) {
		this.rollNo = rollNo;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the standard
	 */
	public Integer getStandard() {
		return standard;
	}

	/**
	 * @param standard the standard to set
	 */
	public void setStandard(Integer standard) {
		this.standard = standard;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", standard=" + standard + "]";
	}
	
	
	

}
