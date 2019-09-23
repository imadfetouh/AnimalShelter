package AnimalModels;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CatTest {

    @Test
    void testConstructor(){
        Cat cat = new Cat("imad", Gender.Male, "krassen");
        Assertions.assertEquals("imad", cat.getName());
    }

}