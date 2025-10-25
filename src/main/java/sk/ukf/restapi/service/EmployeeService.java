package sk.ukf.restapi.service;

import sk.ukf.restapi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee save(Employee employee);
    List<Employee> findAll();
    Employee findById(int id);
    void deleteById(int id);
}
