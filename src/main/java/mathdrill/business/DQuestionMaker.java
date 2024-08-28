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
public class DQuestionMaker {

  static Random generator = new Random();

  public DQuestionMaker() {
  }

// get question "random (0-9) x number
  public static QuestionAnswer makeDivisionFactByNumber (int number){
     QuestionAnswer qa =new QuestionAnswer();
     int r;
     int d;

     if (number>=10 && number <=12){
       r = generator.nextInt(number+1);  // a random number between 0 to number
     }
     else
        r = generator.nextInt(10);  // a random number between 0 to 9

     d = number * r;
     String q = d +" &divide; " + number + " = ";
     String a = ""+r;
     qa.setQuestion(q);
     qa.setAnswer(a);
     return qa;
  }

  public static QuestionAnswer makeDivisionFactByRange (int number1,int number2){
     QuestionAnswer qa =new QuestionAnswer();
     int r;
     if (number1>number2){
       int t=number1;
       number1=number2;
       number2=t;
     }

     //generator.nextInt(number2-number1+1) will generate a random number between 0 to number2-number1
     int number = generator.nextInt(number2-number1+1)+number1;

     return makeDivisionFactByNumber(number);
  }

// general divsion worksheets
  public static QuestionAnswer makeDivision (int number1, int number2, boolean withRemainder){


     QuestionAnswer qa =null;
     int r1, r2;


     if (withRemainder){
         qa =new DQuestionAnswer();
     }
     else qa=new QuestionAnswer();

     r1 = Helper.getRandomWithGivenDigits(number1);
     r2 = Helper.getRandomWithGivenDigits(number2);

     if (!withRemainder){
       r1 = r1/r2 * r2;   //slightly alter r1 so that we will make a number with no remainder
     }

     String q = Helper.convertLongIntToProperForm(r1 ) +" &divide; " + Helper.convertLongIntToProperForm(r2 ) + " = ";
     String a = ""+r1/r2;
     String b = ""+ (r1-r1/r2 * r2);
     qa.setQuestion(q);
     qa.setAnswer(a);
     qa.setAnswerB(b);
     return qa;
  }


  public static void main(String[] args) {
     System.out.println(" 100/26="+100/26);

  }
}