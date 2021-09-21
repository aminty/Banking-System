package util.initializer;

import domain.User;
import service.*;
import ui.enumeration.Gender;
import ui.enumeration.Job;
import util.ApplicationContext;

public class Initiator {

    public static void init() {
        AccountService accountService = ApplicationContext.getAccountService();
        BankService bankService = ApplicationContext.getBankService();

        TransactionService transactionService = ApplicationContext.getTransactionService();

        /* INIT*/
//        User user = new User();
//        user.setFirstName("amin");
//        user.setLastName("tavakkoli");
//        user.setNationalCode("0020411741");
//        user.setGender(Gender.MALE);
//        user.setUsername("aminty");
//        user.setPassword("1234");
//        Employee employee = new Employee();
//        employee.setJobTitle(Job.CHIEF);
//        employee.setUser(user);

    }
}
