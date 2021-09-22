package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.Account;
import domain.User;
import repository.AccountRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class AccountRepositoryImpl extends BaseEntityRepositoryImpl<Account,Long> implements AccountRepository {


    public AccountRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Account> getEntityClass() {
        return Account.class;
    }

    @Override
    public Account findByUser(long userId) {
        return entityManager.createQuery(
                "from "+getEntityClass().getSimpleName()+ " where ownerAccount_id=:userId",getEntityClass())
                .setParameter("userId",userId).getSingleResult();    }

    @Override
    public Account findByCardId(Long cardId) {
        return entityManager.createQuery(
                "from "+getEntityClass().getSimpleName()+" where creaditCard_id=:cardId",
                getEntityClass()).setParameter("cardId",cardId).getSingleResult();
    }

    @Override
    public List<Account> accountByUserId(long userId) {
        return entityManager.createQuery(
                "from "+getEntityClass().getSimpleName()+" where ownerAccount_id=:userId",
                getEntityClass()).setParameter("userId",userId).getResultList();
    }
}
