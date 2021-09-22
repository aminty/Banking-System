package service;

import base.service.BaseEntityService;
import domain.Account;
import domain.Bank;
import domain.User;
import ui.enumeration.TransactionType;

import java.util.List;

public interface BankService extends BaseEntityService<Bank, Long> {
    void buidBank();

    List<Bank> showBanks();

    User fingByBname(String bName);

    boolean isExistsByBname(String bName);

    boolean withdraw();

    void processTransaction(TransactionType cardToCard, Account destAccount,double amount);

    void getBalance();

    boolean changePin();
}
