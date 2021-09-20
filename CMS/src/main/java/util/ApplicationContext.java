package util;

import repository.*;
import repository.impl.*;
import service.*;
import service.impl.*;

import javax.persistence.EntityManager;

public class ApplicationContext {
    private static final AccountService accountService;
    private static final BankService bankService;
    private static final CustomerService customerService;
    private static final EmployeeService employeeService;
    private static final TransactionService TransactionService;


    private static final AccountRepository accountRepository;
    private static final BankRepository bankRepository;
    private static final CustomerRepository customerRepository;
    private static final EmployeeRepository employeeRepository;
    private static final TransactionRepository transactionRepository;


    static {
        EntityManager entityManager = HibernateUtil.getEntityMangerFactory().createEntityManager();
        accountRepository = new AccountRepositoryimpl(entityManager);
        bankRepository = new BankRepositoryImpl(entityManager);
        customerRepository = new CustomerRepositoryImpl(entityManager);
        employeeRepository = new EmployeeRepositoryImpl(entityManager);
        transactionRepository = new TransactionRepositoryImpl(entityManager);
        accountService = new AccountServiceImpl(accountRepository);

        bankService = new BankServiceImpl(bankRepository);
        customerService = new CustomerServiceImpl(customerRepository);
        employeeService = new EmployeeServiceImpl(employeeRepository);
        TransactionService = new TransactionServiceImpl(transactionRepository);

    }

    public static AccountService getAccountService() {
        return accountService;
    }

    public static BankService getBankService() {
        return bankService;
    }

    public static CustomerService getCustomerService() {
        return customerService;
    }

    public static EmployeeService getEmployeeService() {
        return employeeService;
    }

    public static service.TransactionService getTransactionService() {
        return TransactionService;
    }
}
