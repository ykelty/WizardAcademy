package mathdrill.business.question;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class VDivisionQuestion extends RegularQuestion {

  public void makeHTML(int questionNumber){
    html ="<table border='0' cellpadding='0' cellspacing='0'>"
        + "<tr><td><img border='0' src='images/clear.gif' width='1' height='2' align='top'></td><td colspan='2'>"
         +makeInputTextTag(questionNumber)+ makeInputHiddenTag(questionNumber)
         + "</td></tr><tr><td><img border='0' src='images/clear.gif' width='1' height='2' align='top'></td><td colspan='2' valign='top'>"
         + "<img border='0' src='images/div.gif' width='100%' height='2' align='top'></td></tr>" + question
         + "</table>";

     setHTML(html);
  }
  private String makeInputTextTag(int questionNumber){
    //<input type='text' name='T1' size = '6'/>

    String name="T"+questionNumber;
    return "<input type='text' name='"+ name+ "' size = '6' style='text-align:left'  />";
  }

  private String makeInputHiddenTag(int questionNumber){
    // <input type='text' name='H1' value='3641'  class='wsAnswer' size='6' style='display:none'>
    String name="H"+questionNumber;
    return "<input type='text' name='"+name+"' value='"+answer +"'  class='wsAnswer' size='6' style='text-align:left;display:none'>";

  }

}