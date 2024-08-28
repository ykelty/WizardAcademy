package mathdrill.business.questionMaker;
import mathdrill.business.question.*;
import java.math.BigDecimal;

/**
 * <p>Title: </p>
 * <p>Description: Divisibility Facts </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Maker26 extends BaseMaker {

  public static MakeChangeQuestion makeQuestion(String var2,String var3,String var4, String var5){

   MakeChangeQuestion qa =new MakeChangeQuestion();
   String q ="";
   String a ="";
   int amount=Helper.getRandom(1, 9);
   int paidAmount=Helper.getRandom(1,amount);
   BigDecimal saleAmount=Helper.getRandomDecimal(0,9).add(new BigDecimal(Helper.getRandom(0,paidAmount-1)));
   int random = Helper.getRandom(1,3);
   q="Amount of sales is: $"+saleAmount + ", amount paid is $"+ paidAmount +". Please make change. <br>";
   a= ""+new BigDecimal(paidAmount).subtract(saleAmount);
   BigDecimal t = new BigDecimal(a);
   BigDecimal dollar = new BigDecimal("1");
   BigDecimal quarter = new BigDecimal("0.25");
   BigDecimal dime = new BigDecimal("0.1");
   BigDecimal nickel = new BigDecimal("0.05");
   BigDecimal penny = new BigDecimal("0.01");
   int iDollar=0, iQuarter=0, iDime=0, iNickel=0, iPenny=0;
   while (t.compareTo(new BigDecimal(0))>0){

     if (t.compareTo(dollar)>=0){
       t= t.subtract(dollar);
       iDollar++;
     }
     else      if (t.compareTo(quarter)>=0){
       t= t.subtract(quarter);
       iQuarter++;
     }
     else      if (t.compareTo(dime)>=0){
       t= t.subtract(dime);
       iDime++;
     }
     else      if (t.compareTo(nickel)>=0){
       t= t.subtract(nickel);
       iNickel++;
     }
     else      if (t.compareTo(penny)>=0){
       t= t.subtract(penny);
       iPenny++;
     }
   }
   qa.setAnswerDollar(""+iDollar);
   qa.setAnswerQuarter(""+iQuarter);
   qa.setAnswerDime(""+iDime);
   qa.setAnswerNickel(""+iNickel);
   qa.setAnswerPenny(""+iPenny);

   //Javascript has problems with decimal numbers, let's use whole number for javascript sake
   a= ""+new BigDecimal(a).multiply(new BigDecimal("100"));
   qa.setQuestion(q);
   qa.setAnswer(a);
   return qa;
  }

  public static void main(String[] args) {
    int paidAmount=1;
     BigDecimal saleAmount=Helper.getRandomDecimal(0,2).add(new BigDecimal(Helper.getRandom(0,paidAmount-1)));
     System.out.println(saleAmount);
     paidAmount=5;
     saleAmount=Helper.getRandomDecimal(0,2).add(new BigDecimal(Helper.getRandom(0,paidAmount-1)));
     System.out.println(saleAmount);
     paidAmount=10;
     saleAmount=Helper.getRandomDecimal(0,2).add(new BigDecimal(Helper.getRandom(0,paidAmount-1)));
     System.out.println(saleAmount);

  }
}