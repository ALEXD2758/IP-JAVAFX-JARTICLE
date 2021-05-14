package jarticle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jarticle.controller.HostServicesControllerFactory;

public class JArticleApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("generalView.fxml"));
        loader.setControllerFactory(new HostServicesControllerFactory(getHostServices()));
        Parent root = loader.load();
        primaryStage.setTitle("JArticle - Research articles management engine");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}