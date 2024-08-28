package mathdrill;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mathdrill.business.question.BaseQuestion;
import mathdrill.business.questionMaker.BaseMaker;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class getMultipleChoiceWS extends HttpServlet {
  static final private String CONTENT_TYPE = "text/html";
  //Initialize global variables
  public void init() throws ServletException {
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  doPost(request,response);
  }
  //Process the HTTP Post request
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String nextJSP = "/worksheet_container.jsp";
    String persistData="wsCategory=multiplechoice&";
    HttpSession session = request.getSession();

    String partner = request.getParameter("partner");
    if (partner == null) {
    	partner = "";
      }
    session.setAttribute("partner", partner);
    
     String wsType = request.getParameter("wsType");
    if (wsType == null) {
      wsType = "";
    }
    persistData=persistData+"wsType="+wsType+"&";

    String qtperrow  = request.getParameter("qtperrow");
    if (qtperrow == null) {
      qtperrow = "1";
    }

    session.setAttribute("qtperrow",""+qtperrow);
    persistData=persistData+"qtperrow="+qtperrow+"&";

    
    String var1 = request.getParameter("numberofquestions");
    int numberofquestions=0;
    if (var1 == null) {
      var1 = "0";
    }
    try{
      numberofquestions=Integer.parseInt(var1);
    }
    catch (Exception e){
      numberofquestions =0;
    }

    //NOTE: NO MORE THAN 100 QUESTIONS ARE ALLOWED TO PROTECT OUR SERVER!
    if (numberofquestions>100) numberofquestions=100;
    persistData=persistData+"numberofquestions="+numberofquestions+"&";

    String var2 = request.getParameter("input1");
    if (var2 == null) {
      var2 = "";
    }
    persistData=persistData+"input1="+var2+"&";

    String var3 = request.getParameter("input2");
    if (var3 == null) {
      var3 = "";
    }
    persistData=persistData+"input2="+var3+"&";

    String var4 = request.getParameter("input3");
    if (var4 == null) {
      var4 = "";
    }
    persistData=persistData+"input3="+var4+"&";

    String var5 = request.getParameter("input4");
    if (var5 == null) {
      var5 = "";
    }
    persistData=persistData+"input4="+var5+"&";

    String var6 = request.getParameter("input5");
    if (var6 == null) {
      var6 = "";
    }
    persistData=persistData+"input5="+var6+"&";

    session.setAttribute("worksheetData",persistData);

    callingMaker(request, wsType, var2, var3, var4, var5,var6, numberofquestions);
    session.setAttribute("worksheetTemplate","worksheet_mc_new.jsp");

   response.setContentType(CONTENT_TYPE);
   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
   dispatcher.forward(request,response);
}

private void callingMaker (HttpServletRequest request, String wsType, String var2,String var3, String var4, String var5, String var6,int numberofquestions){
          HttpSession session=request.getSession();
          ArrayList qaList=new ArrayList();
          BaseQuestion question=null;

      try {
          for (int i=0;i<numberofquestions;i++){
              question= BaseMaker.makeQuestion(wsType, var2,var3,var4, var5,var6);

              question.makeHTML(i+1);
              qaList.add(question);
          }
      }
      catch (Exception e){
        //Attention , handle exception later

        System.out.println("Exception:"+e.getMessage());
      }
          session.setAttribute("qList",qaList);
}


  //Clean up resources
  public void destroy() {
  }
}