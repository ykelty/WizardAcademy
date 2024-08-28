package com.mathking;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import mathdrill.business.AQuestionMaker;
import mathdrill.business.A_AQuestionMaker;
import mathdrill.business.DQuestionMaker;
import mathdrill.business.D_AQuestionMaker;
import mathdrill.business.FQuestionMaker;
import mathdrill.business.MQuestionMaker;
import mathdrill.business.M_AQuestionMaker;
import mathdrill.business.MoneyMaker;
import mathdrill.business.NumberSenseQM;
import mathdrill.business.QuestionAnswer;
import mathdrill.business.SQuestionMaker;
import mathdrill.business.S_AQuestionMaker;
import mathdrill.business.question.BaseQuestion;
import mathdrill.business.questionMaker.BaseMaker;

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2007
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author unascribed
 * @version 1.0
 */

public class getWorksheet extends HttpServlet {
	static final private String CONTENT_TYPE = "application/json";

	// Initialize global variables
	public void init() throws ServletException {
	}

	// Process the HTTP Post request
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	// Process the HTTP Post request
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextJSP = "/worksheet_container.jsp";
		String worksheetTemplate = "worksheet.jsp";
		String persistData = "wsCategory=regular&";
		HttpSession session = request.getSession();
		System.out.println("persistData=" + persistData);
		BaseQuestion theQuestion;
		

		String partner = request.getParameter("partner");
		if (partner == null) {
			partner = "";
		}
		session.setAttribute("partner", partner);

		String wsType = request.getParameter("wsType");
		if (wsType == null) {
			wsType = "";
		}
		persistData = persistData + "wsType=" + wsType + "&";

		String var1 = request.getParameter("numberofquestions");
		int numberofquestions = 0;
		if (var1 == null) {
			var1 = "0";
		}
		try {
			numberofquestions = Integer.parseInt(var1);
		} catch (Exception e) {
			numberofquestions = 0;
		}
		// NOTE: NO MORE THAN 100 QUESTIONS ARE ALLOWED TO PROTECT OUR SERVER!
		if (numberofquestions > 100)
			numberofquestions = 100;
		persistData = persistData + "numberofquestions=" + numberofquestions
				+ "&";

		String qtperrow = request.getParameter("qtperrow");
		if (qtperrow == null) {
			qtperrow = "1";
		}

		session.setAttribute("qtperrow", "" + qtperrow);
		persistData = persistData + "qtperrow=" + qtperrow + "&";

		String var2 = request.getParameter("input1");
		System.out.println("var2: " + var2);
		if (var2 == null) {
			var2 = "";
		}
		persistData = persistData + "input1=" + var2 + "&";

		String var3 = request.getParameter("input2");
		System.out.println("SHOULD BE MIXED: " + var3);
		if (var3 == null) {
			var3 = "";
		}
		persistData = persistData + "input2=" + var3 + "&";

		String var4 = request.getParameter("input3");
		if (var4 == null) {
			var4 = "";
		}
		persistData = persistData + "input3=" + var4 + "&";

		String var5 = request.getParameter("input4");
		if (var5 == null) {
			var5 = "";
		}
		persistData = persistData + "input4=" + var5 + "&";

		String var6 = request.getParameter("input5");
		if (var6 == null) {
			var6 = "";
		}
		persistData = persistData + "input5=" + var6 + "&";

		session.setAttribute("worksheetData", persistData);
		
		theQuestion = callingMaker(request, wsType, var2, var3, var4, var5, var6,
				numberofquestions);

