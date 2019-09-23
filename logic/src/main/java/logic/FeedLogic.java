package logic;

import AnimalFeed.ISellable;
import Observers.IObserver;
import Observers.Observer;
import logicInterface.IFeedLogic;
import storageInterface.IAnimalFeed;

import java.util.List;

public class FeedLogic implements IFeedLogic {

    private IAnimalFeed animalFeed;

    public FeedLogic(IAnimalFeed animalFeed){
        this.animalFeed = animalFeed;
    }

    @Override
    public List<ISellable> getProducts() {
        return animalFeed.getProducts();
    }

    @Override
    public void addProduct(ISellable iSellable) {
        animalFeed.addProduct(iSellable);
    }

    @Override
    public void updateProduct(ISellable iSellable) {
        animalFeed.updateProduct(iSellable);
    }

    @Override
    public void addObserver(ISellable iSellable, IObserver observer) {
        iSellable.addObserver(observer);
        animalFeed.updateProduct(iSellable);
    }
}
