package com.vidvaan.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vidvaan.dao.ProductDAO;
import com.vidvaan.model.Product;

public class ProductTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		
//		Product product = new Product();
//		product.setPname("mobile");
//		product.setPid(2);
//		product.setPcost(22000.0);
		
		ProductDAO productDAO = (ProductDAO) applicationContext.getBean("productDAO");
//		productDAO.add(product);
//		productDAO.deleteById(1);
		productDAO.findById(2);
		System.out.println(productDAO.findAllPnames());
	}
}
