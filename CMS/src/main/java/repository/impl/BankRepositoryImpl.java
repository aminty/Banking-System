package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.Bank;
import repository.BankRepository;

import javax.persistence.EntityManager;

public class BankRepositoryImpl extends BaseEntityRepositoryImpl<Bank,Long> implements
        BankRepository {
    public BankRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Bank> getEntityClass() {
        return Bank.class;
    }
}
