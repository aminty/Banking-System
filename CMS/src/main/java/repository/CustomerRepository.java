package repository;

import base.repository.BaseEntityRepository;
import domain.Customer;
import domain.Employee;

public interface CustomerRepository extends BaseEntityRepository<Customer,Long> {
    Customer fingByUsername(String username);
    boolean isExistsByUsername(String username);

    boolean isExistsByNationalCode(String nationalCode);
}
