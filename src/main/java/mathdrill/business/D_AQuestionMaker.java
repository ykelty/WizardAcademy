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
public class D_AQuestionMaker {

  static Random generator = new Random();

  public D_AQuestionMaker() {
  }

// get question "random (0-9) x number
  public static QuestionAnswer makeDivisionFactByNumber (int number, String solveFor){
     QuestionAnswer qa =new QuestionAnswer();
     int r;
     int d;

     if (number>=10 && number <=12){
       r = generator.nextInt(number)+1;  // a random number between 1 to number
     }
     else
        r = generator.nextInt(10) + 1;  // a random number between 1 to 10

     d = number * r;

     String fna,fnb, fda,fdb,faa,fab,q,a;
     if (solveFor.indexOf("empty")>=0){
       solveFor="&#91;&#93;";
     }

     
     fna="<math xmlns='http://www.w3.org/1998/Math/MathML' display='block'><mrow><mfrac><mrow><mi>";
     fnb="</mi>";
     fda="</mrow><mrow><mi>";
     fdb="</mi></mrow></mfrac></mrow><mo>=</mo>";
     faa="<mi>";
     fab="</mi></mrow></math>";


     if (Helper.getRandom(1,2)==1){
    	q= fna+solveFor+fnb+fda+number+fdb+faa+r+fab+"Solve for "+solveFor+" : ";
  //     q=solveFor+ " &divide; " + number + " = " + r+"<br>&nbsp;&nbsp;Solve for "+solveFor+" : ";
       a=""+d;
     }
     else {
    	q= fna+d+fnb+fda+solveFor+fdb+faa+r+fab+"Solve for "+solveFor+" : ";

    // q=""+d + " &divide; "+solveFor+" = " + r+"<br>&nbsp;&nbsp;Solve for "+solveFor+" : ";
       a = ""+number;
     }

     qa.setQuestion(q);
     qa.setAnswer(a);
     return qa;
  }

  public static QuestionAnswer makeDivisionFactByRange (int number1,int number2, String solveFor){
     QuestionAnswer qa =new QuestionAnswer();
     int r;
     if (number1>number2){
       int t=number1;
       number1=number2;
       number2=t;
     }

     //generator.nextInt(number2-number1+1) will generate a random number between 0 to number2-number1
     int number = generator.nextInt(number2-number1+1)+number1;

     return makeDivisionFactByNumber(number,solveFor);
  }

// general divsion worksheets
  public static QuestionAnswer makeDivision (int number1, int number2, boolean withRemainder, String solveFor){


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