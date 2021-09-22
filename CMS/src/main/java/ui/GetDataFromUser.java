package ui;

import domain.User;
import ui.enumeration.Job;
import util.ApplicationContext;
import validation.Validator;

import java.util.HashMap;
import java.util.Map;
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

    public static String getCardNumberFromUser() {

        while (true) {
            System.out.printf("\t %s enter destination card number: ", Menu.NEXTLINE);
            String cardNumner = new Scanner(System.in).next();
            if (Validator.checkCardNumer(cardNumner))
                return cardNumner;
        }

    }

    public static Map<String, String> getAuthenticationData() {
        Map<String, String> data = new HashMap<>();


        System.out.printf("\t %s enter cvv2: ", Menu.NEXTLINE);
        data.put("cvv2", String.valueOf(Validator.checkInteger("\\d+")));

        System.out.printf("\t %s enter exp date: ", Menu.NEXTLINE);
        data.put("exp", new Scanner(System.in).next());


        return data;

    }

    public static int getPin() {
        while (true) {
            System.out.printf("\t %s enter pin: ", Menu.NEXTLINE);
            String pin = new Scanner(System.in).next();
            if (Validator.isValidPin(pin))
                return Integer.parseInt(pin);
        }

    }


    public static Double getAmountFromUser() {

        System.out.printf("\t %s enter amount: ", Menu.NEXTLINE);
        return new Scanner(System.in).nextDouble();


    }

    public static int changePin() {
        while (true) {
            System.out.printf("\t %s enter new pin: ", Menu.NEXTLINE);
            String pin = new Scanner(System.in).next();

            if (Validator.isValidPin(pin))
                return Integer.parseInt(pin);
        }
    }

    public static int getItem() {

        while (true) {
            System.out.printf("\t %s enter account id: ", Menu.NEXTLINE);
            return Validator.checkInteger("\\d+");
        }
    }
}
