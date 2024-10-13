package pt.pa.adts.queue;

public class NullNotAllowedException extends RuntimeException {
    public NullNotAllowedException() {
        super("Esta exceçao nao é permitida");
    }

  public NullNotAllowedException(String message) {
        super(message);
  }
}
