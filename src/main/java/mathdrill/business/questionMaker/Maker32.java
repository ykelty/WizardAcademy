package mathdrill.business.questionMaker;
import java.math.*;
import mathdrill.business.*;
import mathdrill.business.question.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author Li Kelty
 * @version 1.0
 */

public class Maker32 extends BaseMaker {

  public Maker32() {
  }
  
  public static BaseQuestion makeQuestion(String var2,String var3,String var4, String var5){

      BaseQuestion qa = null;
      boolean bDecimal = false;
      int int1 = Helper.getRandom(1, 2);
      int int2 = Helper.getRandom(1, 3);
           
     if (int1 == 1){
    	  bDecimal = true;        
      }
     if (int2 == 1){
    	 qa=makeLengthQuestion( bDecimal);       
     }
     else if (int2 == 2){
    	 qa=makeWeightQuestion( bDecimal);       
     }   
     else{
    	 qa=makeVolumeQuestion( bDecimal);       
     }
     
  return qa;
}


  private static BaseQuestion makeLengthQuestion(boolean bDecimal){

 	UnitQuestion qa = null;
   String in_unit1="", in_unit2="",out_unit="";
   
   int typeofquestion = Helper.getRandom(1,5);
   int inputNumber1 = Helper.getRandom(1,9);
   int inputNumber1a = Helper.getRandom(1,9);
   int inputNumber2 = Helper.getRandom(1,99);
   int inputNumber3 = Helper.getRandom(1,999);
  int outputNumber=0;
  String outputNumber_str="";
    double d_outputNumber=0;
   
   qa = new UnitQuestion();
   if (!bDecimal){
	   if (typeofquestion==1){
		   in_unit1="centimeters";
		   in_unit2="millimeters";
		   out_unit="millimeters";
		   outputNumber=inputNumber2+inputNumber1;	   
		   qa.setQuestion(inputNumber2 + " " + in_unit1 + " " +inputNumber1 + " " + in_unit2 + " = ");
		   qa.setOutUnit(out_unit);
		   qa.setAnswer(""+outputNumber);
	   }
	   else if (typeofquestion==2){
		   in_unit1="decimeters";
		   in_unit2="centimeters";
		   out_unit="centimeters";
		   outputNumber=inputNumber2*10+inputNumber1;	   
		   qa.setQuestion(inputNumber2 + " " + in_unit1 + " " +inputNumber1 + " " + in_unit2 + " = ");
		   qa.setOutUnit(out_unit);
		   qa.setAnswer(""+outputNumber);
	   } 
	   else    if (typeofquestion==3){
		   in_unit1="meters";
		   in_unit2="decimeters";
		   out_unit="decimeters";
		   outputNumber=inputNumber2*10+inputNumber1;	   
		   qa.setQuestion(inputNumber2 + " " + in_unit1 + " " +inputNumber1 + " " + in_unit2 + " = ");
		   qa.setOutUnit(out_unit);
		   qa.setAnswer(""+outputNumber);
	   }
	   else if (typeofquestion==4){
		   in_unit1="meters";
		   in_unit2="centimeters";
		   out_unit="centimeters";
		   if (Helper.getRandom(1,2)==1){
			   outputNumber=inputNumber1*100+inputNumber2;
			   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber2 + " " + in_unit2 + " = ");
		   }
		   else {
			   outputNumber=inputNumber1*100+inputNumber1a;
			   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber1a + " " + in_unit2 + " = ");
		   }
		   qa.setOutUnit(out_unit);
		   qa.setAnswer(""+outputNumber);
	   }
	   else {
		   in_unit1="kilometers";
		   in_unit2="meters";
		   out_unit="meters";
		   if (Helper.getRandom(1,2)==1){
			   outputNumber=inputNumber1*1000+inputNumber3;	 
			   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber3 + " " + in_unit2 + " = ");
			   
		   }
		   else{
			   outputNumber=inputNumber1*1000+inputNumber2;
			   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber2 + " " + in_unit2 + " = ");
			   
		   }
		   qa.setOutUnit(out_unit);
		   qa.setAnswer(""+outputNumber);
	   }
	   
   }
   else { 
	   if (typeofquestion==1){
	   in_unit1="centimeters";
	   in_unit2="millimeters";
	   out_unit="centimeters";
	   qa.setQuestion(inputNumber2 + " " + in_unit1 + " " +inputNumber1 + " " + in_unit2 + " = ");
	   d_outputNumber=inputNumber2+inputNumber1*1.0/10;	   
	   outputNumber_str=Helper.formatDouble(d_outputNumber,2);
	  
   }
   else if (typeofquestion==2){
	   in_unit1="decimeters";
	   in_unit2="centimeters";
	   out_unit="decimeters";
	   qa.setQuestion(inputNumber2 + " " + in_unit1 + " " +inputNumber1 + " " + in_unit2 + " = ");
	   d_outputNumber=inputNumber2+inputNumber1*1.0/10;	   
	   outputNumber_str=Helper.formatDouble(d_outputNumber,2);
   } 
   else if (typeofquestion==3){
	   in_unit1="meters";
	   in_unit2="decimeters";
	   out_unit="meters";  
	   qa.setQuestion(inputNumber2 + " " + in_unit1 + " " +inputNumber1 + " " + in_unit2 + " = ");
	   d_outputNumber=inputNumber2+inputNumber1*1.0/10;
	   outputNumber_str=Helper.formatDouble(d_outputNumber,2);
   }
   else if (typeofquestion==4){
	   in_unit1="meters";
	   in_unit2="centimeters";
	   out_unit="meters";
	   if (Helper.getRandom(1,2)==1){
		   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber2 + " " + in_unit2 + " = ");
		   d_outputNumber=inputNumber1+inputNumber2*1.0/100;
	   }
	   else {
		   outputNumber=inputNumber1*100+inputNumber1a;
		   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber1a + " " + in_unit2 + " = ");
		   d_outputNumber=inputNumber1+inputNumber1a*1.0/100;
	   }
	   outputNumber_str=Helper.formatDouble(d_outputNumber,2);
   }
   else {
	   in_unit1="kilometers";
	   in_unit2="meters";
	   out_unit="kilometers";
	   if (Helper.getRandom(1,2)==1){		  
		   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber3 + " " + in_unit2 + " = ");
		   d_outputNumber=inputNumber1+inputNumber3*1.0/1000;
		   
	   }
	   else{
		   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber2 + " " + in_unit2 + " = ");
		   d_outputNumber=inputNumber1+inputNumber2*1.0/1000;		   
	   }
	   outputNumber_str=Helper.formatDouble(d_outputNumber,3);
   }
	   qa.setOutUnit(out_unit);
	    
	   qa.setAnswer(outputNumber_str);
   }
   
   
   return qa;
  }
  
  private static BaseQuestion makeVolumeQuestion(boolean bDecimal){

	 	UnitQuestion qa = null;
	   String in_unit1="", in_unit2="",out_unit="";
	   
	   int typeofquestion = Helper.getRandom(1,5);
	   int inputNumber1 = Helper.getRandom(1,9);
	   int inputNumber1a = Helper.getRandom(1,9);
	   int inputNumber2 = Helper.getRandom(1,99);
	   int inputNumber3 = Helper.getRandom(1,999);
	  int outputNumber=0;
	  String outputNumber_str="";
	    double d_outputNumber=0;
	   
	   qa = new UnitQuestion();
	   if (!bDecimal){
		   if (typeofquestion==1){
			   in_unit1="centiliters";
			   in_unit2="milliliters";
			   out_unit="milliliters";
			   outputNumber=inputNumber2*10+inputNumber1;	   
			   qa.setQuestion(inputNumber2 + " " + in_unit1 + " " +inputNumber1 + " " + in_unit2 + " = ");
			   qa.setOutUnit(out_unit);
			   qa.setAnswer(""+outputNumber);
		   }
		   else if (typeofquestion==2){
			   in_unit1="deciliters";
			   in_unit2="centiliters";
			   out_unit="centiliters";
			   outputNumber=inputNumber2*10+inputNumber1;	   
			   qa.setQuestion(inputNumber2 + " " + in_unit1 + " " +inputNumber1 + " " + in_unit2 + " = ");
			   qa.setOutUnit(out_unit);
			   qa.setAnswer(""+outputNumber);
		   } 
		   else    if (typeofquestion==3){
			   in_unit1="liters";
			   in_unit2="deciliters";
			   out_unit="deciliters";
			   outputNumber=inputNumber2*10+inputNumber1;	   
			   qa.setQuestion(inputNumber2 + " " + in_unit1 + " " +inputNumber1 + " " + in_unit2 + " = ");
			   qa.setOutUnit(out_unit);
			   qa.setAnswer(""+outputNumber);
		   }
		   else if (typeofquestion==4){
			   in_unit1="liters";
			   in_unit2="centiliters";
			   out_unit="centiliters";
			   if (Helper.getRandom(1,2)==1){
				   outputNumber=inputNumber1*100+inputNumber2;
				   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber2 + " " + in_unit2 + " = ");
			   }
			   else {
				   outputNumber=inputNumber1*100+inputNumber1a;
				   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber1a + " " + in_unit2 + " = ");
			   }
			   qa.setOutUnit(out_unit);
			   qa.setAnswer(""+outputNumber);
		   }
		   else {
			   in_unit1="kiloliters";
			   in_unit2="liters";
			   out_unit="liters";
			   if (Helper.getRandom(1,2)==1){
				   outputNumber=inputNumber1*1000+inputNumber3;	 
				   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber3 + " " + in_unit2 + " = ");
				   
			   }
			   else{
				   outputNumber=inputNumber1*1000+inputNumber2;
				   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber2 + " " + in_unit2 + " = ");
				   
			   }
			   qa.setOutUnit(out_unit);
			   qa.setAnswer(""+outputNumber);
		   }
		   
	   }
	   else { 
		   if (typeofquestion==1){
		   in_unit1="centiliters";
		   in_unit2="milliliters";
		   out_unit="centiliters";
		   qa.setQuestion(inputNumber2 + " " + in_unit1 + " " +inputNumber1 + " " + in_unit2 + " = ");
		   d_outputNumber=inputNumber2+inputNumber1*1.0/10;	   
		   outputNumber_str=Helper.formatDouble(d_outputNumber,2);
		  
	   }
	   else if (typeofquestion==2){
		   in_unit1="deciliters";
		   in_unit2="centiliters";
		   out_unit="deciliters";
		   qa.setQuestion(inputNumber2 + " " + in_unit1 + " " +inputNumber1 + " " + in_unit2 + " = ");
		   d_outputNumber=inputNumber2+inputNumber1*1.0/10;	   
		   outputNumber_str=Helper.formatDouble(d_outputNumber,2);
	   } 
	   else    if (typeofquestion==3){
		   in_unit1="liters";
		   in_unit2="deciliters";
		   out_unit="liters";  
		   qa.setQuestion(inputNumber2 + " " + in_unit1 + " " +inputNumber1 + " " + in_unit2 + " = ");
		   d_outputNumber=inputNumber2+inputNumber1*1.0/10;
		   outputNumber_str=Helper.formatDouble(d_outputNumber,2);
	   }
	   else if (typeofquestion==4){
		   in_unit1="liters";
		   in_unit2="centiliters";
		   out_unit="liters";
		   if (Helper.getRandom(1,2)==1){
			   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber2 + " " + in_unit2 + " = ");
			   d_outputNumber=inputNumber1+inputNumber2*1.0/100;
		   }
		   else {
			   outputNumber=inputNumber1*100+inputNumber1a;
			   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber1a + " " + in_unit2 + " = ");
			   d_outputNumber=inputNumber1+inputNumber1a*1.0/100;
		   }
		   outputNumber_str=Helper.formatDouble(d_outputNumber,2);
	   }
	   else {
		   in_unit1="kiloliters";
		   in_unit2="liters";
		   out_unit="kiloliters";
		   if (Helper.getRandom(1,2)==1){		  
			   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber3 + " " + in_unit2 + " = ");
			   d_outputNumber=inputNumber1+inputNumber3*1.0/1000;
			   
		   }
		   else{
			   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber2 + " " + in_unit2 + " = ");
			   d_outputNumber=inputNumber1+inputNumber2*1.0/1000;		   
		   }
		   outputNumber_str=Helper.formatDouble(d_outputNumber,3);
	   }
		   qa.setOutUnit(out_unit);
		    
		   qa.setAnswer(outputNumber_str);
	   }
	   
	   
	   return qa;
	  }
	  
  private static BaseQuestion makeWeightQuestion(boolean bDecimal){

		 	UnitQuestion qa = null;
		   String in_unit1="", in_unit2="",out_unit="";
		   
		   int typeofquestion = Helper.getRandom(1,5);
		   int inputNumber1 = Helper.getRandom(1,9);
		   int inputNumber1a = Helper.getRandom(1,9);
		   int inputNumber2 = Helper.getRandom(1,99);
		   int inputNumber3 = Helper.getRandom(1,999);
		  int outputNumber=0;
		  String outputNumber_str="";
		    double d_outputNumber=0;
		   
		   qa = new UnitQuestion();
		   if (!bDecimal){
			   if (typeofquestion==1){
				   in_unit1="centigrams";
				   in_unit2="milligrams";
				   out_unit="milligrams";
				   outputNumber=inputNumber2+inputNumber1;	   
				   qa.setQuestion(inputNumber2 + " " + in_unit1 + " " +inputNumber1 + " " + in_unit2 + " = ");
				   qa.setOutUnit(out_unit);
				   qa.setAnswer(""+outputNumber);
			   }
			   else if (typeofquestion==2){
				   in_unit1="decigrams";
				   in_unit2="centigrams";
				   out_unit="centigrams";
				   outputNumber=inputNumber2*10+inputNumber1;	   
				   qa.setQuestion(inputNumber2 + " " + in_unit1 + " " +inputNumber1 + " " + in_unit2 + " = ");
				   qa.setOutUnit(out_unit);
				   qa.setAnswer(""+outputNumber);
			   } 
			   else    if (typeofquestion==3){
				   in_unit1="grams";
				   in_unit2="decigrams";
				   out_unit="decigrams";
				   outputNumber=inputNumber2*10+inputNumber1;	   
				   qa.setQuestion(inputNumber2 + " " + in_unit1 + " " +inputNumber1 + " " + in_unit2 + " = ");
				   qa.setOutUnit(out_unit);
				   qa.setAnswer(""+outputNumber);
			   }
			   else if (typeofquestion==4){
				   in_unit1="grams";
				   in_unit2="centigrams";
				   out_unit="centigrams";
				   if (Helper.getRandom(1,2)==1){
					   outputNumber=inputNumber1*100+inputNumber2;
					   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber2 + " " + in_unit2 + " = ");
				   }
				   else {
					   outputNumber=inputNumber1*100+inputNumber1a;
					   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber1a + " " + in_unit2 + " = ");
				   }
				   qa.setOutUnit(out_unit);
				   qa.setAnswer(""+outputNumber);
			   }
			   else {
				   in_unit1="kilograms";
				   in_unit2="grams";
				   out_unit="grams";
				   if (Helper.getRandom(1,2)==1){
					   outputNumber=inputNumber1*1000+inputNumber3;	 
					   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber3 + " " + in_unit2 + " = ");
					   
				   }
				   else{
					   outputNumber=inputNumber1*1000+inputNumber2;
					   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber2 + " " + in_unit2 + " = ");
					   
				   }
				   qa.setOutUnit(out_unit);
				   qa.setAnswer(""+outputNumber);
			   }
			   
		   }
		   else { 
			   if (typeofquestion==1){
			   in_unit1="centigrams";
			   in_unit2="milligrams";
			   out_unit="centigrams";
			   qa.setQuestion(inputNumber2 + " " + in_unit1 + " " +inputNumber1 + " " + in_unit2 + " = ");
			   d_outputNumber=inputNumber2+inputNumber1*1.0/10;	   
			   outputNumber_str=Helper.formatDouble(d_outputNumber,2);
			  
		   }
		   else if (typeofquestion==2){
			   in_unit1="decigrams";
			   in_unit2="centigrams";
			   out_unit="decigrams";
			   qa.setQuestion(inputNumber2 + " " + in_unit1 + " " +inputNumber1 + " " + in_unit2 + " = ");
			   d_outputNumber=inputNumber2+inputNumber1*1.0/10;	   
			   outputNumber_str=Helper.formatDouble(d_outputNumber,2);
		   } 
		   else    if (typeofquestion==3){
			   in_unit1="grams";
			   in_unit2="decigrams";
			   out_unit="grams";  
			   qa.setQuestion(inputNumber2 + " " + in_unit1 + " " +inputNumber1 + " " + in_unit2 + " = ");
			   d_outputNumber=inputNumber2+inputNumber1*1.0/10;
			   outputNumber_str=Helper.formatDouble(d_outputNumber,2);
		   }
		   else if (typeofquestion==4){
			   in_unit1="grams";
			   in_unit2="centigrams";
			   out_unit="grams";
			   if (Helper.getRandom(1,2)==1){
				   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber2 + " " + in_unit2 + " = ");
				   d_outputNumber=inputNumber1+inputNumber2*1.0/100;
			   }
			   else {
				   outputNumber=inputNumber1*100+inputNumber1a;
				   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber1a + " " + in_unit2 + " = ");
				   d_outputNumber=inputNumber1+inputNumber1a*1.0/100;
			   }
			   outputNumber_str=Helper.formatDouble(d_outputNumber,2);
		   }
		   else {
			   in_unit1="kilograms";
			   in_unit2="grams";
			   out_unit="kilograms";
			   if (Helper.getRandom(1,2)==1){		  
				   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber3 + " " + in_unit2 + " = ");
				   d_outputNumber=inputNumber1+inputNumber3*1.0/1000;
				   
			   }
			   else{
				   qa.setQuestion(inputNumber1 + " " + in_unit1 + " " +inputNumber2 + " " + in_unit2 + " = ");
				   d_outputNumber=inputNumber1+inputNumber2*1.0/1000;		   
			   }
			   outputNumber_str=Helper.formatDouble(d_outputNumber,3);
		   }
			   qa.setOutUnit(out_unit);
			    
			   qa.setAnswer(outputNumber_str);
		   }
		   
		   
		   return qa;
		  
	  }
  
  public static void main(String[] args) {

	   // BaseQuestion q=makeQuestion("from decimal to percent","larger than 100%","larger than 100%","");
	    //q.makeHTML(1);
	    //System.out.println(q.getHTML());
	  /*BigDecimal d_inputNumber=new BigDecimal(0);
	  String printStr="";
	  for (int i=0;i<10;i++){
	     d_inputNumber=new BigDecimal(Helper.getRandom(1,100)).add(
	    		 new BigDecimal(Helper.getRandom(1,100))).multiply(new BigDecimal(0.01));
	     System.out.println("d_inputNumber 1:"+d_inputNumber);
	     d_inputNumber=d_inputNumber.multiply(new BigDecimal(10));
	     printStr=d_inputNumber+";";
	    System.out.println(printStr);
	  }
	  */
	  for (int i=0;i<100;i++){
		 int r= Helper.getRandom(1,8);
	  System.out.println("Random Number:"+r);
	  }
	 
}
}