package mathdrill.business.questionMaker;
import mathdrill.business.question.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Maker20 extends BaseMaker {

  public static RegularQuestion makeQuestion(String var2,String var3,String var4, String var5){

    RegularQuestion qa = null;
    int r1, r2, random;

     r1 = Helper.getRandomWithGivenDigits(2);
     r2 = Helper.getRandomWithGivenDigits(2);

     random = Helper.getRandom(1,2);
     if (random==1){
       qa = makeMultiplication(r1,r2);
     }
     else {
       qa = makeDivision(r1,r2);
     }

    return qa;
  }
  private static VerticalQuestion makeMultiplication (int r1, int r2){
    VerticalQuestion qa =new VerticalQuestion();
    String q= Helper.convertLongIntToProperForm(r1)+ " x "+Helper.convertLongIntToProperForm(r2)
                     +" = ";
     String a = ""+ (r1*r2);
     qa.setQuestion(q);
     qa.setAnswer(a);
     return qa;
  }


  private static VDivisionQuestion makeDivision (int r1, int r2){
    VDivisionQuestion qa =new VDivisionQuestion();
    if (r1<r2){
      int t=r1;
      r1=r2;
      r2=t;
    }

    if (r1/r2<2){
      r2 = r2/2;
    }
    int divisor= r1/r2;
    r1 = r2 * divisor;

    String q= Helper.convertLongIntToProperForm(r1) + " divided by "  + Helper.convertLongIntToProperForm(divisor) +" = ";

    String a = ""+ r1/divisor;
    qa.setQuestion(q);
    qa.setAnswer(a);
    return qa;
 }

}