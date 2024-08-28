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

public class Maker24 extends BaseMaker {

  public static MultipleChoiceQuestion makeQuestion(String var2,String var3,String var4, String var5){

   MultipleChoiceQuestion qa =new MultipleChoiceQuestion();
   String q ="";
   String a ="";
   int random = Helper.getRandom(1,3);
   q="Is the following angle acute, right or obtuse ? <br>";

   String blockpath = "images/geometry/angle/";
   if (random==1){
     //come with an acute angle
     int n1 = Helper.getRandom(1, 25);
     q = q+ " <img border='0' src='"+blockpath+"acute"+n1+".JPG'> ";
     a="a";
   }
   else if (random==2){
     //come with a right angle
     int n2 = Helper.getRandom(1, 20);
     q = q+" <img border='0' src='"+blockpath+"right"+n2+".JPG'> ";
      a="b";
   }
   else {
     //come with an obtuse angle
     int n3 = Helper.getRandom(1, 25);
     q = q+" <img border='0' src='"+blockpath+"obtuse"+n3+".JPG'> ";
     a="c";
  }


   ArrayList options = new ArrayList();
   options.add("a. "+ "acute");
   options.add("b. "+ "right");
   options.add("c. "+ "obtuse");
   qa.setOptions(options);

   qa.setQuestion(q);
   qa.setAnswer(a);
   return qa;
  }


}