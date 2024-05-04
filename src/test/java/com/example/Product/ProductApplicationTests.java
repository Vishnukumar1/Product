//package com.example.Product;
//
//import com.example.Product.entity.Product;
//import com.example.Product.repository.ProductRepository;
//import com.example.Product.service.ProductService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//
//class ProductApplicationTests {
//
//	@Test
//	void contextLoads() {
//	}
//	@Autowired
//	private ProductService service;
//	@MockBean
//	private ProductRepository repository;
//	@Test
//	public void getProductsTests(){
//		when(repository.findAll())
//				.thenReturn(Stream
//						.of(new Product(1,"apple","apple",30),new Product(2,"mango","mango",20)).collect(Collectors.toList())
//
//	}
//
//}
