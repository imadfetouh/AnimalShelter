package AnimalFile;

import AnimalModels.Animal;
import AnimalModels.Reservor;

import java.util.List;

public class SetReservor {

    public static void addReservor(List<Animal> animals, Reservor reservor, String id){
        for(Animal animal : animals){
            if(animal.getSerialVersionUID().equals(id)){
                animal.setReservedBy(reservor);
            }
        }
    }

}
