package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.Customer;
import repository.CustomerRepository;
import service.CustomerService;

public class CustomerServiceImpl extends BaseEntityServiceImpl<Customer,Long, CustomerRepository>
        implements CustomerService {
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }
}
