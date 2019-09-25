package AnimalStorage;

import AnimalModels.Animal;
import AnimalModels.Cat;
import AnimalModels.Gender;
import AnimalModels.Reservor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTestStorageTest {

    @Test
    void testConstructor(){
        AnimalTestStorage animalTestStorage = new AnimalTestStorage();

        assertEquals(4, animalTestStorage.getAnimals().size());
    }

    @Test
    void testAddAnimalListCount(){
        AnimalTestStorage animalTestStorage = new AnimalTestStorage();
        Cat cat = new Cat("Imad", Gender.Male, "Krassen");

        animalTestStorage.addAnimal(cat);

        assertEquals(5, animalTestStorage.getAnimals().size());
    }

    @Test
    void testUpdateAnimalListCount(){
        AnimalTestStorage animalTestStorage = new AnimalTestStorage();
        Animal animal = animalTestStorage.getAnimals().get(0);
        animal.setReservedBy(new Reservor("Imad", LocalDate.now()));

        animalTestStorage.updateAnimal(animal);

        assertEquals(4, animalTestStorage.getAnimals().size());
        assertEquals("Imad", animalTestStorage.getAnimals().get(0).getReservedBy().getName());
        assertEquals(LocalDate.now(), animalTestStorage.getAnimals().get(0).getReservedBy().getDate());
    }

}