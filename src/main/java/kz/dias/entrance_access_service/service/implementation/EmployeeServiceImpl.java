package kz.dias.entrance_access_service.service.implementation;

import kz.dias.entrance_access_service.domain.Employee;
import kz.dias.entrance_access_service.mapper.EmployeeMapper;
import kz.dias.entrance_access_service.repository.EmployeeRepository;
import kz.dias.entrance_access_service.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Employee getEmployeeById(String id) {
        var optionalEmployee = employeeRepository.findById(id);
        return employeeMapper.entityToDomain(optionalEmployee.orElseThrow());
    }
}
