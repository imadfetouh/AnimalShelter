package Observers;

import AnimalFeed.ISellable;

import java.io.Serializable;

public class Observer implements IObserver, Serializable {

    private String email;

    public Observer(String email){
        this.email = email;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void update() {
        //send email
    }
}
