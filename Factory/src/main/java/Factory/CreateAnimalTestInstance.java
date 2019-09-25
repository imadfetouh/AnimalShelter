package Factory;

import AnimalStorage.AnimalTestStorage;
import logic.AnimalLogic;

public class CreateAnimalTestInstance implements ICreateInstance {
    @Override
    public Object create() {
        return new AnimalLogic(new AnimalTestStorage());
    }
}
