package com.dev.back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("COMPRADORES")
@Entity
@Table(name="compradores")
public class Buyer {

	@ApiModelProperty(value="Identificador")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer buyerId;
	
	@ApiModelProperty(value="Nombre")
	@Size(max=250)
	@Column(name="nombre")
	private String name;
	
	public Buyer() {
		
	}
	
	public Buyer(Integer buyerId, String name) {
		super();
		this.buyerId = buyerId;
		this.name = name;
	}

	public Integer getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Integer buyerId) {
		this.buyerId = buyerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
