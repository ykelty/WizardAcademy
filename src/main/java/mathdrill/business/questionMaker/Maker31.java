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

public class Maker31 extends BaseMaker {

  public Maker31() {
  }
  
  public static BaseQuestion makeQuestion(String var2,String var3,String var4, String var5){

      BaseQuestion qa = null;
      boolean bDecimal = false;
      int ignoreCase = Helper.getRandom(1, 2);
      int questionType = Helper.getRandom(1, 3);
      
     if (ignoreCase == 1){
    	  bDecimal = true;        
      }
     if (questionType == 1){
    	 qa=makeLengthQuestion( bDecimal);       
     }
     else if (questionType == 2){
    	 qa=makeWeightQuestion( bDecimal);       
     }   
     else{
    	 qa=makeVolumeQuestion( bDecimal);       
     }
     
  return qa;
}


  private static BaseQuestion makeLengthQuestion(boolean bDecimal){

 	UnitQuestion qa = null;
   String in_unit="", out_unit="";
   
   int typeofquestion = Helper.getRandom(1,8);
   int inputNumber = Helper.getRandom(1,100);
   int outputNumber=0;
   double d_inputNumber=Helper.getRandom(1,100)+Helper.getRandom(1,100)*1.0/100;
   double d_outputNumber=0;
   
   qa = new UnitQuestion();
   if (!bDecimal){
	   if (typeofquestion==1){
		   in_unit="centimeters";
		   out_unit="meters";
		   outputNumber=inputNumber;
		   inputNumber=outputNumber*100;
	   }
	   else if (typeofquestion==2){
		   in_unit="meters";
		   out_unit="centimeters";
		   outputNumber=inputNumber*100;
	   } 
	   else    if (typeofquestion==3){
		   in_unit="millimeters";
		   out_unit="centimeters";
		   outputNumber=inputNumber;
		   inputNumber=outputNumber*10;
	   }
	   else if (typeofquestion==4){
		   in_unit="centimeters";
		   out_unit="millimeters";
		   outputNumber=inputNumber*10;
	   }
	   else if (typeofquestion==5){
		   in_unit="meters";
		   out_unit="millimeters";
		   outputNumber=inputNumber*1000;
	   }
	   else if (typeofquestion==6){
		   in_unit="millimeters";
		   out_unit="meters";
		   outputNumber=inputNumber;
		   inputNumber=outputNumber*1000;
	   }
	   else if (typeofquestion==7){
		   in_unit="meters";
		   out_unit="kilometers";
		   outputNumber=inputNumber;
		   inputNumber=outputNumber*1000;
	   }
	   else if (typeofquestion==8){
		   in_unit="kilometers";
		   out_unit="meters";
		   outputNumber=inputNumber*1000;
	   }
	   qa.setQuestion("How many " + out_unit + " is " + inputNumber + " " + in_unit + " ?");
	   qa.setOutUnit(out_unit);
	   qa.setAnswer(""+outputNumber);
	 
   }
   else {
	   if (typeofquestion==1){
		   in_unit="centimeters";
		   out_unit="meters";
		   d_outputNumber=d_inputNumber;
		   d_inputNumber =d_outputNumber*100;
	   }
	   else if (typeofquestion==2){
		   in_unit="meters";
		   out_unit="centimeters";
		   d_outputNumber=d_inputNumber*100;
	   } 
	   else    if (typeofquestion==3){
		   in_unit="millimeters";
		   out_unit="centimeters";
		   d_outputNumber=d_inputNumber;
		   d_inputNumber=d_outputNumber*10;
	   }
	   else if (typeofquestion==4){
		   in_unit="centimeters";
		   out_unit="millimeters";
		   d_outputNumber=d_inputNumber*10;
	   }
	   else if (typeofquestion==5){
		   in_unit="meters";
		   out_unit="millimeters";
		   d_outputNumber=d_inputNumber*1000;
	   }
	   else if (typeofquestion==6){
		   in_unit="millimeters";
		   out_unit="meters";
		   d_outputNumber=d_inputNumber;
		   d_inputNumber=d_outputNumber*1000;
	   }
	   else if (typeofquestion==7){
		   in_unit="meters";
		   out_unit="kilometers";
		   d_outputNumber=d_inputNumber;
		   d_inputNumber=d_outputNumber*1000;
	   }
	   else if (typeofquestion==8){
		   in_unit="kilometers";
		   out_unit="meters";
		   d_outputNumber=d_inputNumber*1000;
	   }
	   
	   String inputNumber_str=Helper.formatDouble(d_inputNumber,2);
	   
	   qa.setQuestion("How many " + out_unit + " is " + inputNumber_str+ " " + in_unit + " ?");
	   qa.setOutUnit(out_unit);
	   String outputNumber_str=Helper.formatDouble(d_outputNumber,2);
	   qa.setAnswer(""+outputNumber_str);
   }
   
   
   return qa;
  }
  
