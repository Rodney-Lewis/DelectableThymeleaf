package delectable.app.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import delectable.app.entity.Product;

public class ProductService {

	private EntityManager entityManager;

	public Product getProduct(int id) {

		TypedQuery<Product> query = entityManager.createQuery("SELECT * FROM product WHERE id = 1", Product.class);
		List<Product> result = query.getResultList();

		Product product = result.get(0);
		return product;
	}
}
