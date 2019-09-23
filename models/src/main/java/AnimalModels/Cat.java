package AnimalModels;

import java.io.Serializable;

public class Cat extends Animal implements Serializable {

    private String badHabits;

    public Cat(String name, Gender gender, String badHabits) {
        super(name, gender, TypeAnimal.Cat);

        this.badHabits = badHabits;
    }

    public String getBadHabits(){
        return badHabits;
    }

    @Override
    public String toString() {
        return super.toString() + ", bad habits: " + this.badHabits.toLowerCase();
    }
}
