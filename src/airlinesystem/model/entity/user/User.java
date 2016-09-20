package airlinesystem.model.entity.user;

import airlinesystem.model.entity.airline.Route;
import airlinesystem.model.entity.airline.Ticket;
import airlinesystem.model.entity.seat.Seat;
import airlinesystem.model.operations.GeneralOperations;
import airlinesystem.model.valueobject.Order;
import java.util.ArrayList;
import java.util.List;

public class User implements GeneralOperations
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
            System.out.println("Avião " + route.getAirplane().toString());
            System.out.println("Data do voo: " + route.getFlightTime());
            System.out.println("Data do Pouso: " + route.getLandTime());
            System.out.println("Origem: " + route.getOrigin());
            System.out.println("Destino: " + route.getDestiny());
            System.out.println("Duração: " + route.getDuration());
            System.out.println("Fator: " + route.getPriceFactor());
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
}
