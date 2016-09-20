package airlinesystem.model.exception;

import static airlinesystem.model.constants.Constants.ERROR_LOGIN;

public class LoginException extends RuntimeException{
    private static final long serialVersionUID = 1276727019536603615L;

    public LoginException() 
    {
        System.out.println(ERROR_LOGIN);
    }
}
