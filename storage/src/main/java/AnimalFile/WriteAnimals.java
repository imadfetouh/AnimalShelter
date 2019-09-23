package AnimalFile;

import AnimalModels.Animal;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class WriteAnimals {

    public static void writeAnimals(List<Animal> animals){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("D:/animals.bin")));

            for(Animal a : animals) {
                objectOutputStream.writeObject(a);
                objectOutputStream.flush();
            }
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
