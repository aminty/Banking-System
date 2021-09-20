package util;

import domain.Account;

public class CurrentData {
     public  static Account currentAccount;


    public static void logout() {
        currentAccount = null;
    }
    public static Account getCurrentAccount() {
        return currentAccount;
    }

    public static void setCurrentAccount(Account currentAccount) {
        CurrentData.currentAccount = currentAccount;
    }
}
