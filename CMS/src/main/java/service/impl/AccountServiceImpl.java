package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.Account;
import domain.Bank;
import repository.AccountRepository;
import service.AccountService;
import ui.GetDataFromUser;
import ui.Menu;
import ui.PrintData;
import util.ApplicationContext;
import util.CurrentData;
import validation.Validator;

import java.util.List;
import java.util.Map;

public class AccountServiceImpl extends BaseEntityServiceImpl<Account, Long, AccountRepository>
        implements AccountService {
    public AccountServiceImpl(AccountRepository repository) {
        super(repository);
    }

    @Override
    public Account findByUser(long userId) {
        return repository.findByUser(userId);
    }

    @Override
    public Account findByCardId(Long cardId) {
        return repository.findByCardId(cardId);
    }

    @Override
    public void createNewAccount() {
        Account account=new Account();
        account.setOwnerAccount(CurrentData.getCurrentAccount().getOwnerAccount());
        account.setCreaditCard(ApplicationContext.getCreaditCardService().generateCard());
        account.setBalance(50000);
        List<Bank> banksList = ApplicationContext.getBankService().showBanks();

        outer:
        {
            while (true) {
                System.out.printf("\t %s chosse bank: ", Menu.NEXTLINE);
                int selectedItem = Validator.checkInteger("\\d");
                for (Bank item : banksList ) {
                    if (item.getId() == selectedItem) {
                        account.setBranch( ApplicationContext.getBankService().findById((long) selectedItem));
                        break outer;
                    }
                }
            }
        }
        save(account);


    }

    @Override
    public List<Account> accountByUserId(long userId) {
        return repository.accountByUserId(userId);
    }

    @Override
    public Account switchAccount(Long id) {
        List<Account> accounts =repository.accountByUserId(id);
        if (accounts.size() == 1)
            return accounts.get(0);
        else {
            PrintData.showAllAccounts(accounts);
            int item = GetDataFromUser.getItem();
            return ApplicationContext.getAccountService().findById((long) item);
        }
    }


}
