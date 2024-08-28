package mathdrill.business;
import java.util.Random;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company:  Noetic Learning LLC</p>
 * @author Li Kelty
 * @version 1.0
 */
public class MQuestionMaker {

  static Random generator = new Random();

  public MQuestionMaker() {
  }

// get question "random (0-9) x number
  public static QuestionAnswer makeMultiplicationFactByNumber (int number){
     QuestionAnswer qa =new QuestionAnswer();
     int r;

     if (number>=10 && number <=12){
       r = generator.nextInt(number+1);  // a random number between 0 to number
     }
     else
        r = generator.nextInt(10);  // a random number between 0 to 9

     String q = r +" x " + number + " = ";
     String a = ""+r*number;
     qa.setQuestion(q);
     qa.setAnswer(a);
     return qa;
  }

  public static QuestionAnswer makeMultiplicationFactByRange (int number1,int number2){
     QuestionAnswer qa =new QuestionAnswer();
     int r;
     if (number1>number2){
       int t=number1;
       number1=number2;
       number2=t;
     }

     //generator.nextInt(number2-number1+1) will generate a random number between 0 to number2-number1
     int number = generator.nextInt(number2-number1+1)+number1;

     return makeMultiplicationFactByNumber(number);
  }

// general multiplication worksheets
  public static QuestionAnswer makeMultiplication (int number1, int number2){
     QuestionAnswer qa =new QuestionAnswer();
     int r1, r2;

     //generate a 3 digit random number, it means a random integer from 0 to 899 add an additional 100
     // it menas generator.nextInt(900)+100
     r1 = Helper.getRandomWithGivenDigits(number1);
     r2 = Helper.getRandomWithGivenDigits(number2);

     String q = Helper.convertLongIntToProperForm(r1 ) +" x " + Helper.convertLongIntToProperForm(r2 ) + " = ";
     String a = ""+r1 * r2;
     qa.setVQuestion("<table width=100 border=0 class=wsquestion ><tr><td align=right>"
                     + Helper.convertLongIntToProperForm(r1 )+ "&nbsp;</td></tr><tr><td align=right> X &nbsp;&nbsp;"
                     +Helper.convertLongIntToProperForm(r2 )+"&nbsp;</td></tr><tr><td align=right><hr width=80%></td></tr>");

     qa.setQuestion(q);
     qa.setAnswer(a);
     return qa;
  }


  public static void main(String[] args) {
     MQuestionMaker questionMaker1 = new MQuestionMaker();

  }
}