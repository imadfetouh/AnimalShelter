package validate;

import AnimalModels.Cat;
import AnimalModels.Gender;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class validateAnimalTest {

    @Test
    void testValidateNewAnimalCorrect(){
        Cat cat = new Cat("Imad", Gender.Male, "Krassen");

        assertEquals(true, validateAnimal.validateNewAnimal(cat));
    }

    @Test
    void testValidateNewAnimalEmptyName(){
        Cat cat = new Cat("", Gender.Male, "Krassen");

        assertEquals(false, validateAnimal.validateNewAnimal(cat));
    }

    @Test
    void testValidateNewAnimalNullName(){
        Cat cat = new Cat(null, Gender.Male, "Krassen");

        assertEquals(false, validateAnimal.validateNewAnimal(cat));
    }

    @Test
    void testValidateNewAnimalNullGender(){
        Cat cat = new Cat("Imad", null, "Krassen");

        assertEquals(false, validateAnimal.validateNewAnimal(cat));
    }
}