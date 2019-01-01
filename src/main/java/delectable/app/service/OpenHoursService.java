package delectable.app.service;

import org.springframework.data.repository.CrudRepository;

import delectable.app.entity.secondary.RestaurantOpenHours;

public interface OpenHoursService extends CrudRepository<RestaurantOpenHours, Integer> {

}