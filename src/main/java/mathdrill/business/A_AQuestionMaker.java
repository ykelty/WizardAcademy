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

public class A_AQuestionMaker {
  static Random generator = new Random();

  public A_AQuestionMaker() {
  }


  public static QuestionAnswer makeAdditionSumUpTo (int number, String solveFor){
    QuestionAnswer qa =new QuestionAnswer();
    int r1=0, r2=0, sum=0;
    boolean done =false;
   String q;
   String a;
    while (!done){
      //we need to continue until find a question fits the criteria
      r1 = generator.nextInt(10);  // a random number between 0 to 9
      r2= generator.nextInt(10);  // a random number between 0 to 9
      sum = r1+r2;
      if (sum <=number)
        done = true;
    }

    if (solveFor.indexOf("empty")>=0){
      solveFor="&#91;&#93;";
    }

    if (Helper.getRandom(1,2)==1){
      q=solveFor+ " + " + r2 + " = " + sum+"<br>&nbsp;&nbsp;Solve for "+solveFor+" : ";
      a=""+r1;
    }
    else {
      q=""+r2 + " + "+solveFor+" = " + sum+"<br>&nbsp;&nbsp;Solve for "+solveFor+" : ";
      a = ""+r1;
    }

    qa.setQuestion(q);
    qa.setAnswer(a);
    return qa;
  }


  public static QuestionAnswer makeAdditionNoGrouping (int number1, int number2, String solveFor){
    QuestionAnswer qa =new QuestionAnswer();
    int r1=0, r2=0, sum,random1=0, random2=0;
    int tmp = number1;

    if (number2>number1){
      tmp=number2;   //assign tmp to the bigger of the two
    }

    for (int i=0;i<tmp;i++){
      r1 = generator.nextInt(10);  //random between 0 - 9
      r2 = generator.nextInt(10-r1);    //random number between 0 - (9-r1)

      if ((number1-1)>=i)
        random1= random1+ (int)Math.pow(10,i) * r1;
      if ((number2-1)>=i)
      random2= random2+ (int)Math.pow(10,i) * r2;
    }

    sum = random1+random2;

    String q, a;

       if (solveFor.indexOf("empty")>=0){
        solveFor="&#91;&#93;";
      }

      if (Helper.getRandom(1,2)==1){
        q=solveFor+ " + " + Helper.convertLongIntToProperForm(random2 ) + " = " + Helper.convertLongIntToProperForm(sum )
         +"<br>&nbsp;&nbsp;Solve for "+solveFor+" : ";
        a=""+random1;
      }
      else {
        q=""+Helper.convertLongIntToProperForm(random2 ) + " + "+solveFor+" = " + Helper.convertLongIntToProperForm(sum )
         +"<br>&nbsp;&nbsp;Solve for "+solveFor+" : ";
        a = ""+random1;
        }


    qa.setQuestion(q);
//    qa.setVQuestion("<table width=20px><tr><td alight=right>"+random1+"</td></tr><tr><td alight=right> + "+random2+"</td></tr><tr><td alight=right><hr></td></tr></table>");

    qa.setVQuestion("<table width=100 border=0 class=wsquestion ><tr><td align=right>"
                    + Helper.convertLongIntToProperForm(random1 ) + "&nbsp;</td></tr><tr><td align=right> +&nbsp;&nbsp;"
                    +Helper.convertLongIntToProperForm(random2 )+"&nbsp;</td></tr><tr><td align=right><hr width=80%></td></tr>");
    System.out.println(qa.getVQuestion());
    qa.setAnswer(a);
    return qa;
  }

  public static QuestionAnswer makeAddition (int number1, int number2, String solveFor){
   QuestionAnswer qa =new QuestionAnswer();
   int r1, r2, sum;

   r1 = Helper.getRandomWithGivenDigits(number1);
   r2 = Helper.getRandomWithGivenDigits(number2);
   sum = r1+r2;

   String q, a;

   if (solveFor.indexOf("empty")>=0){
    solveFor="&#91;&#93;";
  }

  if (Helper.getRandom(1,2)==1){
    q=solveFor+ " + " + Helper.convertLongIntToProperForm(r2 ) + " = " + Helper.convertLongIntToProperForm(sum )
     +"<br>&nbsp;&nbsp;Solve for "+solveFor+" : ";
    a=""+r1;
  }
  else {
    q=""+Helper.convertLongIntToProperForm(r2 ) + " + "+solveFor+" = " + Helper.convertLongIntToProperForm(sum )
     +"<br>&nbsp;&nbsp;Solve for "+solveFor+" : ";
    a = ""+r1;
    }

   qa.setQuestion(q);
   qa.setAnswer(a);
   return qa;
  }

  public static void main(String[] args) {
    for (int i=0;i<10;i++){
      AQuestionMaker.makeAdditionNoGrouping(3,4);
    }
  }
}