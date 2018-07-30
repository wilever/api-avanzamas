package com.dev.back.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ventas")
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Transient
	private String buyerName;
	
	@Transient
	private String cityName;
	
	@Column(name="cantidad")
	private Integer quantity;
	
	@Column(name="valor")
	private Float value;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Temporal(TemporalType.DATE)
	@Column(name="fecha")
	private Date date;
	
	@JsonIgnore
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(
			name="buyer_id")
	private Buyer buyer;
	
	@JsonIgnore
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(
			name="city_id")
	private City city;
	
	public Sale() {
		
	}
	
	public Sale(Integer id, Integer quantity, Float value, Date date, Buyer buyer, City city) {
		
		this.id = id;
		this.quantity = quantity;
		this.value = value;
		this.date = date;
		this.buyer = buyer;
		this.city = city;
	}
	
	@PostLoad
	private void postLoad() {
		if(buyer!=null) {
			this.buyerName= buyer.getName();
		}
		if(city!=null) {
			this.cityName= city.getName();
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quatity) {
		this.quantity = quatity;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Buyer getBuyer() {
		return buyer;
	}

	public void setBuyer(Buyer buyer) {
		this.buyer = buyer;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
