package delectable.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import delectable.app.entity.Restaurant;

public interface RestaurantService extends PagingAndSortingRepository<Restaurant, Integer> {

	Page<Restaurant> findAllByOrderByNameAsc(Pageable pageable);

	Restaurant findById(int id);

}
