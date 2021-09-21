package repository;

import base.repository.BaseEntityRepository;
import domain.User;

public interface UserRepository extends BaseEntityRepository<User,Long> {

    User fingByUsername(String username);

    boolean isExistsByUsername(String username);

    boolean isExistsByNationalCode(String nationalCode);
}
