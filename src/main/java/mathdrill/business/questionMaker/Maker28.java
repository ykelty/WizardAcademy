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

public class Maker28 extends BaseMaker {

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

        if ( var2!=null && var2.equalsIgnoreCase("from fraction to percent")){
          qa = makeFractionToPercent(var3,hasDecimal);
        }
        else  if (var2!=null && var2.equalsIgnoreCase("from percent to fraction")){
          qa = makePercentToFraction(var3,hasDecimal);
        }
        else {
          if (random==0){
            qa = makeFractionToPercent(var3,hasDecimal);
          }
          else {
            qa = makePercentToFraction(var3,hasDecimal);
          }

        }


    return qa;
  }

  private static BaseQuestion makeFractionToPercent(String var3, boolean hasDecimal){

    int r=Helper.getRandom(0,1);

    if (var3.equalsIgnoreCase("larger than 100%"))
    {
       return makeFractionToPercent2(hasDecimal);
    }
    else   if (var3.equalsIgnoreCase("not larger than 100%"))
    {
      return makeFractionToPercent1(hasDecimal);
    }
    else {
      if (r==0){
        return makeFractionToPercent2(hasDecimal);
      }
      else{
        return makeFractionToPercent1(hasDecimal);
      }
    }

  }
  private static BaseQuestion makeFractionToPercent1( boolean hasDecimal){

   BaseQuestion qa = null;
   int p = Helper.getRandom(1,5);
   int r;
   if (p>=4){
    r=Helper.getRandom(1,49)*2;
   }
   else if (p>=2){
        r=Helper.getRandom(1,19)*5;
   }
   else {
        r=Helper.getRandom(1,99);
    }
   int f=Helper.getGCF(r,100);
   String q="",a ="";
   q="<sup>"+r/f+"</sup>/<sub>"+100/f+"</sub> = ";
   a=""+r;

   qa = new PercentQuestion();
   qa.setQuestion(q);
   qa.setAnswer(a);
   return qa;
  }
  private static BaseQuestion makeFractionToPercent2( boolean hasDecimal){

    BaseQuestion qa = null;
    int p = Helper.getRandom(1,5);
    int r;
    if (p>=4){
         r=Helper.getRandom(51,99)*2;
       }
     else if (p>=2){
         r=Helper.getRandom(21,39)*5;
       }
    else {
         r=Helper.getRandom(101,199);
    }

    int f=Helper.getGCF(r,100);
    String q="",a ="";
    q="<sup>"+r/f+"</sup>/<sub>"+100/f+"</sub> = ";
    a=""+r;

    qa = new PercentQuestion();
    qa.setQuestion(q);
    qa.setAnswer(a);
    return qa;

  }
  private static BaseQuestion makePercentToFraction(String var3,boolean hasDecimal){

    int r=Helper.getRandom(0,1);
      if (var3.equalsIgnoreCase("larger than 100%"))
      {
         return makePercentToFraction2(hasDecimal);
      }
      else   if (var3.equalsIgnoreCase("not larger than 100%"))
      {
        return makePercentToFraction1(hasDecimal);
      }
      else {
        if (r==0){
          return makePercentToFraction2(hasDecimal);
        }
        else{
          return makePercentToFraction1(hasDecimal);
        }
    }
 }


  private static BaseQuestion makePercentToFraction1(boolean hasDecimal){

    FractionQuestion qa =new FractionQuestion();
    int p = Helper.getRandom(1,5);
    int r;
    if (p>=4){
      r=Helper.getRandom(1,49)*2;
    }
    else if (p>=2){
      r=Helper.getRandom(1,19)*5;
    }
    else {
      r=Helper.getRandom(1,99);
    }

    String q="",a ="";
    int f=Helper.getGCF(r,100);
    q=""+r +"% = ";

    qa.setAnswer(""+r/f);
    qa.setAnswerB(""+100/f);

    qa.setQuestion(q);
     return qa;
  }

  private static BaseQuestion makePercentToFraction2(boolean hasDecimal){

    FractionQuestion qa =new FractionQuestion();
       int p = Helper.getRandom(1,5);
       int r;
       if (p>=4){
         r=Helper.getRandom(51,99)*2;
       }
       else if (p>=2){
         r=Helper.getRandom(21,39)*5;
       }
       else {
         r=Helper.getRandom(101,199);
       }
       String q="",a ="";
       int f=Helper.getGCF(r,100);
       q=""+r +"% = ";

       qa.setAnswer(""+r/f);
       qa.setAnswerB(""+100/f);

       qa.setQuestion(q);

    return qa;
   }

  public static void main(String[] args) {

    BaseQuestion q=makeQuestion("",null,null,null);
    q.makeHTML(1);
    System.out.println(q.getHTML());

  }
}