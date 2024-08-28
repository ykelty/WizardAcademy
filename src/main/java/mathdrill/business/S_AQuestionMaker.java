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

public class S_AQuestionMaker {
  static Random generator = new Random();

  public S_AQuestionMaker() {
  }


  public static QuestionAnswer makeSubtractionUpTo (int number, String solveFor){
    QuestionAnswer qa =new QuestionAnswer();
    int r1=0, r2=0,result, temp;

      //we need to continue until find a question fits the criteria
      r1 = generator.nextInt(number+1);  // a random number between 0 to number
      r2= generator.nextInt(10);  // a random number between 0 to 9

      if (r1<r2){
    	  temp = r1;
    	  r1=r2;
    	  r2=temp;
      }
  
    result=r1-r2;

    String q, a;
    if (solveFor.indexOf("empty")>=0){
     solveFor="&#91;&#93;";
   }

   if (Helper.getRandom(1,2)==1){
     q=solveFor+ " - " + Helper.convertLongIntToProperForm(r2 ) + " = " + Helper.convertLongIntToProperForm(result )+"<br>&nbsp;&nbsp;Solve for "+solveFor+" : ";
     a=""+r1;
   }
   else {
     q=""+Helper.convertLongIntToProperForm(r1 ) + " - "+solveFor+" = " + Helper.convertLongIntToProperForm(result )+"<br>&nbsp;&nbsp;Solve for "+solveFor+" : ";
     a = ""+r2;
   }

    qa.setQuestion(q);
    qa.setAnswer(a);
    return qa;
  }


  public static QuestionAnswer makeSubtractionNoGrouping (int number1, int number2, String solveFor){
    QuestionAnswer qa =new QuestionAnswer();
    int r1=0, r2=0, result,random1=0, random2=0;
    int tmp = number1;

    if (number2>number1){
      tmp=number2;   //assign tmp to the bigger of the two
    }

    for (int i=0;i<tmp;i++){
      r1 = generator.nextInt(10);  //random between 0 - 9
      r2 = generator.nextInt(r1+1);    //random number between 0 - r1

      if ((number1-1)>=i)
        random1= random1+ (int)Math.pow(10,i) * r1;
      if ((number2-1)>=i)
      random2= random2+ (int)Math.pow(10,i) * r2;
    }

    result = random1 - random2;
     String q, a;

    if (Helper.getRandom(1,2)==1){
       q=solveFor+ " - " + Helper.convertLongIntToProperForm(random2 ) + " = " + Helper.convertLongIntToProperForm(result )
        +"<br>&nbsp;&nbsp;Solve for "+solveFor+" : ";
       a=""+random1;
     }
     else {
       q=""+Helper.convertLongIntToProperForm(random1 ) + " - "+solveFor+" = " + Helper.convertLongIntToProperForm(result )
        +"<br>&nbsp;&nbsp;Solve for "+solveFor+" : ";
       a = ""+random2;
       }


    qa.setQuestion(q);
     qa.setAnswer(a);
     return qa;
  }

  public static QuestionAnswer makeSubtraction (int number1, int number2, boolean bPositiveResult, String solveFor){
   QuestionAnswer qa =new QuestionAnswer();
   int r1=0, r2=0, result, temp;   


     r1 = Helper.getRandomWithGivenDigits(number1);
     r2 = Helper.getRandomWithGivenDigits(number2);

     if (bPositiveResult) {
       if (r1<r2){
    	   temp=r1;
    	   r1=r2;
    	   r2=temp;
       }
     }
  
   result = r1-r2;

     String q, a;

   if (Helper.getRandom(1,2)==1){
      q=solveFor+ " - " + Helper.convertLongIntToProperForm(r2 ) + " = " + Helper.convertLongIntToProperForm(result )
       +"<br>&nbsp;&nbsp;Solve for "+solveFor+" : ";
      a=""+r1;
    }
    else {
      q=""+Helper.convertLongIntToProperForm(r1 ) + " - "+solveFor+" = " + Helper.convertLongIntToProperForm(result )
       +"<br>&nbsp;&nbsp;Solve for "+solveFor+" : ";
      a = ""+r2;
      }
   qa.setQuestion(q);
   qa.setAnswer(a);
   return qa;
  }

  public static void main(String[] args) {
    for (int i=0;i<10;i++){
      System.out.println("see how negative number shows:"+(500-798));
    }
  }
}