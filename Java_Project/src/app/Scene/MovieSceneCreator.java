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
public class MovieSceneCreator extends SceneCreator implements EventHandler<MouseEvent> {
    BorderPane rootBorderPane;
    Button cancelButton, addTicketButton, modifyButton, goback;
    TextField movieField, typeField, seatField, priceField;
    TableView<Tickets> ticketTableView;
    List <Tickets> ticketList;

    public MovieSceneCreator(double width, double height) {
        // SceneCreator (width και height)
        super(width, height);
        
        // Add all components  
        rootBorderPane = new BorderPane();
        ticketTableView = new TableView<>();
        ticketList = new ArrayList<>();
        movieField = new TextField("Movie: ");
        typeField = new TextField("Type: ");
        seatField = new TextField("Seat: ");
        priceField = new TextField("Price: ");
        
        // All Button Components
        addTicketButton = new Button("Add Ticket");  
        cancelButton = new Button("cancel");
        modifyButton = new Button("modifyButton");
        goback = new Button("go back");
        
        // Border Pane layout
        rootBorderPane.setPadding(new Insets(10));
       
        // Create columns
        TableColumn<Tickets, String> codeColumn = new TableColumn<>("Code");
        TableColumn<Tickets, String> movieColumn = new TableColumn<>("Movie");
        TableColumn<Tickets, String> issueDateColumn = new TableColumn<>("Issue Date");
        TableColumn<Tickets, String> typeColumn = new TableColumn<>("Type");
        TableColumn<Tickets, String> seatColumn = new TableColumn<>("Seat");
        TableColumn<Tickets, Double> priceColumn = new TableColumn<>("Price");

        // Set column cell value factories
        codeColumn.setCellValueFactory(new PropertyValueFactory<>("code"));
        movieColumn.setCellValueFactory(new PropertyValueFactory<>("movie"));
        issueDateColumn.setCellValueFactory(new PropertyValueFactory<>("issueDate"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        seatColumn.setCellValueFactory(new PropertyValueFactory<>("seat"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        // Add columns to the table
        ticketTableView.getColumns().addAll(codeColumn, movieColumn, issueDateColumn, typeColumn, seatColumn, priceColumn);
        
        // Add to Left of Border Pane
        rootBorderPane.setLeft(ticketTableView);

        // Create input area for new ticket
        VBox MovieTicketInputBox = new VBox(10);
        MovieTicketInputBox.setPadding(new Insets(10));
        
        // All Vbox Children
        MovieTicketInputBox.getChildren().addAll(movieField,typeField,seatField,priceField, addTicketButton, cancelButton, modifyButton,  goback);
        
        // Add to Right of Border Pane
        rootBorderPane.setRight(MovieTicketInputBox);
        
        addTicketButton.setOnMouseClicked(this);
        cancelButton.setOnMouseClicked(this);
        modifyButton.setOnMouseClicked(this);
        goback.setOnMouseClicked(this);
    }
    
    @Override
    public Scene createScene() {
        return new Scene(rootBorderPane, width, height);            
    }
    


        
    @Override
    public void handle(MouseEvent event) {
        if (event.getSource() == addTicketButton) {
            String Movie = movieField.getText();
            String type = typeField.getText();
            String seat = seatField.getText();
            double price = Double.parseDouble(priceField.getText());
            //Create New Ticket
            NewCreateTicket(Movie, type, seat, price);
            
            tableSync();
            // Clear the text fields
            clearTextFields();
        }
        
        if (event.getSource() == modifyButton) {
            String Movie = movieField.getText();
            String type = typeField.getText();
            String seat = seatField.getText();
            double price = Double.parseDouble(priceField.getText());
            //Create New Ticket
            modifyTicket(Movie, type, seat, price);
            
            tableSync();
            // Clear the text fields
            clearTextFields();
        }
        
        if (event.getSource() == cancelButton) {
            CancelTicket(movieField.getText());
    
            tableSync();
            clearTextFields();
        }
        
        if (event.getSource() == goback) {
            //Set the Stage to UserScene
            Main.primaryStage.setScene(Main.UserScene);
            Main.primaryStage.setTitle("User Scene");
            
        }
        
    }
    

    
    public void modifyTicket(String Movie, String type, String seat, double price) {
        LocalDateTime screeningDateTime = LocalDateTime.parse(Movie, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime currentDateTime = LocalDateTime.now();
        Duration duration = Duration.between(currentDateTime, screeningDateTime);
        Tickets modifyTicket;
        String dateOfIssue = "2024-12-18", code = "T001";
        
        if (duration.toHours() <= 2) {

            modifyTicket = new Tickets(code, Movie, dateOfIssue, type, seat, price);
        }
        
        else {
            System.out.println("Ticket modification is not allowed at this time.");
        }
    }
    
    public void CancelTicket(String movie) {
        for (int i=0; i < ticketList.size();  i++) {
             if (ticketList.get(i).getScreening().equals(movie)) {
                ticketList.remove(i);
                break;
            }
             
        }
        
    }
    
    public void NewCreateTicket(String Movie, String type, String seat, double price){
         Tickets newTicket = new Tickets("NEW_CODE", Movie, "NEW_DATE", type, seat, price);
         ticketList.add(newTicket);
    }
    
     public void showTicketsForShow(String show) {
        List<Tickets> ticketsForShow = new ArrayList<>();
        for (Tickets ticket : ticketList) {
            if (ticket.getScreening().equals(show)) {
                ticketsForShow.add(ticket);
            }
        }
     }
        
    public void tableSync() {
        List<Tickets> items = ticketTableView.getItems();
        for (Tickets ticket : ticketList) {
            if (ticket instanceof Tickets) {
                items.add(ticket);
            }
        }
    }
    
    public void clearTextFields() {
            // Clear the text fields
            movieField.clear();
            typeField.clear();
            seatField.clear();
            priceField.clear();
     }
    
}