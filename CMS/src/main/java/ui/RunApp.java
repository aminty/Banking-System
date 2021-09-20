package ui;

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
                       if( ApplicationContext.getEmployeeService().login())
                           login();
                        break;

                    case 2:
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
    }


}
