package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.Employee;
import repository.EmployeeRepository;
import service.EmployeeService;

public class EmployeeServiceImpl extends BaseEntityServiceImpl<Employee,Long, EmployeeRepository>
        implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }
}
