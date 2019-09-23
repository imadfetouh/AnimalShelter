package AnimalFactory;

import AnimalModels.*;

public class AnimalFactory {

    public static Animal createAnimal(TypeAnimal typeAnimal, String name, Gender gender, String badHabits){

        switch (typeAnimal){
            case Cat:
                return new Cat(name, gender, badHabits);
            case Dog:
                return new Dog(name, gender);
            default:
                return null;
        }
    }

}
