package mathdrill.business.questionMaker;
import mathdrill.business.question.*;
import java.util.*;

/**
 * <p>Title: </p>
 * <p>Description: Divisibility Facts </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Maker14 extends BaseMaker {

  public static MultipleChoiceQuestion makeQuestion(String var2,String var3,String var4, String var5){

    MultipleChoiceQuestion qa =new MultipleChoiceQuestion();
    String q ="";
   String a ="";
   int divisor = Helper.getRandom(1,9);
   int numberatorUpTo = 25;
   int random = Helper.getRandom(1,2);
   int number=1;

   if (random==1){
     //come with a number that is divisible
     int n1 = Helper.getRandom(1, numberatorUpTo);
     number = n1 * divisor;
     a="yes";
   }
   else {
     //come with a number that is NOT divisible
     int n1 = Helper.getRandom(1, numberatorUpTo);
     number = n1* divisor + Helper.getRandom(1,divisor-1);
      a="no";
   }

   q="Is "+ Helper.convertLongIntToProperForm(number) + " divisible by "+ divisor+ " ? (Answer 'yes' or 'no')";

   ArrayList options = new ArrayList();
   options.add("a. "+ "Yes");
   options.add("b. "+ "No");
   qa.setOptions(options);

   qa.setQuestion(q);
   qa.setAnswer(a);
   return qa;
  }


}