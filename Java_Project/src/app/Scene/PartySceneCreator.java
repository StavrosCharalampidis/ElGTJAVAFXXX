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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import app.PartyPackage.PartyEvent;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class PartySceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
    BorderPane rootBorderPane;
    Button cancelButton, addTicketButton, modifyButton, goback;
    TextField CodeField, DateField, DetailsField, priceField;
    TableView<PartyEvent> partyTableView;
    List <PartyEvent> partyList;

    public PartySceneCreator(double width, double height) {
        // SceneCreator (width και height)
        super(width, height);
        
        // Add all components  
        rootBorderPane = new BorderPane();
        partyTableView = new TableView<>();
        partyList = new ArrayList<>();
        CodeField = new TextField("Code: ");
        DateField = new TextField("Date: ");
        DetailsField = new TextField("Details: ");
        priceField = new TextField("Price: ");
        
        // All Button Components
        addTicketButton = new Button("Add Party ");  
        cancelButton = new Button("cancel Party");
        modifyButton = new Button("modify Party");
        goback = new Button("go back");
        
        // Border Pane layout
        rootBorderPane.setPadding(new Insets(10));
        
       
        

        // Create columns
        TableColumn<PartyEvent, String> codeColumn = new TableColumn<>("Code");
        TableColumn<PartyEvent, String> DateColumn = new TableColumn<>("Issue Date");
        TableColumn<PartyEvent, String> DetailsColumn = new TableColumn<>("Details");
        TableColumn<PartyEvent, Double> priceColumn = new TableColumn<>("Price");

        // Set column cell value factories
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        DateColumn.setCellValueFactory(new PropertyValueFactory<>("Date"));
        DetailsColumn.setCellValueFactory(new PropertyValueFactory<>("Details"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Add columns to the table
        partyTableView.getColumns().addAll(codeColumn, DateColumn, DetailsColumn, priceColumn);
        
        // Add to Left of Border Pane
        rootBorderPane.setLeft(partyTableView);


        // Create input area for new ticket
        VBox MovieTicketInputBox = new VBox(10);
        MovieTicketInputBox.setPadding(new Insets(10));

        

           
        addTicketButton.setOnMouseClicked(this);
        cancelButton.setOnMouseClicked(this);
        modifyButton.setOnMouseClicked(this);
        goback.setOnMouseClicked(this);
        
        // All Vbox Children
        MovieTicketInputBox.getChildren().addAll(CodeField,DateField,DetailsField,priceField, 
                addTicketButton,
                cancelButton,
                modifyButton,
                goback
        );
        // Add to Right of Border Pane
        rootBorderPane.setRight(MovieTicketInputBox);
        
    }
    
    @Override
    public Scene createScene() {
        return new Scene(rootBorderPane, width, height);            
    }
    


        
    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() == addTicketButton) {
            String code = CodeField.getText();
            String Date = DateField.getText();
            String Details = DetailsField.getText();
            double price = Double.parseDouble(priceField.getText());
            //Create New Ticket
            CreateNewParty(code, Date, Details, price);
            
            tableSync();
            // Clear the text fields
            clearTextFields();
        }
        
        if (event.getSource() == modifyButton) {
            String Movie = CodeField.getText();
            String type = DateField.getText();
            String seat = DetailsField.getText();
            double price = Double.parseDouble(priceField.getText());
            
            //Create New Ticket
            modifyParty(Movie, type, seat, price);
            
            tableSync();
            // Clear the text fields
            clearTextFields();
        }
        
        if (event.getSource() == cancelButton) {
            CancelTicket(CodeField.getText());
    
            tableSync();
            clearTextFields();
        }
        
        if (event.getSource() == goback) {
            //set the stage to UserScene
            Main.primaryStage.setScene(Main.UserScene);
            Main.primaryStage.setTitle("User Scene");
        }
        
    }
    

    
    public void modifyParty(String code, String Date, String Details, double price) {
        LocalDateTime screeningDateTime = LocalDateTime.parse(Date, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime currentDateTime = LocalDateTime.now();
        Duration duration = Duration.between(currentDateTime, screeningDateTime);

        if (duration.toHours() <= 24) {

            PartyEvent modifyParty = new PartyEvent(code, Date, Details, price);
        }
        
        else {
            System.out.println("Party modification is not allowed at this time.");
        }
    }
    
    public void CancelTicket(String code) {
        for (int i=0; i < partyList.size();  i++) {
             if (partyList.get(i).getPartyCode().equals(code)) {
                partyList.remove(i);
                break;
            }
             
        }
        
    }
    
    public void CreateNewParty(String code, String Date, String Details, double price){
        PartyEvent NewParty = new PartyEvent(code, Date, Details, price);
        partyList.add(NewParty);
    }

        
    public void tableSync() {
        List<PartyEvent> items = partyTableView.getItems();
        for (PartyEvent party : partyList) {
            if (party instanceof PartyEvent) {
                items.add(party);
            }
        }
    }
    
    public void clearTextFields() {
            // Clear the text fields
            CodeField.clear();
            DateField.clear();
            DetailsField.clear();
            priceField.clear();
     }
    
}