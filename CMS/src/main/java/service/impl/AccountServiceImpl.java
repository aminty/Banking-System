package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.Account;
import repository.AccountRepository;
import service.AccountService;
import util.ApplicationContext;
import util.CurrentData;

import java.util.Map;

public class AccountServiceImpl extends BaseEntityServiceImpl<Account, Long, AccountRepository>
        implements AccountService {
    public AccountServiceImpl(AccountRepository repository) {
        super(repository);
    }

    @Override
    public Account findByUser(long userId) {
        return repository.findByUser(userId);
    }

    @Override
    public Account findByCardId(Long cardId) {
        return repository.findByCardId(cardId);
    }


}
