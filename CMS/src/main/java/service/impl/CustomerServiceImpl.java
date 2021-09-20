package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.Customer;
import domain.Employee;
import repository.CustomerRepository;
import service.CustomerService;
import ui.Menu;
import ui.PrintData;
import util.CurrentData;

import java.util.Scanner;

public class CustomerServiceImpl extends BaseEntityServiceImpl<Customer,Long, CustomerRepository>
        implements CustomerService {
    public CustomerServiceImpl(CustomerRepository repository) {
        super(repository);
    }

    @Override
    public boolean login() {
        System.out.printf("\t %s enter username: ", Menu.NEXTLINE);
        String username = new Scanner(System.in).next();
        System.out.printf("\t %s enter password: ", Menu.NEXTLINE);
        String password = new Scanner(System.in).next();
        if (repository.isExistsByUsername(username)) {
            Customer customer = repository.fingByUsername(username);
            if (customer.getUser().getPassword().equals(password))
                CurrentData.setCurrentUser(customer.getUser());
            PrintData.printMessage(Menu.LOGIN_SUCCESS__MSG);
            return true;
        } else {
            PrintData.errorMessage("This user does not exists!");
            return false;
        }
    }
}
