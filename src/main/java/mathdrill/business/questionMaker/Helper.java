package mathdrill.business.questionMaker;
import java.util.Random;
import java.math.BigDecimal;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Helper {
  static Random generator = new Random();
  public Helper() {
  }

 public static BigDecimal getRandomDecimal(int digits1,int digits2){
   BigDecimal a1= new BigDecimal("0");
   String placeValue="";
   for (int i=digits2;i>=1;i--){
   int r12=Helper.getRandom(0,9);
   if (r12>0){
     placeValue=Helper.getPlaceValue(0-i);
     a1 =a1.add( new BigDecimal(placeValue).multiply(new BigDecimal(r12)));
  }
 }

 for (int i=0;i<digits1;i++){
   int r11=Helper.getRandom(0,9);
   placeValue=Helper.getPlaceValue(i+1);
   if (r11>0){
     a1 = a1.add( new BigDecimal(r11).multiply( new BigDecimal(placeValue)));
   }
 }
 return a1;
 }
  public static int getRandom(int startNumber, int endNumber){
       //generate a 3 digit random number, it means a random integer from 0 to 899 add an additional 100
       // it menas generator.nextInt(900)+100
       //generator.nextInt(endNumber-startNumber+1) generates a frandom number from 0 to endNumber-startNumber
       return generator.nextInt(endNumber-startNumber+1) + startNumber;
     }

  public static int getRandomWithGivenDigits(int digitNumber){
    //generate a 3 digit random number, it means a random integer from 0 to 899 add an additional 100
    // it menas generator.nextInt(900)+100

    return generator.nextInt((int)(Math.pow(10,digitNumber) -Math.pow(10,digitNumber-1) )) + (int)Math.pow(10,digitNumber-1);
  }

  public static int getRandomWithGivenDigitsNoRepeat(int digitNumber){
     //generate a 3 digit random number, it means a random integer from 0 to 899 add an additional 100
     // it menas generator.nextInt(900)+100


     return generator.nextInt((int)(Math.pow(10,digitNumber) -Math.pow(10,digitNumber-1) )) + (int)Math.pow(10,digitNumber-1);
   }

  //convert 3420 to 3,420
  public static String convertLongIntToProperForm (int number){
     String rVal = null;
     int tmp=0;
     if (number < 1000) {
       rVal=""+number;
     }
     else if (number >=1000 && number <1000000){
       rVal=""+number/1000+","+ make3digits((number-number/1000 *1000));
     }
     else if (number >=1000000 && number <1000000000){
       tmp = number -number/1000000 * 1000000;
      rVal=""+number/1000000+","+make3digits(tmp/1000)+","+ make3digits((tmp-tmp/1000*1000));
     }

     return rVal;
  }

  public static String make3digits (int number){
    String rValue="";
    if (number<10){
      rValue="00"+number;
    }
    else if (number<100){
      rValue="0"+number;
    }
    else
      rValue=""+number;

    return rValue;
  }
  public static String make2digits (int number){
    String rValue="";
    if (number<10){
      rValue="0"+number;
    }
    else
      rValue=""+number;

    return rValue;
  }
  public static String getPlaceValue(int digit){
    String rString="";
    switch (digit) {

                case 1:  rString="1"; break;
                case 2:  rString="10"; break;
                case 3:  rString="100"; break;
                case 4:  rString="1000"; break;
                case 5:  rString="10000"; break;
                case 6:  rString="100000"; break;
                case 7:  rString="1000000"; break;
                case 8:  rString="10000000"; break;
                case 9:  rString="100000000"; break;
                 case -1:  rString="0.1"; break;
                case -2:  rString="0.01"; break;
                case -3:  rString="0.001"; break;
                case -4:  rString="0.0001"; break;
                case -5:  rString="0.00001"; break;
                case -6:  rString="0.000001"; break;
                case -7:  rString="0.0000001"; break;
                case -8:  rString="0.00000001"; break;
                case -9:  rString="0.000000001"; break;
                default: break;
         }
      return rString;
   }
  public static int getGCF(int number1, int number2){
     //find the min of 2
     int min=number1;
     if (number2<number1)
        min = number2;

     int gcf = 1;
     for (int i=1;i<=min;i++){
       if ( (number1/i * i == number1) &&(number2/i * i == number2)) {
         gcf = i; // then i is a common factor

       }
     }
     return gcf;
   }
   public static int getLCM(int number1, int number2){

     int lcm = (number1*number2)/getGCF(number1,number2);
     return lcm;
  }

  public static String makeFractionHTML(int n, int d){

    String rValue="<sup>"+n+"</sup>/<sub>"+d+"</sub>";
    return rValue;
  }
  
  public static String formatDouble(double d, int decimalPlaces){
	  String rValue="";
	  Object[] arr = {new Double(d)};
	  if (decimalPlaces==2){
	  rValue=String.format("%.2f",arr);
	  }
	  else if (decimalPlaces==3){
		  rValue=String.format("%.3f",arr);
	  }
	  else if (decimalPlaces==4){
		  rValue=String.format("%.4f",arr);
	  }
	  return rValue;
  }
}