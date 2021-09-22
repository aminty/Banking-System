package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.CreaditCard;
import repository.CreaditCardRepository;

import javax.persistence.EntityManager;

public class CreaditCardRepositoryImpl extends BaseEntityRepositoryImpl<CreaditCard,Long> implements
        CreaditCardRepository {
    public CreaditCardRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<CreaditCard> getEntityClass() {
        return CreaditCard.class;
    }

    @Override
    public boolean isExistsByCardNumber(String cardNumber) {
        return entityManager.createQuery(
                "select count(cardNumber) from "+ getEntityClass().getSimpleName()+" where cardNumber =:cardNumber",
                Long.class).setParameter("cardNumber",cardNumber).getSingleResult()==1L;    }

    @Override
    public boolean destinationValidator(String  destinationCardNumber) {
         return entityManager.createQuery(
                "select count(cardNumber) from "+ getEntityClass().getSimpleName()+" where cardNumber =:cardNumber",
                Long.class).setParameter("cardNumber",destinationCardNumber).getSingleResult()==1L;
    }

    @Override
    public long findIdByCardNumber(String cardNumber) {
        return entityManager.createQuery("select id from "+getEntityClass().getSimpleName()+
                " where cardNumber=:cardNumber",Long.class).setParameter("cardNumber",cardNumber).getSingleResult();
    }
}
