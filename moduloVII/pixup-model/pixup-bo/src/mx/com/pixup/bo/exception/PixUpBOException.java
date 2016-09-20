package mx.com.pixup.bo.exception;

public class PixUpBOException extends Exception {

    public PixUpBOException() {
    }

    public PixUpBOException(String message) {
        super(message);
    }

    public PixUpBOException(String message, Throwable cause) {
        super(message, cause);
    }

    public PixUpBOException(Throwable cause) {
        super(cause);
    }
    
}
