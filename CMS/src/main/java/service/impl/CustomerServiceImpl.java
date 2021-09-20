package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.Customer;
import domain.Employee;
import domain.User;
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

    @Override
    public void signup() {
        User user=new User();
        System.out.println("-*-*-*-*-*-* sign up -*-*-*-*-*-*");
        System.out.printf("\t %s enter first name: ", Menu.NEXTLINE);
        String firstName = new Scanner(System.in).next();
        System.out.printf("\t %s enter last name: ", Menu.NEXTLINE);
        String lastName = new Scanner(System.in).next();
        while(true){
            System.out.printf("\t %s choose username: ", Menu.NEXTLINE);
            String username = new Scanner(System.in).next();
            if (!repository.isExistsByUsername(username)) {
                user.setUsername(username);
                break;
            }else
                System.out.println("\t"+" >>>  "+ Menu.PROHIBITED+" This user is exist !" );

        }
        System.out.printf("\t %s choose password: ", Menu.NEXTLINE);
        String password = new Scanner(System.in).next();
        while(true){
            System.out.printf("\t %s enter national code: ", Menu.NEXTLINE);
            String nationalCode= new Scanner(System.in).next();
            if (!repository.isExistsByNationalCode(nationalCode)) {
                user.setNationalCode(nationalCode);
                break;
            }else
                System.out.println("\t"+" >>>  "+ Menu.PROHIBITED+" This national code is exist !" );

        }
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setPassword(password);
        save(new Customer(user));
        PrintData.successMessage(Menu.ACCOUNT_CREATE_MSG);

    }
}
