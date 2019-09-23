package Filter;

import AnimalModels.Animal;
import AnimalModels.TypeAnimal;

import java.util.ArrayList;
import java.util.List;

public class AnimalFilter {

    public static List<Animal> filterAnimals(List<Animal> animals, TypeAnimal typeAnimal){
        List<Animal> animalsFilter = new ArrayList<>();
        for(Animal animal : animals){
            if(animal.getTypeAnimal().equals(typeAnimal)) animalsFilter.add(animal);
        }

        return animalsFilter;
    }
}
