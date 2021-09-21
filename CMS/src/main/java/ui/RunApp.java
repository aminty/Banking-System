package ui;

import ui.enumeration.Job;
import util.ApplicationContext;
import validation.Validator;


public class RunApp {


    public static void run() {

        outer:
        {
            while (true) {
                int selectedItem;
                PrintData.printMenu(Menu.STARTMENU);
                PrintData.printMessage("Select item : ");
                switch (Validator.checkInteger("\\d+")) {
                    case 1:
                        login();
                        break;

                    case 2:
                        signup();
                        break;


                    case 3:
                        ApplicationContext.getBankService().buidBank();
                        break;

                    case 4:
                        break outer;
                    default:
                        PrintData.errorMessage("Item does not exists !");

                }
            }
        }
    }

    private static void signup() {
        outer:
        {
            while (true) {
                System.out.println("-*-*-*-*-*-* sign up -*-*-*-*-*-*");
                int selectedItem;
                PrintData.printMenu(Menu.LOGINAS);
                PrintData.printMessage("Signup as : ");
                switch (Validator.checkInteger("\\d+")) {
                    case 1:
                        ApplicationContext.getUserService().signup(Job.EMPLOYEE);

                        break;

                    case 2:
                        ApplicationContext.getUserService().signup(Job.CUSTOMER);


                        break;

                    case 3:
                        break outer;
                    default:
                        PrintData.errorMessage("Item does not exists !");
                }
            }
        }

    }


    private static void login() {
        outer:
        {
            while (true) {
                System.out.println("-*-*-*-*-*-* login -*-*-*-*-*-*");
                int selectedItem;
                PrintData.printMenu(Menu.LOGINAS);
                PrintData.printMessage("Login as : ");
                switch (Validator.checkInteger("\\d+")) {
                    case 1:
                        loginAsEmployee();
                        break;

                    case 2:
                        loginAsCustomer();
                        break;

                    case 3:
                        break outer;
                    default:
                        PrintData.errorMessage("Item does not exists !");
                }
            }
        }
    }

    private static void loginAsCustomer() {
        outer:
        {
            while (true) {
                int selectedItem;
                PrintData.printDashboard(Menu.WHENCUSTOMERLOGIN);
                PrintData.printMessage("Select item : ");
                switch (Validator.checkInteger("\\d+")) {
                    case 1:

                        break;

                    case 2:

                        break;
                    case 3:

                        break;

                    case 4:

                        break;

                    case 5:
                        break outer;
                    default:
                        PrintData.errorMessage("Item does not exists !");

                }
            }
        }
    }

    private static void loginAsEmployee() {

        outer:
        {
            while (true) {
                int selectedItem;
                PrintData.printMenu(Menu.WHENEMPLOYEELOGIN);
                PrintData.printMessage("Select item : ");
                switch (Validator.checkInteger("\\d+")) {
                    case 1:

                        break;

                    case 2:

                        break;
                    case 3:

                        break;

                    case 4:

                        break;

                    case 5:
                        break outer;
                    default:
                        PrintData.errorMessage("Item does not exists !");

                }
            }
        }
    }
}
