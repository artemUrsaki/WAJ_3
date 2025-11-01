package sk.ukf.mvc.service;

import org.springframework.stereotype.Service;
import sk.ukf.mvc.dao.EmployeeRepository;
import sk.ukf.mvc.entity.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
//        return employeeRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Zamestnanec", id));
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee save(Employee employee) {
//        if (employee.getId() == 0) {
//            if (employeeRepository.existsByEmail(employee.getEmail())) {
//                throw new EmailAlreadyExistsException(employee.getEmail());
//            }
//        } else {
//            Employee existingWithEmail = employeeRepository.findByEmail(employee.getEmail()).orElse(null);
//            if (existingWithEmail != null && existingWithEmail.getId() != employee.getId()) {
//                throw new EmailAlreadyExistsException(employee.getEmail());
//            }
//        }

        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
//        if (!employeeRepository.existsById(id)) {
//            throw new ObjectNotFoundException("Zamestnanec", id);
//        }
        employeeRepository.deleteById(id);
    }
}
