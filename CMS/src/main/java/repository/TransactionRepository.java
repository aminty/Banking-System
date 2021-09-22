package repository;

import base.repository.BaseEntityRepository;
import domain.Transaction;

import java.util.List;

public interface TransactionRepository extends BaseEntityRepository<Transaction,Long> {
    List<Transaction> findTransactionsByUser(long id);
}
