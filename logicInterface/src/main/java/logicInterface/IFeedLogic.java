package logicInterface;

import AnimalFeed.ISellable;
import Observers.IObserver;
import Observers.Observer;

import java.util.List;

public interface IFeedLogic {
    List<ISellable> getProducts();
    void addProduct(ISellable iSellable);
    void updateProduct(ISellable iSellable);
    boolean validateNewFeed(ISellable iSellable);
    boolean validateNewObserver(Observer observer);
}
