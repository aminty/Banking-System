package util;

import repository.*;
import repository.impl.*;
import service.*;
import service.impl.*;

import javax.persistence.EntityManager;

public class ApplicationContext {
    private static final AccountService accountService;
    private static final BankService bankService;
    private static final TransactionService TransactionService;
    private static final UserService userService;
    private static final CreaditCardService creaditCardService;


    private static final CreaditCardRepository creaditCardRepository;
    private static final AccountRepository accountRepository;
    private static final BankRepository bankRepository;
    private static final TransactionRepository transactionRepository;
    private static final UserRepository userRepository;


    static {
        EntityManager entityManager = HibernateUtil.getEntityMangerFactory().createEntityManager();
        accountRepository = new AccountRepositoryImpl(entityManager);
        bankRepository = new BankRepositoryImpl(entityManager);
        creaditCardRepository = new CreaditCardRepositoryImpl(entityManager);

        transactionRepository = new TransactionRepositoryImpl(entityManager);
        userRepository = new UserRepositoryImpl(entityManager);

        accountService = new AccountServiceImpl(accountRepository);
        bankService = new BankServiceImpl(bankRepository);

        TransactionService = new TransactionServiceImpl(transactionRepository);
        userService = new UserServiceImpl(userRepository);

        creaditCardService = new CreaditCardSeviceImpl(creaditCardRepository);

    }

    public static AccountService getAccountService() {
        return accountService;
    }

    public static BankService getBankService() {
        return bankService;
    }


    public static TransactionService getTransactionService() {
        return TransactionService;
    }

    public static UserService getUserService() {
        return userService;
    }

    public static CreaditCardService getCreaditCardService() {
        return creaditCardService;
    }
}
