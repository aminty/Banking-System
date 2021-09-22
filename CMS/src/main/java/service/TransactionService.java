package service;

import base.service.BaseEntityService;
import domain.Transaction;

import java.util.List;

public interface TransactionService extends BaseEntityService<Transaction,Long> {
    Transaction save(Transaction transaction);
    List<Transaction> showTransaction(long id);
}
