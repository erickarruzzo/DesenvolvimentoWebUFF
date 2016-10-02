package airlinesystem.model.entity.user;


import airlinesystem.model.valueobject.Order;
import java.util.List;

public class User
{
    private int id;
    private String username;
    private String password;
    private List<Order> orders;
    
    public User(int id, String username, String password)
    {
        this.id = id;
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

}
