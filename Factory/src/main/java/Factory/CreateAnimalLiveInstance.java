package Factory;

import logic.AnimalLogic;
import AnimalStorage.AnimalStorage;

public class CreateAnimalLiveInstance implements ICreateInstance {

    @Override
    public Object create() {
        return new AnimalLogic(new AnimalStorage());
    }
}
