package airlinesystem.model.entity.airline;

import airlinesystem.model.entity.seat.Seat;

public class RouteFlight 
{
    private Route route;
    private Seat seat;
    private int id;
    
    public RouteFlight(Route route, Seat seat, int id)
    {
        this.route = route;
        this.seat = seat;
        this.id = id;
    }

    public Route getRoute() 
    {
        return this.route;
    }

    public void setRoute(Route route) 
    {
        this.route = route;
    }

    public Seat getSeat() 
    {
        return this.seat;
    }

    public void setSeat(Seat seat) 
    {
        this.seat = seat;
    }

    public int getId() 
    {
        return this.id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }
}
