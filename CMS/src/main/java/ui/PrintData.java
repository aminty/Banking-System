package ui;

import domain.Account;

import java.util.stream.Stream;

public class PrintData {
    public static void printMenu(String[] items) {
        Stream.of(items).forEach(System.out::println);

    }

    public static void printDashboard(String[] items, Account account) {
        System.out.println("|-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-|");
        System.out.printf("|Name: %S   -   Branch: %S   -    Customer id: %d \n",
                account.getCustomer().getUser().getFirstName() + " " +
                        account.getCustomer().getUser().getLastName(), account.getBranch().getBName(),
                account.getCustomer().getId());
        System.out.println("|-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-|");
        Stream.of(items).forEach(System.out::println);

    }

    public static void printMessage(String title) {
        System.out.print("--> " + title +"\n");
    }
}
