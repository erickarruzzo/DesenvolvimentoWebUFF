package airlinesystem.model.exception;

import static airlinesystem.model.constants.Constants.ERROR_PAYMENT;


public class PaymentException extends RuntimeException{
    private static final long serialVersionUID = 1209874521536603615L;

    public PaymentException() 
    {
        System.out.println(ERROR_PAYMENT);
    }
}
