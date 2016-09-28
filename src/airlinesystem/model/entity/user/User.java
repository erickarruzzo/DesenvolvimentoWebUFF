package airlinesystem.model.entity.user;


import airlinesystem.model.valueobject.Order;
import java.util.List;

public class User //implements UserOperations
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
    
// TODO verifique que a classe user nao tem como responsabilidade exibir as rotas
    //nem saber o preco do ticket(responsabilidade de ticket)
    //nem available seats 
    //nem realizar pagamentos
//    @Override
//    public void viewAvailableRoutes(List<Route> routes){
//        for (Route route : routes){
//            if (route.isAvailable()){
//                System.out.println("Avião " + route.getAirplane().toString());
//                System.out.println("Data do voo: " + route.getFlightTime());
//                System.out.println("Data do Pouso: " + route.getLandTime());
//                System.out.println("Origem: " + route.getOrigin());
//                System.out.println("Destino: " + route.getDestiny());
//                System.out.println("Duração: " + route.getDuration());
//                System.out.println("Fator: " + route.getPriceFactor());
//            }   
//        }
//    }
//    
//    @Override
//    public double getPriceTicket(Ticket ticket){
//        return ticket.getPrice();
//    }
//
//    @Override
//    public Ticket getTicketByNumber(int number) {
//        //Procurar no BD o ticket com o numero especificado pelo usuario
//        return null;
//    }
//
//    @Override
//    public List<Seat> getAvailableSeats(Route route) {
//        return route.getAirplane().checkAvailableSeats();
//    }
//
//    @Override
//    public void makePaymentOrderByNumber(int number, double valor) {
//        double totalPrice = 0;
//        for (Order order : this.orders)
//        {
//            if (order.getOrderNumber() == number) 
//            {
//                totalPrice = order.getTotalPrice();
//            }
//        }
//        if (totalPrice>0)
//        {
//            if (valor == totalPrice)
//            {
//                System.out.println(SUCCESSFUL_SALE);
//                //The order was sold
//            } 
//            else 
//            {
//                //TODO so quem joga a excecao de payment eh a propria classe payment (ou seus herdeiros)
//                //throw new PaymentException();
//                //The order wasn't sold
//            }
//        }
//        else
//        {
//            System.out.println(ORDER_NOT_FOUND);
//        }
//        
//    }
//
//    @Override
//    public boolean checkLogin(String username, String senha) {
//        //Verificar se username e senha estão contidos no BD
//        
//
//        //TODO so quem joga a excecao de login eh a classe de login
//        //throw new LoginException();
//        return true;
//    }
//
//    @Override
//    public void makePaymentAllOrders(List<Order> orders) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
