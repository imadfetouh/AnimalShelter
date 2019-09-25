package logic;

import AnimalModels.Animal;
import AnimalModels.Cat;
import AnimalModels.Gender;
import AnimalModels.Reservor;
import AnimalStorage.AnimalTestStorage;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnimalLogicTest {

    @Test
    void testGetAllAnimals(){
        AnimalLogic animalLogic = new AnimalLogic(new AnimalTestStorage());

        List<Animal> getAllAnimals = animalLogic.getAnimals("All");

        assertEquals(4, getAllAnimals.size());
    }

    @Test
    void testGetAllCats(){
        AnimalLogic animalLogic = new AnimalLogic(new AnimalTestStorage());

        List<Animal> getAllAnimals = animalLogic.getAnimals("Cat");

        assertEquals(2, getAllAnimals.size());
    }

    @Test
    void testGetAllDogs(){
        AnimalLogic animalLogic = new AnimalLogic(new AnimalTestStorage());

        List<Animal> getAllAnimals = animalLogic.getAnimals("Dog");

        assertEquals(2, getAllAnimals.size());
    }

    @Test
    void testAddAnimal(){
        AnimalLogic animalLogic = new AnimalLogic(new AnimalTestStorage());
        Cat cat = new Cat("Imad", Gender.Male, "Krassen");

        animalLogic.addAnimal(cat);

        assertEquals(5, animalLogic.getAnimals("All").size());
    }

    @Test
    void testUpdateAnimal(){
        AnimalLogic animalLogic = new AnimalLogic(new AnimalTestStorage());

        animalLogic.getAnimals("All").get(0).setReservedBy(new Reservor("Imad", LocalDate.now()));

        assertEquals(4, animalLogic.getAnimals("All").size());
        assertEquals("Imad", animalLogic.getAnimals("All").get(0).getReservedBy().getName());
        assertEquals(LocalDate.now(), animalLogic.getAnimals("All").get(0).getReservedBy().getDate());
    }
}