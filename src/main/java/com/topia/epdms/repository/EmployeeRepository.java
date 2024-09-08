package com.topia.epdms.repository;

import com.topia.epdms.model.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Flux;

@Repository
public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Integer> {
  Flux<Employee> findByNameContaining(String name);
  
  Flux<Employee> findByDepartment(String department);
}
