package mathdrill.business.question;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class UnitQuestion extends BaseQuestion {
	private String out_unit="";

	
	
	public String getOutUnit() {return out_unit;}
	public void setOutUnit(String newValue){out_unit=newValue;}

	
  public void makeHTML(int questionNumber){
     html = question+ makeInputTextTag(questionNumber) + out_unit + makeInputHiddenTag(questionNumber);
     setHTML(html);
   }


   private String makeInputTextTag(int questionNumber){
     //<input type='text' name='T1' size = '6'/>

     String name="T"+questionNumber;
     return "<input type='text' name='"+ name+ "' size = '6' style='text-align:right' /> ";
   }

   private String makeInputHiddenTag(int questionNumber){
     // <input type='text' name='H1' value='3641'  class='wsAnswer' size='6' style='display:none'>
     String name="H"+questionNumber;
     return "<input type='text' name='"+name+"' value='"+answer +"'  class='wsAnswer' size='6' style='text-align:right;display:none'>";

 }

}