package mathdrill.user;

import mathdrill.util.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Noetic Learning</p>
 * @author Li Kelty
 * @version 1.0
 */

public class BaseManager
{
  

  public BaseManager()
  {
  }
  public static java.util.Date  getToday(){
     java.util.Date today = new  java.util.Date(getSQLToday().getTime());

     return today;
  }
  public static java.sql.Date  getSQLToday(){
     java.sql.Date today = new java.sql.Date(System.currentTimeMillis());

     return today;
  }
  public static java.util.Date  getUtilDate(java.sql.Date sqlDate){
    if ( sqlDate == null )   {
    return null;
 }  else  {
    return new java.util.Date ( sqlDate.getTime (  )  ) ;
      }
  }
  public static java.sql.Date  getSQLDate(java.util.Date date){
    if ( date == null )   {
         return null;
      }  else  {
         return new java.sql.Date ( date.getTime (  )  ) ;
      }

}

  static {
  
  }
  protected static String makeStringParam (String s){
    if (s ==null){
      s="";
    }
    String newString = " '"+s+"' ";
    return newString;
  }
  public static void main(String[] args)
  {
    BaseManager baseManager1 = new BaseManager();
  }
}