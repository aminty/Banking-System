package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import com.github.javafaker.Faker;
import domain.CreaditCard;
import repository.CreaditCardRepository;
import service.CreaditCardService;

import javax.persistence.EntityManager;

public class CreaditCardSeviceImpl extends BaseEntityServiceImpl<CreaditCard, Long, CreaditCardRepository> implements
        CreaditCardService {
    public CreaditCardSeviceImpl(CreaditCardRepository repository) {
        super(repository);
    }

    @Override
    public CreaditCard generateCard() {
        CreaditCard creaditCard=new CreaditCard();
        Faker faker=new Faker();
        while(true){
            String creditCardNumber=faker.business().creditCardNumber();
            if (!repository.isExistsByCardNumber(creditCardNumber)){
                creaditCard.setCardNumber(creditCardNumber);
                break;
            }
        }
        creaditCard.setExpDate(faker.business().creditCardExpiry());
        creaditCard.setPinCode("1234");
        creaditCard.setCvv2(String.valueOf((int)(Math.random()*9000)+1000));
        creaditCard.setActiveCard(false);
        creaditCard.setBlockCard(false);

        return creaditCard;
    }
}
