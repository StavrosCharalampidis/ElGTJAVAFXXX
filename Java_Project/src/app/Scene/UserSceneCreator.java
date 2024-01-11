package app.Scene;

import app.Main;
import app.MoviesPackage.Tickets;
import app.Users.User;
import java.util.List;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
//import app.MoviesPackage.Tickets;



import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import app.MoviesPackage.Tickets;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.scene.layout.FlowPane;
public class UserSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
    FlowPane rootFlowPane;
    Button PartyBtn, MovieBtn, GoBackBtn;
    
    public UserSceneCreator(int width, int height) {
        super(width, height);
        
        rootFlowPane = new FlowPane();


        
        PartyBtn = new Button("Party");
        PartyBtn.setOnMouseClicked(this);
        
        MovieBtn = new Button("Movie");
        MovieBtn.setOnMouseClicked(this);
        
        GoBackBtn = new Button("Go Back");
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
            
            Main.primaryStage.setScene(Main.PartyScene);
            Main.primaryStage.setTitle("Party Scene");
        }
        
        if (event.getSource() == MovieBtn) {
            
            Main.primaryStage.setScene(Main.MovieScene);
            Main.primaryStage.setTitle("Movie Scene");
        }
        
        if (event.getSource() == GoBackBtn) {
            
            Main.primaryStage.setScene(Main.mainScene);
            Main.primaryStage.setTitle("main Scene");
        }
        
        
    }
}