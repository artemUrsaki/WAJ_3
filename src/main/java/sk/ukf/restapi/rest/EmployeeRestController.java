package sk.ukf.restapi.rest;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.ukf.restapi.dto.ApiResponse;
import sk.ukf.restapi.entity.Employee;
import sk.ukf.restapi.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<ApiResponse<List<Employee>>> findAll() {
        List<Employee> employees = employeeService.findAll();
        return ResponseEntity.ok(
                ApiResponse.success(employees, "Zoznam zamestnancov načítaný úspešne")
        );
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<ApiResponse<Employee>> getEmployee(@PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            throw new RuntimeException("Zamestnanec s ID " + id + " nebol nájdený");
        }

        return ResponseEntity.ok(
                ApiResponse.success(employee, "Zamestnanec načítaný úspešne")
        );
    }

    @PostMapping("/employees")
    public ResponseEntity<ApiResponse<Employee>> addEmployee(@Valid @RequestBody Employee employee) {
        Employee savedEmployee = employeeService.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(savedEmployee, "Zamestnanec úspešne pridaný"));
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<ApiResponse<Employee>> updateEmployee(@PathVariable Integer id,@Valid @RequestBody Employee employee) {
        Employee employeeRecord = employeeService.findById(id);
        if (employeeRecord == null) {
            throw new RuntimeException("Employee with id " + id + " not found");
        }

        employee.setId(id);
        Employee updatedEmployee = employeeService.save(employee);

        return ResponseEntity.ok(
                ApiResponse.success(updatedEmployee, "Zamestnanec úspešne aktualizovaný")
        );
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteEmployee(@PathVariable Integer id) {
        Employee existing = employeeService.findById(id);
        if (existing == null) {
            throw new RuntimeException("Zamestnanec s ID " + id + " nebol nájdený");
        }

        employeeService.deleteById(id);
        return ResponseEntity.ok(
                ApiResponse.success(null, "Zamestnanec úspešne odstránený")
        );
    }
}
