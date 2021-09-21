package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.Bank;
import domain.User;
import repository.UserRepository;
import service.UserService;
import ui.GetDataFromUser;
import ui.Menu;
import ui.PrintData;
import ui.enumeration.Job;
import util.ApplicationContext;
import validation.Validator;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UserServiceImpl extends BaseEntityServiceImpl<User, Long, UserRepository>
        implements UserService {
    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }
//        @Override
//        public boolean login() {
//            System.out.printf("\t %s enter username: ", Menu.NEXTLINE);
//            String username = new Scanner(System.in).next();
//            System.out.printf("\t %s enter password: ", Menu.NEXTLINE);
//            String password = new Scanner(System.in).next();
//            if (repository.isExistsByUsername(username)) {
//                User user = repository.fingByUsername(username);
//                if (user.getPassword().equals(password))
//                    CurrentData.setCurrentUser(user);
//                PrintData.printMessage(Menu.LOGIN_SUCCESS__MSG);
//                return true;
//            } else {
//                PrintData.errorMessage("This user does not exists!");
//                return false;
//            }
    //      }

    @Override
    public void signup(Job jobTitle) {

        if (ApplicationContext.getBankService().findAll().isEmpty()) {
            PrintData.errorMessage("Please build a bank !");
            return;
        }
        User user;
        Bank bank ;
        user=GetDataFromUser.getDataForSignUp(jobTitle);
        List<Bank> banksList = ApplicationContext.getBankService().showBanks();
        banksList.forEach(b -> System.out.printf("[%d] - %s\n", b.getId(), b.getBName()));
        outer:{
            while (true) {
                System.out.printf("\t %s chosse bank: ", Menu.NEXTLINE);
                int selectedItem = Validator.checkInteger("\\d");
                for (Bank item : banksList) {
                    if (item.getId() == selectedItem)
                        break;
                }
                bank=ApplicationContext.getBankService().findById((long) selectedItem);
                break;
            }
        }
        user.setJobTitle(jobTitle);
        save(user);
        if (bank.getChief()==null)
            if (Job.EMPLOYEE.equals(jobTitle))
                bank.setChief(user);
            else {
                PrintData.errorMessage("This bank has no cheif yet!");
                return;
            }
        Set<User> bankUsers=bank.getBankUsers();
        bankUsers.add(user);
        bank.setBankUsers(bankUsers);
        ApplicationContext.getBankService().save(bank);
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

