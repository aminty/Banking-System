package service;

import base.service.BaseEntityService;
import domain.Account;

import java.util.List;
import java.util.Map;

public interface AccountService extends BaseEntityService<Account, Long> {
    Account findByUser(long userId);

    Account findByCardId(Long cardId);

    void createNewAccount();

    List<Account> accountByUserId(long userId);

    Account switchAccount(Long id);
}
