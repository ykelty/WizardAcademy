package mathdrill.business.questionMaker;
import mathdrill.business.question.*;
/**
 * <p>Title: Telling Time </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author Li Kelty
 * @version 1.0
 */

public class Maker9 extends BaseMaker {

  public static TellingTimeQuestion makeQuestion(String var2,String var3,String var4, String var5){

    TellingTimeQuestion qa =new TellingTimeQuestion();
    int r1=0, r2=0;
    String clockimagepath, q="", a="",a2="";


      int increments = intValue (var2);
      int parts = 60/increments -1;
      r1 = Helper.getRandom(1,12);  // hour
      r2 = Helper.getRandom(0,parts) * increments; // minutes
      clockimagepath = "images/clocks/clock"+Helper.make2digits(r1)+"_"+Helper.make2digits(r2)+".jpg";
      q = "<img border='0' src='"+clockimagepath+"'>";
      a = Helper.make2digits(r1);
      a2 = Helper.make2digits(r2);

      qa.setQuestion(q);
      qa.setAnswer(a);
      qa.setAnswerB(a2);

    return qa;
  }

}