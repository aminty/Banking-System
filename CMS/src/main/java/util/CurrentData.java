package util;

import domain.Account;
import domain.User;

public class CurrentData {
     public  static User currentUser;


    public static void logout() {
        currentUser = null;
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        CurrentData.currentUser = currentUser;
    }
}
