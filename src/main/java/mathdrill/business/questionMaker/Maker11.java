package mathdrill.business.questionMaker;
import mathdrill.business.question.*;
import mathdrill.business.questionMaker.util.*;
/**
 * <p>Title: Order Of Operation 1 </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author Li Kelty
 * @version 1.0
 */

public class Maker11 extends BaseMaker {

  public static RegularQuestion makeQuestion(String var2,String var3,String var4, String var5){
	int int1 = Helper.getRandom(1, 4);

    RegularQuestion qa =null;
    if (int1 == 3){
      qa=makeQuestionWith3Numbers();
     }
    else if (int1 == 4){
       //qa=makeQuestionWith4Numbers();
    	qa=makeQuestionWith3Numbers();
     }
    else{
      //qa=makeQuestionWith4Numbers();
    	qa=makeQuestionWith3Numbers();
    }

    String q=qa.getQuestion();

    qa.setQuestion(q+" = ");
    return qa;
  }


  public static RegularQuestion makeQuestionWith3Numbers(){

     RegularQuestion qa =null;
     String q="", a="";
     qa=compose();

     int s =Helper.getRandom(1,2);
     if (s==1){
        composeLeft(qa, true);
     }else if (s==2){
        composeRight(qa,true);
     }
     return qa;
   }

  public static RegularQuestion makeQuestionWith4Numbers(){

     RegularQuestion qa =null;
     String q="", a="";
     int count=0;
     qa=compose();
     System.out.println("TESTING: " + qa.getQuestion());
     count=count+2;
     int s=Helper.getRandom(1,3);
     if (s==1){
       qa = compose(qa,compose());
       count=count+2;
     }
     else if (s==2){
        composeLeft(qa,false);
        composeRight(qa,true);
        count=count+1;
     }
     else {
      composeRight(qa,false);
      composeRight(qa,true);
      count=count+1;
     }

     return qa;
   }

 private static RegularQuestion compose(){
   RegularQuestion qa = new RegularQuestion();
   int operation = Helper.getRandom(1,4);
   int n1= Helper.getRandom(1,9);
   int n2= Helper.getRandom(1,9);
   String q="",a="";
   int answer=0;
   if (operation==1){  //+
     answer = n1+n2;
     q= symbolLP()+ n1 + symbolA() + n2 + symbolRP();
   }
   if (operation==2){   //-

     if (n1 >= n2){
       if (n1==n2) n1++;    //we don't like 0 here
       q= symbolLP()+ n1 + symbolS() + n2 + symbolRP();
       answer = n1 - n2;
     }
     else if (n1<n2){
        q= symbolLP()+ n2 + symbolS() + n1 + symbolRP();
        answer = n2-n1;
     }
   }
   if (operation==3){   //*
     answer = n1*n2;
     q= n1 + symbolM() + n2;
    }
    if (operation==4){  ///
      n1 = n1* n2;
      answer = n1/n2;
      q= n1 + symbolM() + n2;
     }
  a = ""+answer;
  qa.setAnswer(a);
  qa.setQuestion(q);
  return qa;
 }
private static  void composeLeft( RegularQuestion qu, boolean lastStep){
  int operation = Helper.getRandom(1,3);
  int n2= Helper.getRandom(1,9);
  String q="",a="";
  int a1= Integer.parseInt(qu.getAnswer());
  String q1=qu.getQuestion();
  int answer=0;
  if (operation==1){  //+
    answer=n2+a1;
    if (lastStep){
      q = n2+symbolA()+ q1;
    }
    else {
      q = symbolLP()+ n2+symbolA()+ q1+symbolRP();
    }
   }
   if (operation==2){   //-
     n2 = a1+n2;
    answer=n2-a1;
    if (lastStep){
       q = n2+symbolS()+ q1;
    }
    else {
      q =symbolLP()+n2+symbolS()+ q1+symbolRP();
    }
   }
   else{   //*
     answer=n2*a1;
     q = ""+n2+symbolM()+ q1;
   }
    //if (operation==4){  ///
    //  n2 = n2 * a1;
    //  answer=n2/a1;
    //  q =  n2+symbolD()+q1;
    // }
   a=""+answer;
   qu.setQuestion(q);
   qu.setAnswer(a);
}

private static  void composeRight( RegularQuestion qu, boolean lastStep){
  int operation = Helper.getRandom(1,3);
  int n2= Helper.getRandom(1,9);
  String q="",a="";
  int a1= Integer.parseInt(qu.getAnswer());
  String q1=qu.getQuestion();
  int answer=0;
  if (operation==1){  //+
    answer=n2+a1;
    if (lastStep){
     q =q1+symbolA()+ n2;
    }
    else {
    	q =symbolLP()+q1+symbolA()+ n2+symbolRP();
    }
   }
   if (operation==2){   //-
     n2 = n2+a1;
    answer=n2-a1;
    if (lastStep){
       q = n2 +symbolS()+ q1;
    }
    else {
      q = symbolLP()+n2 +symbolS()+ q1+symbolRP();
    }
   }
   else{   //*
     answer=n2*a1;
     q = ""+q1+symbolM()+ n2;
   }
  // if (operation==4){   ///
  //   n2 = n2 * a1;
  //   answer=n2/a1;
  //   q = n2+symbolD()+ q1;
  //  }

   a=""+answer;
   qu.setQuestion(q);
   qu.setAnswer(a);
}

 private static RegularQuestion compose(RegularQuestion q1, RegularQuestion q2){
    RegularQuestion qa = new RegularQuestion();
    int operation = Helper.getRandom(1,4);
    int n1= Helper.getRandom(1,9);
    int n2= Helper.getRandom(1,9);
    int a1= Integer.parseInt(q1.getAnswer());
    int a2= Integer.parseInt(q2.getAnswer());
    String q="",a="";
    int answer=0;
    if (operation==1){  //+
      answer = a1 + a2;
      q=  q1.getQuestion() + symbolA() + q2.getQuestion() ;
    }
    if (operation==2){   //-
     if (a1>=a2){
      answer = a1 - a2;
      q=  q1.getQuestion() + symbolS() + q2.getQuestion() ;
     }
     else {
       answer = a2 - a1;
      q=  q2.getQuestion() + symbolS() + q1.getQuestion() ;
     }
    }
    if (operation==3){   //*
      answer = a1*a2;
      q= q1.getQuestion() + symbolM() + q2.getQuestion();
     }
     if (operation==4){  ///
        if (a2!=0 && a1/a2 * a2==a1){   //this is probably very rare
          answer = a1/a2;
          q= q1.getQuestion() + symbolM() + symbolLP()+ q2.getQuestion()+ symbolRP();
        }
        else {
          answer = a1*a2;
          q= q1.getQuestion() + symbolM() + q2.getQuestion();
        }
      }
   a = ""+answer;
   qa.setAnswer(a);
   qa.setQuestion(q);
   return qa;
 }
  private static String symbolA(){ return " + ";}
  private static String symbolS(){ return " - ";}
  private static String symbolM(){ return " * ";}
  private static String symbolLP(){ return "(";}
  private static String symbolRP(){ return ")";}

  public static void main(String[] args)
{
    for (int i = 0;i<20;i++){
   System.out.println(Maker11.makeQuestion("4","","","").toString());
    }
  }
}
