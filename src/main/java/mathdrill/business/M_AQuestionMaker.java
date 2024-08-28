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
public class M_AQuestionMaker {

  static Random generator = new Random();

  public M_AQuestionMaker() {
  }

// get question "random (0-9) x number
  public static QuestionAnswer makeMultiplicationFactByNumber (int number, String solveFor){
     QuestionAnswer qa =new QuestionAnswer();
     int r, result;

     if (number>=10 && number <=12){
       r = generator.nextInt(number+1);  // a random number between 0 to number
     }
     else
        r = generator.nextInt(10);  // a random number between 0 to 9

    result = r*number;
    if (solveFor.indexOf("empty")>=0){
         solveFor="&#91;&#93;";
       }

    String q, a;
     if (Helper.getRandom(1,2)==1){
       q=solveFor+ " x " + number + " = " + result+"<br>&nbsp;&nbsp;Solve for "+solveFor+" : ";
       a=""+r;
     }
     else {
       q=""+number + " x "+solveFor+" = " + result+"<br>&nbsp;&nbsp;Solve for "+solveFor+" : ";
       a = ""+r;
     }

     qa.setQuestion(q);
     qa.setAnswer(a);
     return qa;
  }

  public static QuestionAnswer makeMultiplicationFactByRange (int number1,int number2, String solveFor){
     QuestionAnswer qa =new QuestionAnswer();
     if (number1>number2){
       int t=number1;
       number1=number2;
       number2=t;
     }

     int number = Helper.getRandom(number1,number2);

     return makeMultiplicationFactByNumber(number,solveFor);
  }

// general multiplication worksheets
  public static QuestionAnswer makeMultiplication (int number1, int number2, String solveFor){
     QuestionAnswer qa =new QuestionAnswer();
     int r1, r2;

     //generate a 3 digit random number, it means a random integer from 0 to 899 add an additional 100
     // it menas generator.nextInt(900)+100
     r1 = Helper.getRandomWithGivenDigits(number1);
     r2 = Helper.getRandomWithGivenDigits(number2);

     int result = r1*r2;
       if (solveFor.indexOf("empty")>=0){
            solveFor="&#91;&#93;";
          }

       String q, a;
        if (Helper.getRandom(1,2)==1){
          q=solveFor+ " x " + Helper.convertLongIntToProperForm(r2 ) + " = " + Helper.convertLongIntToProperForm(result )+"<br>&nbsp;&nbsp;Solve for "+solveFor+" : ";
          a=""+r1;
        }
        else {
          q=""+Helper.convertLongIntToProperForm(r1 ) + " x "+solveFor+" = " + Helper.convertLongIntToProperForm(result )+"<br>&nbsp;&nbsp;Solve for "+solveFor+" : ";
          a = ""+r2;
        }

      qa.setQuestion(q);
     qa.setAnswer(a);
     return qa;
  }


  public static void main(String[] args) {
     MQuestionMaker questionMaker1 = new MQuestionMaker();

  }
}