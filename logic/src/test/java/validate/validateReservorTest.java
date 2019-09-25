package validate;

import AnimalModels.Reservor;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class validateReservorTest {

    @Test
    void testValidateNewReservorCorrect(){
        Reservor reservor = new Reservor("imad", LocalDate.now());

        assertEquals(true, validateReservor.validateNewReservor(reservor));
    }

    @Test
    void testValidateNewReservorNullName(){
        Reservor reservor = new Reservor(null, LocalDate.now());

        assertEquals(false, validateReservor.validateNewReservor(reservor));
    }

    @Test
    void testValidateNewReservorEmptyName(){
        Reservor reservor = new Reservor("", LocalDate.now());

        assertEquals(false, validateReservor.validateNewReservor(reservor));
    }
}