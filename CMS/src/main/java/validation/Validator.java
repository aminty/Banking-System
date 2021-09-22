package validation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static int checkInteger(String pattern){
        String entry;
        while(true){
            entry= new Scanner(System.in).next();
            Matcher m= Pattern.compile(pattern).matcher(entry);
            if (m.matches())
                return Integer.parseInt(entry);
        }
    }

    public static boolean checkCardNumer(String number){
            Matcher m= Pattern.compile("\\d{16}").matcher(number);
            if (m.matches()){
                return true;

            }else return false;
        }

    public static boolean isValidPin(String pin) {
        return Pattern.compile("\\d+").matcher(pin).matches();
    }
}
