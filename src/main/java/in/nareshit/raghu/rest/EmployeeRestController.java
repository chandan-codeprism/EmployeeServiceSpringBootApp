package in.nareshit.raghu.rest;

import in.nareshit.raghu.entity.Employee;
import in.nareshit.raghu.exception.EmployeeNotFoundException;
import in.nareshit.raghu.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        Long id = employeeService.createEmployee(employee);
        String message = "Employee '" + id + "' is created";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> findAllEmployees() {
        List<Employee> list = employeeService.findAllEmployees();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findEmployeeById(@PathVariable Long id) {
        ResponseEntity<?> resp = null;
        try {
            Employee employee = employeeService.findEmployeeById(id);
            resp = new ResponseEntity<>(employee, HttpStatus.OK);// 200 OK

        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
            throw e;//call globalExceptionHandler
        }
        return resp;
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteOneEmployee(@PathVariable Long id) {
        ResponseEntity<String> resp = null;
        try {
            employeeService.deleteOneEmployee(id);
            resp = new ResponseEntity<>("Employee deleted", HttpStatus.OK);// 200 OK
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
            throw e;//Call Global Exception Handler
        }
        return resp;
    }

    @PutMapping("/modify")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
        ResponseEntity<String> resp = null;
        try {
            employeeService.updateEmployee(employee);
            resp = new ResponseEntity<>("Employee updated", HttpStatus.OK);
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
        return resp;
    }

    @PatchMapping("/modify/name/{id}/{name}")
    public ResponseEntity<String> updateEmployeeName(
            @PathVariable String name, @PathVariable Long id) {
        ResponseEntity<String> resp;
        try {
            employeeService.updateEmployeeName(name, id);
            resp = new ResponseEntity<>("Employee name updated", HttpStatus.OK);
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
            throw e;
        }
        return resp;
    }
}
