package in.nareshit.raghu.service.impl;

import in.nareshit.raghu.entity.Employee;
import in.nareshit.raghu.exception.EmployeeNotFoundException;
import in.nareshit.raghu.repo.EmployeeRepository;
import in.nareshit.raghu.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        /*Optional<Employee> opt = employeeRepository.findById(id);
        if (opt.isPresent())
            return opt.get();
        else
            throw new EmployeeNotFoundException("Employee'" + id + "'exist");*/
        return employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Employee '" + id + "' is not exist"));
    }

    @Override
    public void deleteOneEmployee(Long id) {
        employeeRepository.delete(findEmployeeById(id));
    }

    @Override
    public void updateEmployee(Employee employee) {
        Long id = employee.getEmpId();
        if (id != null && employeeRepository.existsById(id)) {
            employeeRepository.save(employee);
        } else {
            throw new EmployeeNotFoundException("Employee '" + id + "' is not exist");
        }
    }

    @Override
    @Transactional
    public void updateEmployeeName(String ename, Long id) {
        if (id != null && employeeRepository.existsById(id)) {
            employeeRepository.updateEmployeeName(ename, id);
        } else
            throw new EmployeeNotFoundException("Employee '" + id + "' is not exist");
    }
}
