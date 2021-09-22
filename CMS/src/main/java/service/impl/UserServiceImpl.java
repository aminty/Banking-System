package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import com.github.javafaker.Faker;
import com.github.javafaker.*;
import com.github.javafaker.service.RandomService;
import domain.Account;
import domain.Bank;
import domain.CreaditCard;
import domain.User;
import repository.UserRepository;
import service.UserService;
import ui.GetDataFromUser;
import ui.Menu;
import ui.PrintData;
import ui.enumeration.Job;
import util.ApplicationContext;
import util.CurrentData;
import validation.Validator;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UserServiceImpl extends BaseEntityServiceImpl<User, Long, UserRepository>
        implements UserService {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }
    @Override
    public boolean login(Job jobTitle) {
        System.out.printf("\t %s enter username: ", Menu.NEXTLINE);
        String username = new Scanner(System.in).next();
        System.out.printf("\t %s enter password: ", Menu.NEXTLINE);
        String password = new Scanner(System.in).next();
        if (repository.isExistsByUsername(username)) {
            User user = repository.fingByUsername(username);
            if (user.getJobTitle().equals(Job.CUSTOMER) && jobTitle.equals(Job.EMPLOYEE)){
                PrintData.errorMessage("Access denied!");
                return false;

            }
            if (user.getPassword().equals(password)) {
                CurrentData.setCurrentUser(user);

                CurrentData.setCurrentAccount(ApplicationContext.getAccountService().switchAccount(user.getId()));
            }
            PrintData.printMessage(Menu.LOGIN_SUCCESS__MSG);
            return true;
        } else {
            PrintData.errorMessage("This user does not exists!");
            return false;
        }
    }

    @Override
    public void signup(Job jobTitle) {

        if (ApplicationContext.getBankService().findAll().isEmpty()) {
            PrintData.errorMessage("Please build a bank !");
            return;
        }
        User user;
        Bank bank;
        Faker faker=new Faker();
        Account account=new Account();
        CreaditCard creaditCard=new CreaditCard();
        user = GetDataFromUser.getDataForSignUp(jobTitle);
        List<Bank> banksList = ApplicationContext.getBankService().showBanks();
        banksList.forEach(b -> System.out.printf("[%d] - %s\n", b.getId(), b.getBName()));
        outer:
        {
            while (true) {
                System.out.printf("\t %s chosse bank: ", Menu.NEXTLINE);
                int selectedItem = Validator.checkInteger("\\d");
                for (Bank item : banksList) {
                    if (item.getId() == selectedItem) {
                        bank = ApplicationContext.getBankService().findById((long) selectedItem);
                        break outer;
                    }
                }
            }
        }
        if (bank.getChief() == null) {
            if (Job.EMPLOYEE.equals(jobTitle)) {
                bank.setChief(user);
                save(user);
            }
            if (Job.CUSTOMER.equals(jobTitle)) {
                PrintData.errorMessage("This bank has no chief yet!");
                return; }

        } else {
            save(user);
        }
        Set<User> bankUsers = bank.getBankUsers();
        bankUsers.add(user);
        bank.setBankUsers(bankUsers);
        ApplicationContext.getBankService().save(bank);
        account.setCreaditCard(ApplicationContext.getCreaditCardService().generateCard());
        account.setOwnerAccount(user);
        account.setActive(true);
        account.setBalance(50000);
        account.setBranch(bank);
        ApplicationContext.getAccountService().save(account);

        PrintData.successMessage(Menu.ACCOUNT_CREATE_MSG);
    }

    @Override
    public User fingByUsername(String username) {
        return repository.fingByUsername(username);
    }

    @Override
    public boolean isExistsByUsername(String username) {
        return repository.isExistsByUsername(username);
    }

    @Override
    public boolean isExistsByNationalCode(String nationalCode) {
        return repository.isExistsByNationalCode(nationalCode);
    }
}

