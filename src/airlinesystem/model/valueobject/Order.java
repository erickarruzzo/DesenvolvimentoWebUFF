package airlinesystem.model.valueobject;

import airlinesystem.model.valueobject.enums.Payment;
import airlinesystem.model.entity.airline.Ticket;
import airlinesystem.model.entity.user.User;
import java.util.List;

public class Order 
{
    private List<Ticket> tickets;
    private double totalPrice;
    private User user;
    private Payment payment;
    
    public Order(List<Ticket> tickets, User user, Payment payment)
    {
        this.tickets = tickets;
        this.user = user;
        this.payment = payment;
        this.totalPrice = calcTotalPrice();
    }
    
    private double calcTotalPrice()
    {
        double total = 0;
        for (Ticket ticket : this.tickets) {
            total += ticket.getPrice();
        }
        return total;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
    
    
    
}
