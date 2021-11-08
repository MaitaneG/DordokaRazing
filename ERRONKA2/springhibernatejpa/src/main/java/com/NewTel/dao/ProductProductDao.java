package com.NewTel.dao;

import javax.persistence.EntityManager;
import java.util.List;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import eus.uni.dam.ProductProduct;
import org.springframework.stereotype.Repository;

//import com.NewTel.Model.ProductProduct;

@Repository
@Transactional
public class ProductProductDao {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	/**
	 * produktua sortzean persistentzia izateko
	 * @param product
	 */
	public void create(ProductProduct product) {
		entityManager.persist(product);
		return;
	}
	
	
	
	/**
	 * produktua ezabatzeko; produktu bat jasotzen du
	 * @param product
	 */
	public void delete(ProductProduct product) {
		if (entityManager.contains(product)) entityManager.remove(product);
		else {
			entityManager.remove(entityManager.merge(product));
		}
		return;
	}
	
	
	/**
	 * produktuen select bat egiten du eta produktuen lista bat itzultzen du
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<ProductProduct> getAll(){
		return entityManager.createQuery("from ProductProduct").getResultList();
	}
	
	
	/**
	 * produktua id bidez bilatzen du
	 * @param id
	 * @return
	 */
	public ProductProduct getById(long id) {
		return entityManager.find(ProductProduct.class, id);
	}
	
	
	/**
	 * zegoen produktua updateatu egiten du.
	 * @param product
	 */
	public void update(ProductProduct product) {
		entityManager.merge(product);
		return;
	}
}

