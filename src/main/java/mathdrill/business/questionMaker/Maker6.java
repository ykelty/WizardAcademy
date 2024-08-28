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

public class Maker6 extends BaseMaker {

  public static RegularQuestion makeQuestion(String var2,String var3,String var4, String var5){

    RegularQuestion qa =new RegularQuestion();

    int r, r11, r12;
    BigDecimal a1= new BigDecimal(0);
    String q ="",temp;
    String a="";
    String placeValue="";
    int digits1 = intValue(var2);
     int digits2 = intValue(var3);
     for (int i=digits2;i>=1;i--){
        r12=Helper.getRandom(0,9);

        if (r12>0){
          placeValue=Helper.getPlaceValue(0-i);
          a1 =a1.add( new BigDecimal(placeValue).multiply(new BigDecimal(r12)));

          temp = r12 + " x " + placeValue;
          if (!q.equals("")){
            q=temp+" + "+q;
          }
          else
            q= ""+ temp;
       }
      }

     for (int i=0;i<digits1;i++){
        r11=Helper.getRandom(0,9);
         placeValue=Helper.getPlaceValue(i+1);
        if (r11>0){
          temp= r11+ " x "+   placeValue;
          a1 = a1.add( new BigDecimal(r11).multiply( new BigDecimal(placeValue)));
          if (!q.equals("")){
            q=temp+" + "+q;
          }
          else
            q= ""+ temp;
       }
      }
    a = a1.toString();
    q = q+" = ";
    qa.setQuestion(q);
    qa.setAnswer(a);
   return qa;
  }

  public static void main(String[] args) {

    try{

     RegularQuestion q = (RegularQuestion)Maker6.makeQuestion("2","5", "","");
      System.out.println("q:"+q.toString());
    }
    catch (Exception e){
      System.out.println(e.getMessage());
  }
  }
}


