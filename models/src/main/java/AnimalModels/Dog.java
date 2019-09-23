package AnimalModels;

import java.time.LocalDate;
import java.time.Period;

public class Dog extends Animal {

    private LocalDate lastWalk;

    public Dog(String name, Gender gender) {
        super(name, gender, TypeAnimal.Dog);

        this.lastWalk = LocalDate.now();
    }

    public Dog(String name, Gender gender, LocalDate lastWalk) {
        super(name, gender, TypeAnimal.Dog);

        this.lastWalk = lastWalk;
    }

    public LocalDate getLastWalk(){
        return this.lastWalk;
    }

    public boolean needsWalk()
    {
        return Period.between(this.lastWalk, LocalDate.now()).getDays() > 0;
    }

    public boolean needsWalk(LocalDate localDate)
    {
        return Period.between(localDate, LocalDate.now()).getDays() > 0;
    }

    @Override
    public String toString() {
        return super.toString() + ", last walk: " + needsWalk();
    }
}
