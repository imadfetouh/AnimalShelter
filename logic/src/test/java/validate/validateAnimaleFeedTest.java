package validate;

import AnimalFeed.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class validateAnimaleFeedTest {

    @Test
    void testValidateAnimalFeedCorrect(){
        Product product = new Product("Imad", 2.80, 9);

        assertEquals(true, validateAnimalFeed.validate(product));
    }

    @Test
    void testValidateAnimalFeedNullName(){
        Product product = new Product(null, 2.80, 9);

        assertEquals(false, validateAnimalFeed.validate(product));
    }

    @Test
    void testValidateAnimalFeedEmptyName(){
        Product product = new Product("", 2.80, 9);

        assertEquals(false, validateAnimalFeed.validate(product));
    }

    @Test
    void testValidateAnimalFeedEmptyPrice(){
        Product product = new Product("Imad", null, 9);

        assertEquals(false, validateAnimalFeed.validate(product));
    }

    @Test
    void testValidateAnimalFeedEmptyStock(){
        Product product = new Product("Imad", 9.80, null);

        assertEquals(false, validateAnimalFeed.validate(product));
    }

}