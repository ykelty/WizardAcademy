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

public class Maker16 extends BaseMaker {
 static private  String  plusSign = " + ";
 static private  String  minusSign = " - ";
 static private  String  multiplySign = " * ";
 static private  String  divideSign = " &divide; ";

  public static RegularQuestion makeQuestion(String var2,String var3,String var4, String var5){

    RegularQuestion qa =new RegularQuestion();
    String q ="";
    String a ="";
    int answer;
    int numberSize = Integer.parseInt(var2);
    int number=1, n1=1,n2=0,n3=0;

    if (numberSize==100){
      n3= Helper.getRandom(1,5);
      n2 = Helper.getRandom(0,7);
      n1= Helper.getRandom(0,5);
    }
    if (numberSize==10){
      n3=0;
      n2 = Helper.getRandom(1,9);
      n1 = Helper.getRandom(0,9);
    }
    if (numberSize==1){
      n3=0;
      n2=0;
      n1 = Helper.getRandom(1,9);
    }

    String blockpath = "images/placevalue/";
    for (int i=0;i<n3;i++){
      q=q+ " <img border='0' src='"+blockpath+"100.GIF'> ";
    }
    for (int i=0;i<n2;i++){
     q=q+ " <img border='0' src='"+blockpath+"10.GIF'> ";
    }
    for (int i=0;i<n1;i++){
      q=q+ " <img border='0' src='"+blockpath+"1.GIF'> ";
    }
    q=q+ "<br>The value of given base ten blocks is: ";

    answer = n3* 100 + n2*10 + n1;
    a=""+answer;
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