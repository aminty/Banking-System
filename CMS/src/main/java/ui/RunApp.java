package ui;

import util.ApplicationContext;
import util.CurrentData;
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
                        break outer;
                    default:
                        PrintData.errorMessage("Item does not exists !");

                }


            }
        }


    }

    private static void signup() {
        ApplicationContext.getCustomerService().signup();

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
                        if( ApplicationContext.getEmployeeService().login())
                            loginAsEmployee();
                        break;

                    case 2:
                        if( ApplicationContext.getCustomerService().login())
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
                PrintData.printMenu(Menu.WHENCUSTOMERLOGIN);
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
