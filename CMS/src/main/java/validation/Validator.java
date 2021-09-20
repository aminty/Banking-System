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
                return Integer.valueOf(entry);

        }

    }

}
