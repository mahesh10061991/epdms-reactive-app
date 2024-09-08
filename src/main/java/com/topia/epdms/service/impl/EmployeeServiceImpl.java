package com.topia.epdms.service.impl;

import com.topia.epdms.exception.NotFoundException;
import com.topia.epdms.model.Employee;
import com.topia.epdms.repository.EmployeeRepository;
import com.topia.epdms.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

import static com.topia.epdms.constant.EpdmsExceptionConstant.Attribute.EMPLOYEE_FIELD;
import static com.topia.epdms.constant.EpdmsExceptionConstant.NotFoundException.NOT_FOUND_EXCEPTION;
import static com.topia.epdms.constant.EpdmsExceptionConstant.TimeoutException.TIMEOUT_EXCEPTION;

@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Flux<Employee> findAll() {
        return employeeRepository
                .findAll()
                .map(employeeObj -> employeeObj)
                .switchIfEmpty(Mono.error(new NotFoundException(NOT_FOUND_EXCEPTION, EMPLOYEE_FIELD)))
                .doOnError(throwable ->
                        log.error("RUNTIME_EXCEPTION_WHILE_FINDING_ALL_EMPLOYEE: {}", throwable.getMessage()))
                .onErrorResume(ex -> {
                    if(ex instanceof TimeoutException) {
                        return Mono.error(new com.topia.epdms.exception.TimeoutException(TIMEOUT_EXCEPTION, EMPLOYEE_FIELD));
                    } else {
                        return Mono.error(ex);
                    }
                })
                .onErrorStop();
    }

    public Flux<Employee> findByNameContaining(String name) {
        return employeeRepository
                .findByNameContaining(name)
                .map(employeeObj -> employeeObj)
                .switchIfEmpty(Mono.error(new NotFoundException(NOT_FOUND_EXCEPTION, EMPLOYEE_FIELD)))
                .doOnError(throwable ->
                        log.error("RUNTIME_EXCEPTION_WHILE_FINDING_ALL_EMPLOYEE_BY_NAME: {}", throwable.getMessage()))
                .onErrorResume(ex -> {
                    if(ex instanceof TimeoutException) {
                        return Mono.error(new com.topia.epdms.exception.TimeoutException(TIMEOUT_EXCEPTION, EMPLOYEE_FIELD));
                    } else {
                        return Mono.error(ex);
                    }
                })
                .onErrorStop();
    }

    public Mono<Employee> findById(int id) {
        return Mono.defer(
                () -> {
                    var employee = employeeRepository
                            .findById(id)
                            .timeout(Duration.ofMillis(500));
                    return employee
                            .map(employeeObj -> employeeObj)
                            .switchIfEmpty(Mono.error(new NotFoundException(NOT_FOUND_EXCEPTION, EMPLOYEE_FIELD+": "+id)))
                            .doOnError(throwable ->
                                    log.error("RUNTIME_EXCEPTION_WHILE_FINDING_EMPLOYEE: {}", throwable.getMessage()))
                            .onErrorResume(ex -> {
                                if(ex instanceof TimeoutException) {
                                    return Mono.error(new com.topia.epdms.exception.TimeoutException(TIMEOUT_EXCEPTION, EMPLOYEE_FIELD+": "+id));
                                } else {
                                    return Mono.error(ex);
                                }
                            })
                            .onErrorStop();
                }
        );
    }

    public Mono<Employee> save(Employee employee) {
        return Mono.defer(
                () -> {
                    var savedEmployee = employeeRepository
                            .save(employee)
                            .timeout(Duration.ofMillis(500));
                    return savedEmployee
                            .map(employeeObj -> employeeObj)
                            .doOnError(throwable ->
                                    log.error("RUNTIME_EXCEPTION_WHILE_SAVING_EMPLOYEE: {}", throwable.getMessage()))
                            .onErrorResume(ex -> {
                                if(ex instanceof TimeoutException) {
                                    return Mono.error(new com.topia.epdms.exception.TimeoutException(TIMEOUT_EXCEPTION, EMPLOYEE_FIELD));
                                } else {
                                    return Mono.error(ex);
                                }
                            })
                            .onErrorStop();
                }
        );
    }

    public Mono<Employee> update(int id, Employee employee) {
        return employeeRepository
                .findById(id)
                .map(Optional::of)
                .defaultIfEmpty(Optional.empty())
                .flatMap(employeeObj-> {
                    if (employeeObj.isPresent()) {
                        employee.setId(id);
                        return employeeRepository.save(employee);
                    }
                    return Mono.error(new NotFoundException(NOT_FOUND_EXCEPTION, EMPLOYEE_FIELD+": "+id));
                })
                .doOnError(throwable ->
                        log.error("RUNTIME_EXCEPTION_WHILE_UPDATING_EMPLOYEE: {}", throwable.getMessage()))
                .onErrorResume(ex -> {
                    if(ex instanceof TimeoutException) {
                        return Mono.error(new com.topia.epdms.exception.TimeoutException(TIMEOUT_EXCEPTION, EMPLOYEE_FIELD));
                    } else {
                        return Mono.error(ex);
                    }
                })
                .onErrorStop();
    }

    public Mono<Void> deleteById(int id) {
        return employeeRepository
                .deleteById(id)
                .doOnError(throwable ->
                        log.error("RUNTIME_EXCEPTION_WHILE_DELETING_EMPLOYEE: {}", throwable.getMessage()))
                .onErrorResume(ex -> {
                    if(ex instanceof TimeoutException) {
                        return Mono.error(new com.topia.epdms.exception.TimeoutException(TIMEOUT_EXCEPTION, EMPLOYEE_FIELD));
                    } else {
                        return Mono.error(ex);
                    }
                })
                .onErrorStop();
    }

    public Mono<Void> deleteAll() {
        return employeeRepository
                .deleteAll()
                .doOnError(throwable ->
                        log.error("RUNTIME_EXCEPTION_WHILE_DELETING_ALL_EMPLOYEE: {}", throwable.getMessage()))
                .onErrorResume(ex -> {
                    if(ex instanceof TimeoutException) {
                        return Mono.error(new com.topia.epdms.exception.TimeoutException(TIMEOUT_EXCEPTION, EMPLOYEE_FIELD));
                    } else {
                        return Mono.error(ex);
                    }
                })
                .onErrorStop();
    }

    public Flux<Employee> findByDepartment(String department) {
        return employeeRepository
                .findByDepartment(department)
                .map(employeeObj -> employeeObj)
                .switchIfEmpty(Mono.error(new NotFoundException(NOT_FOUND_EXCEPTION, EMPLOYEE_FIELD)))
                .doOnError(throwable ->
                        log.error("RUNTIME_EXCEPTION_WHILE_FINDING_EMPLOYEE_BY_DEPARTMENT: {}", throwable.getMessage()))
                .onErrorResume(ex -> {
                    if(ex instanceof TimeoutException) {
                        return Mono.error(new com.topia.epdms.exception.TimeoutException(TIMEOUT_EXCEPTION, EMPLOYEE_FIELD));
                    } else {
                        return Mono.error(ex);
                    }
                })
                .onErrorStop();
    }
}
