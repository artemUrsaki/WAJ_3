package sk.ukf.restapi.service;

import sk.ukf.restapi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);
    List<Employee> findAll();
    Employee findById(Integer id);
    void delete(Employee employee);
}
