/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.login;

import airlinesystem.model.entity.user.User;
import airlinesystem.model.exception.WrongPasswordException;
import airlinesystem.model.exception.WrongUsernameException;
import airlinesystem.persistence.SimulateDB;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Henrique
 */
public class Login 
{
    private String username;
    private String password;
    private Date time;
    private boolean failed;
    
    public Login(String username, String password)
    {
        this.username = username;
        this.password = password;
        this.time = new Date();
    }
    
    public User authenticate()
    {
        List<User> userList = SimulateDB.retrieveUsers();
        
        for(User user : userList)
        {
            if(user.getUsername().equals(this.username))
            {
                if(user.getPassword().equals(this.password))
                {
                    this.failed = false;
                    return user;
                }
                else
                {
                    this.failed = false;
                    throw new WrongPasswordException();
                }
            }
        }
        this.failed = false;
        throw new WrongUsernameException();
    }
}
