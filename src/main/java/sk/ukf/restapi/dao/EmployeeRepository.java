package sk.ukf.restapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.ukf.restapi.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {}
