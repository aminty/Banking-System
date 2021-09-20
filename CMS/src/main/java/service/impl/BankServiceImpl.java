package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.Bank;
import repository.BankRepository;
import service.BankService;

public class BankServiceImpl extends BaseEntityServiceImpl<Bank,Long, BankRepository>
        implements BankService {
    protected BankServiceImpl(BankRepository repository) {
        super(repository);
    }
}
