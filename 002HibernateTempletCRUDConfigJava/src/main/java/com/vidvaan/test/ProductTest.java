package com.vidvaan.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vidvaan.config.SpringConfig;
import com.vidvaan.dao.ProductDAO;
import com.vidvaan.model.Product;

public class ProductTest {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
		
		Product product = new Product();
		product.setPname("tv");
		product.setPid(3);
		product.setPcost(25000.0);
		
		ProductDAO productDAO = (ProductDAO) applicationContext.getBean("productDAO");
		productDAO.add(product);
//		productDAO.deleteById(1);
//		productDAO.findById(2);
//		System.out.println(productDAO.findAllPnames());
	}
}
