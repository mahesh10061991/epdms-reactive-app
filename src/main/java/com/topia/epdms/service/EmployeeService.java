package com.topia.epdms.service;
import com.topia.epdms.model.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface EmployeeService {
  Flux<Employee> findAll();

  Flux<Employee> findByNameContaining(String name);

  Mono<Employee> findById(int id);

  Mono<Employee> save(Employee employee);

  Mono<Employee> update(int id, Employee employee);

  Mono<Void> deleteById(int id);

  Mono<Void> deleteAll();

  Flux<Employee> findByDepartment(String department);
}
