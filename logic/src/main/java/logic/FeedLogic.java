package logic;

import AnimalFeed.ISellable;
import Observers.IObserver;
import Observers.Observer;
import logicInterface.IFeedLogic;
import storageInterface.IAnimalFeed;
import validate.validateAnimalFeed;
import validate.validateObserver;
import validate.validateReservor;

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
    public boolean validateNewFeed(ISellable iSellable) {
        return validateAnimalFeed.validate(iSellable);
    }

    @Override
    public boolean validateNewObserver(Observer observer){
        return validateObserver.validateNewObserver(observer);
    }
}
