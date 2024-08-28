package mathdrill.business.questionMaker;
import mathdrill.business.question.*;
import mathdrill.business.questionMaker.util.*;
/**
 * <p>Title: Telling Time </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author Li Kelty
 * @version 1.0
 */

public class Maker10 extends BaseMaker {

  public static TellingTimeQuestion makeQuestion(String var2,String var3,String var4, String var5){

    TellingTimeQuestion qa =new TellingTimeQuestion();
    int r11=0, r12=0, r21=0, r22=0;
    String clockimagepath, tmp, q="", a="",a2="";
    Time t=new Time(0,0),t1, t2;

      int increments = intValue (var3);
      int parts = 60/increments -1;
      r11 = Helper.getRandom(1,12);  // hour
      r12 = Helper.getRandom(0,parts) * increments; // minutes
      r21 = Helper.getRandom(1,12);  // hour
      r22 = Helper.getRandom(0,parts) * increments; // minutes
       clockimagepath = "images/clocks/clock"+Helper.make2digits(r11)+"_"+Helper.make2digits(r12)+".jpg";
      tmp = r21 +" hours and "+ r22 + " minutes";
      t1 = new Time(r11,r12);
      t2 = new Time(r21,r22);

      if (var2.equalsIgnoreCase("adding")){
        t=Time.addTime(t1,t2);
        q= "It is "+"<img border='0' src='"+clockimagepath+"'> . What time will it be in " + tmp + "? ";
      }
      else if (var2.equalsIgnoreCase("subtracting")){
        t=Time.subtractTime(t1,t2);
         q= "It is "+"<img border='0' src='"+clockimagepath+"'> . What time was it " + tmp + " ago?";
      }
      r12 = Helper.getRandom(0,parts) * increments; // minutes
      r12 = Helper.getRandom(0,parts) * increments; // minutes

      a = ""+t.getHours();
      a2= ""+t.getMinutes();
      qa.setQuestion(q);
      qa.setAnswer(a);
      qa.setAnswerB(a2);

    return qa;
  }
}
