package validate;

import AnimalFeed.ISellable;

public class validateAnimalFeed {

    public static boolean validate(ISellable iSellable){
        return iSellable.getName() != null && !iSellable.getName().isEmpty()
                && iSellable.getPrice() != null
                && iSellable.getStock() != null;
    }

}
