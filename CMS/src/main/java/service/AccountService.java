package service;

import base.service.BaseEntityService;
import base.service.impl.BaseEntityServiceImpl;
import domain.Account;
import domain.User;

public interface AccountService extends BaseEntityService<Account,Long> {
    Account findByUser(long userId);
}
