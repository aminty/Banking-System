package util.initializer;

import domain.Bank;
import domain.Employee;
import domain.User;
import service.*;
import ui.enumeration.Gender;
import ui.enumeration.Job;
import util.ApplicationContext;

public class Initiator {

    public void init() {
        AccountService accountService = ApplicationContext.getAccountService();
        BankService bankService = ApplicationContext.getBankService();
        CustomerService customerService = ApplicationContext.getCustomerService();
        EmployeeService employeeService = ApplicationContext.getEmployeeService();
        TransactionService transactionService = ApplicationContext.getTransactionService();

        /* INIT */
        User user = new User();
        user.setFirstName("amin");
        user.setLastName("tavakkoli");
        user.setNationalCode("0020411741");
        user.setGender(Gender.MALE);
        Employee employee = new Employee();
        Bank mellat = new Bank();
        employee.setJobTitle(Job.CHIEF);
        employee.setUser(user);
        employee.setUsername("aminty");
        employee.setPassword("1234");
        employee.setChief(employee);
        employee.setIsChief(true);
        mellat.setBName("Mellat");
        ApplicationContext.getBankService().save(mellat);
        employee.setWorkPlace(mellat);
        ApplicationContext.getEmployeeService().save(employee);
        mellat.setChief(employee);
        ApplicationContext.getBankService().save(mellat);

    }
}
