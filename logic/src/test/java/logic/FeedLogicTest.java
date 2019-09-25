package logic;

import AnimalFeed.ISellable;
import AnimalFeed.Product;
import FeedStorage.FeedTestStorage;
import Observers.Observer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FeedLogicTest {

    @Test
    void testGetAnimalFeedCount(){
        FeedLogic feedLogic = new FeedLogic(new FeedTestStorage());

        assertEquals(4, feedLogic.getProducts().size());
    }

    @Test
    void testAddAnimalFeedCount(){
        FeedLogic feedLogic = new FeedLogic(new FeedTestStorage());
        Product product = new Product("Kaas", 4.57, 4);

        feedLogic.addProduct(product);

        assertEquals(5, feedLogic.getProducts().size());
    }

    @Test
    void testUpdateAnimalFeed(){
        FeedLogic feedLogic = new FeedLogic(new FeedTestStorage());
        ISellable sellable = feedLogic.getProducts().get(0);
        Observer observer = new Observer("imad.elfetouh@hotmail.com");

        sellable.addObserver(observer);

        assertEquals(4, feedLogic.getProducts().size());
        assertEquals(1, feedLogic.getProducts().get(0).getObserversCount());
    }
}