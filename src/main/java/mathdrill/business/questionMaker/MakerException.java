package mathdrill.business.questionMaker;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Noetic Learning</p>
 * @author Li Kelty
 * @version 1.0
 */

public class MakerException extends Exception
{

  public MakerException()
  {
     super();
  }

  /**
    * Constructs a LoginException with a specified detail message.
    *
    * @param message exception text
    */
    public MakerException(String message) {
        super(message);
    }
}