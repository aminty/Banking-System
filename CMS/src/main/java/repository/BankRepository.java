package repository;

import base.repository.BaseEntityRepository;
import domain.Bank;
import domain.User;

import java.util.List;

public interface BankRepository extends BaseEntityRepository<Bank,Long> {

    User fingByBname(String bName);

    boolean isExistsByBname(String bName);

    List<Bank> showBanks();
}
