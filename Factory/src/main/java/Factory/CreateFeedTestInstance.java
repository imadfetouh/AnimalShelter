package Factory;

import FeedStorage.FeedTestStorage;
import logic.FeedLogic;

public class CreateFeedTestInstance implements ICreateInstance {
    @Override
    public Object create() {
        return new FeedLogic(new FeedTestStorage());
    }
}
