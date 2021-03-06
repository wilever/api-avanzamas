package com.dev.back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="USUARIOS")
@Entity
@Table(name="usuarios")
public class User {

	@ApiModelProperty(value= "Identificador. El valor es autogenerado iniciado desde 0 e incrementadose en 1", required=true)
	@Id
	private Long id;
	
	@ApiModelProperty(value= "Campo CC")
	@Column
	private String cc;
	
	@ApiModelProperty(value= "Nombres")
	@Column(name="nombres")
	private String name;
	
	@ApiModelProperty(value= "Apellidos")
	@Column(name="apellidos")
	private String lastName;
	
	@ApiModelProperty(value= "Estado")
	@Column(name="estado")
	private String state;

	public User() {
		
	}

	public User(Long id, String cc, String name, String lastName, String state) {
		
		this.id = id;
		this.cc = cc;
		this.name = name;
		this.lastName = lastName;
		this.state = state;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}	
}
