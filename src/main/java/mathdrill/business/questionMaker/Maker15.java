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

public class Maker15 extends BaseMaker {

  public static MultipleChoiceQuestion makeQuestion(String var2,String var3,String var4, String var5){

    MultipleChoiceQuestion qa =new MultipleChoiceQuestion();
    String q ="";
   String a ="";
   int divisor = getDivisor(intValue(var2));
   int numberatorUpTo = intValue(var3);
   int random = Helper.getRandom(1,2);
   int number=1;

   if (random==1){
     //come with a number that is divisible
     int n1 = Helper.getRandom(1, numberatorUpTo/divisor);
     number = n1 * divisor;
     a="a";
   }
   else {
     //come with a number that is NOT divisible
     int n1 = Helper.getRandom(1, numberatorUpTo/divisor);
     number = n1* divisor + Helper.getRandom(1,divisor-1);
      a="b";
   }

   q="Is "+ Helper.convertLongIntToProperForm(number) + " divisible by "+ divisor+ " ?";

   ArrayList options = new ArrayList();
   options.add("a. "+ "Yes");
   options.add("b. "+ "No");
   qa.setOptions(options);

   qa.setQuestion(q);
   qa.setAnswer(a);
   return qa;
  }

private static int getDivisor(int upTo){
   //divisior can only be 2,3,4,5,6,8,9,10
  int rValue = Helper.getRandom(2,upTo);
  if (rValue==7)
    rValue =3;  // give 3 a bonus :)

  return rValue;
}

}