package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.Bank;
import domain.Employee;
import repository.BankRepository;
import repository.EmployeeRepository;

import javax.persistence.EntityManager;

public class EmployeeRepositoryImpl extends BaseEntityRepositoryImpl<Employee,Long> implements
        EmployeeRepository {

    public EmployeeRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Employee> getEntityClass() {
        return Employee.class;
    }
}
