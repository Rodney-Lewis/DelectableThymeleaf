package delectable.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import delectable.app.entity.Product;

public interface ProductService extends PagingAndSortingRepository<Product, Integer> {

	Page<Product> findAllByOrderByNameAsc(Pageable pageable);
}
