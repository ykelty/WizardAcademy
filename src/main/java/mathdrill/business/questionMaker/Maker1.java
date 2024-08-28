package mathdrill.business.questionMaker;
import mathdrill.business.question.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Maker1 extends BaseMaker {

  public static RegularQuestion makeQuestion(String var2,String var3,String var4, String var5){

    RegularQuestion qa =new RegularQuestion();
    int r1=0, r2=0, sum=0;
    String q="", a="";


      int fact = Helper.getRandom(0,10);
      r1 = Helper.getRandom(0,10);  // a random number between 0 to 9
      r2 = Helper.getRandom(0,1);
      sum = r1+fact;
      if (r2==0){
        q=  ""+r1 +" + " + fact + " = ";
      }
      else {
        q=  ""+fact +" + " + r1 + " = ";
      }
      a = ""+ sum;
      qa.setQuestion(q);
      qa.setAnswer(a);

    return qa;
  }

}