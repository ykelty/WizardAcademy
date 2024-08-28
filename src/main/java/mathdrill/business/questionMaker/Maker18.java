package mathdrill.business.questionMaker;
import mathdrill.business.question.*;
import java.util.*;

/**
 * <p>Title:  Base Ten Blocks</p>
 * <p>Description:  Base Ten Blocks</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Maker18 extends BaseMaker {
 static private  String  plusSign = " + ";
 static private  String  minusSign = " - ";
 static private  String  multiplySign = " * ";
 static private  String  divideSign = " divided by ";

  public static RegularQuestion makeQuestion(String var2,String var3,String var4, String var5){

    RegularQuestion qa =new RegularQuestion();
    String q ="";
    String a ="";
    int answer;
    int patternUpTo = 9;
    int n1=1,n2=1,n3=1,n4=1,n5=1;
    int pattern = Helper.getRandom(2,patternUpTo);
    int increment=0;
    if (pattern > 10){
      pattern = pattern/10 * 10; // if it is 48, we use 40 instead.
    }

      n1=Helper.getRandom(1,10);
      n2=n1*pattern;
      n3=n2*pattern;
      n4=n3*pattern;
  //    n5=n4*pattern;

    q="Find the pattern and fill in the missing number: "+n1+" , "+n2+" , "+n3+" , ";

    a=""+n4;
    qa.setQuestion(q);
    qa.setAnswer(a);
    return qa;
  }


  public static void main(String arg[]) {
    try{
  RegularQuestion q= Maker13.makeQuestion("10",null,null,null);
  System.out.println(q.toString());
    }
    catch (Exception e){
      System.out.println(e.getMessage());
    }
}
}