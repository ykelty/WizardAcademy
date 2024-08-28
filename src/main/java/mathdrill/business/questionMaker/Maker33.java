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

public class Maker33 extends BaseMaker {

  public Maker33() {
  }
  
  public static BaseQuestion makeQuestion(String var2,String var3,String var4, String var5){

      BaseQuestion qa = null;
      
     
     if (var2.equalsIgnoreCase("length(inches,feet and yards)")){
    	 qa=makeLengthQuestion1( );       
     }
     if (var2.equalsIgnoreCase("length(feet,yards and miles)")){
    	 qa=makeLengthQuestion2( );       
     }
     if (var2.equalsIgnoreCase("mass(ounces, pounds and tons)")){
    	 qa=makeWeightQuestion( );       
     }   
     if (var2.equalsIgnoreCase("liquid measurements")){
   	 qa=makeVolumeQuestion( );       
     }
     
  return qa;
}


  private static BaseQuestion makeLengthQuestion1(){

	  UnitQuestion qa = null;
   String in_unit="", out_unit="";
   
   int typeofquestion = Helper.getRandom(1,6);
   int inputNumber =0;
  int outputNumber=0;
    
   qa = new UnitQuestion();
	   if (typeofquestion==1){
		   in_unit="feet";
		   out_unit="inches";
		   inputNumber = Helper.getRandom(1,50);
		   outputNumber=inputNumber*12;
	   }
	   else if (typeofquestion==2){
		   in_unit="yards";
		   out_unit="feet";
		   inputNumber = Helper.getRandom(1,100);
		   outputNumber=inputNumber*3;
	   } 
	   else    if (typeofquestion==3){
		   in_unit="yards";
		   out_unit="inches";
		   inputNumber = Helper.getRandom(1,25);
		   outputNumber=inputNumber*36;
	   }
	   else if (typeofquestion==4){
		   in_unit="inches";
		   out_unit="feet";
		   outputNumber=Helper.getRandom(1,50);
		   inputNumber=outputNumber*12;
	   }
	   else if (typeofquestion==5){
		   in_unit="feet";
		   out_unit="yards";
		   outputNumber = Helper.getRandom(1,100);
		   inputNumber=outputNumber*3;
	   }
	   else if (typeofquestion==6){
		   in_unit="inches";
		   out_unit="yards";
		   outputNumber = Helper.getRandom(1,25);
		   inputNumber=outputNumber*36;
	   }
	 
	   qa.setQuestion(inputNumber + " " + in_unit + " = ");
	   qa.setOutUnit(out_unit);
	   qa.setAnswer(""+outputNumber);
	 
   return qa;
  }
  
  private static BaseQuestion makeLengthQuestion2(){

	  UnitQuestion qa = null;
	   String in_unit="", out_unit="";
	   
	   int typeofquestion = Helper.getRandom(1,6);
	   int inputNumber =0;
	  int outputNumber=0;
	    
	   qa = new UnitQuestion();
		   if (typeofquestion==1){
			   in_unit="yards";
			   out_unit="feet";
			   inputNumber = Helper.getRandom(1,50);
			   outputNumber=inputNumber*3;
		   }
		   else if (typeofquestion==2){
			   in_unit="miles";
			   out_unit="yards";
			   inputNumber = Helper.getRandom(1,10);
			   outputNumber=inputNumber*1760;
		   } 
		   else    if (typeofquestion==3){
			   in_unit="miles";
			   out_unit="feet";
			   inputNumber = Helper.getRandom(1,10);
			   outputNumber=inputNumber*5280;
		   }
		   else if (typeofquestion==4){
			   in_unit="feet";
			   out_unit="yards";
			   outputNumber=Helper.getRandom(1,50);
			   inputNumber=outputNumber*3;
		   }
		   else if (typeofquestion==5){
			   in_unit="yards";
			   out_unit="miles";
			   outputNumber = Helper.getRandom(1,10);
			   inputNumber=outputNumber*1760;
		   }
		   else if (typeofquestion==6){
			   in_unit="feet";
			   out_unit="miles";
			   outputNumber = Helper.getRandom(1,10);
			   inputNumber=outputNumber*5280;
		   }
		 
		   qa.setQuestion(inputNumber + " " + in_unit + " = ");
		   qa.setOutUnit(out_unit);
		   qa.setAnswer(""+outputNumber);
		 
	   return qa;
	  }
	  
