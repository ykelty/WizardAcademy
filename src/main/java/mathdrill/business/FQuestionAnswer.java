package mathdrill.business;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */


public class FQuestionAnswer  extends QuestionAnswer{

  public FQuestionAnswer() {
  }

  public void makeHTML(int questionNumber){

     html = question + makeInputTextTag(questionNumber) + makeInputHiddenTag(questionNumber);
     setHTML(html);
   }

  private String makeInputTextTag(int questionNumber){
    //<input type='text' name='T1' size = '6'/>
     String name="T"+questionNumber;
      String nameB="TB"+questionNumber;
    return "<sup><input type='text' name='"+ name+ "' size = '1' style='text-align:right' /></sup>"
        +"/<sub><input type='text' name='"+ nameB+ "' size = '1' style='text-align:right' /></sub>";
  }

  private String makeInputHiddenTag(int questionNumber){
    // <input type='text' name='H1' value='3641'  class='wsAnswer' size='6' style='display:none'>
    String name="H"+questionNumber;
    String nameB="HB"+questionNumber;
    String idB="ID_"+nameB;
   // String answerdisplay="Q:"+answer+" &nbsp;&nbsp;R:"+answerB;

    return "<input type='text' name='"+name+ "' value='"+answer +"'  class='wsAnswer' size='1' style='display:none'>"
        +"<input type='text' name='"+nameB + "' id='"+idB+ "' value='"+answerB +"'  class='wsAnswer' size='1' style='display:none'>";
}
}