package airlinesystem.model.entity.airline;

import java.util.List;

public class Flight 
{
    private List<RouteFlight> routes;
    private int number;
    
    public Flight(List<RouteFlight> routes, int number)
    {
        this.routes = routes;
        this.number = number;
    }

    public List<RouteFlight> getRoutes() 
    {
        return routes;
    }

    public void setRoutes(List<RouteFlight> routes) 
    {
        this.routes = routes;
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
