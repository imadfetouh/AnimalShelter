package storageInterface;

import AnimalFeed.ISellable;

import java.util.List;

public interface IAnimalFeed {

    List<ISellable> getProducts();
    void addProduct(ISellable iSellable);
    void updateProduct(ISellable iSellable);
}
