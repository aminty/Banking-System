package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.Bank;
import domain.Customer;
import domain.Employee;
import repository.BankRepository;
import repository.CustomerRepository;

import javax.persistence.EntityManager;

public class CustomerRepositoryImpl extends BaseEntityRepositoryImpl<Customer,Long> implements
        CustomerRepository {



    public CustomerRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }

    @Override
    public Customer fingByUsername(String username) {
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

    @Override
    public boolean isExistsByNationalCode(String nationalCode) {
        return entityManager.createQuery(
                "select count(nationalCode) from "+ getEntityClass().getSimpleName()+" where nationalCode =:nationalCode",
                Long.class).setParameter("nationalCode",nationalCode).getSingleResult()==1L;
    }
}
