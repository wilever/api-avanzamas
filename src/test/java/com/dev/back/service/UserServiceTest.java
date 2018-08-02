package com.dev.back.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.dev.back.myapi;
import com.dev.back.entity.User;
import com.dev.back.util.MyApiResponse.message;
import com.fasterxml.jackson.databind.ObjectMapper;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { myapi.class })
@WebAppConfiguration
public class UserServiceTest {
	
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	private String path = "/api/user";

	private User user = new User(1l, "cc", "newName", "apellidos", null);

	@Autowired
	private ObjectMapper mapper;
	
	@Before
	public void setup() throws Exception {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void testServletContext() {
	    ServletContext servletContext = wac.getServletContext();
	    Assert.assertNotNull(servletContext);
	    Assert.assertTrue(servletContext instanceof MockServletContext);
	    Assert.assertNotNull(wac.getBean("userController"));
	}
	
	@Test
	public void test10_getData_no_content() throws Exception {
		mockMvc.perform(
				get(path))
		.andDo(print())
		.andExpect(status().isNoContent());
	}

	@Test
	public void test20_postData_success() throws Exception {
		mockMvc.perform(
				post(path)
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(user)))
		.andDo(print())
		.andExpect(status().isCreated())
		.andExpect(jsonPath("$.message").value(message.DATA_SAVED.toString()));
	}
	
	@Test
	public void test30_postData_fail() throws Exception {
		mockMvc.perform(
				post(path)
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(user)))
		.andDo(print())
		.andExpect(status().isConflict())
		.andExpect(jsonPath("$.message").value(message.DATA_ALREADY_EXIST.toString()));
	}
	
	@Test
	public void test40_getData_ok() throws Exception {
		mockMvc.perform(
				get(path))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.[0].id").value(user.getId()))
		.andExpect(jsonPath("$.[0].cc").value(user.getCc()))
		.andExpect(jsonPath("$.[0].name").value(user.getName()))
		.andExpect(jsonPath("$.[0].lastName").value(user.getLastName()))
		.andExpect(jsonPath("$.[0].state").value(user.getState()))
		.andExpect(jsonPath("$.[1]").doesNotExist());
	}
	
	@Test
	public void test50_putData_success() throws Exception {
		mockMvc.perform(
				put(path+"/?id="+user.getId())
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(user)))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.message").value(message.DATA_SAVED.toString()));
	}
	
	@Test
	public void test60_putData_id_no_exist() throws Exception {
		mockMvc.perform(
				put(path+"/?id="+777l)
				.contentType(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(user)))
		.andDo(print())
		.andExpect(status().isConflict())
		.andExpect(jsonPath("$.message").value(message.DATA_NO_EXIST.toString()));
	}
	
	@Test
	public void test70_deleteData_success() throws Exception {
		mockMvc.perform(
				delete(path+"/?id="+user.getId()))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.message").value(message.DATA_DELETED.toString()));
	}
	
	@Test
	public void test80_deleteData_id_no_exist() throws Exception {
		mockMvc.perform(
				delete(path+"/?id="+777l))
		.andDo(print())
		.andExpect(status().isConflict())
		.andExpect(jsonPath("$.message").value(message.DATA_NO_EXIST.toString()));
	}
}
