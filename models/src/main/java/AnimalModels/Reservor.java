package AnimalModels;

import java.io.Serializable;
import java.time.LocalDate;

public class Reservor implements Serializable {

    private String name;
    private LocalDate date;

    public Reservor(String name, LocalDate date){
        this.name = name;
        this.date = date;
    }

    public LocalDate getDate(){
        return this.date;
    }

    public String getName(){
        return this.name;
    }

}
