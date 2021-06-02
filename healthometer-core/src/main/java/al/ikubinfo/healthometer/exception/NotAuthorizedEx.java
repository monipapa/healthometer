package al.ikubinfo.healthometer.exception;

public class NotAuthorizedEx extends RuntimeException {
  public NotAuthorizedEx(String message) {
    super(message);
  }
}
