package service;

import base.service.BaseEntityService;
import domain.Account;
import domain.Employee;

public interface EmployeeService extends BaseEntityService<Employee,Long> {

    boolean login();
}
