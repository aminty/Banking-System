package util.initializer;

import util.ApplicationContext;

public class Initiator {

    public void init(){
        ApplicationContext.getAccountService();
        ApplicationContext.getBankService();
        ApplicationContext.getCustomerService();
        ApplicationContext.getEmployeeService();
        ApplicationContext.getTransactionService();
    }
}
