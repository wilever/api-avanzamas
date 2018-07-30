package com.dev.back.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="provincias")
public class Province {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer provinceId;
	
	@Column(name="nombre")
	private String name;
	
	@JsonIgnore
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(
			name="country_id",
			//insertable=false,
			//updatable=false,
			nullable=true)
	private Country country;
	
	@JsonIgnore
	@OneToMany(
			fetch=FetchType.EAGER,
			cascade=CascadeType.ALL,
			mappedBy="cityId")
	private Set<City> cities;

	public Province() {
		
	}
	
	public Province(Integer provinceId, String name, Country country, Set<City> cities) {
		
		this.provinceId = provinceId;
		this.name = name;
		this.country = country;
		this.cities = cities;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Set<City> getCities() {
		return cities;
	}

	public void setCities(Set<City> cities) {
		this.cities = cities;
	}
	
}
