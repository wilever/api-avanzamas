package com.dev.back.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ciudades")
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cityId;
	
	@Column(name="nombre")
	private String name;
	
	@JsonIgnore
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(
			name="province_id",
			insertable=false,
			updatable=false,
			nullable=true)
	private Province province;
	
	public City() {
		
	}
	
	public City(Integer cityId, String name, Province province) {
		
		this.cityId = cityId;
		this.name = name;
		this.province = province;
	}
	
	

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}
	
}
