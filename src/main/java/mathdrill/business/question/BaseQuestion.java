package mathdrill.business.question;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

abstract public class BaseQuestion {
  protected String question;
  protected String vQuestion;
  protected String answer;
  protected String answerB;
  protected String html;

   public BaseQuestion() {
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
  abstract public void makeHTML(int questionNumber);
  public void makeVHTML(int questionNumber){int j  = questionNumber;}
  public String toString(){
    return "  Q:"+question+" - A:"+answer;
  }

}