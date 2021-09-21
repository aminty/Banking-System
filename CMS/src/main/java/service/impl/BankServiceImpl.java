package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.Bank;
import domain.User;
import repository.BankRepository;
import service.BankService;
import ui.Menu;
import ui.PrintData;

import java.util.List;
import java.util.Scanner;

public class BankServiceImpl extends BaseEntityServiceImpl<Bank,Long, BankRepository>
        implements BankService {
    public BankServiceImpl(BankRepository repository) {
        super(repository);
    }

    @Override
    public void buidBank() {
        System.out.println("-*-*-*-*-*-* build bank -*-*-*-*-*-*");
        Bank bank=new Bank();
        while (true){
            System.out.printf("\t %s enter bank name: ", Menu.NEXTLINE);
            String bankName = new Scanner(System.in).next();
            if (repository.isExistsByBname(bankName))
                PrintData.errorMessage("This bank is exist!");
            else{
            bank.setBName(bankName);
            break;
            }
        }
        save(bank);
        PrintData.successMessage("The bank was built successfully");

    }

    @Override
    public List<Bank> showBanks() {
         return repository.showBanks();
    }

    @Override
    public User fingByBname(String bName) {
        return repository.fingByBname(bName);
    }

    @Override
    public boolean isExistsByBname(String bName) {
        return repository.isExistsByBname(bName);
    }
}
