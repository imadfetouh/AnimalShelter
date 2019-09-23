package Validate;

import AnimalModels.Animal;

public class ValidateAnimal {

    public static boolean validateNewAnimal(Animal animal){
        return !animal.getName().equals("") && animal.getGender() != null;
    }

}
