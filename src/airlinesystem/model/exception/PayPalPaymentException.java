/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinesystem.model.exception;

/**
 *
 * @author Henrique
 */
public class PayPalPaymentException extends PaymentException 
{
    
    public PayPalPaymentException(String message) 
    {
        super(message);
    }
    
}
