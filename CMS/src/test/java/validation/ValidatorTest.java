package validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ui.GetDataFromUser;
import util.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {

    @Test
    void checkCardNumer() {

        Assertions.assertEquals("1141232234334444",Validator.checkCardNumer("1141-2322-3433-4444"));
    }
}