  private static BaseQuestion makeVolumeQuestion(){

	 	UnitQuestion qa = null;
	   String in_unit="", out_unit="";
	   
	   int typeofquestion = Helper.getRandom(1,18);
	   int inputNumber =0;
	  int outputNumber=0;
	    
	   qa = new UnitQuestion();
		 
		    if (typeofquestion==1){
			   in_unit="cups";
			   out_unit="fluid ounces";
			   inputNumber = Helper.getRandom(1,50);
			   outputNumber=inputNumber*8;
		   }
		   else if (typeofquestion==2){
			   in_unit="pints";
			   out_unit="cups";
			   inputNumber = Helper.getRandom(1,100);
			   outputNumber=inputNumber*2;
		   }
		 
		   else if (typeofquestion==3){
			   in_unit="quarts";
			   out_unit="pints";
			   inputNumber = Helper.getRandom(1,100);
			   outputNumber=inputNumber*2;
		   }
		   else if (typeofquestion==4){
			   in_unit="gallons";
			   out_unit="quarts";
			   inputNumber = Helper.getRandom(1,100);
			   outputNumber=inputNumber*4;
		   }
		   else if (typeofquestion==5){
			   in_unit="pints";
			   out_unit="fluid ounces";
			   inputNumber = Helper.getRandom(1,25);
			   outputNumber=inputNumber*16;
		   }
		   else if (typeofquestion==6){
			   in_unit="quarts";
			   out_unit="fluid ounces";
			   inputNumber = Helper.getRandom(1,10);
			   outputNumber=inputNumber*32;
		   }
		   else if (typeofquestion==7){
			   in_unit="quarts";
			   out_unit="cups";
			   inputNumber = Helper.getRandom(1,50);
			   outputNumber=inputNumber*4;
		   }
		   else if (typeofquestion==8){
			   in_unit="gallons";
			   out_unit="pints";
			   inputNumber = Helper.getRandom(1,25);
			   outputNumber=inputNumber*8;
		   }
		   else if (typeofquestion==9){
			   in_unit="gallons";
			   out_unit="cups";
			   inputNumber = Helper.getRandom(1,10);
			   outputNumber=inputNumber*16;
		   }
		   else if (typeofquestion==10){
				   in_unit="fluid ounces";
				   out_unit="cups";
				   outputNumber = Helper.getRandom(1,50);
				   inputNumber=outputNumber* 8;
			   }
			   else if (typeofquestion==11){
				   in_unit="pints";
				   out_unit="cups";
				   outputNumber = Helper.getRandom(1,100);
				   inputNumber=outputNumber*2;
			   }
			 
			   else if (typeofquestion==12){
				   in_unit="pints";
				   out_unit="quarts";
				   outputNumber = Helper.getRandom(1,100);
				   inputNumber=outputNumber*2;
			   }
			   else if (typeofquestion==13){
				   in_unit="quarts";
				   out_unit="gallons";
				   outputNumber = Helper.getRandom(1,100);
				   inputNumber=outputNumber*4;
			   }
			   else if (typeofquestion==14){
				   in_unit="fluid ounces";
				   out_unit="pints";
				   outputNumber = Helper.getRandom(1,25);
				   inputNumber=outputNumber*16;
			   }
			   else if (typeofquestion==15){
				   in_unit="fluid ounces";
				   out_unit="quarts";
				   outputNumber = Helper.getRandom(1,10);
				   inputNumber=outputNumber*32;
			   }
			   else if (typeofquestion==16){
				   in_unit="cups";
				   out_unit="quarts";
				   outputNumber = Helper.getRandom(1,50);
				   inputNumber=outputNumber*4;
			   }
			   else if (typeofquestion==17){
				   in_unit="pints";
				   out_unit="gallons";
				   outputNumber = Helper.getRandom(1,25);
				   inputNumber=outputNumber*8;
			   }
			   else if (typeofquestion==18){
				   in_unit="cups";
				   out_unit="gallons";
				   outputNumber = Helper.getRandom(1,10);
				   inputNumber=outputNumber*16;
			   }		 
		   qa.setQuestion(inputNumber + " " + in_unit + " = ");
		   qa.setOutUnit(out_unit);
		   qa.setAnswer(""+outputNumber);
		 
	   return qa;
	  }

  private static BaseQuestion makeWeightQuestion(){

	  UnitQuestion qa = null;
	   String in_unit="", out_unit="";
	   
	   int typeofquestion = Helper.getRandom(1,6);
	   int inputNumber =0;
	  int outputNumber=0;
	    
	   qa = new UnitQuestion();
		   if (typeofquestion==1||typeofquestion==2){
			   in_unit="pounds";
			   out_unit="ounces";
			   inputNumber = Helper.getRandom(1,5);
			   outputNumber=inputNumber*16;
		   }
		   else if (typeofquestion==3){
			   in_unit="tons";
			   out_unit="pounds";
			   inputNumber = Helper.getRandom(1,20);
			   outputNumber=inputNumber*2000;
		   } 
		   else    if (typeofquestion==4 || typeofquestion==5){
			   in_unit="ounces";
			   out_unit="pounds";
			   outputNumber=Helper.getRandom(1,25);
			   inputNumber=outputNumber*16;
		   }
		   else if (typeofquestion==6){
			   in_unit="pounds";
			   out_unit="tons";
			   outputNumber=Helper.getRandom(1,20);
			   inputNumber=outputNumber*2000;
		   }
		 
		   qa.setQuestion(inputNumber + " " + in_unit + " = ");
		   qa.setOutUnit(out_unit);
		   qa.setAnswer(""+outputNumber);
		 
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