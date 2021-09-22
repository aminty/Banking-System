package repository;

import base.repository.BaseEntityRepository;
import domain.Account;
import domain.User;

import java.util.List;

public interface AccountRepository extends BaseEntityRepository <Account,Long>{
    Account findByUser(long userId);

    Account findByCardId(Long cardId);

    List<Account> accountByUserId(long userId);
}
