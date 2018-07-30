package com.dev.back.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dev.back.entity.Sale;
import com.dev.back.util.MyReportByCountry;
import com.dev.back.util.MyReportByMonth;

@Repository
public interface SaleRepo extends JpaRepository<Sale, Integer>{

	@Query("select new com.dev.back.util.MyReportByCountry("+ 
			"s.city.province.country.name, " +
			"sum(s.quantity), " + 
			"sum(s.quantity*s.value)) "+
			"from Sale s " +
			"where s.city.province.country.name = ?1 "+
			"group by s.city.province.country.name ")
	List<MyReportByCountry> getReportByCountry(String country);
	
	List<Sale> findByBuyer_Name(String buyerName);
	
	@Query("select new com.dev.back.util.MyReportByMonth("+ 
			"month(s.date), " +
			"sum(s.quantity), " + 
			"sum(s.quantity*s.value)) "+
			"from Sale s " +
			"where s.date < cast(?1 as date) "+
			"and s.date >= cast(?2 as date) "+
			"group by s.date "+
			"order by s.date desc")
	List<MyReportByMonth> getReportByMonth(String max, String min);
}
