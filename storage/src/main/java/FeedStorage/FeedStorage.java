package FeedStorage;

import AnimalFeed.ISellable;
import FeedFile.ReadFeed;
import FeedFile.WriteFeed;
import storageInterface.IAnimalFeed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FeedStorage implements IAnimalFeed  {

    private List<ISellable> sellables;

    public FeedStorage(){
        sellables = new ArrayList<>();
    }

    @Override
    public List<ISellable> getProducts() {
        sellables = ReadFeed.getProducts();
        return Collections.unmodifiableList(sellables);
    }

    @Override
    public void addProduct(ISellable iSellable) {
        sellables.add(iSellable);
        WriteFeed.writeProducts(sellables);
    }

    @Override
    public void updateProduct(ISellable iSellable) {
        for(ISellable s : sellables){
            if(s.getSerialVersionUid().equals(iSellable.getSerialVersionUid())){
                s = iSellable;
                break;
            }
        }
        WriteFeed.writeProducts(sellables);
    }
}
