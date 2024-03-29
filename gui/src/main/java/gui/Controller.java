package gui;

import AnimalFactory.AnimalFactory;
import AnimalFeed.ISellable;
import AnimalFeed.Product;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import logicInterface.IFeedLogic;
import logicInterface.ILogic;
import AnimalModels.*;
import Observers.*;

import java.time.LocalDate;
import java.util.List;

public class Controller {

    @FXML
    public TextField tfAddStock;

    @FXML
    private TextField tfObserverEmail;

    @FXML
    private ComboBox cbxAnimalFilter;

    @FXML
    private ListView<Animal> lvAnimals;

    @FXML
    private ComboBox cbxAnimalType;

    @FXML
    private TextField tfAnimalName;

    @FXML
    private RadioButton rbMale;

    @FXML
    private RadioButton rbFemale;

    @FXML
    private TextField tfBadHabits;

    @FXML
    private TextField tfReservorName;

    @FXML
    private ListView lvAnimalFeed;

    @FXML
    private TextField tfAnimalFeed;

    @FXML
    private TextField tfPrice;

    @FXML
    private TextField tfNewFeedStock;

    private ILogic logic;
    private IFeedLogic feedLogic;

    public Controller(ILogic logic, IFeedLogic feedLogic){
        this.logic = logic;
        this.feedLogic = feedLogic;
    }

    @FXML
    public void initialize() {
        cbxAnimalFilter.getItems().add("All");
        cbxAnimalFilter.getItems().addAll(TypeAnimal.values());
        cbxAnimalType.getItems().addAll(TypeAnimal.values());

        cbxAnimalType.getSelectionModel().select(TypeAnimal.Cat);
        cbxAnimalFilter.getSelectionModel().select("All");
        getAnimals();
        getAnimalFeed();
    }

    public void getAnimalFeed(){
        lvAnimalFeed.getItems().clear();
        List<ISellable> products = feedLogic.getProducts();
        for(ISellable sellable : products){
            lvAnimalFeed.getItems().add(sellable);
        }
    }

    public void getAnimals(){
        lvAnimals.getItems().clear();
        List<Animal> animals = logic.getAnimals(cbxAnimalFilter.getValue().toString());
        for(Animal animal : animals){
            lvAnimals.getItems().add(animal);
        }
    }

    @FXML
    public void newAnimal(ActionEvent actionEvent) {
        String name = tfAnimalName.getText();
        Gender gender = (rbMale.isSelected()) ? Gender.Male : (rbFemale.isSelected()) ? Gender.Female : null;
        String badHabits = tfBadHabits.getText();
        TypeAnimal typeAnimal = TypeAnimal.valueOf(cbxAnimalType.getValue().toString());

        Animal animal = AnimalFactory.createAnimal(typeAnimal, name, gender, badHabits);

        if(logic.validateNewAnimal(animal)){
            logic.addAnimal(animal);
            getAnimals();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill all fields in");
            alert.show();
        }
    }

    public void addReservor(ActionEvent actionEvent) {
        if(lvAnimals.getSelectionModel().getSelectedItems().size() == 0){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select an animal");
            alert.show();
        }
        else{
           Animal animal = lvAnimals.getSelectionModel().getSelectedItem();
           Reservor reservor = new Reservor(tfReservorName.getText(), LocalDate.now());

           if(logic.validateNewReservor(reservor)){
               animal.setReservedBy(reservor);
               logic.addReservor(animal);
               getAnimals();
           }
           else{
               Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill a name in");
               alert.show();
           }
        }
    }

    public void addObserver(ActionEvent actionEvent) {
        if(lvAnimalFeed.getSelectionModel().getSelectedItems().size() == 0){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select an animal feed first");
            alert.show();
        }
        else{
            Observer observer = new Observer(tfObserverEmail.getText());
            if(feedLogic.validateNewObserver(observer)){
                ISellable iSellable = (ISellable) lvAnimalFeed.getSelectionModel().getSelectedItem();
                iSellable.addObserver(observer);
                feedLogic.updateProduct(iSellable);
                getAnimalFeed();
            }
            else{
                Alert alert = new Alert(Alert.AlertType.WARNING, "Please choose an email");
                alert.show();
            }
        }
    }

    public void newAnimalFeed(ActionEvent actionEvent) {
        Product product = new Product(tfAnimalFeed.getText(), Double.parseDouble(tfPrice.getText().toString()), Integer.parseInt(tfNewFeedStock.getText()));
        if(feedLogic.validateNewFeed(product)){
            feedLogic.addProduct(product);
            getAnimalFeed();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill all fiels in");
            alert.show();
        }
    }

    public void sell(ActionEvent actionEvent) {
        if(lvAnimalFeed.getSelectionModel().getSelectedItems().size() == 0){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select an animal feed first");
            alert.show();
        }
        else{
            ISellable iSellable = (ISellable) lvAnimalFeed.getSelectionModel().getSelectedItem();
            if(iSellable.getStock() == 0){
                Alert alert = new Alert(Alert.AlertType.WARNING, "No stock");
                alert.show();
            }
            else{
                iSellable.sell();
                feedLogic.updateProduct(iSellable);
                getAnimalFeed();
            }
        }

    }

    public void addStock(ActionEvent actionEvent) {
        if(lvAnimalFeed.getSelectionModel().getSelectedItems().size() == 0){
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please select an animal feed first");
            alert.show();
        }
        else{
            ISellable iSellable = (ISellable) lvAnimalFeed.getSelectionModel().getSelectedItem();
            iSellable.addStock(Integer.parseInt(tfAddStock.getText()));
            feedLogic.updateProduct(iSellable);
            getAnimalFeed();
        }

    }
}