  private static BaseQuestion makeVolumeQuestion(boolean bDecimal){

	 	UnitQuestion qa = null;
	   String in_unit="", out_unit="";
	   
	   int typeofquestion = Helper.getRandom(1,8);
	   int inputNumber = Helper.getRandom(1,100);
	   int outputNumber=0;
	   double d_inputNumber=Helper.getRandom(1,100)+Helper.getRandom(1,100)*1.0/100;
	   double d_outputNumber=0;
	   
	   qa = new UnitQuestion();
	   if (!bDecimal){
		   if (typeofquestion==1){
			   in_unit="centiliters";
			   out_unit="liters";
			   outputNumber=inputNumber;
			   inputNumber=outputNumber*100;
		   }
		   else if (typeofquestion==2){
			   in_unit="liters";
			   out_unit="centiliters";
			   outputNumber=inputNumber*100;
		   } 
		   else    if (typeofquestion==3){
			   in_unit="milliliters";
			   out_unit="centiliters";
			   outputNumber=inputNumber;
			   inputNumber=outputNumber*10;
		   }
		   else if (typeofquestion==4){
			   in_unit="centiliters";
			   out_unit="milliliters";
			   outputNumber=inputNumber*10;
		   }
		   else if (typeofquestion==5){
			   in_unit="liters";
			   out_unit="milliliters";
			   outputNumber=inputNumber*1000;
		   }
		   else if (typeofquestion==6){
			   in_unit="milliliters";
			   out_unit="liters";
			   outputNumber=inputNumber;
			   inputNumber=outputNumber*1000;
		   }
		   else if (typeofquestion==7){
			   in_unit="liters";
			   out_unit="kiloliters";
			   outputNumber=inputNumber;
			   inputNumber=outputNumber*1000;
		   }
		   else if (typeofquestion==8){
			   in_unit="kiloliters";
			   out_unit="liters";
			   outputNumber=inputNumber*1000;
		   }
		   qa.setQuestion("How many " + out_unit + " is " + inputNumber + " " + in_unit + " ?");
		   qa.setOutUnit(out_unit);
		   qa.setAnswer(""+outputNumber);
		 
	   }
	   else {
		   if (typeofquestion==1){
			   in_unit="centiliters";
			   out_unit="liters";
			   d_outputNumber=d_inputNumber;
			   d_inputNumber =d_outputNumber*100;
		   }
		   else if (typeofquestion==2){
			   in_unit="liters";
			   out_unit="centiliters";
			   d_outputNumber=d_inputNumber*100;
		   } 
		   else    if (typeofquestion==3){
			   in_unit="milliliters";
			   out_unit="centiliters";
			   d_outputNumber=d_inputNumber;
			   d_inputNumber=d_outputNumber*10;
		   }
		   else if (typeofquestion==4){
			   in_unit="centiliters";
			   out_unit="milliliters";
			   d_outputNumber=d_inputNumber*10;
		   }
		   else if (typeofquestion==5){
			   in_unit="liters";
			   out_unit="milliliters";
			   d_outputNumber=d_inputNumber*1000;
		   }
		   else if (typeofquestion==6){
			   in_unit="milliliters";
			   out_unit="liters";
			   d_outputNumber=d_inputNumber;
			   d_inputNumber=d_outputNumber*1000;
		   }
		   else if (typeofquestion==7){
			   in_unit="liters";
			   out_unit="kiloliters";
			   d_outputNumber=d_inputNumber;
			   d_inputNumber=d_outputNumber*1000;
		   }
		   else if (typeofquestion==8){
			   in_unit="kiloliters";
			   out_unit="liters";
			   d_outputNumber=d_inputNumber*1000;
		   }
		   
		   String inputNumber_str=Helper.formatDouble(d_inputNumber,2);
		   qa.setQuestion("How many " + out_unit + " is " + inputNumber_str+ " " + in_unit + " ?");
		   qa.setOutUnit(out_unit);
		   String outputNumber_str=Helper.formatDouble(d_outputNumber,2);
		   qa.setAnswer(""+outputNumber_str);
	   }
	   
	   
	   return qa;
	  }
	  
