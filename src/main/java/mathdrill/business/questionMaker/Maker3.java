package mathdrill.business.questionMaker;
import mathdrill.business.question.*;
import java.util.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Maker3 extends BaseMaker {

  public static MultipleChoiceQuestion makeQuestion(String var2,String var3,String var4, String var5){

    MultipleChoiceQuestion qa =new MultipleChoiceQuestion();

    int r, r1, r2;
    String q ="";
    String a ="";
    int digits = 3;

    int highEnd= (int)Math.pow(10,digits);
     int lowEnd = 1;
     if (digits>=2){
       lowEnd = (int)Math.pow(10,digits-2);
     }
    r1 = Helper.getRandom(lowEnd,highEnd) ;
    r2 = Helper.getRandom(lowEnd,highEnd) ;
    r = Helper.getRandom(0,1);

    if (r==0){
      q="Which one of the following two numbers is larger: " + r1 + " or " + r2 + "? (if equal, respond 'equal')";
      if (r1>r2){
        a= Integer.toString(r1);
      }
      else if (r1<r2){
        a= Integer.toString(r2);
      }
      else {
        a="equal";
      }
    }
    else {
      q="Which one of the following two numbers is smaller: " + r1 + " or " + r2 + "? (if equal, respond 'equal')";
      if (r1>r2){
        a= Integer.toString(r2);;
      }
      else if (r1<r2){
       a= Integer.toString(r1);
     }
     else {
       a="equal";
     }
    }

    ArrayList options = new ArrayList();
    options.add("a. "+Helper.convertLongIntToProperForm(r1));
    options.add("b. "+Helper.convertLongIntToProperForm(r2));
    options.add("c. the same");
    qa.setOptions(options);

    qa.setQuestion(q);
    qa.setAnswer(a);
   return qa;
  }


}