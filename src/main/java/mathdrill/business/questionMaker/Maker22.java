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

public class Maker22 extends BaseMaker {
 static private  String  plusSign = " + ";
 static private  String  minusSign = " - ";
 static private  String  multiplySign = " * ";
 static private  String  divideSign = " &divide; ";

  public static RegularQuestion makeQuestion(String var2,String var3,String var4, String var5,String var6){

    RegularQuestion qa =new RegularQuestion();
    String q ="";
    String a ="";
    double answer;
    int number=1, n1=0,n2=0,n3=0,n4=0,n5=0;
    boolean bInclude100 = false, bInclude25=false, bInclude10=false, bInclude5=false, bInclude1=false;
    int leadingNumber=1;

     if (var2.equalsIgnoreCase("on")){
           bInclude100 = true;
           leadingNumber=100;
     }
     if (var3.equalsIgnoreCase("on")){
          bInclude25 = true;
          if (leadingNumber<=1)
          leadingNumber=25;
    }
    if (var4.equalsIgnoreCase("on")){
          bInclude10 = true;
          if (leadingNumber<=1)
          leadingNumber=10;
    }
    if (var5.equalsIgnoreCase("on")){
          bInclude5 = true;
          if (leadingNumber<=1)
          leadingNumber=5;
    }
    if (var6.equalsIgnoreCase("on")){
         bInclude1 = true;
         if (leadingNumber<=1)
         leadingNumber=1;
   }

    if (bInclude100){
      if (leadingNumber==100)
        n1= Helper.getRandom(1,3);
      else
        n1= Helper.getRandom(0,3);
    }
    if (bInclude25){
      if (leadingNumber==25)
        n2= Helper.getRandom(1,3);
      else
      n2= Helper.getRandom(0,3);
    }
    if (bInclude10){
      if (leadingNumber==10)
       n3= Helper.getRandom(1,5);
     else
       n3= Helper.getRandom(0,5);
     }
    if (bInclude5){
      if (leadingNumber==5)
        n4= Helper.getRandom(1,4);
      else
        n4= Helper.getRandom(0,4);
    }
    if (bInclude1){
      if (leadingNumber==1)
        n5= Helper.getRandom(1,5);
      else
         n5= Helper.getRandom(0,5);
    }


    String blockpath = "images/money/";
    for (int i=0;i<n1;i++){
      q=q+ " <img border='0' src='"+blockpath+"100cent.JPG'> ";
    }
    for (int i=0;i<n2;i++){
     q=q+ " <img border='0' src='"+blockpath+"25cent.JPG'> ";
    }
    for (int i=0;i<n3;i++){
      q=q+ " <img border='0' src='"+blockpath+"10cent.JPG'> ";
    }
    for (int i=0;i<n4;i++){
      q=q+ " <img border='0' src='"+blockpath+"5cent.JPG'> ";
    }
    for (int i=0;i<n5;i++){
      q=q+ " <img border='0' src='"+blockpath+"1cent.JPG'> ";
    }

    q=q+ "<br>The amount of money is: $";

    answer = (n1* 100 + n2*25 + n3*10 + n4*5 + n5*1)/100.0;
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