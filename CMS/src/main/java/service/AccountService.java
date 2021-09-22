package service;

import base.service.BaseEntityService;
import domain.Account;

import java.util.Map;

public interface AccountService extends BaseEntityService<Account, Long> {
    Account findByUser(long userId);

    Account findByCardId(Long cardId);
}
