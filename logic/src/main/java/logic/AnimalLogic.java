package logic;

import Filter.AnimalFilter;
import Validate.ValidateAnimal;
import logicInterface.ILogic;
import AnimalModels.*;
import storageInterface.IAnimalStorage;

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
    public void addReservor(Reservor reservor, String id) {
        animalStorage.addReservor(reservor, id);
    }

    @Override
    public boolean validate(Animal animal) {
        return ValidateAnimal.validateNewAnimal(animal);
    }
}