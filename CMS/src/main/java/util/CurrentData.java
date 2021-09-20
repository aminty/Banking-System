package util;

import domain.Account;
import domain.User;

public class CurrentData {
     public  static User currentUser;
     public  static Account currentAccount;



    public static void logout() {
        currentUser = null;
        currentAccount=null;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        CurrentData.currentUser = currentUser;
    }

    public static Account getCurrentAccount() {
        return currentAccount;
    }

    public static void setCurrentAccount(Account currentAccount) {
        CurrentData.currentAccount = currentAccount;
    }
}
