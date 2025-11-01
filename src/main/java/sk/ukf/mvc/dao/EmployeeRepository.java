package sk.ukf.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.ukf.mvc.entity.Employee;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByEmail(String email);
    boolean existsByEmail(String email);
}
