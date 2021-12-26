package in.nareshit.raghu.service.impl;

import in.nareshit.raghu.entity.Employee;
import in.nareshit.raghu.repo.EmployeeRepository;
import in.nareshit.raghu.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Long createEmployee(Employee employee) {
        employeeRepository.save(employee);
        return employee.getEmpId();
    }

    @Override
    public List<Employee> findAllEmployees() {
        List<Employee> list = employeeRepository.findAll();
        return list;
    }

    @Override
    public Employee findEmployeeById(Long id) {
        Optional<Employee> opt = employeeRepository.findById(id);
        if (opt.isPresent())
            return opt.get();
        else
            return null;
    }

}
