package delectable.app.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import delectable.app.entity.Product;

public interface ProductService extends CrudRepository<Product, Integer> {

	  Iterable<Product> findAll();
}
