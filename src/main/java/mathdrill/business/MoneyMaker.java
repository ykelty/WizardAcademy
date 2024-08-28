package mathdrill.business;
import java.util.Random;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.text.DecimalFormat;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class MoneyMaker {

    static Random generator = new Random();
    static NumberFormat currencyformat = NumberFormat.getCurrencyInstance();
    static NumberFormat decimalFormat = new DecimalFormat("###.###");
    public MoneyMaker() {}

    public static QuestionAnswer makeAddition (int dollar, int increment_cent){
      QuestionAnswer qa =new QuestionAnswer();
      int r1=0, r2=0, sum=0;
      BigDecimal m1, m2;


      r1 = generator.nextInt(dollar*100/increment_cent);
      r2 = generator.nextInt(dollar*100/increment_cent);
      m1 = new BigDecimal(r1 * increment_cent *0.01);
      m2 = new BigDecimal(r2 * increment_cent *0.01);


      String q = ""+currencyformat.format(m1.doubleValue()) +" + " + currencyformat.format(m2.doubleValue()) + " = $";

      String a =decimalFormat.format(m1.add(m2).doubleValue());
      qa.setQuestion(q);
      qa.setAnswer(a);
      System.out.println(qa.getQuestion()+qa.getAnswer());
      return qa;
    }

    public static QuestionAnswer makeSubtraction (int dollar, int increment_cent){
      QuestionAnswer qa =new QuestionAnswer();
      int r1=0, r2=0, tmp=0;
      BigDecimal m1, m2;


      r1 = generator.nextInt(dollar*100/increment_cent);
      r2 = generator.nextInt(dollar*100/increment_cent);
      if (r1<r2){  //make sure r1>=r2
        tmp=r1;
        r1=r2;
        r2=tmp;
      }
      m1 = new BigDecimal(r1 * increment_cent *0.01);
      m2 = new BigDecimal(r2 * increment_cent *0.01);


      String q = ""+currencyformat.format(m1.doubleValue()) +" - " + currencyformat.format(m2.doubleValue()) + " = $";

      String a = decimalFormat.format(m1.subtract(m2).doubleValue());
      qa.setQuestion(q);
      qa.setAnswer(a);
      System.out.println(qa.getQuestion()+qa.getAnswer());
      return qa;
    }


    public static QuestionAnswer makeMultiplication (int dollar, int digits){
     QuestionAnswer qa =new QuestionAnswer();
     int r1=0, r2=0, sum=0;
     BigDecimal m1,m2;


      r1 = generator.nextInt(dollar*100);
      m1 = new BigDecimal(r1 *0.01);
      r2 = Helper.getRandomWithGivenDigits(digits);
      m2 = new BigDecimal(r2 *1.0);

     String q = ""+currencyformat.format(m1.doubleValue()) +" x " + r2 + " = $";

     String a =decimalFormat.format(m1.multiply(m2).doubleValue());
     qa.setQuestion(q);
     qa.setAnswer(a);
     System.out.println(qa.getQuestion()+qa.getAnswer());
     return qa;
   }

   public static QuestionAnswer makeDivision (int dollar, int digits){
     QuestionAnswer qa =new QuestionAnswer();
     int r1=0, r2=0, sum=0;
     BigDecimal m1,m2;


      r1 = generator.nextInt(dollar*100);
      r2 = Helper.getRandomWithGivenDigits(digits);

      r1 = r1/r2 * r2;  //slightly alter r1 so there will be no remainder

      m1 = new BigDecimal(r1 *0.01);
      m2 = new BigDecimal(r2 *1.0);

     String q = ""+currencyformat.format(m1.doubleValue()) +" &divide; " + r2 + " = $";

     String a =decimalFormat.format(m1.divide(m2,BigDecimal.ROUND_HALF_DOWN).doubleValue());
     qa.setQuestion(q);
     qa.setAnswer(a);
     System.out.println(qa.getQuestion()+qa.getAnswer());
     return qa;
   }

    public static void main(String[] args) {
      for (int i=0;i<10;i++){
        makeDivision(10,1);

      }
      for (int i=0;i<10;i++){
       makeDivision(10,2);

      }
      for (int i=0;i<10;i++){
             makeDivision(100,3);
      }
  }
}