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

public class SQuestionMaker {
  static Random generator = new Random();

  public SQuestionMaker() {
  }


  public static QuestionAnswer makeSubtractionUpTo (int number){
    QuestionAnswer qa =new QuestionAnswer();
    int r1=0, r2=0,result, temp;
 
    	//we need to continue until find a question fits the criteria
      r1 = generator.nextInt(number+1);  // a random number between 0 to number
      r2= generator.nextInt(10);  // a random number between 0 to 9
      System.out.println("r1 and r2: "+r1+" " +r2);

      if (r1<r2){
    	  temp=r1;
    	  r1=r2;
    	  r2=temp;
      }
 
    
    result=r1-r2;
    String q = ""+Helper.convertLongIntToProperForm(r1 ) +" - " +  Helper.convertLongIntToProperForm(r2 ) + " = ";
    String a = ""+ result;
    qa.setQuestion(q);
    qa.setAnswer(a);
    return qa;
  }


  public static QuestionAnswer makeSubtractionNoGrouping (int number1, int number2){
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

    String q = ""+random1 +" - " + random2 + " = ";
    String a = ""+ result;

    qa.setQuestion(q);
//    qa.setVQuestion("<table width=20px><tr><td alight=right>"+random1+"</td></tr><tr><td alight=right> + "+random2+"</td></tr><tr><td alight=right><hr></td></tr></table>");

    qa.setVQuestion("<table width=100 border=0 class=wsquestion ><tr><td align=right>"
                    + Helper.convertLongIntToProperForm(random1 ) + "&nbsp;</td></tr><tr><td align=right> - &nbsp;&nbsp;"
                    +Helper.convertLongIntToProperForm(random2 )+"&nbsp;</td></tr><tr><td align=right><hr width=80%></td></tr>");
    qa.setAnswer(a);
     return qa;
  }

  public static QuestionAnswer makeSubtraction (int number1, int number2, boolean bPositiveResult){
   QuestionAnswer qa =new QuestionAnswer();
   int r1=0, r2=0, result,temp;


 
     r1 = Helper.getRandomWithGivenDigits(number1);
     r2 = Helper.getRandomWithGivenDigits(number2);

      if (bPositiveResult) {
       if  (r1<r2) {
    	   temp=r1;
    	   r1=r2;
    	   r2=temp;
       }
     }
     
   result = r1-r2;

   String q = ""+r1 +" - " + r2 + " = ";
   String a = ""+ result;
   qa.setQuestion(q);
   qa.setVQuestion("<table width=100 border=0 class=wsquestion ><tr><td align=right>"
                   + Helper.convertLongIntToProperForm(r1 ) + "&nbsp;</td></tr><tr><td align=right> - &nbsp;&nbsp;"
                   +Helper.convertLongIntToProperForm(r2 )+"&nbsp;</td></tr><tr><td align=right><hr width=80%></td></tr>");
   qa.setAnswer(a);
   return qa;
  }

  public static void main(String[] args) {
	  makeSubtraction(3,2,true);
  }
}