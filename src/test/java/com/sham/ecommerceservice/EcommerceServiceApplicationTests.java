package com.sham.ecommerceservice;

import com.sham.ecommerceservice.pojo.ProductPojo;
import com.sham.ecommerceservice.repository.ProductRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class EcommerceServiceApplicationTests {

	@Container
	private static final MySQLContainer MY_SQL_CONTAINER = new MySQLContainer("mysql:");

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ProductRepo productRepo;

	@DynamicPropertySource
	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry){
		//dynamicPropertyRegistry.add("spring.datasource.port", MY_SQL_CONTAINER::getExposedPorts); //3306
		dynamicPropertyRegistry.add("spring.datasource.url", MY_SQL_CONTAINER::getJdbcUrl);
		dynamicPropertyRegistry.add("spring.datasource.username", MY_SQL_CONTAINER::getUsername);
		dynamicPropertyRegistry.add("spring.datasource.password", MY_SQL_CONTAINER::getPassword);
		dynamicPropertyRegistry.add("spring.datasource.driver-class-name", MY_SQL_CONTAINER::getDriverClassName);
	}

	@Test
	void shouldCreateProduct() throws Exception {
		ProductPojo productRequest = getProductRequest();
		String productRequestString = objectMapper.writeValueAsString(productRequest);
		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
				.contentType(MediaType.APPLICATION_JSON)
				.content(productRequestString))
				.andExpect(status().isCreated());
		Assertions.assertEquals(1, productRepo.findAll().size());
	}

	private ProductPojo getProductRequest(){
		return ProductPojo.builder()
				.name("Iphone 13")
				.description("Iphone 13 with good camera")
				.price(BigDecimal.valueOf(1200))
				.build();
	}
}
