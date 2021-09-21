package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.Account;
import domain.User;
import repository.AccountRepository;
import service.AccountService;

public class AccountServiceImpl extends BaseEntityServiceImpl<Account, Long, AccountRepository>
        implements AccountService {
    public AccountServiceImpl(AccountRepository repository) {
        super(repository);
    }

    @Override
    public Account findByUser(long userId) {
        return repository.findByUser(userId);
    }
}
