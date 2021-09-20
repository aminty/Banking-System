package ui;

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
                        break;

                    case 2:
                        break;

                    case 3:
                        break outer;
                    default:
                        PrintData.printMessage("Item does not exists !");

                }


            }
        }


    }


}
