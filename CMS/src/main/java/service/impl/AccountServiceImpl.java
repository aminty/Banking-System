package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.Account;
import repository.AccountRepository;
import service.AccountService;

public class AccountServiceImpl extends BaseEntityServiceImpl<Account, Long, AccountRepository>
        implements AccountService {
    public AccountServiceImpl(AccountRepository repository) {
        super(repository);
    }
}
