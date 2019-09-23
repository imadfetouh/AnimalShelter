package FeedFile;

import AnimalFeed.ISellable;
import AnimalFeed.Product;
import AnimalModels.Animal;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadFeed {

    public static List<ISellable> getProducts(){
        List<ISellable> sellables = new ArrayList<>();
        try {
            sellables.clear();
            Object object;
            ObjectInputStream objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream("D:/animalfeed.bin")));
            while ((object = objectInputStream.readObject()) != null){
                ISellable sellable = (ISellable) object;
                sellables.add(sellable);
            }
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return sellables;
    }
}
