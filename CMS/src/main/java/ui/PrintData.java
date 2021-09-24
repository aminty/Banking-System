package ui;

import domain.Account;
import domain.Transaction;
import util.CurrentData;

import java.util.List;
import java.util.stream.Stream;

public class PrintData {
    public static void printMenu(String[] items) {
        Stream.of(items).forEach(System.out::println);

    }

    public static void printDashboard(String[] items) {
        System.out.println("|-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-|");
        System.out.printf("|Name: %S   -   Branch: %S   -    Customer id: %d   \n",
                CurrentData.getCurrentAccount().getOwnerAccount().getFirstName() + " " +
                        CurrentData.getCurrentAccount().getOwnerAccount().getLastName(), CurrentData.getCurrentAccount().getBranch().getBName(),
                CurrentData.getCurrentAccount().getId());
        System.out.println("|-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-|");
        Stream.of(items).forEach(System.out::println);

    }

    public static void printMessage(String title) {
        System.out.print("->> " + title);
    }

    public static void errorMessage(String title) {
        System.out.println("\t" + " >>>  " + Menu.DELETE + " " + title);
    }

    public static void successMessage(String title) {
        System.out.println("\t" + " >>>  " + Menu.CHECKMARK + " " + title);
    }

    public static void showAllTransactions(List<Transaction> transaction) {
        transaction.forEach(t -> System.out.printf
                ("\t " + Menu.NEXTLINE + "[%d] - T-Type: %s  Amount: %s  Owner: %s  Destination: %s  Date: %s  \n",
                        t.getId(),
                        t.getTransactionType(), t.getWithdrawAmount(), t.getSource().getOwnerAccount().getUsername(),
                        t.getDestination().getOwnerAccount().getUsername(), t.getDate()));
        System.out.println("|-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-|");
    }

    public static void showAllAccounts(List<Account> accounts) {
        accounts.forEach(a -> System.out.printf
                ("\t " + Menu.NEXTLINE + "[%d] - Owner: %s  Balance: %s   Usename: %s    Branch: %s  \n",
                        a.getId(),
                        a.getOwnerAccount().getFirstName()+a.getOwnerAccount().getLastName(),
                        a.getBalance(), a.getOwnerAccount().getUsername(),
                        a.getBranch().getBName()));
        System.out.println("|-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-|");

    }
}
