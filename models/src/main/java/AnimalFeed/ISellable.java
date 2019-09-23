package AnimalFeed;

import Observers.IObserver;
import Observers.Observer;

public interface ISellable {

    String getName();
    Double getPrice();
    int getStock();
    void addStock(int stock);
    void sell();
    void notifyObservers();
    void addObserver(IObserver ob);
    String getSerialVersionUid();
}
