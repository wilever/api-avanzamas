package com.dev.back.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="paises")
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer countryId;
	
	@Column(name="nombre")
	private String name;
	
	@JsonIgnore
	@OneToMany(
			fetch=FetchType.EAGER,
			cascade=CascadeType.ALL,
			mappedBy="provinceId")
	private Set<Province> provinces;
	
	public Country() {
		
	}
	
	public Country(Integer countryId, String name, Set<Province> provinces) {
		
		this.countryId = countryId;
		this.name = name;
		this.provinces = provinces;
	}

	public Integer getCountryId() {
		return countryId;
	}

	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Province> getProvinces() {
		return provinces;
	}

	public void setProvinces(Set<Province> provinces) {
		this.provinces = provinces;
	}
	
}
