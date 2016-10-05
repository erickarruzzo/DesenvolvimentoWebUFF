/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.model.exception;

import static airlinesystem.model.constants.Constants.INVALID_SEAT_OPTION;

/**
 *
 * @author Henrique
 */
public class InvalidSeatOptionException extends Exception
{
    public InvalidSeatOptionException()
    {
        super(INVALID_SEAT_OPTION);
    }
}
