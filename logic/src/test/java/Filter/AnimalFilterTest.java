package Filter;

import AnimalModels.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalFilterTest {

    private static List<Animal> animals;

    @BeforeAll
    static void setup(){
        animals = new ArrayList<>();
        Cat cat = new Cat("Imad", Gender.Male, "krassen");
        Cat cat1 = new Cat("Rik", Gender.Female, "Likken");
        Dog dog = new Dog("Peter", Gender.Female);
        Dog dog1 = new Dog("Rinus", Gender.Male);
        Dog dog2 = new Dog("Jan", Gender.Male);
        animals.add(cat);
        animals.add(cat1);
        animals.add(dog);
        animals.add(dog1);
        animals.add(dog2);
    }

    @Test
    void testGetAllCats(){
        assertEquals(2, AnimalFilter.filterAnimals(animals, TypeAnimal.Cat).size());
    }

    @Test
    void testGetAllDogs(){
        assertEquals(3, AnimalFilter.filterAnimals(animals, TypeAnimal.Dog).size());
    }
}