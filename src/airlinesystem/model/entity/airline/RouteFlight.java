package airlinesystem.model.entity.airline;

import airlinesystem.model.entity.seat.Seat;
import java.util.List;

public class RouteFlight 
{
    private List<Route> routes;
    private Seat seat;
    private int number;
    
    public RouteFlight(List<Route> routes, Seat seat, int number)
    {
        this.routes = routes;
        this.seat = seat;
        this.number = number;
    }

    public List<Route> getRoutes() 
    {
        return routes;
    }

    public void setRoutes(List<Route> routes) 
    {
        this.routes = routes;
    }

    public Seat getSeat() 
    {
        return seat;
    }

    public void setSeat(Seat seat) 
    {
        this.seat = seat;
    }

    public int getNumber() 
    {
        return number;
    }

    public void setNumber(int number) 
    {
        this.number = number;
    }
}
