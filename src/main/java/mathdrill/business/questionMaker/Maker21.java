package mathdrill.business.questionMaker;
import mathdrill.business.question.*;
import java.util.*;

/**
 * <p>Title: </p>
 * <p>Description: Place Value 2 - Which place is 4 in 5324?</p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Maker21 extends BaseMaker {



  public static MultipleChoiceQuestion makeQuestion(String var2,String var3,String var4, String var5){

    MultipleChoiceQuestion qa =new MultipleChoiceQuestion();
   int n1=1,d1=1,n2=1,d2=1;
   String q ="";
   String a ="";
   
   //four digit number
   int numberUpTo = 4;
   
   System.out.println("New Question");
   //returns four digit number
   int number = construct(numberUpTo);
   
   System.out.println("Number created: " + number);
   
   int digitPlace = Helper.getRandom(1,numberUpTo);
   System.out.println("Digit place: " + digitPlace);
   
   int digitPlaceValue = (int)Math.pow(10,digitPlace-1);
   System.out.println("Digit place value: " + digitPlaceValue);
   
   //5678 to get value in its hundreds place (5678/100)- (5678/100)/10 * 10
   int digitNumber = (number/digitPlaceValue)-((number/digitPlaceValue)/10)*10;

   q = "What place is "+ digitNumber+ " in " +Helper.convertLongIntToProperForm(number)+ " ? (Ones, Tens, Hundreds, or Thousands)" ;
   ArrayList options = new ArrayList();
    if (numberUpTo==2){
      options.add("a. "+getDigitPlaceName(1));
      options.add("b. "+getDigitPlaceName(2));
      if (digitPlace==1)
        a= "Ones" ;
      else if (digitPlace==2)
        a= "Tens";
    }
    if (numberUpTo==3 ){
      options.add("a. "+getDigitPlaceName(1));
      options.add("b. "+getDigitPlaceName(2));
      options.add("c. "+getDigitPlaceName(3));
      if (digitPlace==1)
        a="Ones";
      else if (digitPlace==2)
        a="Tens";
      else if (digitPlace==3)
        a="Hundreds";
    }
    if (numberUpTo>3 ){
      if (digitPlace==1){
        options.add("a. "+getDigitPlaceName(1));
        options.add("b. "+getDigitPlaceName(2));
        options.add("c. "+getDigitPlaceName(3));
        a="Ones";
      }
      else if (digitPlace==2){
        options.add("a. "+getDigitPlaceName(1));
        options.add("b. "+getDigitPlaceName(2));
        options.add("c. "+getDigitPlaceName(3));
        a="Tens";
      }
      else {

        int optionSequence=Helper.getRandom(1,3);
        if (optionSequence==1){
          options.add("a. "+getDigitPlaceName(digitPlace));
          options.add("b. "+getDigitPlaceName(digitPlace+1));
          options.add("c. "+getDigitPlaceName(digitPlace+2));
          a= getDigitPlaceName(digitPlace);
        }
        else if (optionSequence==2){
          options.add("a. "+getDigitPlaceName(digitPlace-1));
          options.add("b. "+getDigitPlaceName(digitPlace));
          options.add("c. "+getDigitPlaceName(digitPlace+1));
          a=getDigitPlaceName(digitPlace);
        }
        else if (optionSequence==3){
            options.add("a. "+getDigitPlaceName(digitPlace-2));
            options.add("b. "+getDigitPlaceName(digitPlace-1));
            options.add("c. "+getDigitPlaceName(digitPlace));
            a=getDigitPlaceName(digitPlace);
        }
      }

    }
   qa.setOptions(options);

   qa.setQuestion(q);
   qa.setAnswer(a);
   return qa;
  }

private static ArrayList constructOptions(int numberUpTo, int digitPlace)
{
  ArrayList options = new ArrayList();
  if (numberUpTo==2){
    options.add("a. "+getDigitPlaceName(1));
    options.add("b. "+getDigitPlaceName(2));
  }
  if (numberUpTo==3){
    options.add("a. "+getDigitPlaceName(1));
    options.add("b. "+getDigitPlaceName(2));
    options.add("c. "+getDigitPlaceName(3));
  }
  if (numberUpTo>=3){
   options.add("a. "+getDigitPlaceName(digitPlace-1));
   options.add("b. "+getDigitPlaceName(digitPlace));
   options.add("c. "+getDigitPlaceName(digitPlace+1));
   options.add("d. "+getDigitPlaceName(digitPlace+2));
  }
  return options;
}

private static String getDigitPlaceName(int digitPlace){
  String sReturn ="Ones";
  switch (digitPlace){
     case 1: sReturn ="Ones"; break;
     case 2: sReturn ="Tens"; break;
     case 3: sReturn ="Hundreds"; break;
     case 4: sReturn ="Thousands"; break;
     case 5: sReturn ="Ten Thousands"; break;
     case 6: sReturn ="Hundred Thousands"; break;
     case 7: sReturn ="Millions"; break;
     case 8: sReturn ="Ten Millions"; break;
     case 9: sReturn ="Hundred Millions"; break;
     case 10: sReturn ="Billions"; break;
     case 11: sReturn ="Ten Billions"; break;
     case 12: sReturn ="Hundred Billions"; break;
  }
  return  sReturn;
}

private static int construct(int digitNumber){
  int iReturn=0;
  
  
  int seedRandom = Helper.getRandom(0,9);
  int temp = seedRandom;
  int method=Helper.getRandom(1,2); 

  System.out.println("Digit Number: " + digitNumber);
  //iterate 4 times
  for (int i=0;i<4;i++){
      temp=getNext3(temp, i);
      iReturn = iReturn + temp*(int)Math.pow(10,i);
      System.out.println("i: "+ i);
      System.out.println("iReturn:"+ iReturn);
  }
  
  return iReturn;
}
private static int getNext7(int i ){
   int ireturn ;
   ireturn = i+7;
   /*
   if (ireturn>=10){
     ireturn = ireturn - ireturn/10*10;
   }
   */
   return ireturn;
}

private static int getNext3(int a, int i){
 int ireturn;
 if(i == 3) {
	 
	 ireturn = Helper.getRandom(6,9);
 
 }else if (i == 2){
	 ireturn = Helper.getRandom(4, 5);
 }else if (i == 1) {
	 ireturn = Helper.getRandom(2, 3);
 }else {
	 ireturn = Helper.getRandom(0, 1);
 }
 
 return ireturn;
}

public static void main(String args[]) {

System.out.println(construct(6));


    }
}