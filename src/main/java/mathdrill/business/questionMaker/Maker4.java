package mathdrill.business.questionMaker;
import mathdrill.business.question.*;
import java.util.*;

/**
 * <p>Title: </p>
 * <p>Description: Fraction Addition/Subtraction </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Maker4 extends BaseMaker {

  public static FractionQuestion makeQuestion(String var2,String var3,String var4, String var5){

    FractionQuestion qa =new FractionQuestion();

    int n1=1,d1=1,n2=1,d2=1,iaa=1,iab=1;;
    String operation="";
    String q="", aa="", ab="";

      d1 = Helper.getRandom(1,9);
      n1 = Helper.getRandom(1,d1);
      int int2 = Helper.getRandom(1, 2);
      if (int2 == 1){
        d2=d1; //use common denominators
      }
      else {
        d2 = Helper.getRandom(1,9);
      }
      n2 = Helper.getRandom(1,9);

      
      int int1 = Helper.getRandom(1, 4);

      if (int1 == 1){
        iaa=n1*d2+n2*d1;
        iab=d1*d2;
        operation=" + ";
      }
      else if (int1 == 2){
        //let's worry about positive for now
        if (n1*d2 < n2*d1){
          int t;
          t=n1;
          n1=n2;
          n2=t;
          t=d1;
          d1=d2;
          d2=t;
        }
        iaa=n1*d2-n2*d1;
        if (iaa==0){
          n1=n1+1;
          iaa=n1*d2-n2*d1;
        }
        iab=d1*d2;
        operation=" - ";
      }
      else if (int1 == 3){
         iaa=n1*n2;
         iab=d1*d2;
         operation=" x ";
      }
      else {
         iaa=n1*d2;
         iab=d1*n2;
         operation=" divided by ";
      }

      int gcf = Helper.getGCF(iaa,iab);;
      iaa=iaa/gcf;
      iab=iab/gcf;
      
      
      
      q = " "+ n1 + "/" + d1 + operation + n2 + "/" + d2 + " = ";

      qa.setQuestion(q);
      if (iab == 1) {
    	  qa.setAnswer(""+iaa);
      }else {
    	  qa.setAnswer(""+iaa+"/"+iab);
      }
     
     

    return qa;
  }
}