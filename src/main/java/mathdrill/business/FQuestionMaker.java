package mathdrill.business;
import java.util.Random;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class FQuestionMaker {
  static Random generator = new Random();

  public FQuestionMaker() {
  }


  public static QuestionAnswer findLCM (){
    QuestionAnswer qa =new QuestionAnswer();
      int r1=0, r2=0;
      int f=Helper.getRandom(1,12);
      r1 = Helper.getRandom(1,12);
      r2 = Helper.getRandom(1,12);


    String q = " LCM  ("+r1*f+" , " + r2*f + ") = ";
    String a = ""+ Helper.getLCM(r1*f,r2*f);
    qa.setQuestion(q);
    qa.setAnswer(a);
    return qa;
  }

  public static QuestionAnswer findGCF (){
     QuestionAnswer qa =new QuestionAnswer();
     int r1=0, r2=0;
     int f=Helper.getRandom(1,12);
     r1 = Helper.getRandom(1,12);
     r2 = Helper.getRandom(1,12);


     String q = " GCF  ("+r1*f+" , " + r2*f + ") = ";
     String a = ""+ Helper.getGCF(r1*f,r2*f);
     qa.setQuestion(q);
     qa.setAnswer(a);
     return qa;
  }

  public static QuestionAnswer reduceFraction (){
       FQuestionAnswer qa =new FQuestionAnswer();
       int r1=0, r2=0;
       int f=Helper.getRandom(1,12);
       r1 = Helper.getRandom(1,12) * f;
       r2 = Helper.getRandom(1,12) * f;


       String q = " <sup>"+r1+"</sup>/<sub>"+r2+"</sub> = ";

       int a = r1/Helper.getGCF(r1,r2);
       int b =  r2/Helper.getGCF(r1,r2);
       qa.setQuestion(q);
       qa.setAnswer(""+a);
       qa.setAnswerB(""+b);
       return qa;
  }

  public static void main(String[] args) {
    for (int i=0;i<10;i++){
      AQuestionMaker.makeAdditionNoGrouping(3,4);
    }
  }
}