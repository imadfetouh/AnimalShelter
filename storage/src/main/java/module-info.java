module storage {
    requires models;
    requires storageInterface;

    exports AnimalStorage;
    exports FeedStorage;

    opens AnimalStorage;
    opens FeedStorage;
}