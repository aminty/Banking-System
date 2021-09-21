package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.Bank;
import domain.User;
import repository.BankRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class BankRepositoryImpl extends BaseEntityRepositoryImpl<Bank,Long> implements
        BankRepository {
    public BankRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Bank> getEntityClass() {
        return Bank.class;
    }

    @Override
    public User fingByBname(String bName) {
        return null;
    }

    @Override
    public boolean isExistsByBname(String bName) {
        return entityManager.createQuery(
                "select count(bName) from "+ getEntityClass().getSimpleName()+" where bName =:bName",
                Long.class).setParameter("bName",bName).getSingleResult()==1L;
    }

    @Override
    public List<Bank> showBanks() {
         return super.findAll();

    }
}
