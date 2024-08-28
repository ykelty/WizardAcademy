package mathdrill.business.questionMaker;
import mathdrill.business.question.*;
import java.util.*;

/**
 * <p>Title:  Two Step Pre Algebra </p>
 * <p>Description:  One Step Pre Algebra</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Maker13 extends BaseMaker {
 static private  String  plusSign = " + ";
 static private  String  minusSign = " - ";
 static private  String  multiplySign = " * ";
 static private  String  divideSign = " / ";

  public static RegularQuestion makeQuestion(String var2,String var3,String var4, String var5){

    RegularQuestion qa =new RegularQuestion();
    String q ="";
    String a ="";
    String operation= getOperation();
    String variable=getVariable();
    int numberSize = 20;
    int n1, n2, n3;
    boolean bIncludeNeg = false;
     if (var4.equalsIgnoreCase("on")){
           bIncludeNeg = true;
     }

    if (bIncludeNeg){
      n1=getANumber(0-numberSize, numberSize);
      n2=getANumber(0-numberSize, numberSize);
      n3 =getANumber(0-numberSize, numberSize);
    }
    else {
      n1=getANumber(0, numberSize);
      n2=getANumber(0, numberSize);
      n3 =getANumber(0, numberSize);
    }
    int n4=0;
    int random=Helper.getRandom(1,4);
    int randomLook=Helper.getRandom(1,2);


    if (random==1){
       // generate question looks like: 3x+2 = 17
      if (operation.equals(plusSign)){
        n4 = n1*n2 + n3;
        if (randomLook==1)
          q = n1+ variable + operation + getString(n3) + " = " + n4 ;
        else{
          q =getString(n3) + operation + getString(n1)+ variable +  " = " + n4 ;
        }
      }
      else {
        n4 = n1*n2 - n3;
        q = n1+ variable + operation + getString(n3) + " = " + n4 ;
      }
        a = ""+n2;
    }
    else  if (random==2){
       // generate question looks like: x/3+2 = 17
      if (bIncludeNeg){
      n4 =getANumber(0-numberSize, numberSize);
      }
      else {
         n4 =getANumber(0, numberSize);
      }
       if (operation.equals(plusSign)){
         if (n1==0) n1++;
         n2=(n4-n3)*n1;
         if (randomLook==1)
           q = variable + "/"+getString(n1) + operation + getString(n3) + " = " + n4;
         else
           q =  n3 + operation + variable + "/"+getString(n1) + " = " + n4;

       }
       else {
         n2 = (n4+n3)*n1;
         q = variable + "/"+getString(n1) + operation + getString(n3) + " = " + n4;
       }
      a = ""+n2;
    }
    else  if (random==3){
       // generate question looks like: (3+x)* 2 = 18
      if (operation.equals(plusSign)){
        n4=(n1+n2)*n3;
        if (randomLook==1)
          q = "("+ n1 + operation + variable +")"+ "*"+getString(n3) + " = " + n4;
        else
          q = getString(n3) + "* ("+ n1 + operation + variable +")" + " = " + n4;

      }
      else {
        n4 = (n1-n2)*n3;
         q = "("+ n1 + operation + variable +")"+ multiplySign+getString(n3) + " = " + n4;
      }
      a = ""+n2;
    }

    else  if (random==4){
       // generate question looks like: (x+3)/ 2 = 18
      if (bIncludeNeg){
        n4 =getANumber(0-numberSize, numberSize);
      }
      else {
        n4 =getANumber(0, numberSize);
      }

      if (operation.equals(plusSign)){
        n2=(n4 * n3) - n1;
      }
      else {
         n2=(n4 * n3) + n1;
      }
        q = "("+ variable + operation + getString(n1) +")"+ divideSign +getString(n3) + " = " + n4;
        a = ""+n2;
    }

     q= q+ ". What is the value of "+variable+"?";
    qa.setQuestion(q);
    qa.setAnswer(a);
    return qa;
  }
  private static String getOperation (){
    String rValue=" + ";
    int oper1= Helper.getRandom(1,2);
        if (oper1==1){
         rValue = plusSign;
       }
       else {
          rValue = minusSign;
       }

   return rValue;

  }
  private static String getVariable()
{
    String rValue="";
    int random = Helper.getRandom(1,6);
    switch (random) {
             case 1:  rValue ="x"; break;
             case 2:  rValue ="y"; break;
             case 3:  rValue ="m"; break;
             case 4:  rValue ="n"; break;
             case 5:  rValue ="p"; break;
             case 6:  rValue ="q"; break;
             case 7:  rValue ="r"; break;
             case 8:  rValue ="t"; break;

    }
    return rValue;
  }

  private static int getANumber(int from, int to)
  {
    int iReturn = Helper.getRandom(from, to);
    return iReturn;
  }

  private static String getString(int i){
    if (i>=0){
      return Integer.toString(i);
    }
    else {
      return "("+Integer.toString(i)+")";
    }
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