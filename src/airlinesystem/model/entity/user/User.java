package airlinesystem.model.entity.user;

import static airlinesystem.model.constants.Constants.DONT_FOUND_ORDER;
import static airlinesystem.model.constants.Constants.SUCCESSFUL_SALE;
import airlinesystem.model.entity.airline.Route;
import airlinesystem.model.entity.airline.Ticket;
import airlinesystem.model.entity.seat.Seat;
import airlinesystem.model.exception.LoginException;
import airlinesystem.model.exception.PaymentException;
import airlinesystem.model.operations.UserOperations;
import airlinesystem.model.valueobject.Order;
import java.util.List;

public class User implements UserOperations
{
    private String username;
    private String password;
    private List<Order> orders;
    
    public User(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public String getUsername() 
    {
        return username;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public List<Order> getOrders() 
    {
        return orders;
    }

    public void setOrders(List<Order> orders) 
    {
        this.orders = orders;
    }   
    
    @Override
    public void viewAvailableRoutes(List<Route> routes){
        for (Route route : routes){
            if (route.isAvailable()){
                System.out.println("Avião " + route.getAirplane().toString());
                System.out.println("Data do voo: " + route.getFlightTime());
                System.out.println("Data do Pouso: " + route.getLandTime());
                System.out.println("Origem: " + route.getOrigin());
                System.out.println("Destino: " + route.getDestiny());
                System.out.println("Duração: " + route.getDuration());
                System.out.println("Fator: " + route.getPriceFactor());
            }   
        }
    }
    
    @Override
    public double getPriceTicket(Ticket ticket){
        return ticket.getPrice();
    }

    @Override
    public Ticket getTicketByNumber(int number) {
        //Procurar no BD o ticket com o numero especificado pelo usuario
        return null;
    }

    @Override
    public List<Seat> getAvailableSeats(Route route) {
        return route.getAirplane().checkReleasedSeats();
    }

    @Override
    public void makePaymentOrderByNumber(int number, double valor) {
        double totalPrice = 0;
        for (Order order : this.orders)
        {
            if (order.getOrderNumber() == number) 
            {
                totalPrice = order.getTotalPrice();
            }
        }
        if (totalPrice>0){
            if (valor == totalPrice)
            {
                System.out.println(SUCCESSFUL_SALE);
                //The order was saled
            } 
            else 
            {
                throw new PaymentException();
                //The order wasn't saled
            }
        }
        else
        {
            System.out.println(DONT_FOUND_ORDER);
        }
        
    }

    @Override
    public boolean checkLogin(String username, String senha) {
        //Verificar se username e senha estão contidos no BD
        throw new LoginException();
    }

    @Override
    public void makePaymentAllOrders(List<Order> orders) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
