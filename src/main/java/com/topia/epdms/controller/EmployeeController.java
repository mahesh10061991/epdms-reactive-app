package com.topia.epdms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.topia.epdms.model.Employee;
import com.topia.epdms.service.EmployeeService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<ResponseEntity<Employee>> getAllEmployees(@RequestParam(required = false) String name) {
        if (name == null)
            return employeeService
                    .findAll()
                    .map(employee ->
                            ResponseEntity
                                    .ok()
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .body(employee));
        else
            return employeeService
                    .findByNameContaining(name)
                    .map(employee ->
                            ResponseEntity
                                    .ok()
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .body(employee));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Employee>> getEmployeeById(@PathVariable("id") int id) {
        return employeeService
                .findById(id)
                .map(employee ->
                        ResponseEntity
                                .ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(employee));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<ResponseEntity<Employee>> createEmployee(@RequestBody Employee employee) {
        return employeeService
                .save(employee)
                .map(employeeObj ->
                        ResponseEntity
                                .ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(employeeObj));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<ResponseEntity<Employee>> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
        return employeeService
                .update(id, employee)
                .map(employeeObj ->
                        ResponseEntity
                                .ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(employeeObj));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Void>> deleteEmployee(@PathVariable("id") int id) {
        return employeeService
                .deleteById(id)
                .map(obj ->
                        ResponseEntity.ok().build());
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<ResponseEntity<Void>> deleteAllEmployees() {
        return employeeService
                .deleteAll()
                .map(obj ->
                        ResponseEntity.ok().build());
    }

    @GetMapping("/department/{department}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<ResponseEntity<Employee>> findByDepartment(@PathVariable("department") String department) {
        return employeeService
                .findByDepartment(department)
                .map(employee ->
                        ResponseEntity
                                .ok()
                                .contentType(MediaType.APPLICATION_JSON)
                                .body(employee));
    }
}
