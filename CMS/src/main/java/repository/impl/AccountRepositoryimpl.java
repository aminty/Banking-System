package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.Account;
import repository.AccountRepository;

import javax.persistence.EntityManager;

public class AccountRepositoryimpl extends BaseEntityRepositoryImpl<Account,Long> implements AccountRepository {


    public AccountRepositoryimpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Account> getEntityClass() {
        return Account.class;
    }

}
