package airlinesystem.persistence;

import airlinesystem.model.entity.airline.Airplane;
import airlinesystem.model.entity.airline.Route;
import airlinesystem.model.entity.seat.Seat;
import airlinesystem.model.valueobject.enums.SeatCategory;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class SimulateDB {
    
    public static List<Route> startRoutes() 
    {
        List<Route> routes = new ArrayList<>();
        List<Airplane> airplanes = new ArrayList<>();
        List<Seat> seats = new ArrayList<>();
        
        seats.add(new Seat("","AC",SeatCategory.FIRST_CLASS));
        seats.add(new Seat("","DF",SeatCategory.ECONOMY));
        seats.add(new Seat("","EA",SeatCategory.FIRST_CLASS));
        seats.add(new Seat("","IO",SeatCategory.ECONOMY));
        
        airplanes.add(new Airplane(1,seats,"American Airlines","ATY-3456",new GregorianCalendar(2016,9,16,6,30)));
        
        routes.add(new Route(1,"GIG","Miami",new GregorianCalendar(2016,9,15,20,30),new GregorianCalendar(2016,9,16,6,30),airplanes.get(0)));
        routes.add(new Route(2,"GIG","Charlotte",new GregorianCalendar(2016,9,15,19,30),new GregorianCalendar(2016,9,16,4,30),airplanes.get(0)));
        routes.add(new Route(3,"Charlotte","Boston",new GregorianCalendar(2016,9,16,9,30),new GregorianCalendar(2016,9,16,12,30),airplanes.get(0)));
        routes.add(new Route(4,"Miami","New York",new GregorianCalendar(2016,9,16,8,30),new GregorianCalendar(2016,9,16,12,30),airplanes.get(0)));

        return routes;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static boolean validateLogin(String username, String password)
    {
        return true;
    }
}
