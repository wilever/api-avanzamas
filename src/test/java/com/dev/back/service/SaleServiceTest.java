package com.dev.back.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.servlet.ServletContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dev.back.myapi;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { myapi.class })
@WebAppConfiguration
public class SaleServiceTest {
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	private String path = "/api/sale/report";
	
	@Before
	public void setup() throws Exception {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testServletContext() {
	    ServletContext servletContext = wac.getServletContext();
	    Assert.assertNotNull(servletContext);
	    Assert.assertTrue(servletContext instanceof MockServletContext);
	    Assert.assertNotNull(wac.getBean("saleController"));
	}
	
	@Test
	public void test10_getReport_by_country() throws Exception {
		String country= "country_0";
		mockMvc.perform(
				get(path+"?country="+country))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].country").value(country))
		.andExpect(jsonPath("$[0].quantity").exists())
		.andExpect(jsonPath("$[0].earnings").exists())
		.andExpect(jsonPath("$[1]").doesNotExist());
	}
	
	@Test
	public void test20_getReport_by_buyer() throws Exception {
		String buyer= "buyer_0";
		mockMvc.perform(
				get(path+"?buyer="+buyer))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].buyerName").value(buyer))
		.andExpect(jsonPath("$[1].buyerName").value(buyer))
		.andExpect(jsonPath("$[2]").doesNotExist());
	}
	
	@Test
	public void test30_getReport() throws Exception {
		mockMvc.perform(
				get(path))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].month").exists())
		.andExpect(jsonPath("$[5].month").exists())
		.andExpect(jsonPath("$[6]").doesNotExist());
	}
}
