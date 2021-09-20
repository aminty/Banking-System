package service;

import base.service.BaseEntityService;
import domain.Account;
import domain.Customer;

public interface CustomerService extends BaseEntityService<Customer,Long> {
    boolean login();

    void signup();
}
