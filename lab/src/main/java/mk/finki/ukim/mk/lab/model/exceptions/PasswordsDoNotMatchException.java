package mk.finki.ukim.mk.lab.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException{
    public PasswordsDoNotMatchException() {
        super("The Password and Repeat password fields do not match.");
    }

}