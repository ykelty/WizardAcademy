package mathdrill.business.questionMaker;
import mathdrill.business.question.*;
import java.util.*;
import java.math.BigDecimal;

/**
 * <p>Title: Decimal Comparison</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Noetic Learning </p>
 * @author Li Kelty
 * @version 1.0
 */

public class Maker5 extends BaseMaker {

  public static MultipleChoiceQuestion makeQuestion(String var2,String var3,String var4, String var5){

    MultipleChoiceQuestion qa =new MultipleChoiceQuestion();

    int r, r11, r12,r21,r22;
    String q ="";
    String a="",a1 ="",a2="";
    int digits1 = intValue(var2);
     int digits2 = intValue(var3);

    r11 = Helper.getRandom(0,(int)Math.pow(10,digits1)-1) ;
    r12 = Helper.getRandom(0,(int)Math.pow(10,digits2)-1) ;
    a1 = ""+r11+"."+r12;
    BigDecimal d1= new BigDecimal(a1);

    r21 = Helper.getRandom(0, (int)Math.pow(10,digits1)-1) ;
    r22 = Helper.getRandom(0, (int)Math.pow(10,digits2)-1) ;
    a2 = ""+r21+"."+r22;
     BigDecimal d2= new BigDecimal(a2);


      q="Which one of the following two numbers is larger?";
      if (d1.compareTo(d2) >0 ){
        a="a";
      }
      else if (d1.compareTo(d2)<0 ){
        a="b";
      }
      else {
        a="c";
      }


    ArrayList options = new ArrayList();
    options.add("a. "+a1);
    options.add("b. "+a2);
    options.add("c. the same");
    qa.setOptions(options);

    qa.setQuestion(q);
    qa.setAnswer(a);
   return qa;
  }


}