package logicInterface;

import AnimalModels.*;

import java.util.List;

public interface ILogic {

    List<Animal> getAnimals(String filter);
    void addAnimal(Animal animal);
    void addReservor(Reservor reservor, String id);
    boolean validate(Animal animal);
}
