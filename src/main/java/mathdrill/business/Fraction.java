package mathdrill.business;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Fraction {
  private int numerator;
  private int denominator;
  public int getNumerator () {return numerator;}
  public int getDenominator() {return denominator;}
  public void setNumberator(int newValue){numerator=newValue;}
  public void setDenominator(int newValue){denominator=newValue;}
  public boolean greaterThan(Fraction f){
    return (numerator * f.getDenominator()> f.getNumerator()*denominator);
  }
  public boolean lessThan(Fraction f){
    return (numerator * f.getDenominator()< f.getNumerator()*denominator);
  }
  public boolean equalTo(Fraction f){
    return (numerator * f.getDenominator()== f.getNumerator()*denominator);
  }

  public static Fraction random(int denominatorUpTo){
    Fraction f = new Fraction();
    int denominator = Helper.getRandom(2,denominatorUpTo);
    f.setDenominator(denominator);
    int numerator = Helper.getRandom(1,denominator);
    f.setNumberator(numerator);
    return f;

  }
}