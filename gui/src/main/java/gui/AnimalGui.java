package gui;

import Factory.Factory;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Factory.CreateAnimalLiveInstance;
import Factory.CreateFeedLiveInstance;
import logicInterface.IFeedLogic;
import logicInterface.ILogic;

public class AnimalGui extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui.fxml"));
        loader.setControllerFactory(c -> {
            return new Controller((ILogic) Factory.buildInstance(new CreateAnimalLiveInstance()),
                    (IFeedLogic) Factory.buildInstance(new CreateFeedLiveInstance()) );
        });
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());

        primaryStage.setTitle("Animal Shelter | Animals");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
