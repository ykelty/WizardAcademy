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

public class Maker23 extends BaseMaker {

  public static MultipleChoiceQuestion makeQuestion(String var2,String var3,String var4, String var5){

   MultipleChoiceQuestion qa =new MultipleChoiceQuestion();
   String q ="";
   String a ="";
   int divisor = 2;
   int numberatorUpTo = intValue(var2);
   int random = Helper.getRandom(1,2);
   int number=1;

   if (random==1){
     //come with a number that is even
     int n1 = Helper.getRandom(1, 99);
     number = n1 * divisor;
     a="even";
   }
   else {
     //come with a number that is odd
     int n1 = Helper.getRandom(1, 99);
     number = n1* divisor + 1;
      a="odd";
   }

   q="Is "+ Helper.convertLongIntToProperForm(number)  + " even or odd ?";
   System.out.println("MAKER 23");
   ArrayList options = new ArrayList();
   options.add("a. "+ "Even");
   options.add("b. "+ "Odd");
   qa.setOptions(options);

   qa.setQuestion(q);
   qa.setAnswer(a);
   System.out.println(qa.getQuestion());
   System.out.println(qa.getAnswer());
   return qa;
  }


}