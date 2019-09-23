package AnimalFile;

import AnimalModels.Animal;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadAnimals {

    public static List<Animal> getAnimals(){
        List<Animal> animals = new ArrayList<>();
        try {
            animals.clear();
            Object object;
            ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("D:/animals.bin")));
            while ((object = objectInputStream.readObject()) != null){
                Animal animal = (Animal) object;
                animals.add(animal);
            }
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return animals;
    }

}
