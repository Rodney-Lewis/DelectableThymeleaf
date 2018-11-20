package delectable.app.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import delectable.app.entity.Product;

public class ProductService {

	private EntityManager entityManager;

	public Product getProduct(int id) {

		TypedQuery<Product> query = entityManager.createQuery("SELECT c FROM product c WHERE c.id = :id",
				Product.class);
		query.setParameter("id", id);
		List<Product> result = query.getResultList();

		Product product = result.get(0);
		return product;
	}
}
