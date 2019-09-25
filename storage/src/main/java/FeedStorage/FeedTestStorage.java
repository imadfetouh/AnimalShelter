package FeedStorage;

import AnimalFeed.ISellable;
import AnimalFeed.Product;
import storageInterface.IAnimalFeed;

import java.util.ArrayList;
import java.util.List;

public class FeedTestStorage implements IAnimalFeed {

    List<ISellable> sellables;

    public FeedTestStorage(){
        sellables = new ArrayList<>();
        Product product = new Product("Brood", 2.50, 2);
        sellables.add(product);
        Product product1 = new Product("Melk", 3.50, 7);
        sellables.add(product1);
        Product product2 = new Product("Boter", 1.50, 5);
        sellables.add(product2);
        Product product3 = new Product("Pizza", 8.50, 10);
        sellables.add(product3);
    }

    @Override
    public List<ISellable> getProducts() {
        return sellables;
    }

    @Override
    public void addProduct(ISellable iSellable) {
        sellables.add(iSellable);
    }

    @Override
    public void updateProduct(ISellable iSellable) {
        for(ISellable s : sellables){
            if(s.getSerialVersionUid().equals(iSellable.getSerialVersionUid())){
                s = iSellable;
                break;
            }
        }
    }
}
