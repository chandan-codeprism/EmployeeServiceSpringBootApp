package in.nareshit.raghu.rest;

import in.nareshit.raghu.entity.Employee;
import in.nareshit.raghu.service.impl.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee){

        Long id=employeeService.createEmployee(employee);
        String message= "Employee '"+id+"' is created";
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
