package service;

import base.service.BaseEntityService;
import domain.User;
import ui.enumeration.Job;

public interface UserService extends BaseEntityService<User, Long> {
    void signup(Job jobTitle);

    boolean login(Job jobTitle);

    User fingByUsername(String username);

    boolean isExistsByUsername(String username);

    boolean isExistsByNationalCode(String nationalCode);
}
