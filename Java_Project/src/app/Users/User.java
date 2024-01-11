package app.Users;

import app.MoviesPackage.Tickets;
import java.util.ArrayList;
import java.util.List;

public class User implements IUser{
    private List<Tickets> tickets;
    
    public User() {
        this.tickets = new ArrayList<>();
    }
    
    @Override
    public void NewTicket(String code, String screening, String dateOfIssue, String type, String seat, double price) {
        Tickets ticket = new Tickets(code, screening, dateOfIssue, type, seat, price);
        tickets.add(ticket);
    }
    
    @Override
    public void CancelTicket(Tickets ticket) {
        tickets.remove(ticket);
    }
    
    @Override
    public List<Tickets> getTickets() {
        return tickets;
    }
    
}
