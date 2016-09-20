package airlinesystem.model.entity.airline;

import airlinesystem.model.entity.passenger.Passenger;

public class Ticket 
{
    private RouteFlight flight;
    private double price;
    private Passenger passenger;
    private int ticketNumber;
    
    public Ticket(RouteFlight flight)
    {
        this.flight = flight;
    }
    
    public double getPrice()
    {
        return this.price;
    }

    public RouteFlight getFlight() 
    {
        return flight;
    }

    public void setFlight(RouteFlight flight) 
    {
        this.flight = flight;
    }

    public Passenger getPassenger() 
    {
        return passenger;
    }

    public void setPassenger(Passenger passenger) 
    {
        this.passenger = passenger;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(int ticketNumber) 
    {
        this.ticketNumber = ticketNumber;
    }
    
    
}
