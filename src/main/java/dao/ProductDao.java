package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Utils.JpaUtils;
import entities.Product;

public class ProductDao {
	private EntityManager eManager;
	
	public ProductDao() {
		this.eManager = JpaUtils.getEntityManager();
	}
	public List<Product> all(){
		String jpql = "SELECT p FROM Product p";
		TypedQuery<Product> query = this.eManager.createQuery(jpql, Product.class);
		List<Product> result = query.getResultList();
		return result;
	}
	public Product create(Product eProduct) throws Exception{
		try {
			this.eManager.getTransaction().begin();
			this.eManager.persist(eProduct);
			this.eManager.getTransaction().commit();
			return eProduct;
		} catch (Exception e) {
			e.printStackTrace();
			this.eManager.getTransaction().rollback();
			throw e;
			// TODO: handle exception
		}
	}
	
	public Product findById(int id) {
		return this.eManager.find(Product.class, id);
	}
	
	public Product delete(Product eProduct) throws Exception{
		try {
			this.eManager.getTransaction().begin();
			this.eManager.remove(eProduct);
			this.eManager.getTransaction().commit();
			return eProduct;
		} catch (Exception e) {
			e.printStackTrace();
			this.eManager.getTransaction().rollback();
			throw e;
			// TODO: handle exception
		}
	}
	
	public Product update(Product eProduct) throws Exception{
		try {
			this.eManager.getTransaction().begin();
			this.eManager.merge(eProduct);
			this.eManager.getTransaction().commit();
			return eProduct;
		} catch (Exception e) {
			e.printStackTrace();
			this.eManager.getTransaction().rollback();
			throw e;
			// TODO: handle exception
		}
	}
}
