package mathdrill.business;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company:  Noetic Learning LLC</p>
 * @author Li Kelty
 * @version 1.0
 */

public class QuestionAnswer {

  protected String question;
  protected String vQuestion;
  protected String answer;
  protected String answerB;
  protected String html;

  public QuestionAnswer() {
  }
  public String getQuestion() {return question;}
   public void setQuestion (String newValue){question=newValue;}
   public String getVQuestion() {return vQuestion;}
    public void setVQuestion (String newValue){vQuestion=newValue;}

  public void setAnswer (String newValue){answer=newValue;}
  public String getAnswer() {return answer;}
  public void setAnswerB (String newValue){answerB=newValue;}
  public String getAnswerB() {return answerB;}

  public String getHTML() {return html;}
  public void setHTML (String newValue){html=newValue;}

  public void makeHTML(int questionNumber){
    // 5 + 3 = <input type='text' name='T1' size = '6'/>
   // <input type="text" name="H1" value="3641"  class='wsAnswer' size="6" style="display:none">

    html = question + makeInputTextTag(questionNumber) + makeInputHiddenTag(questionNumber);
    setHTML(html);
  }


   public void makeVHTML(int questionNumber){
     // 5 + 3 = <input type='text' name='T1' size = '6'/>
    // <input type="text" name="H1" value="3641"  class='wsAnswer' size="6" style="display:none">

     html = vQuestion + "<tr><td align=right>"+ makeInputTextTag(questionNumber) + makeInputHiddenTag(questionNumber) + "</td></tr></table>";
     setHTML(html);
  }
  private String makeInputTextTag(int questionNumber){
    //<input type='text' name='T1' size = '6'/>

    String name="T"+questionNumber;
    return "<input type='text' name='"+ name+ "' size = '6' style='text-align:right'  />";
  }

  private String makeInputHiddenTag(int questionNumber){
    // <input type='text' name='H1' value='3641'  class='wsAnswer' size='6' style='display:none'>
    String name="H"+questionNumber;
    return "<input type='text' name='"+name+"' value='"+answer +"'  class='wsAnswer' size='6' style='text-align:right;display:none'>";

}

  public String toString(){
    return "  Q:"+question+" - A:"+answer;
  }
  public static void main(String[] args) {
    QuestionAnswer questionAnswer1 = new QuestionAnswer();
  }
}