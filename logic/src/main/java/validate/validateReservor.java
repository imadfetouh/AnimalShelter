package validate;

import AnimalModels.Reservor;

public class validateReservor {

    public static boolean validateNewReservor(Reservor reservor){
        return reservor.getName() != null && !reservor.getName().isEmpty();
    }
}
