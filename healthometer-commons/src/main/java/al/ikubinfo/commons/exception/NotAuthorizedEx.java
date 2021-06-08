package al.ikubinfo.commons.exception;

public class NotAuthorizedEx extends RuntimeException {
  public NotAuthorizedEx(String message) {
    super(message);
  }
}
