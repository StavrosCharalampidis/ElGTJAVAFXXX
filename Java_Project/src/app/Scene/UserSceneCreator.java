package app.Scene;

import app.Main;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

public class UserSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
    FlowPane rootFlowPane;
    Button PartyBtn, MovieBtn, GoBackBtn;
    
    public UserSceneCreator(int width, int height) {
        super(width, height);
        
        // Add all components 
        rootFlowPane = new FlowPane();
        PartyBtn = new Button("Party");
        MovieBtn = new Button("Movie");
        GoBackBtn = new Button("Go Back");
        
        PartyBtn.setOnMouseClicked(this);
        MovieBtn.setOnMouseClicked(this);
        GoBackBtn.setOnMouseClicked(this);
        
        rootFlowPane.setHgap(10);
        rootFlowPane.setAlignment(Pos.CENTER);
        rootFlowPane.getChildren().addAll(PartyBtn, MovieBtn, GoBackBtn);
        
       
    }
    
    @Override
    public Scene createScene() {
        return new Scene(rootFlowPane, width, height);
    }
    
    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() == PartyBtn) {
            //Set the Stage to PartyScene
            Main.primaryStage.setScene(Main.PartyScene);
            Main.primaryStage.setTitle("Party Scene");
        }
        
        if (event.getSource() == MovieBtn) {
            //Set the Stage to MovieScene
            Main.primaryStage.setScene(Main.MovieScene);
            Main.primaryStage.setTitle("Movie Scene");
        }
        
        if (event.getSource() == GoBackBtn) {
            //Set the Stage to mainScene
            Main.primaryStage.setScene(Main.mainScene);
            Main.primaryStage.setTitle("main Scene");
        }
        
        
    }
}