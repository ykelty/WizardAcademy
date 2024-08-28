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

public class Maker7 extends BaseMaker {

  public static RegularQuestion makeQuestion(String var2,String var3,String var4, String var5){

    RegularQuestion qa =new RegularQuestion();

    int r, r11, r12;
    BigDecimal a1= new BigDecimal(0);
    String q ="",temp;
    String a="";
    String placeValue="";
    int digits1 = intValue(var2);
     int digits2 = intValue(var3);

     r=Helper.getRandom(1,3);  //place number we are going to ask questions  tenths, hundredths?

     for (int i=digits2;i>=1;i--){
        r12=Helper.getRandom(0,9);
        if (i==r)
           a=""+r12;
        if (r12>0){
          placeValue=Helper.getPlaceValue(0-i);
          a1 =a1.add( new BigDecimal(placeValue).multiply(new BigDecimal(r12)));
       }
      }

     for (int i=0;i<digits1;i++){
        r11=Helper.getRandom(0,9);
         placeValue=Helper.getPlaceValue(i+1);
        if (r11>0){
             a1 = a1.add( new BigDecimal(r11).multiply( new BigDecimal(placeValue)));
       }
      }

    q = " What digit is in the "+getPlace(r)+ " place? "+a1 +" ";
    qa.setQuestion(q);
    qa.setAnswer(a);
   return qa;
  }

  private static String getPlace(int digit){
      String rString="";
      switch (digit) {
               case 1:  rString="tenths"; break;
               case 2:  rString="hundredths"; break;
               case 3:  rString="thousandths"; break;
               default: break;
           }
      return rString;

  }

}


