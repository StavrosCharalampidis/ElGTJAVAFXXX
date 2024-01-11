package app;

import app.Scene.UserSceneCreator;
import app.Scene.MainSceneCreator;
import app.Scene.MovieSceneCreator;
import app.Scene.PartySceneCreator;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    public static Stage primaryStage;
    public static Scene mainScene, UserScene, PartyScene, MovieScene;
    
    @Override
    public void start(Stage primaryStage) {
       this.primaryStage = primaryStage;
       
        // Scene Main
        MainSceneCreator mainSceneCreator = new MainSceneCreator(650, 300);
        mainScene = mainSceneCreator.createScene();
        
        //Scene User
        UserSceneCreator UserSceneCreator = new UserSceneCreator(750, 500);
        UserScene = UserSceneCreator.createScene();
        
        //Scene Party
        PartySceneCreator partySceneCreator = new PartySceneCreator(750, 500);
        PartyScene = partySceneCreator.createScene();
        
        //Scene Movie
        MovieSceneCreator MovieSceneCreator = new MovieSceneCreator(750, 500);
        MovieScene = MovieSceneCreator.createScene();
        
        // Set the Stage to mainScene and title Main App
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Main App");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
}
