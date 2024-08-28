package mathdrill.business;
import java.util.ArrayList;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class NumberSenseQM {


public static QuestionAnswer rounding (int digits){
    QuestionAnswer qa =new QuestionAnswer();
    int r, r1, r2;
    String temp="", q ="";
    int number =0,a=0;

    r2=Helper.getRandom(2,digits);  //place number we are going to ask questions ones, tens, hundreds?
    for (int i=0;i<digits;i++){
      r1=Helper.getRandom(0,9);
      number = number+r1* (int)Math.pow(10,i);
    }

    a= (int)Math.pow(10,r2-1);
    a = (int)Math.floor((number+0.5*a )/a) * a;

   q= "Round " + Helper.convertLongIntToProperForm(number) +"  to the nearest "+getPlaceForRounding(r2)+ ". ";
   qa.setQuestion(q);
   qa.setAnswer(new Integer(a).toString());
   return qa;

}
public static QuestionAnswer placevalue1 (int digits){
  QuestionAnswer qa =new QuestionAnswer();
  int r, r1, r2;
  String temp="", q ="";
  int number =0,a=0;

  r2=Helper.getRandom(1,digits);  //place number we are going to ask questions ones, tens, hundreds?
  for (int i=0;i<digits;i++){
    r1=Helper.getRandom(0,9);
    number = number+r1* (int)Math.pow(10,i);
    if (i+1 == r2){
      a=r1;
    }
  }

 q= "Which digit is in the "+getPlace(r2)+ " place? "+Helper.convertLongIntToProperForm(number) +" ";
 qa.setQuestion(q);
 qa.setAnswer(new Integer(a).toString());
 return qa;

}

private static String getPlace(int digit){
    String rString="";
    switch (digit) {
             case 1:  rString="ONES"; break;
             case 2:  rString="TENS"; break;
             case 3:  rString="HUNDREDS"; break;
             case 4:  rString="THOUSANDS"; break;
             case 5:  rString="TEN-THOUSANDS"; break;
             case 6:  rString="HUNDRED-THOUSANDS "; break;
             case 7:  rString="MILLIONS"; break;
             case 8:  rString="TEN-MILLIONS"; break;
             case 9:  rString="HUNDRED-MILLIONS "; break;
             default: break;
         }
    return rString;

  }
  private static String getPlaceForRounding(int digit){
      String rString="";
      switch (digit) {
               case 1:  rString="one"; break;
               case 2:  rString="ten"; break;
               case 3:  rString="hundred"; break;
               case 4:  rString="thousand"; break;
               case 5:  rString="ten thousand"; break;
               case 6:  rString="hundred thousand"; break;
               case 7:  rString="million"; break;
               case 8:  rString="ten million"; break;
               case 9:  rString="hundred million"; break;
               default: break;
           }
      return rString;

  }
public static QuestionAnswer writeStandardForm (int digits){
 QuestionAnswer qa =new QuestionAnswer();
 int r, r1, r2;
 String temp="", q ="";
 int a =0;

for (int i=0;i<digits;i++){
  if (i==digits-1){
   r1=Helper.getRandom(1,9);
  }
  else {
    r1=Helper.getRandom(0,9);
  }
   if (r1>0){
     temp= r1+ " x "+ (int)Math.pow(10,i);
     a = a+r1* (int)Math.pow(10,i);
     if (!q.equals("")){
       q=temp+" + "+q;
     }
     else
       q= temp;
  }
}
 q=q+" = ";
 qa.setQuestion(q);
 qa.setAnswer(new Integer(a).toString());
 return qa;

}


}