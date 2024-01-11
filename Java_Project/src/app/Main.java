package app;

import app.Scene.UserSceneCreator;
import app.Scene.MainSceneCreator;
import app.Scene.MovieSceneCreator;
import app.Scene.PartySceneCreator;


import javafx.application.Application;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Main extends Application {
    public static Stage primaryStage;
    public static Scene mainScene, UserScene, PartyScene, MovieScene;
    //public static Scene menuScene;
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        //primaryStage.initStyle(StageStyle.UNDECORATED);
            
//        Menu menuSceneCreator = new  Menu(650, 300);
//        menuScene = menuSceneCreator.createScene();
        
        MainSceneCreator mainSceneCreator = new MainSceneCreator(650, 300);
        mainScene = mainSceneCreator.createScene();
        
        UserSceneCreator UserSceneCreator = new UserSceneCreator(750, 500);
        UserScene = UserSceneCreator.createScene();
            
        PartySceneCreator partySceneCreator = new PartySceneCreator(750, 500);
        PartyScene = partySceneCreator.createScene();
        
        MovieSceneCreator MovieSceneCreator = new MovieSceneCreator(750, 500);
        MovieScene = MovieSceneCreator.createScene();
        
            
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("JavaFXApplication1");
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
}
