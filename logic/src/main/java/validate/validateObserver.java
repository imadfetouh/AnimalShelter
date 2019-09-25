package validate;

import Observers.Observer;

public class validateObserver {

    public static boolean validateNewObserver(Observer observer){
        return observer.getEmail() != null && !observer.getEmail().isEmpty();
    }

}
