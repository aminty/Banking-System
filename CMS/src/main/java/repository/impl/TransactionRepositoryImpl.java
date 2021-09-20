package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.Transaction;
import repository.TransactionRepository;

import javax.persistence.EntityManager;

public class TransactionRepositoryImpl extends BaseEntityRepositoryImpl<Transaction, Long> implements
        TransactionRepository {
    public TransactionRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Transaction> getEntityClass() {
        return
                Transaction.class;
    }
}