  private static BaseQuestion makeWeightQuestion(boolean bDecimal){

	 	UnitQuestion qa = null;
	   String in_unit="", out_unit="";
	   
	   int typeofquestion = Helper.getRandom(1,8);
	   int inputNumber = Helper.getRandom(1,100);
	   int outputNumber=0;
	   double d_inputNumber=Helper.getRandom(1,100)+(Helper.getRandom(1,100)*1.0)/100;
	   double d_outputNumber=0;
	   
	   qa = new UnitQuestion();
	   if (!bDecimal){
		   if (typeofquestion==1){
			   in_unit="centigrams";
			   out_unit="grams";
			   outputNumber=inputNumber;
			   inputNumber=outputNumber*100;
		   }
		   else if (typeofquestion==2){
			   in_unit="grams";
			   out_unit="centigrams";
			   outputNumber=inputNumber*100;
		   } 
		   else    if (typeofquestion==3){
			   in_unit="milligrams";
			   out_unit="centigrams";
			   outputNumber=inputNumber;
			   inputNumber=outputNumber*10;
		   }
		   else if (typeofquestion==4){
			   in_unit="centigrams";
			   out_unit="milligrams";
			   outputNumber=inputNumber*10;
		   }
		   else if (typeofquestion==5){
			   in_unit="grams";
			   out_unit="milligrams";
			   outputNumber=inputNumber*1000;
		   }
		   else if (typeofquestion==6){
			   in_unit="milligrams";
			   out_unit="grams";
			   outputNumber=inputNumber;
			   inputNumber=outputNumber*1000;
		   }
		   else if (typeofquestion==7){
			   in_unit="grams";
			   out_unit="kilograms";
			   outputNumber=inputNumber;
			   inputNumber=outputNumber*1000;
		   }
		   else if (typeofquestion==8){
			   in_unit="kilograms";
			   out_unit="grams";
			   outputNumber=inputNumber*1000;
		   }
		   qa.setQuestion("How many " + out_unit + " is " + inputNumber + " " + in_unit + " ?");
		   qa.setOutUnit(out_unit);
		   qa.setAnswer(""+outputNumber);
		 
	   }
	   else {
		   if (typeofquestion==1){
			   in_unit="centigrams";
			   out_unit="grams";
			   d_outputNumber=d_inputNumber;
			   d_outputNumber=d_outputNumber*100;
		   }
		   else if (typeofquestion==2){
			   in_unit="grams";
			   out_unit="centigrams";
			   d_outputNumber=d_inputNumber*100;
		   } 
		   else    if (typeofquestion==3){
			   in_unit="milligrams";
			   out_unit="centigrams";
			   d_outputNumber=d_inputNumber;
			   d_inputNumber=d_outputNumber*10;
		   }
		   else if (typeofquestion==4){
			   in_unit="centigrams";
			   out_unit="milligrams";
			   d_outputNumber=d_inputNumber*10;
		   }
		   else if (typeofquestion==5){
			   in_unit="grams";
			   out_unit="milligrams";
			   d_outputNumber=d_inputNumber*1000;
		   }
		   else if (typeofquestion==6){
			   in_unit="milligrams";
			   out_unit="grams";
			   d_outputNumber=d_inputNumber;
			   d_inputNumber=d_outputNumber*1000;
		   }
		   else if (typeofquestion==7){
			   in_unit="grams";
			   out_unit="kilograms";
			   d_outputNumber=d_inputNumber;
			   d_inputNumber=d_outputNumber*1000;
		   }
		   else if (typeofquestion==8){
			   in_unit="kilograms";
			   out_unit="grams";
			   d_outputNumber=d_inputNumber*1000;	   
		   }
		   String inputNumber_str=Helper.formatDouble(d_inputNumber,2);
		   qa.setQuestion("How many " + out_unit + " is " + inputNumber_str+ " " + in_unit + " ?");
		   qa.setOutUnit(out_unit);
		   String outputNumber_str=Helper.formatDouble(d_outputNumber,2);
		   qa.setAnswer(""+outputNumber_str);
		 
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