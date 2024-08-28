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

public class Maker17 extends BaseMaker {
 static private  String  plusSign = " + ";
 static private  String  minusSign = " - ";
 static private  String  multiplySign = " * ";
 static private  String  divideSign = " &divide; ";

  public static RegularQuestion makeQuestion(String var2,String var3,String var4, String var5){

    RegularQuestion qa =new RegularQuestion();
    String q ="";
    String a ="";
    int answer;
    int patternType = Helper.getRandom(1, 2);
    int patternUpTo = 99;
    int numberSize = 99;
    int n1=0,n2=0,n3=0,n4=0,n5=0;
    int pattern = Helper.getRandom(2,patternUpTo);
    int increment=0;
    if (pattern > 10){
      pattern = pattern/10 * 10; // if it is 48, we use 40 instead.
    }
    
    if (patternType == 1){
      n1=0;
      n2=pattern;
      n3=pattern*2;
      n4=pattern*3;
      n5=pattern*4;
      if (n5<numberSize){
        increment = Helper.getRandom(1,numberSize-n5);
      }
    }
    else{
      n1=numberSize;
      n2=numberSize-pattern;
      n3=numberSize - pattern*2;
      n4=numberSize- pattern*3;
      n5=numberSize- pattern*4;
      if (n5>0){
        increment = 0-Helper.getRandom(1,n5);
      }
    }
    n1=n1+increment;
    n2=n2+increment;
    n3=n3+increment;
    n4=n4+increment;
    n5=n5+increment;

    q="Find the pattern and fill in the missing number 'x': "+n1+" , "+n2+" , "+n3+" , "+n4+" , x " ;

    a=""+n5;
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