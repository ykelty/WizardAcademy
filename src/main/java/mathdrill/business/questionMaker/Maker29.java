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

public class Maker29 extends BaseMaker {

  public static BaseQuestion makeQuestion(String var2,String var3,String var4, String var5){

        BaseQuestion qa = null;
        int r;
        if ( var2!=null && var2.equalsIgnoreCase("What is M% of N?")){
          qa = makePercentage1();
        }
        else  if (var2!=null && var2.equalsIgnoreCase("How many percent of M is N?")){
          qa = makePercentage2();
        }
        else  if (var2!=null && var2.equalsIgnoreCase("M% of what number is N?")){
          qa = makePercentage3();
        }
        else  {
         qa = makePercentage1();
        }

    return qa;
  }

  private static int getRandomPercent(int a){

   int percent=1;

   int r=Helper.getRandom(1,9);
   switch (r) {
      case 1:percent=2;break;
      case 2:percent=4;break;
      case 3:percent=5;break;
      case 4:percent=20;break;
      case 5:percent=25;break;
      case 6:percent=50;break;
      case 7:percent=2*a;break;
      case 8:percent=4*a;break;
      case 9:percent=5*a;break;
       default:break;
   }

   return percent;
  }

  private static RegularQuestion makePercentage1(){

    RegularQuestion qa = new RegularQuestion();
    int a=Helper.getRandom(1,20);
    int x=getRandomPercent(a);
    int y= a*100/x;
    int r=Helper.getRandom(1,2);
    String q="";
    if (r==1){
      q="What number is "+x+"% of "+y+"? " ;
    }
    else {
      q="What is "+x+"% of "+y+"? " ;
    }

    qa.setQuestion(q);
    qa.setAnswer(""+a);

    return qa;
  }

  private static PercentQuestion makePercentage2(){

    PercentQuestion qa = new PercentQuestion();
    int y=Helper.getRandom(1,20);
    int a=getRandomPercent(y);
    int x= y*100/a;
    int r=Helper.getRandom(1,2);
    String q="";
    if (r==1){
      q="What percent of "+x+" is "+y+"? " ;
    }
    else {
      q="How many percent of "+x+" is "+y+"? " ;
    }

    qa.setQuestion(q);
    qa.setAnswer(""+a);

    return qa;
 }

 private static RegularQuestion makePercentage3(){

     RegularQuestion qa = new RegularQuestion();
     // x= y% * a ==> 100*x = a * y
     int x=Helper.getRandom(1,20);
     int a=getRandomPercent(x);
     int y= x*100/a;
     int r=Helper.getRandom(1,2);
     String q="";
     if (r==1){
       q=""+ x+" is "+y+"% of what? ";
     }
     else {
       q=""+y+"% of what number is "+x+"? ";
     }

     qa.setQuestion(q);
     qa.setAnswer(""+a);

     return qa;

 }

  public static void main(String[] args) {

    BaseQuestion q=makeQuestion("",null,null,null);
    q.makeHTML(1);
    System.out.println(q.getHTML());

  }
}