		if (wsType.equals("multiplicationfactByNumber")) {
			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);
			getMultiplicationfactByNumber(request, var2, var3, var4,
					numberofquestions);
		} else if (wsType.equals("multiplicationfactByRange")) {
			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);
			getMultiplicationfactByRange(request, var2, var3, var4, var5,
					numberofquestions);
		} else if (wsType.equals("multiplication")) {
			getMultiplication(request, var2, var3, var4, var5,
					numberofquestions);
			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);

		} else if (wsType.equals("additionUpTo")) {
			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);

			getAdditionSumUpTo(request, var2, var3, var4, numberofquestions);
		} else if (wsType.equals("addition")) {
			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);

			getAddition(request, var2, var3, var4, var5, numberofquestions);
		} else if (wsType.equals("additionNoGrouping")) {
			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);
			getAdditionNoGrouping(request, var2, var3, var4, var5,
					numberofquestions);
		} else if (wsType.equals("subtractionUpTo")) {
			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);
			getSubtractionUpTo(request, var2, var3, var4, numberofquestions);
		} else if (wsType.equals("subtraction")) {
			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);
			getSubtraction(request, var2, var3, var4, var5, var6,
					numberofquestions);
		} else if (wsType.equals("subtractionNoGrouping")) {
			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);
			getSubtractionNoGrouping(request, var2, var3, var4, var5,
					numberofquestions);
		} else if (wsType.equals("divisionfactByNumber")) {
			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);
			getDivisionfactByNumber(request, var2, var3, var4,
					numberofquestions);
		} else if (wsType.equals("divisionfactByRange")) {
			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);
			getDivisionfactByRange(request, var2, var3, var4, var5,
					numberofquestions);
		} else if (wsType.equals("division")) {
			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);

			getDivision(request, var2, var3, var4, numberofquestions);
		} else if (wsType.equals("moneyAddition")) {

			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);
			getMoneyAddition(request, var2, var3, numberofquestions);
		} else if (wsType.equals("moneySubtraction")) {
			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);
			getMoneySubtraction(request, var2, var3, numberofquestions);
		} else if (wsType.equals("moneyMultiplication")) {
			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);
			getMoneyMultiplication(request, var2, var3, numberofquestions);
		} else if (wsType.equals("moneyDivision")) {
			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);
			getMoneyDivision(request, var2, var3, numberofquestions);
		}

		else if (wsType.equals("findGCF")) {
			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);

			// var2 is a placeholder, it is not being used here
			findGCF(request, var2, numberofquestions);
		} else if (wsType.equals("findLCM")) {
			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);

			// var2 is a placeholder, it is not being used here
			findLCM(request, var2, numberofquestions);
		}

		else if (wsType.equals("reduceFraction")) {
			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);

			// var2 is a placeholder, it is not being used here
			reduceFraction(request, var2, numberofquestions);
		} else if (wsType.equals("writeStandardForm")) {
			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);
			// var2 is a placeholder, it is not being used here
			writeStandardForm(request, var2, numberofquestions);
		}

		else if (wsType.equals("placevalue1")) {
			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);
			// var2 is a placeholder, it is not being used here
			placevalue1(request, var2, numberofquestions);
		} else if (wsType.equals("rounding")) {
			// legacy ones needs to rewrite to use callingMaker(request, wsType,
			// var2, var3, var4, var5,var6, numberofquestions);
			// var2 is a placeholder, it is not being used here
			rounding(request, var2, numberofquestions);
		} else if (wsType.equals("worksheet2")) {
			// legacy ones needs to rewrite to use getMultipleChoiceWS;
			// var2 is a placeholder, it is not being used here
			worksheetTemplate = "worksheet_mc_new.jsp";
			callingMaker(request, wsType, var2, var3, var4, var5, var6,
					numberofquestions);
		} else if (wsType.equals("worksheet26")) {
			// This one is a little different, it is Make Change worksheet, we
			// need to use a different return jsp
			worksheetTemplate = "worksheet_make_change.jsp";
			callingMaker(request, wsType, var2, var3, var4, var5, var6,
					numberofquestions);
		} else {
			// var2 is a placeholder, it is not being used here
			worksheetTemplate = "worksheet_new.jsp";
			System.out.println(var2);
			System.out.println(var4);
			System.out.println(var6);
			
			
			theQuestion = callingMaker(request, wsType, var2, var3, var4, var5, var6,
					numberofquestions);
		}
		response.setContentType(CONTENT_TYPE);

		session.setAttribute("worksheetTemplate", worksheetTemplate);
		String questionText = theQuestion.getQuestion();
		String answerText = theQuestion.getAnswer();
		
		ResponseObject responseObject = new ResponseObject();
		responseObject.setQuestionText(questionText);
        responseObject.setAnswerText(answerText);
		
		Gson gson = new Gson();
        String jsonResponse = gson.toJson(responseObject);
        
        
		response.getWriter().write(jsonResponse);
		
		//RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		//dispatcher.forward(request, response);

	}
	
	static class ResponseObject {
        private String questionText;
        private String answerText;

        public void setQuestionText(String questionText) {
            this.questionText = questionText;
        }

        public void setAnswerText(String answerText) {
            this.answerText = answerText;
        }

        public String getQuestionText() {
            return questionText;
        }

        public String getAnswerText() {
            return answerText;
        }
    }

	private void getSubtractionNoGrouping(HttpServletRequest request,
			String number1, String number2, String algebraflag,
			String solveFor, int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		int n1 = 0, n2 = 0;
		boolean bAlgebra = false;

		if (algebraflag.equalsIgnoreCase("on")) {
			bAlgebra = true;
		}

		try {
			n1 = Integer.parseInt(number1);
			n2 = Integer.parseInt(number2);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG",
					"Invalid Request: Mulitplication Fact.");
		}

		for (int i = 0; i < numberofquestions; i++) {
			if (bAlgebra) {
				qa = S_AQuestionMaker.makeSubtractionNoGrouping(n1, n2,
						solveFor);
				qa.makeHTML(i + 1);
			} else {

				qa = SQuestionMaker.makeSubtractionNoGrouping(n1, n2);
				qa.makeVHTML(i + 1);
				qa.setHTML(qa.getHTML());
			}
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private void getSubtraction(HttpServletRequest request, String number1,
			String number2, String positiveResult, String algebraflag,
			String solveFor, int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		boolean bPositiveResult = false;
		int n1 = 0, n2 = 0;
		if (positiveResult.equalsIgnoreCase("on")) {
			bPositiveResult = true;
		}
		boolean bAlgebra = false;

		if (algebraflag.equalsIgnoreCase("on")) {
			bAlgebra = true;
		}

		try {
			n1 = Integer.parseInt(number1);
			n2 = Integer.parseInt(number2);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG",
					"Invalid Request: Mulitplication Fact.");
		}

		for (int i = 0; i < numberofquestions; i++) {

			if (bAlgebra) {
				qa = S_AQuestionMaker.makeSubtraction(n1, n2, bPositiveResult,
						solveFor);
				qa.makeHTML(i + 1);
			} else {
				qa = SQuestionMaker.makeSubtraction(n1, n2, bPositiveResult);
				qa.makeVHTML(i + 1);
				qa.setHTML(qa.getHTML());
			}
			// qa.makeHTML(i+1);
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private void getSubtractionUpTo(HttpServletRequest request, String fact,
			String algebraflag, String solveFor, int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		int requestedFact = 0;
		boolean bAlgebra = false;

		if (algebraflag.equalsIgnoreCase("on")) {
			bAlgebra = true;
		}

		try {
			requestedFact = Integer.parseInt(fact);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG",
					"Invalid Request: Mulitplication Fact.");
		}

		for (int i = 0; i < numberofquestions; i++) {
			if (bAlgebra) {
				qa = S_AQuestionMaker.makeSubtractionUpTo(requestedFact,
						solveFor);
			} else {
				qa = SQuestionMaker.makeSubtractionUpTo(requestedFact);
			}
			qa.makeHTML(i + 1);
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private void getAdditionNoGrouping(HttpServletRequest request,
			String number1, String number2, String algebraflag,
			String solveFor, int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		int n1 = 0, n2 = 0;
		boolean bAlgebra = false;

		if (algebraflag.equalsIgnoreCase("on")) {
			bAlgebra = true;
		}

		try {
			n1 = Integer.parseInt(number1);
			n2 = Integer.parseInt(number2);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG",
					"Invalid Request: Mulitplication Fact.");
		}

		for (int i = 0; i < numberofquestions; i++) {

			if (bAlgebra) {
				qa = A_AQuestionMaker.makeAdditionNoGrouping(n1, n2, solveFor);
				qa.makeHTML(i + 1);
			} else {
				qa = AQuestionMaker.makeAdditionNoGrouping(n1, n2);
				qa.makeVHTML(i + 1);
				qa.setHTML(qa.getHTML());
			}
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private void getAddition(HttpServletRequest request, String number1,
			String number2, String algebraflag, String solveFor,
			int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		int n1 = 0, n2 = 0;
		boolean bAlgebra = false;

		if (algebraflag.equalsIgnoreCase("on")) {
			bAlgebra = true;
		}

		try {
			n1 = Integer.parseInt(number1);
			n2 = Integer.parseInt(number2);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG",
					"Invalid Request: Mulitplication Fact.");
		}

		for (int i = 0; i < numberofquestions; i++) {
			if (bAlgebra) {
				qa = A_AQuestionMaker.makeAddition(n1, n2, solveFor);
				qa.makeHTML(i + 1);
			} else {
				qa = AQuestionMaker.makeAddition(n1, n2);
				qa.makeVHTML(i + 1);
				qa.setHTML(qa.getHTML());
			}
			// qa.makeHTML(i+1);
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private void getAdditionSumUpTo(HttpServletRequest request, String fact,
			String algebraflag, String solveFor, int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		int requestedFact = 0;
		boolean bAlgebra = false;

		if (algebraflag.equalsIgnoreCase("on")) {
			bAlgebra = true;
		}

		try {
			requestedFact = Integer.parseInt(fact);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG",
					"Invalid Request: Mulitplication Fact.");
		}

		for (int i = 0; i < numberofquestions; i++) {
			if (bAlgebra) {
				qa = A_AQuestionMaker.makeAdditionSumUpTo(requestedFact,
						solveFor);
			} else {
				qa = AQuestionMaker.makeAdditionSumUpTo(requestedFact);
			}
			qa.makeHTML(i + 1);
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private void getMultiplicationfactByNumber(HttpServletRequest request,
			String fact, String algebraflag, String solveFor,
			int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		boolean bAlgebra = false;

		if (algebraflag.equalsIgnoreCase("on")) {
			bAlgebra = true;
		}

		int requestedFact = 0;
		try {
			requestedFact = Integer.parseInt(fact);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG",
					"Invalid Request: Mulitplication Fact.");
		}

		for (int i = 0; i < numberofquestions; i++) {
			if (bAlgebra) {
				qa = M_AQuestionMaker.makeMultiplicationFactByNumber(
						requestedFact, solveFor);
			} else {
				qa = MQuestionMaker
						.makeMultiplicationFactByNumber(requestedFact);
			}
			qa.makeHTML(i + 1);
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private void getMultiplicationfactByRange(HttpServletRequest request,
			String fact1, String fact2, String algebraflag, String solveFor,
			int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		boolean bAlgebra = false;

		if (algebraflag.equalsIgnoreCase("on")) {
			bAlgebra = true;
		}

		int iFact1 = 0, iFact2 = 0;
		try {
			iFact1 = Integer.parseInt(fact1);
			iFact2 = Integer.parseInt(fact2);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG",
					"Invalid Request: Mulitplication Fact.");
		}

		for (int i = 0; i < numberofquestions; i++) {
			if (bAlgebra) {
				qa = M_AQuestionMaker.makeMultiplicationFactByRange(iFact1,
						iFact2, solveFor);
			} else {
				qa = MQuestionMaker.makeMultiplicationFactByRange(iFact1,
						iFact2);
			}
			qa.makeHTML(i + 1);
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private void getMultiplication(HttpServletRequest request, String number1,
			String number2, String algebraflag, String solveFor,
			int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		int n1 = 0, n2 = 0;
		boolean bAlgebra = false;

		if (algebraflag.equalsIgnoreCase("on")) {
			bAlgebra = true;
		}

		try {
			n1 = Integer.parseInt(number1);
			n2 = Integer.parseInt(number2);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG",
					"Invalid Request: Mulitplication Fact.");
		}

		for (int i = 0; i < numberofquestions; i++) {
			if (bAlgebra) {
				qa = M_AQuestionMaker.makeMultiplication(n1, n2, solveFor);
			} else {
				qa = MQuestionMaker.makeMultiplication(n1, n2);
			}
			// for now, I will still go with horizontal for multiplication , so
			// you won't get confused
			qa.makeHTML(i + 1);
			// qa.makeVHTML(i+1);
			// qa.setHTML(qa.getHTML());
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private void getDivisionfactByNumber(HttpServletRequest request,
			String fact, String algebraflag, String solveFor,
			int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		int requestedFact = 0;
		boolean bAlgebra = false;

		if (algebraflag.equalsIgnoreCase("on")) {
			bAlgebra = true;
		}

		try {
			requestedFact = Integer.parseInt(fact);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG",
					"Invalid Request: Mulitplication Fact.");
		}

		for (int i = 0; i < numberofquestions; i++) {
			if (bAlgebra) {
				qa = D_AQuestionMaker.makeDivisionFactByNumber(requestedFact,
						solveFor);
			} else {
				qa = DQuestionMaker.makeDivisionFactByNumber(requestedFact);
			}
			qa.makeHTML(i + 1);
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private void getDivisionfactByRange(HttpServletRequest request,
			String fact1, String fact2, String algebraflag, String solveFor,
			int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		boolean bAlgebra = false;

		if (algebraflag.equalsIgnoreCase("on")) {
			bAlgebra = true;
		}

		int iFact1 = 0, iFact2 = 0;
		try {
			iFact1 = Integer.parseInt(fact1);
			iFact2 = Integer.parseInt(fact2);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG",
					"Invalid Request: Mulitplication Fact.");
		}

		for (int i = 0; i < numberofquestions; i++) {
			if (bAlgebra) {
				qa = D_AQuestionMaker.makeDivisionFactByRange(iFact1, iFact2,
						solveFor);
			} else {
				qa = DQuestionMaker.makeDivisionFactByRange(iFact1, iFact2);
			}
			qa.makeHTML(i + 1);
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private void getDivision(HttpServletRequest request, String number1,
			String number2, String hasRemainder, int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		int n1 = 0, n2 = 0;
		boolean bHasRemainder = false;

		if (hasRemainder.equalsIgnoreCase("on")) {
			bHasRemainder = true;
		}

		try {
			n1 = Integer.parseInt(number1);
			n2 = Integer.parseInt(number2);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG",
					"Invalid Request: Mulitplication Fact.");
		}

		for (int i = 0; i < numberofquestions; i++) {
			qa = DQuestionMaker.makeDivision(n1, n2, bHasRemainder);

			// horizontal for division
			qa.makeHTML(i + 1);
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private void getMoneyAddition(HttpServletRequest request,
			String moneyAmount, String increments, int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		int amount = 0, increment = 0;

		try {
			amount = Integer.parseInt(moneyAmount);
			increment = Integer.parseInt(increments);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG", "Invalid Input.");
		}

		for (int i = 0; i < numberofquestions; i++) {
			qa = MoneyMaker.makeAddition(amount, increment);

			qa.makeHTML(i + 1);
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private void getMoneySubtraction(HttpServletRequest request,
			String moneyAmount, String increments, int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		int amount = 0, increment = 0;

		try {
			amount = Integer.parseInt(moneyAmount);
			increment = Integer.parseInt(increments);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG", "Invalid Input.");
		}

		for (int i = 0; i < numberofquestions; i++) {
			qa = MoneyMaker.makeSubtraction(amount, increment);

			qa.makeHTML(i + 1);
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private void getMoneyMultiplication(HttpServletRequest request,
			String moneyAmount, String number_digits, int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		int amount = 0, digits = 0;

		try {
			amount = Integer.parseInt(moneyAmount);
			digits = Integer.parseInt(number_digits);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG", "Invalid Input.");
		}

		for (int i = 0; i < numberofquestions; i++) {
			qa = MoneyMaker.makeMultiplication(amount, digits);

			qa.makeHTML(i + 1);
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private void getMoneyDivision(HttpServletRequest request,
			String moneyAmount, String number_digits, int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		int amount = 0, digits = 0;

		try {
			amount = Integer.parseInt(moneyAmount);
			digits = Integer.parseInt(number_digits);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG", "Invalid Input.");
		}

		for (int i = 0; i < numberofquestions; i++) {
			qa = MoneyMaker.makeDivision(amount, digits);

			qa.makeHTML(i + 1);
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private void findGCF(HttpServletRequest request, String number,
			int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		int n = 0;
		boolean bAlgebra = false;
		try {
			n = Integer.parseInt(number);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG",
					"Invalid Request: Mulitplication Fact.");
		}

		for (int i = 0; i < numberofquestions; i++) {
			qa = FQuestionMaker.findGCF();

			qa.makeHTML(i + 1);
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private void findLCM(HttpServletRequest request, String number,
			int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		int n = 0;
		boolean bAlgebra = false;
		try {
			n = Integer.parseInt(number);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG",
					"Invalid Request: Mulitplication Fact.");
		}

		for (int i = 0; i < numberofquestions; i++) {
			qa = FQuestionMaker.findLCM();

			qa.makeHTML(i + 1);
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private void reduceFraction(HttpServletRequest request, String number,
			int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		int n = 0;
		boolean bAlgebra = false;
		try {
			n = Integer.parseInt(number);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG",
					"Invalid Request: Mulitplication Fact.");
		}

		for (int i = 0; i < numberofquestions; i++) {
			qa = FQuestionMaker.reduceFraction();

			qa.makeHTML(i + 1);
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private void writeStandardForm(HttpServletRequest request, String number,
			int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		int n = 0;
		try {
			n = Integer.parseInt(number);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG", "Invalid input :" + number);
		}

		for (int i = 0; i < numberofquestions; i++) {
			qa = NumberSenseQM.writeStandardForm(n);

			qa.makeHTML(i + 1);
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private void placevalue1(HttpServletRequest request, String number,
			int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		int n = 0;
		try {
			n = Integer.parseInt(number);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG", "Invalid input :" + number);
		}

		for (int i = 0; i < numberofquestions; i++) {
			qa = NumberSenseQM.placevalue1(n);

			qa.makeHTML(i + 1);
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private void rounding(HttpServletRequest request, String number,
			int numberofquestions) {
		HttpSession session = request.getSession();
		ArrayList qaList = new ArrayList();
		QuestionAnswer qa = null;
		int n = 0;
		try {
			n = Integer.parseInt(number);
		} catch (Exception e) {
			session.setAttribute("ERROR_MSG", "Invalid input :" + number);
		}

		for (int i = 0; i < numberofquestions; i++) {
			qa = NumberSenseQM.rounding(n);

			qa.makeHTML(i + 1);
			qaList.add(qa);
		}
		session.setAttribute("qList", qaList);
	}

	private BaseQuestion callingMaker(HttpServletRequest request, String wsType,
			String var2, String var3, String var4, String var5, String var6,
			int numberofquestions) {
		HttpSession session = request.getSession();
		
		BaseQuestion question = null;

		try {
			for (int i = 0; i < numberofquestions; i++) {
				System.out.println("Testing ");
				System.out.println(var2);
				System.out.println(var3);
				System.out.println(var4);
				System.out.println(var6);
				System.out.println(wsType);
				question = BaseMaker.makeQuestion(wsType, var2, var3, var4,
						var5, var6);
				System.out.print("Question Number: ");
				System.out.println(i);
				System.out.println(question);

				question.makeHTML(i + 1);
				
			}
		} catch (Exception e) {
			// Attention , handle exception later

			System.out.println("Exception5:" + e.getMessage());
		}
		return question;
		
	}

	// Clean up resources
	public void destroy() {
	}
}