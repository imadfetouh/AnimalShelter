package AnimalFeed;

import Observers.IObserver;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Product implements ISellable, Serializable {

    private String serialVersionUID = "";
    private List<IObserver> observers;
    private String name;
    private Double price;
    private int stock;

    public Product(String name, Double price, int stock){
        this.observers = new ArrayList<>();
        this.name = name;
        this.price = price;
        this.stock = stock;
        this.serialVersionUID = UUID.randomUUID().toString();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public int getStock() {
        return this.stock;
    }

    @Override
    public void addStock(int stock) {
        if(this.stock == 0) notifyObservers();
        this.stock += stock;
    }

    @Override
    public void sell() {
        this.stock--;
    }

    @Override
    public void notifyObservers() {
        for(IObserver observer : observers){
            observer.update();
        }
        observers.clear();
    }

    @Override
    public void addObserver(IObserver ob) {
        observers.add(ob);
    }

    @Override
    public String getSerialVersionUid() {
        return this.serialVersionUID;
    }


    @Override
    public String toString() {
        return this.name + ": " + this.price + ", stock: " + this.stock + ", observers: " + observers.size();
    }
}
