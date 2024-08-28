package mathdrill.data.util;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Noetic Learning</p>
 * @author Li Kelty
 * @version 1.0
 */

public class DateHelper
{

  public static java.sql.Date getSQLToday(){
    return new java.sql.Date(System.currentTimeMillis());
  }

  public static java.sql.Date getSQLForever(){
    return new java.sql.Date(System.currentTimeMillis());
  }

  public DateHelper()
  {
  }
  public static void main(String[] args)
  {
    DateHelper dateHelper = new DateHelper();
  }
}