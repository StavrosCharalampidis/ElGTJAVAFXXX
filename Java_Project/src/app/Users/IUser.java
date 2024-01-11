package app.Users;

import app.MoviesPackage.Tickets;
import java.util.List;


public interface IUser {
    void NewTicket(String code, String screening, String dateOfIssue, String type, String seat, double price);
    void CancelTicket(Tickets ticket);
    List<Tickets> getTickets();
}
