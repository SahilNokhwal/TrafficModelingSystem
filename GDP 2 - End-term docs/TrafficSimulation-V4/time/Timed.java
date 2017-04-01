package time;

/**
 * Interface that timed object must implement
 *
 * 
 */
public interface Timed {
  void pretick() throws TimeStop;
  void tick();
}
