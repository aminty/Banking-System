package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import com.github.javafaker.Faker;
import domain.CreaditCard;
import repository.CreaditCardRepository;
import service.CreaditCardService;
import ui.GetDataFromUser;
import ui.PrintData;
import util.ApplicationContext;
import util.CurrentData;

import java.util.Map;

public class CreaditCardSeviceImpl extends BaseEntityServiceImpl<CreaditCard, Long, CreaditCardRepository> implements
        CreaditCardService {
    public CreaditCardSeviceImpl(CreaditCardRepository repository) {
        super(repository);
    }

    @Override
    public CreaditCard generateCard() {
        CreaditCard creaditCard = new CreaditCard();
        Faker faker = new Faker();
        while (true) {
            String creditCardNumber = faker.business().creditCardNumber();
            if (!repository.isExistsByCardNumber(creditCardNumber.replaceAll("[\\-]", ""))) {
                creaditCard.setCardNumber(creditCardNumber.replaceAll("[\\-]", ""));
                break;
            }
        }
        creaditCard.setExpDate(faker.business().creditCardExpiry());
        creaditCard.setPinCode("1234");
        creaditCard.setCvv2(String.valueOf((int) (Math.random() * 9000) + 1000));
        creaditCard.setActiveCard(false);
        creaditCard.setBlockCard(false);

        return creaditCard;
    }

    @Override
    public boolean destinationValidator(String cardNumber) {
        return repository.destinationValidator(cardNumber);
    }

    @Override
    public boolean checkCreaditCardData() {
        Map<String, String> data = GetDataFromUser.getAuthenticationData();
        if (!CurrentData.currentAccount.getCreaditCard().isBlockCard()) {
            if (CurrentData.currentAccount.getCreaditCard().isActiveCard()) {
                if (data.get("cvv2").equals(CurrentData.currentAccount.getCreaditCard().getCvv2()) &&
                        data.get("exp").equals(CurrentData.currentAccount.getCreaditCard().getExpDate())) {
                    int attemp=0;
                    while (true) {
                        if (GetDataFromUser.getPin()==Integer.parseInt(CurrentData.currentAccount.getCreaditCard().getPinCode()))
                            break;
                        else attemp++;
                        if (attemp==3){
                            CurrentData.getCurrentAccount().getCreaditCard().setBlockCard(true);
                            ApplicationContext.getCreaditCardService().save(CurrentData.currentAccount.getCreaditCard());
                            PrintData.errorMessage("Your account has been blocked!");

                            return false;
                        }

                    }
                    return true;
                }else{
                    PrintData.errorMessage("Authentication data is not match!");
                    return false;
                }
            }else{
                PrintData.errorMessage("Change your pin!");
                return false;
            }
        }else{
            PrintData.errorMessage("Your card is blocked!");
            return false;
        }


    }

    @Override
    public long findIdByCardNumber(String cardNumber) {
        return repository.findIdByCardNumber(cardNumber);
    }
}
