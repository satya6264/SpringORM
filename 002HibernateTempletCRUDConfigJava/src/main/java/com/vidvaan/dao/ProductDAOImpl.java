package com.vidvaan.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.vidvaan.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public int add(Product product) {
		
		return (Integer) hibernateTemplate.save(product);
	}

	public void update(Product product) {
		hibernateTemplate.update(product);
		
	}

	public void deleteById(int pid) {
		Product product = new Product();
		product.setPid(pid);
		hibernateTemplate.delete(product);
		
	}

	public Product findById(int pid) {
		return hibernateTemplate.get(Product.class, pid);
	}

	public List<Product> findAll() {
		
		DetachedCriteria criteria = DetachedCriteria.forClass(Product.class);
        hibernateTemplate.findByCriteria(criteria);
		
		return hibernateTemplate.loadAll(Product.class);
	}

	public List<String> findAllPnames() {
		return (List<String>) hibernateTemplate.find("select pname from Product",new Object[] {});
	}

	public Product findByIdHql(int pid) {
		return (Product) hibernateTemplate.find("select * from Product p where p.pid = ?", new Object[] {pid});
	}

	
	


	
	
	
	
	
	
	
}