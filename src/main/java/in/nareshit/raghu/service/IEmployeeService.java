package in.nareshit.raghu.service;

import in.nareshit.raghu.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    Long createEmployee(Employee employee);
    List<Employee> findAllEmployees();
    Employee findEmployeeById(Long id);
}
