package validate;

import AnimalModels.Animal;

public class validateAnimal {

    public static boolean validateNewAnimal(Animal animal){
        return animal.getTypeAnimal() != null && animal.getGender() != null && animal.getName() != null && !animal.getName().isEmpty();
    }

}
