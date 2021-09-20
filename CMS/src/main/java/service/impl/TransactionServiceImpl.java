package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.Transaction;
import repository.TransactionRepository;
import service.TransactionService;

public class TransactionServiceImpl extends BaseEntityServiceImpl<Transaction,Long, TransactionRepository>
        implements TransactionService {
    public TransactionServiceImpl(TransactionRepository repository) {
        super(repository);
    }
}
