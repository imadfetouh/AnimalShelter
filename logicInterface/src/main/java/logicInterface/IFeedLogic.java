package logicInterface;

import AnimalFeed.ISellable;
import Observers.IObserver;

import java.util.List;

public interface IFeedLogic {
    List<ISellable> getProducts();
    void addProduct(ISellable iSellable);
    void updateProduct(ISellable iSellable);
    void addObserver(ISellable iSellable, IObserver observer);
}
