package validate;

import Observers.Observer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class validateObserverTest {

    @Test
    void testValidateObserverCorrect(){
        Observer observer = new Observer("imad.elfetouh@hotmail.com");

        assertEquals(true, validateObserver.validateNewObserver(observer));
    }

    @Test
    void testValidateObserverEmptyEmail(){
        Observer observer = new Observer("");

        assertEquals(false, validateObserver.validateNewObserver(observer));
    }

    @Test
    void testValidateObserverNullEmail(){
        Observer observer = new Observer(null);

        assertEquals(false, validateObserver.validateNewObserver(observer));
    }
}