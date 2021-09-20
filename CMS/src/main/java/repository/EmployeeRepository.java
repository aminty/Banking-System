package repository;

import base.repository.BaseEntityRepository;
import domain.Employee;

public interface EmployeeRepository extends BaseEntityRepository<Employee,Long> {
    Employee fingByUsername(String username);
    boolean isExistsByUsername(String username);
}
