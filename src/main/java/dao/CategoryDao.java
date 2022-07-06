package dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Utils.JpaUtils;
import entities.Category;

import java.util.List;

public class CategoryDao {
	private EntityManager eManager;
	public CategoryDao() {
		this.eManager = JpaUtils.getEntityManager();
	}
	public List<Category> all(){
		String jpql = "SELECT c FROM Category c";
		TypedQuery<Category> query = this.eManager.createQuery(jpql, Category.class);
		List<Category> result = query.getResultList();
		return result;
	}
	public Category create(Category entity) throws Exception{
		try {
			this.eManager.getTransaction().begin();
			this.eManager.persist(entity);
			this.eManager.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			this.eManager.getTransaction().rollback();
			throw e;
			// TODO: handle exception
		}
	}
	
	public Category findById(int id) {
		return this.eManager.find(Category.class, id);
	}
	
	public Category delete(Category entity) throws Exception{
		try {
			this.eManager.getTransaction().begin();
			this.eManager.remove(entity);
			this.eManager.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			this.eManager.getTransaction().rollback();
			throw e;
			// TODO: handle exception
		}
	}
	
	public Category update(Category entity) throws Exception{
		try {
			this.eManager.getTransaction().begin();
			this.eManager.merge(entity);
			this.eManager.getTransaction().commit();
			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			this.eManager.getTransaction().rollback();
			throw e;
			// TODO: handle exception
		}
	}
}
