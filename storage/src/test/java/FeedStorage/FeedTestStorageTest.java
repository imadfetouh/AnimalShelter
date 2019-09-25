package FeedStorage;

import AnimalFeed.ISellable;
import AnimalFeed.Product;
import Observers.IObserver;
import Observers.Observer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeedTestStorageTest {

    @Test
    void testGetAnimalFeedListCount(){
        FeedTestStorage feedTestStorage = new FeedTestStorage();

        assertEquals(4, feedTestStorage.getProducts().size());
    }

    @Test
    void testAddAnimalFeedCount(){
        FeedTestStorage feedTestStorage = new FeedTestStorage();
        Product product = new Product("Appels", 1.75, 3);

        feedTestStorage.addProduct(product);

        assertEquals(5, feedTestStorage.getProducts().size());
    }

    @Test
    void testUpdateAnimalFeedObservers(){
        FeedTestStorage feedTestStorage = new FeedTestStorage();
        ISellable sellable = feedTestStorage.getProducts().get(0);
        Observer observer = new Observer("imad.elfetouh@hotmail.com");

        sellable.addObserver(observer);

        assertEquals(4, feedTestStorage.getProducts().size());
        assertEquals(1, sellable.getObserversCount());
    }
}