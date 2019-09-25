package logic;

import Filter.AnimalFilter;
import logicInterface.ILogic;
import AnimalModels.*;
import storageInterface.IAnimalStorage;
import validate.validateAnimal;
import validate.validateReservor;

import java.util.List;

public class AnimalLogic implements ILogic {

    private IAnimalStorage animalStorage;

    public AnimalLogic(IAnimalStorage animalStorage){
        this.animalStorage = animalStorage;
    }

    @Override
    public List<Animal> getAnimals(String filter) {
        List<Animal> animals = animalStorage.getAnimals();
        return (filter == "All") ? animalStorage.getAnimals() : AnimalFilter.filterAnimals(animals, TypeAnimal.valueOf(filter));
    }

    @Override
    public void addAnimal(Animal animal) {
        animalStorage.addAnimal(animal);
    }

    @Override
    public void addReservor(Animal animal) {
        animalStorage.updateAnimal(animal);
    }

    @Override
    public boolean validateNewAnimal(Animal animal) {
        return validateAnimal.validateNewAnimal(animal);
    }

    @Override
    public boolean validateNewReservor(Reservor reservor){
        return validateReservor.validateNewReservor(reservor);
    }
}
