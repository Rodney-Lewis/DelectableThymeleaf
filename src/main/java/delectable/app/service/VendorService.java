package delectable.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import delectable.app.entity.Vendor;

public interface VendorService extends PagingAndSortingRepository<Vendor, Integer> {

	Page<Vendor> findAllByOrderByNameAsc(Pageable pageable);

	Vendor findAllById(int id);

}