package AnimalStorage;

import AnimalModels.Animal;
import AnimalModels.Cat;
import AnimalModels.Dog;
import AnimalModels.Gender;
import storageInterface.IAnimalStorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnimalTestStorage implements IAnimalStorage {

    private List<Animal> animals;

    public AnimalTestStorage(){
        animals = new ArrayList<>();
        Cat cat = new Cat("Imad", Gender.Male, "Krassen");
        animals.add(cat);
        Cat cat1 = new Cat("Peter", Gender.Female, null);
        animals.add(cat1);
        Dog dog = new Dog("Karel", Gender.Male);
        animals.add(dog);
        Dog dog1 = new Dog("Rinus", Gender.Female);
        animals.add(dog1);
    }

    @Override
    public List<Animal> getAnimals() {
        return Collections.unmodifiableList(animals);
    }

    @Override
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    @Override
    public void updateAnimal(Animal animal) {
        for(Animal a : animals){
            if(a.getSerialVersionUID().equals(animal.getSerialVersionUID())){
                a = animal;
                break;
            }
        }
    }
}
