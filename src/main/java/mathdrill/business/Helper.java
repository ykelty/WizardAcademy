package mathdrill.business;
import java.util.Random;
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
  public static Fraction reduceFraction(Fraction fraction){
    Fraction retFraction = new Fraction();
    int gcf = getGCF(fraction.getNumerator(),fraction.getDenominator());
    retFraction.setNumberator(fraction.getNumerator()/gcf);
    retFraction.setDenominator(fraction.getDenominator()/gcf);
    return retFraction;
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

}