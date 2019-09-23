module gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires logicInterface;
    requires models;
    requires Factory;
    requires AnimalFactory;

    exports gui;
    opens gui;
}