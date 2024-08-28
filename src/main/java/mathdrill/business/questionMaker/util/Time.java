package mathdrill.business.questionMaker.util;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public  class Time {
  int hours;
  int minutes;
  public Time() {
  }
  public Time(int h,int m) {
   hours=h;
   minutes =m;
  }
  public int getHours() {return hours;}
  public int getMinutes() { return minutes;}

public static Time addTime(Time t1, Time t2){
  Time rTime = new Time(0,0);
  rTime.minutes=t1.minutes+t2.minutes;
  if (rTime.minutes>=60){
    rTime.minutes=rTime.minutes-60;
    rTime.hours=rTime.hours+1;
  }
  rTime.hours=rTime.hours+t1.hours+t2.hours;
  if (rTime.hours>12){
    rTime.hours=rTime.hours-12;
  }
  return rTime;
}


public static  Time subtractTime(Time t1, Time t2){
  Time rTime = new Time(0,0);
  rTime.minutes=t1.minutes-t2.minutes;
  if (rTime.minutes<0){
    rTime.minutes=rTime.minutes+60;
    rTime.hours=rTime.hours-1;
  }
  rTime.hours=rTime.hours+t1.hours-t2.hours;
  if (rTime.hours<=0){
    rTime.hours=rTime.hours+12;
  }
  return rTime;
}
}