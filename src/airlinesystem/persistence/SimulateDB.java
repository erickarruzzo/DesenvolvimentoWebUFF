package airlinesystem.persistence;

import airlinesystem.model.entity.airline.Airplane;
import airlinesystem.model.entity.airline.Flight;
import airlinesystem.model.entity.airline.Route;
import airlinesystem.model.entity.airline.RouteFlight;
import airlinesystem.model.entity.seat.Seat;
import airlinesystem.model.entity.user.User;
import airlinesystem.model.exception.ExistantUsernameException;
import airlinesystem.model.valueobject.enums.SeatCategory;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class SimulateDB 
{
    
    public SimulateDB()
    {
        //
    }
    
    public static List<User> users = new ArrayList<User>();
    
    public List<List<Route>> getRoutes(String origin, String destiny, String date, boolean conexao, int tempoMax, List<Route> routes)
    {
        List<List<Route>> flights = new ArrayList<List<Route>>();
        
        for (Route route : routes)
        {
            String routeDestiny = route.getDestiny();
            String routeOrigin = route.getOrigin();
            GregorianCalendar routeDayCalendar = route.getFlightTime();
            
            //transformar gregorianCalendar no formato dd/MM/YYYY
            //day estara nesse formato
            
            StringBuilder sb = new StringBuilder();
            sb.append(routeDayCalendar.get(GregorianCalendar.DAY_OF_MONTH));
            sb.append("/");
            sb.append(routeDayCalendar.get(GregorianCalendar.MONTH));
            sb.append("/");
            sb.append(routeDayCalendar.get(GregorianCalendar.YEAR));
            String routeDay = sb.toString();
            
            if (routeOrigin.equals(origin) && routeDay.equals(date))
            {
                if (routeDestiny.equals(destiny))
                {
                    List<Route> flight = new ArrayList<Route>();
                    flight.add(route);
                    flights.add(flight);
                }
                //verifica se ha outra rota que o leve ao local pretendido
                else if (conexao)
                {
                    //tempo maximo de espera entre conexoes
                    //fazer logica para buscar mais de uma conexao
                    //List<List<Route>> conexionRoutes = getConexionFlights(routeDestiny,destiny,route.getLandTime(),tempoMax,routes);
                    //a logica abaixo so pegara uma conexao no maximo
                    for (Route connectionRoute : routes)
                    {
                        String secRouteOrigin = connectionRoute.getOrigin();
                        String secRouteDestiny = connectionRoute.getDestiny();
                        
                        if (secRouteOrigin.equals(routeDestiny) && secRouteDestiny.equals(destiny))
                        {
                            List<Route> flight = new ArrayList<Route>();
                            flight.add(route);
                            flight.add(connectionRoute);
                            flights.add(flight);
                        }
                    }
                    
                }
            }
        }
        
        return flights;
    }
    
    private static List<List<Route>> getConnectionFlights(String origin, String destiny, GregorianCalendar landTime, int tempoMax, List<Route> routes)
    {
        List<List<Route>> conexionFlights = new ArrayList<List<Route>>();
        
        for (Route route : routes)
        {
            if (route.getOrigin().equals(origin) && 
                route.getFlightTime().get(GregorianCalendar.DAY_OF_MONTH) == landTime.get(GregorianCalendar.DAY_OF_MONTH) &&
                (route.getFlightTime().get(GregorianCalendar.HOUR_OF_DAY) - landTime.get(GregorianCalendar.HOUR_OF_DAY) <= tempoMax)
            )
            {
                
            } 
        }
        
        return conexionFlights;
    }
    
    private static List<Route> getConnectionFlightsBacktracking(String origin, String destiny, GregorianCalendar landTime, int tempoMax, List<Route> routes)
    {
        List<Route> flightRoute = null;
        
        return flightRoute;
    }
    
    public List<Route> retrieveRoutes() 
    {
        List<Route> routes = new ArrayList<Route>();
        List<Airplane> airplanes = new ArrayList<Airplane>();
        List<Seat> seats = new ArrayList<Seat>();
        
        seats.add(new Seat("","AC",SeatCategory.FIRST_CLASS));
        seats.add(new Seat("","EA",SeatCategory.FIRST_CLASS));
        seats.add(new Seat("","DF",SeatCategory.ECONOMY));
        seats.add(new Seat("","IO",SeatCategory.ECONOMY));
        
        airplanes.add(new Airplane(1,seats,"American Airlines","ATY-3456",new GregorianCalendar(2010,9,1,6,30)));
        
        routes.add(new Route(1,"GIG","Miami",new GregorianCalendar(2016,10,15,20,30),new GregorianCalendar(2016,10,16,6,30),airplanes.get(0)));
        routes.add(new Route(2,"Miami","New York",new GregorianCalendar(2016,10,16,8,30),new GregorianCalendar(2016,10,16,12,30),airplanes.get(0)));
        routes.add(new Route(3,"GIG","Charlotte",new GregorianCalendar(2016,10,15,19,30),new GregorianCalendar(2016,10,16,4,30),airplanes.get(0)));
        routes.add(new Route(4,"Charlotte","Boston",new GregorianCalendar(2016,10,16,9,30),new GregorianCalendar(2016,10,16,12,30),airplanes.get(0)));

        return routes;
    }
       
    public List<Flight> getBoughtFlights()
    {
        List<Route> routes = retrieveRoutes();
        List<Flight> flights = new ArrayList<Flight>();
        List<RouteFlight> routeFlights = new ArrayList<RouteFlight>();
        
        routeFlights.add(new RouteFlight(routes.get(0),routes.get(0).getAirplane().getSeats().get(0),1));
        routeFlights.add(new RouteFlight(routes.get(1),routes.get(1).getAirplane().getSeats().get(0),2));
        
        flights.add(new Flight(routeFlights,1));
        
        return flights;
    }
    
//    public List<Flight> getBoughtFlights(Route route)
//    {
//        List<Flight> flights = getBoughtFlights();
//        
//        for(Flight flight : flights)
//        {
//            if(flight.getRoutes())
//        }
//    }
    
    public List<User> retrieveUsers()
    {   
        if(users.isEmpty())
        {
            users.add(new User(1,"rodrigo","vasco"));
            users.add(new User(2,"erick","marxista"));
        }
        return users;
    }
    
    public User createAccount(String username, String password)
    {
        //start list if not initiated
        retrieveUsers();
        for (User user : users)
        {
            if(user.getUsername().equals(username))
            {
                throw new ExistantUsernameException();
                
            }
        }
        User newUser = new User(users.size(),username,password);
        users.add(newUser);
        return newUser;
    }
}
