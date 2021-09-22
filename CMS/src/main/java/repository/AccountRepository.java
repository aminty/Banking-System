package repository;

import base.repository.BaseEntityRepository;
import domain.Account;
import domain.User;

public interface AccountRepository extends BaseEntityRepository <Account,Long>{
    Account findByUser(long userId);

    Account findByCardId(Long cardId);
}
