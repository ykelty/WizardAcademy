package mathdrill.business.question;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class TellingTimeQuestion extends BaseQuestion {

  public void makeHTML(int questionNumber){

     html = question + makeInputTextTag(questionNumber) + makeInputHiddenTag(questionNumber);
     setHTML(html);
   }


   private String makeInputTextTag(int questionNumber){
     //<input type='text' name='T1' size = '6'/>

     String name="T"+questionNumber;
     String nameB="TB"+questionNumber;
     return "<input type='text' name='"+ name+ "' size = '2' style='text-align:right'  />" + ":"+
         "<input type='text' name='"+ nameB+ "' size = '2' style='text-align:right'  />";
   }


   private String makeInputHiddenTag(int questionNumber){
     // <input type='text' name='H1' value='3641'  class='wsAnswer' size='6' style='display:none'>
     String name="H"+questionNumber;
     String nameB="HB"+questionNumber;
     String idB="ID_"+nameB;
     String inputHiddenTag =  "<input type='text' name='"+name+"' value='"+answer +"'  class='wsAnswer' size='2' style='text-align:right;display:none'>"
       + "<input type='text' name='"+nameB + "' id='"+idB+ "' value='"+answerB +"'  class='wsAnswer' size='2' style='text-align:right;display:none'>";

     return inputHiddenTag;
 }


}