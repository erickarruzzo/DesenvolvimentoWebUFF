/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.model.exception;

import static airlinesystem.model.constants.Constants.WRONG_USERNAME;

/**
 *
 * @author Henrique
 */
public class WrongUsernameException extends LoginException
{
    
    public WrongUsernameException() 
    {
        super(WRONG_USERNAME);
    }
    
}
