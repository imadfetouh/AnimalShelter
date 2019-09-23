package Factory;

import FeedStorage.FeedStorage;
import logic.FeedLogic;

public class CreateFeedLiveInstance implements ICreateInstance {
    @Override
    public Object create() {
        return new FeedLogic(new FeedStorage());
    }
}
