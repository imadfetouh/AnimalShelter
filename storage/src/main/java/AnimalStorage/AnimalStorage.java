package AnimalStorage;
import AnimalFile.ReadAnimals;
import AnimalFile.SetReservor;
import AnimalFile.WriteAnimals;
import AnimalModels.*;
import storageInterface.IAnimalStorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnimalStorage implements IAnimalStorage {

    private List<Animal> animals;

    public AnimalStorage() {
        animals = new ArrayList<>();
    }

    @Override
    public List<Animal> getAnimals(){
        animals = ReadAnimals.getAnimals();
        return Collections.unmodifiableList(animals);
    }

    @Override
    public void addAnimal(Animal animal){
        animals.add(animal);
        WriteAnimals.writeAnimals(animals);
    }

    @Override
    public void addReservor(Reservor reservor, String id) {
        SetReservor.addReservor(animals, reservor, id);
        WriteAnimals.writeAnimals(animals);
    }
}
