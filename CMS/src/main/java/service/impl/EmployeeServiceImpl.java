package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.Employee;
import repository.EmployeeRepository;
import service.EmployeeService;
import ui.Menu;
import ui.PrintData;
import util.CurrentData;

import java.util.Scanner;

public class EmployeeServiceImpl extends BaseEntityServiceImpl<Employee, Long, EmployeeRepository>
        implements EmployeeService {
    public EmployeeServiceImpl(EmployeeRepository repository) {
        super(repository);
    }

    @Override
    public boolean login() {
        System.out.printf("\t %s enter username: ", Menu.NEXTLINE);
        String username = new Scanner(System.in).next();
        System.out.printf("\t %s enter password: ", Menu.NEXTLINE);
        String password = new Scanner(System.in).next();
        if (repository.isExistsByUsername(username)) {
            Employee employee = repository.fingByUsername(username);
            if (employee.getUser().getPassword().equals(password))
                CurrentData.setCurrentUser(employee.getUser());
            PrintData.printMessage(Menu.LOGIN_SUCCESS__MSG);
            return true;
        } else {
            PrintData.errorMessage("This user does not exists!");
            return false;
        }
    }
}
