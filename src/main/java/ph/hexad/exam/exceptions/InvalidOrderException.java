package ph.hexad.exam.exceptions;

/**
 * Created by juliusgutierrez on 15/08/2019.
 */
public class InvalidOrderException extends RuntimeException {

  public InvalidOrderException() {
    super("Invalid Order Received");
  }

  public InvalidOrderException(String message) {
    super(message);
  }

  public InvalidOrderException(String message, Throwable cause) {
    super(message, cause);
  }
}
