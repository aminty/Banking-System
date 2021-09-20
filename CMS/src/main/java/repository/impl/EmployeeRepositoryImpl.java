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

    @Override
    public Employee fingByUsername(String username) {
        return entityManager.createQuery(
                "from "+getEntityClass().getSimpleName()+ " where username=:username",getEntityClass())
                .setParameter("username",username).getSingleResult();
    }

    @Override
    public boolean isExistsByUsername(String username) {
        return entityManager.createQuery(
                "select count(username) from "+ getEntityClass().getSimpleName()+" where username =:username",
                Long.class).setParameter("username",username).getSingleResult()==1L;
    }
}
