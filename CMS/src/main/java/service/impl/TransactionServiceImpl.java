package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.Transaction;
import repository.TransactionRepository;
import service.TransactionService;

import java.util.List;

public class TransactionServiceImpl extends BaseEntityServiceImpl<Transaction,Long, TransactionRepository>
        implements TransactionService {
    public TransactionServiceImpl(TransactionRepository repository) {
        super(repository);
    }

    @Override
    public Transaction save(Transaction transaction) {
         return repository.save(transaction);
    }

    @Override
    public List<Transaction> showTransaction(long id) {
        return repository.findTransactionsByUser(id);
    }
}
