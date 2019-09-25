package Observers;

import java.io.Serializable;

public class Observer implements IObserver, Serializable {

    private String email;

    public Observer(String email){
        this.email = email;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public void update() {
        //send email
    }
}
