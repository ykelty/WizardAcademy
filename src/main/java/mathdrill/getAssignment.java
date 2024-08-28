 package mathdrill;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mathdrill.user.Assignment;
import mathdrill.user.User;
import mathdrill.user.UserManager;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class getAssignment extends HttpServlet {
  static final private String CONTENT_TYPE = "text/html";
  //Initialize global variables
  public void init() throws ServletException {
  }
  //Process the HTTP Get request
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   String nextJSP = "/getworksheet?";
   HttpSession session = request.getSession();
   String message = "";
   User user=null;
   String worksheetData=null;
   String assignmentName=null;
   Assignment assignment = null;

   String userName = request.getParameter("user");
   if (userName == null) {
     userName = "";
   }

   try {
     user=UserManager.getUserByName(userName);
   }
   catch (Exception e){
     message="Cannot find user:"+userName+" in the system. Please check your link or contact the person who passes you the link.";
     user=null;
   }

   try {
     if (user!=null){
       assignment=UserManager.getUserAssignment(user.getUserId());
       worksheetData=assignment.getWorksheetData();
       if (worksheetData.indexOf("wsCategory=multiplechoice")>=0)
         nextJSP=  "/getmultiplechoicews?";
       assignmentName = assignment.getAssignmentName();
       nextJSP=nextJSP+worksheetData;
     }
   }
   catch (Exception e){
     message=e.getMessage();
   }


    session.setAttribute("ERROR_MSG",message);
    session.setAttribute("ASSIGNMENT_NAME",assignmentName);
    session.setAttribute("IS_ASSIGNMENT","TRUE");
    response.setContentType(CONTENT_TYPE);
    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
    dispatcher.forward(request,response);
  }
  //Clean up resources
  public void destroy() {
  }
}