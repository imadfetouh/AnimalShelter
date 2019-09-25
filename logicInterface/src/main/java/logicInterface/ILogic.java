package logicInterface;

import AnimalModels.*;

import java.util.List;

public interface ILogic {

    List<Animal> getAnimals(String filter);
    void addAnimal(Animal animal);
    void addReservor(Animal animal);
    boolean validateNewAnimal(Animal animal);
    boolean validateNewReservor(Reservor reservor);
}
