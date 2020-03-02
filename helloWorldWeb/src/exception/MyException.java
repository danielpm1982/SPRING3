package exception;

public class MyException extends Exception {
    private final String message;
    public MyException(String message) {
        super(message);
        this.message=message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}

/*
Just a custom Exception class to be managed differently from the others.
MyException thrown instances are left to be catched only at the Controller,
instead of being catched and managed in lower-level code (Repository classes),
as the other thrown Exceptions. From the Controller, MyException
instances have their error message sent to the view for the user to see. Not
the other Exceptions.
 */
