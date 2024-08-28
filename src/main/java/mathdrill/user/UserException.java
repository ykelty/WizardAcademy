package mathdrill.user;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */
public class UserException extends Exception
{

  public UserException()
  {
     super();
  }

  /**
   * Constructs a UserException with a specified detail message.
   *
   * @param message exception text
   */
   public UserException(String message) {
       super(message);
    }
}
