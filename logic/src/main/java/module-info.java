module logic {
    requires models;
    requires logicInterface;
    requires storageInterface;

    exports logic;

    opens logic;
    opens validate;
    opens Filter;
}