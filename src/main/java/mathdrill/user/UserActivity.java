package mathdrill.user;
import java.util.Date;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class UserActivity {

  Date date;
  int length; //in seconds
  public UserActivity() {
  }


  public Date getDate(){return date;}
  public void setDate (Date newValue){ date=newValue;}
  public void setLength (int newValue){ length=newValue;}
  public int getLength(){
     return length;
  }
  public String getMinutes(){
    String rValue;
    rValue = ""+  length/60;
    return rValue;
  }
  public String getSeconds(){
    String rValue;
     rValue = ""+ length% 60;
   return rValue;
  }

  public String toString(){
    return "date:"+date+" length:"+length ;

  }

}