package delectable.app.service;

import org.springframework.data.repository.CrudRepository;

import delectable.app.entity.secondary.OpenHours;

public interface OpenHoursService extends CrudRepository<OpenHours, Integer> {

}