package mathdrill.business.question;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */


public class MakeChangeQuestion  extends BaseQuestion{

  private String answerDollar;
  private String answerQuarter;
  private String answerDime;
  private String answerNickel;
  private String answerPenny;

  public MakeChangeQuestion() {
  }

  public void setAnswerDollar (String newValue){answerDollar=newValue;}
  public String getAnswerDollar() {return answerDollar;}
  public void setAnswerQuarter (String newValue){answerQuarter=newValue;}
  public String getAnswerQuarter() {return answerQuarter;}
  public void setAnswerDime (String newValue){answerDime=newValue;}
  public String getAnswerDime() {return answerDime;}
  public void setAnswerNickel (String newValue){answerNickel=newValue;}
  public String getAnswerNickel() {return answerNickel;}
  public void setAnswerPenny (String newValue){answerPenny=newValue;}
  public String getAnswerPenny() {return answerPenny;}
  public void makeHTML(int questionNumber){

     html = question
        + "<table border=0> <tr><td> <img border='0' src='images/money/100cent.JPG'> </td>"
        + " <td> <img border='0' src='images/money/25cent.JPG'> </td>"
        + " <td> <img border='0' src='images/money/10cent.JPG'> </td>"
          + " <td> <img border='0' src='images/money/5cent.JPG'> </td>"
          + " <td> <img border='0' src='images/money/1cent.JPG'> </td></tr>"
        + "<tr><td>"+makeInputTextTagDollar(questionNumber)+ makeInputHiddenTagDollar(questionNumber) + "</td>"
          + "<td>"+makeInputTextTagQuarter(questionNumber)+ makeInputHiddenTagQuarter(questionNumber) + "</td>"
          + "<td>"+makeInputTextTagDime(questionNumber)+ makeInputHiddenTagDime(questionNumber) + "</td>"
          + "<td>"+makeInputTextTagNickel(questionNumber)+ makeInputHiddenTagNickel(questionNumber) + "</td>"
          + "<td>"+makeInputTextTagPenny(questionNumber)+ makeInputHiddenTagPenny(questionNumber) + "</td></tr></table>"
      +makeInputHiddenTag(questionNumber);


         setHTML(html);
   }

  private String makeInputTextTagDollar(int questionNumber){
    //<input type='text' name='Dollar1' size = '6'/>
     String name="Dollar"+questionNumber;
    return "<input type='text' name='"+ name+ "' size = '6' style='text-align:right' />";
  }
  private String makeInputTextTagQuarter(int questionNumber){
    //<input type='text' name='Dollar1' size = '6'/>
     String name="Quarter"+questionNumber;
    return "<input type='text' name='"+ name+ "' size = '6' style='text-align:right' />";
  }
  private String makeInputTextTagDime(int questionNumber){
    //<input type='text' name='Dollar1' size = '6'/>
     String name="Dime"+questionNumber;
    return "<input type='text' name='"+ name+ "' size = '6' style='text-align:right' />";
  }
  private String makeInputTextTagNickel(int questionNumber){
    //<input type='text' name='Dollar1' size = '6'/>
     String name="Nickel"+questionNumber;
    return "<input type='text' name='"+ name+ "' size = '6' style='text-align:right' />";
  }
  private String makeInputTextTagPenny(int questionNumber){
   //<input type='text' name='Dollar1' size = '6'/>
    String name="Penny"+questionNumber;
   return "<input type='text' name='"+ name+ "' size = '6' style='text-align:right' />";
  }

  private String makeInputHiddenTagDollar(int questionNumber){
    // <input type='text' name='HDollar1' value='31'  class='wsAnswer' size='6' style='display:none'>
    String nameDollar="HDollar"+questionNumber;
    String nameQuarter="HQuarter"+questionNumber;
    String nameDime="HDime"+questionNumber;
    String nameNickel="HNikel"+questionNumber;
    String namePenny="HPenny"+questionNumber;


    return "<input type='text' name='"+nameDollar+ "' value='"+answerDollar +"'  class='wsAnswer' size='6' style='display:none'>";
}
private String makeInputHiddenTagQuarter(int questionNumber){
  // <input type='text' name='HDollar1' value='31'  class='wsAnswer' size='6' style='display:none'>
  String nameDollar="HDollar"+questionNumber;
  String nameQuarter="HQuarter"+questionNumber;
  String nameDime="HDime"+questionNumber;
  String nameNickel="HNikel"+questionNumber;
  String namePenny="HPenny"+questionNumber;


  return "<input type='text' name='"+nameQuarter+ "' value='"+answerQuarter +"'  class='wsAnswer' size='6' style='display:none'>";
}
private String makeInputHiddenTagDime(int questionNumber){
  // <input type='text' name='HDollar1' value='31'  class='wsAnswer' size='6' style='display:none'>
  String nameDollar="HDollar"+questionNumber;
  String nameQuarter="HQuarter"+questionNumber;
  String nameDime="HDime"+questionNumber;
  String nameNickel="HNikel"+questionNumber;
  String namePenny="HPenny"+questionNumber;


  return "<input type='text' name='"+nameDime+ "' value='"+answerDime +"'  class='wsAnswer' size='6' style='display:none'>";
}
private String makeInputHiddenTagNickel(int questionNumber){
  // <input type='text' name='HDollar1' value='31'  class='wsAnswer' size='6' style='display:none'>
  String nameDollar="HDollar"+questionNumber;
  String nameQuarter="HQuarter"+questionNumber;
  String nameDime="HDime"+questionNumber;
  String nameNickel="HNickel"+questionNumber;
  String namePenny="HPenny"+questionNumber;


  return "<input type='text' name='"+nameNickel+ "' value='"+answerNickel +"'  class='wsAnswer' size='6' style='display:none'>";
}
private String makeInputHiddenTagPenny(int questionNumber){
  // <input type='text' name='HDollar1' value='31'  class='wsAnswer' size='6' style='display:none'>
  String nameDollar="HDollar"+questionNumber;
  String nameQuarter="HQuarter"+questionNumber;
  String nameDime="HDime"+questionNumber;
  String nameNickel="HNikel"+questionNumber;
  String namePenny="HPenny"+questionNumber;


  return "<input type='text' name='"+namePenny+ "' value='"+answerPenny +"'  class='wsAnswer' size='6' style='display:none'>";
}
private String makeInputHiddenTag(int questionNumber){
   // <input type='text' name='H1' value='3641'  class='wsAnswer' size='6' style='display:none'>
   String name="H"+questionNumber;
   return "<input type='text' name='"+name+"' value='"+answer +"'  class='wsAnswer' size='6' style='text-align:right;display:none'>";

 }
}