package airlinesystem.persistence;

import airlinesystem.model.entity.airline.Route;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SimulateDB {
    private static List<Route> routes;
    
    public static List<Route> startRoutes() 
    {
        List<Route> routes = new ArrayList<>();
        
        Date date = new Date();
        
        routes.add(new Route("GIG","Miami",new GregorianCalendar(2016,9,15,20,30),new GregorianCalendar(2016,9,16,6,30)));
        routes.add(new Route("GIG","Charlotte",new GregorianCalendar(2016,9,15,19,30),new GregorianCalendar(2016,9,16,4,30)));
        routes.add(new Route("Charlotte","Boston",new GregorianCalendar(2016,9,16,9,30),new GregorianCalendar(2016,9,16,12,30)));
        routes.add(new Route("Miami","New York",new GregorianCalendar(2016,9,16,8,30),new GregorianCalendar(2016,9,16,12,30)));

        return routes;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
