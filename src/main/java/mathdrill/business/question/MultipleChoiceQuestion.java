package mathdrill.business.question;
import java.util.ArrayList;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class MultipleChoiceQuestion extends BaseQuestion {

  ArrayList options;
  public ArrayList getOptions() {return options;}
  public void setOptions(ArrayList newValue){options=newValue;}
  public void makeHTML(int questionNumber){
    // 5 + 3 = <input type='text' name='T1' size = '6'/>
   // <input type="text" name="H1" value="3641"  class='wsAnswer' size="6" style="display:none">

    html = question +"<br>" +makeOptionTag(questionNumber) + makeInputHiddenTag(questionNumber) +"<br><br>";
    setHTML(html);
  }
  private String makeOptionTag(int questionNumber){
    //<input type='text' name='T1' size = '6'/>

    String questionName="T"+questionNumber;
    String optionsString="";
    String optionValue="";
    String option;
    for (int i=0;i<options.size();i++){
      option=(String)options.get(i);
      optionsString =optionsString+  "<input type='radio' name='"+questionName+"' value='"+getOptionValue(i)+"' >"+option+"&nbsp;&nbsp;&nbsp;";
    }
    return optionsString;
  }

  private String makeInputHiddenTag(int questionNumber){
     // <input type='text' name='H1' value='3641'  class='wsAnswer' size='6' style='display:none'>
     String name="H"+questionNumber;
     return "<input type='text' name='"+name+"' value='"+answer +"'  class='wsAnswer' size='6' style='text-align:right;display:none'>";

}
  private String getOptionValue(int number){
    String rString="";
    switch (number) {
             case 0:  rString="a"; break;
             case 1:  rString="b"; break;
             case 2:  rString="c"; break;
             case 3:  rString="d"; break;
             default: break;
         }
    return rString;

  }

}