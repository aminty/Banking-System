package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.Transaction;
import repository.TransactionRepository;

import javax.persistence.EntityManager;
import java.util.List;

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

    @Override
    public List<Transaction> findTransactionsByUser(long id) {
        return entityManager.createQuery(
                "from "+ getEntityClass().getSimpleName()+
                        " where source_id=:id",getEntityClass())
                .setParameter("id",id).getResultList();
    }
}
