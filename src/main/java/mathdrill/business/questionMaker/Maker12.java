package mathdrill.business.questionMaker;
import mathdrill.business.question.*;
import java.util.*;

/**
 * <p>Title:  One Step Pre Algebra </p>
 * <p>Description:  One Step Pre Algebra</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Maker12 extends BaseMaker {
 static private  String  plusSign = " + ";
 static private  String  minusSign = " - ";
 static private  String  multiplySign = " * ";
 static private  String  divideSign = " / ";

  public static RegularQuestion makeQuestion(String var2,String var3,String var4, String var5){

    RegularQuestion qa =new RegularQuestion();
    String q ="";
    String a ="";
    String operation;
    String variable=getVariable();
    int numberSize = 30;
    int n1,n2;
    boolean bIncludeNeg = false;
    if (var4.equalsIgnoreCase("on")){
          bIncludeNeg = true;
    }
    if (bIncludeNeg)
      n1=getANumber(0-numberSize, numberSize);
    else
       n1=getANumber(1, numberSize);
     if (bIncludeNeg)
       n2=getANumber(0-numberSize, numberSize);
     else
       n2=getANumber(1, numberSize);
    int n3 = 0;
    int random=Helper.getRandom(1,3);
    operation = getOperation(var2);

    if (operation.equals(plusSign)){
      n3=n1+n2;
    }
    else  if (operation.equals(minusSign)){
     if (!bIncludeNeg && (n1<n2)){
       int t=n1;
       n1=n2;
       n2=t;
     }
        n3=n1-n2;
    }
    else  if (operation.equals(multiplySign)){
      if (n1==0) n1++;
      if (n2==0) n2++;
         n3=n1*n2;
    }
    else  if (operation.equals(divideSign)){
      if (n1==0) n1++;
      if (n2==0) n2++;
          n3=n1*n2;
          int t = n3;   //after changing value n1 divide n2 will have a while value
          n3=n1;
          n1=t;

     }

    if (random==1){
      q = variable + operation + getString(n2) + " = " + n3 ;
      a = ""+n1;
    }
    else  if (random==2){
      q = getString(n1) + operation + variable + " = " + n3;
      a = ""+n2;
    }
    else  if (random==3){
     q = variable + " = " +  getString(n1) + operation + getString(n2);
     a = ""+n3;
    }

     q= q+ ". What is the value of "+variable+"?";
    qa.setQuestion(q);
    qa.setAnswer(a);
    return qa;
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

  private static String getOperation (String oper){
    String rValue=" + ";
    int oper1= Helper.getRandom(1,2);
    int oper2= Helper.getRandom(1,4);
    if (oper.equals("adding/subtracting")){
       if (oper1==1){
         rValue = plusSign;
       }
       else {
          rValue = minusSign;
       }
    }
    if (oper.equals("multiplying/dividing")){
       if (oper1==1){
         rValue = multiplySign;
       }
       else {
          rValue = divideSign;
       }
    }
    if (oper.equals("mixed")){
      switch (oper2) {
            case 1:  rValue =plusSign; break;
            case 2:  rValue =minusSign; break;
            case 3:  rValue =multiplySign; break;
            case 4:  rValue =divideSign; break;
     }
   }
   return rValue;

  }
  public static void main(String arg[]) {
    try{
  RegularQuestion q= Maker12.makeQuestion("mixed","100",null,null);
  System.out.println(q.toString());
    }
    catch (Exception e){
      System.out.println(e.getMessage());
    }
}
}