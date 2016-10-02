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
import java.util.List;

/**
 *
 * @author Henrique
 */
public class Login 
{
    public static boolean authenticate(String username, String password)
    {
        List<User> userList = SimulateDB.retrieveUsers();
        
        for(User user : userList)
        {
            if(user.getUsername().equals(username))
            {
                if(user.getPassword().equals(password))
                {
                    return true;
                }
                else
                {
                    throw new WrongPasswordException();
                }
            }
        }
        throw new WrongUsernameException();
    }
}
