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

public class Maker8 extends BaseMaker {

  public static RegularQuestion makeQuestion(String var2,String var3,String var4, String var5){

    RegularQuestion qa =new RegularQuestion();
    BigDecimal answer = new BigDecimal("0");
    String q="",a="";



    BigDecimal d1=Helper.getRandomDecimal(1,4);
    BigDecimal d2=Helper.getRandomDecimal(1,4);
    BigDecimal d3=Helper.getRandomDecimal(1,1);
    int int1=Helper.getRandom(1,10);
    int int2= Helper.getRandom(1,3);
    
    System.out.println("MAKER 8 Testing");

    if (int2 == 1){
      answer=d1.add(d2);
      q = d1 + " + " + d2 + " = ";
    }
    else if (int2 == 2){
      answer=d1.subtract(d2);
      q = d1 + " - " + d2 + " = ";
    }
    else{
      answer=d1.multiply(d3);
      q = d1 + " x " + d3 + " = ";
    }
    

    a = answer.toString();
    qa.setQuestion(q);
    qa.setAnswer(a);
   return qa;
  }



}


