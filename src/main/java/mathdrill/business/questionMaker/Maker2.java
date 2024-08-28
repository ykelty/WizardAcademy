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

public class Maker2 extends BaseMaker {

  public static MultipleChoiceQuestion makeQuestion(String var2,String var3,String var4, String var5){

    MultipleChoiceQuestion qa =new MultipleChoiceQuestion();
   int n1=1,d1=1,n2=1,d2=1;
   String q ="";
   String a ="";
   int denominatorUpTo = 16;
   int numberatorUpTo = 16;

   d1 = Helper.getRandom(2,denominatorUpTo) ;
   n1 = Helper.getRandom(1,numberatorUpTo);
   
   
   
   d2 = Helper.getRandom(2,denominatorUpTo) ;
   
   
   n2 = Helper.getRandom(1,numberatorUpTo);
   

   q="Which one of the following two fractions is larger: " + n1 + "/" + d1 + " or " + n2 + "/" + d2 + "? (if equal, respond 'equal')";
   if (n1*d2>n2*d1){
     a= Integer.toString(n1) + "/" + Integer.toString(d1);
   }
   else if (n1*d2 < n2*d1){
     a= Integer.toString(n2) + "/" + Integer.toString(d2);
   }
   else {
     a="equal";
   }


   ArrayList options = new ArrayList();
   options.add("a. "+ "<sup>"+n1+"</sup>/<sub>"+d1+"</sub>");
   options.add("b. "+ "<sup>"+n2+"</sup>/<sub>"+d2+"</sub>");
   options.add("c. the same");
   qa.setOptions(options);

   qa.setQuestion(q);
   qa.setAnswer(a);
   return qa;
  }


}