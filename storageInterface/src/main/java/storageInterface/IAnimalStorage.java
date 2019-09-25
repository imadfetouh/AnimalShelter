package storageInterface;

import AnimalModels.Animal;
import AnimalModels.Reservor;

import java.util.List;

public interface IAnimalStorage {
    List<Animal> getAnimals();
    void addAnimal(Animal animal);
    void updateAnimal(Animal animal);
}
