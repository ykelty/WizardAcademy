package mathdrill.business.questionMaker;
import mathdrill.business.question.*;
import java.math.BigDecimal;

/**
 * <p>Title: </p>
 * <p>Description: Convert between percents and decimals </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Maker27 extends BaseMaker {

  public static BaseQuestion makeQuestion(String var2,String var3,String var4, String var5){

        BaseQuestion qa = null;
        int random = Helper.getRandom(0,1);
        boolean bLargeThan1=false;
        boolean hasDecimal = false;
        if (var3!=null && var3.equalsIgnoreCase("larger than 100%")){
          bLargeThan1 = true;
        }
        else
          bLargeThan1 = false;

        if (var4!=null && var4.equalsIgnoreCase("decimal numbers")){
          hasDecimal = true;
        }
        else
          hasDecimal = false;

        if ( var2!=null && var2.equalsIgnoreCase("from decimal to percent")){
          qa = makeDecimalToPercent(var3,hasDecimal);
        }
        else  if (var2!=null && var2.equalsIgnoreCase("from percent to decimal")){
          qa = makePercentToDecimal(var3,hasDecimal);
        }
        else {
          if (random==0){
            qa = makeDecimalToPercent(var3,hasDecimal);
          }
          else {
            qa = makePercentToDecimal(var3,hasDecimal);
          }

        }


    return qa;
  }

  private static BaseQuestion makeDecimalToPercent(String var3, boolean hasDecimal){

    int r=Helper.getRandom(0,1);

    if (var3.equalsIgnoreCase("larger than 100%"))
    {
       return makeDecimalToPercent2(hasDecimal);
    }
    else   if (var3.equalsIgnoreCase("not larger than 100%"))
    {
      return makeDecimalToPercent1(hasDecimal);
    }
    else {
      if (r==0){
        return makeDecimalToPercent2(hasDecimal);
      }
      else{
        return makeDecimalToPercent1(hasDecimal);
      }
    }

  }
  private static BaseQuestion makeDecimalToPercent1( boolean hasDecimal){

   BaseQuestion qa = null;
   int r = Helper.getRandom(0,100);
   String q="",a ="";
   if (r==0){
     q="Turn this decimal to a percent (don't include the percent symbol): 0.00 = ";
     a = ""+"0";
   }
   else if (r<10){
     q ="Turn this decimal to a percent (don't include the percent symbol): 0.0"+r +" = " ;
     a = ""+ r ;
   }
   else if (r<100){
     q ="Turn this decimal to a percent (don't include the percent symbol): 0."+r +" = ";
     a = ""+r;
   }
   else if (r==100){
     q ="Turn this decimal to a percent (don't include the percent symbol): 1" +" = ";
     a = ""+r;
   }
   qa = new PercentQuestion();
   qa.setQuestion(q);
   qa.setAnswer(a);
   return qa;
  }
  private static BaseQuestion makeDecimalToPercent2( boolean hasDecimal){

   //percent is large than 1
   BaseQuestion qa = null;
   int r = Helper.getRandom(101,999);
   double rd=r * 0.01;

   String q="",a ="";
   java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
   nf.setMaximumFractionDigits(2);
   q="Turn this decimal to a percent (don't include the percent symbol): "+nf.format(rd)+" = ";
   a=""+r;

   qa = new PercentQuestion();
   qa.setQuestion(q);
   qa.setAnswer(a);
   return qa;
  }
  private static BaseQuestion makePercentToDecimal(String var3,boolean hasDecimal){

    int r=Helper.getRandom(0,1);
      if (var3.equalsIgnoreCase("larger than 100%"))
      {
         return makePercentToDecimal2(hasDecimal);
      }
      else   if (var3.equalsIgnoreCase("not larger than 100%"))
      {
        return makePercentToDecimal1(hasDecimal);
      }
      else {
        if (r==0){
          return makePercentToDecimal2(hasDecimal);
        }
        else{
          return makePercentToDecimal1(hasDecimal);
        }
    }
 }


  private static BaseQuestion makePercentToDecimal1(boolean hasDecimal){

    RegularQuestion qa = null;
    int r = Helper.getRandom(0,100);
    String q="",a ="";

    if (r==0){
        q="Turn this percent to a decimal: 0% = ";
        a = ""+"0";
    }
    else if (r<10){
        q ="Turn this percent to a decimal: "+r +"% = ";
        a = "0.0"+ r ;
    }
    else if (r<100){
        q ="Turn this percent to a decimal: "+r +"% = ";
        a = "0."+r;
    }
    else if (r==100){
        q ="Turn this percent to a decimal: 100% = ";
        a = "1";
    }

    qa = new RegularQuestion();
    qa.setQuestion(q);
    qa.setAnswer(a);
    return qa;
  }

  private static BaseQuestion makePercentToDecimal2(boolean hasDecimal){

     RegularQuestion qa = null;
     int r = Helper.getRandom(101,999);
     double rd=r * 0.01;
     String q="",a ="";

     java.text.NumberFormat nf = java.text.NumberFormat.getInstance();
     nf.setMaximumFractionDigits(2);
     q ="Turn this percent to a decimal: "+r +"% = ";
     a = ""+nf.format(rd);

     qa = new RegularQuestion();
     qa.setQuestion(q);
     qa.setAnswer(a);
     return qa;
   }

  public static void main(String[] args) {

    BaseQuestion q=makeQuestion("from decimal to percent","larger than 100%","larger than 100%","");
    q.makeHTML(1);
    System.out.println(q.getHTML());

  }
}