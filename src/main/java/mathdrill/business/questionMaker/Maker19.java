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

public class Maker19 extends BaseMaker {

  public static VerticalQuestion makeQuestion(String var2,String var3,String var4, String var5){

    VerticalQuestion qa = null;
    int r1, r2, random;

     r1 = Helper.getRandomWithGivenDigits(Integer.parseInt(var2));
     r2 = Helper.getRandomWithGivenDigits(Integer.parseInt(var3));

     random = Helper.getRandom(1,2);
     if (random==1){
       qa = makeAddition(r1,r2);
     }
     else {
       qa = makeSubtraction(r1,r2);
     }

    return qa;
  }
  private static VerticalQuestion makeAddition (int r1, int r2){
    VerticalQuestion qa =new VerticalQuestion();
    String q= "<table width='100' border='0' class='wsquestion' ><tr><td align=right>"+ Helper.convertLongIntToProperForm(r1 )
                     + "&nbsp;</td></tr><tr><td align=right> +&nbsp;&nbsp;"+Helper.convertLongIntToProperForm(r2 )
                     +"&nbsp;</td></tr><tr><td align=right><hr width=80%></td></tr>";
     String a = ""+ (r1+r2);
     qa.setQuestion(q);
     qa.setAnswer(a);
     return qa;
  }


  private static VerticalQuestion makeSubtraction (int r1, int r2){
    VerticalQuestion qa =new VerticalQuestion();
    if (r1<r2){
      int t=r1;
      r1=r2;
      r2=t;
    }
    String q= "<table width='100' border='0' class='wsquestion' ><tr><td align=right>"+ Helper.convertLongIntToProperForm(r1 )
            + "&nbsp;</td></tr><tr><td align=right> -&nbsp;&nbsp;"+Helper.convertLongIntToProperForm(r2 )
            +"&nbsp;</td></tr><tr><td align=right><hr width=80%></td></tr>";

    String a = ""+ (r1-r2);
    qa.setQuestion(q);
    qa.setAnswer(a);
    return qa;
 }

}