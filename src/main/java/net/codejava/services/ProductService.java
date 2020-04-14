package net.codejava.services;

import java.util.List;

import net.codejava.repositories.Product;
import net.codejava.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	public List<Product> listAll() {

		return repo.findAll();
	}
	
	public void save(Product product) {

		repo.save(product);
	}
	
	public Product get(long id) {
		return repo.findById(id).get();
	}
	
	public void delete(long id) {

		repo.deleteById(id);
	}

	public List<Product> findByMadeIn(String madeIn){

		return repo.findByMadein(madeIn);
	}

	public List<Product> findByPriceGreaterThan(float price){

		return repo.findByPriceGreaterThan(price);
	}

	public Product findByName(String name){

		return repo.findByName(name);
	}

	public List<Product> findByNameNotEqual(String name){

		return repo.findByNameNot(name);
	}

	public void deleteByName(String name){

		repo.deleteByName(name);
	}
}
