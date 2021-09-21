package ui;

import domain.User;
import ui.enumeration.Job;
import util.ApplicationContext;

import java.util.Scanner;

public class GetDataFromUser {

    public static User getDataForSignUp(Job jobTitle) {
        User user = new User();
        System.out.println("-*-*-*-*-*-* sign up -*-*-*-*-*-*");
        System.out.printf("\t %s enter first name: ", Menu.NEXTLINE);
        user.setFirstName(new Scanner(System.in).next());
        System.out.printf("\t %s enter last name: ", Menu.NEXTLINE);
        user.setLastName(new Scanner(System.in).next());
        while (true) {
            System.out.printf("\t %s choose username: ", Menu.NEXTLINE);
            String username = new Scanner(System.in).next();
            if (!ApplicationContext.getUserService().isExistsByUsername(username)) {
                user.setUsername(username);
                break;
            } else
                System.out.println("\t" + " >>>  " + Menu.PROHIBITED + " This user is exist !");
        }
        System.out.printf("\t %s choose password: ", Menu.NEXTLINE);
        user.setPassword(new Scanner(System.in).next());
        while (true) {
            System.out.printf("\t %s enter national code: ", Menu.NEXTLINE);
            String nationalCode = new Scanner(System.in).next();
            if (!ApplicationContext.getUserService().isExistsByNationalCode(nationalCode)) {
                user.setNationalCode(nationalCode);
                break;
            } else
                System.out.println("\t" + " >>>  " + Menu.PROHIBITED + " This national code is exist !");
        }
        user.setJobTitle(jobTitle);


        return user;
    }


}
