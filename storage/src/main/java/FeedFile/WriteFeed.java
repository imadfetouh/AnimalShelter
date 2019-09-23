package FeedFile;

import AnimalFeed.ISellable;
import AnimalModels.Animal;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class WriteFeed {

    public static void writeProducts(List<ISellable> sellables){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("D:/animalfeed.bin")));

            for(ISellable s : sellables) {
                objectOutputStream.writeObject(s);
                objectOutputStream.flush();
            }
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
