package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.Bank;
import domain.Customer;
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
}
