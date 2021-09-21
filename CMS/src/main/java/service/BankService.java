package service;

import base.service.BaseEntityService;
import domain.Bank;
import domain.User;

import java.util.List;

public interface BankService  extends BaseEntityService<Bank,Long> {
    void buidBank();
    List<Bank> showBanks();
    User fingByBname(String bName);

    boolean isExistsByBname(String bName);
}
