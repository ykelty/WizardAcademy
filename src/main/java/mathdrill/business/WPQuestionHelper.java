package mathdrill.business;
import java.util.Random;
import java.util.ArrayList;
import mathdrill.business.question.*;
/**
 * <p>Title: WPQuestionHelper</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author Li Kelty
 * @version 1.0
 */

public class WPQuestionHelper {

  public WPQuestionHelper() {
  }
  
  private static boolean binitiated= false;
  private static Random generator = new Random();
  private static ArrayList additionQuestions1 = new ArrayList();
  private static ArrayList boynames = new ArrayList();
  private static ArrayList girlnames = new ArrayList();
  private static ArrayList objects1 = new ArrayList();

    private static ArrayList objects2 = new ArrayList();
  private static ArrayList places1 = new ArrayList();
    private static ArrayList things1 = new ArrayList();
    private static ArrayList things2 = new ArrayList();
    private static ArrayList things3 = new ArrayList();
        private static ArrayList things4 = new ArrayList();
    private static ArrayList lastnames = new ArrayList();
    private static ArrayList desserts = new ArrayList();
    private static ArrayList schoolnames = new ArrayList();
     private static ArrayList activities = new ArrayList();
     private static ArrayList contests = new ArrayList();
    private static ArrayList events = new ArrayList();
   private static ArrayList animals1 = new ArrayList();
   private static ArrayList jeweries = new ArrayList();
   private static ArrayList collections1 = new ArrayList();
   private static void initCollections1() {
       collections1.add("baseball cards");
       collections1.add("soccer cards");
       collections1.add("basketball cards");
       collections1.add("stamps");
       collections1.add("coins");

    }
   private static void initJeweries() {
          jeweries.add("necklaces");
          jeweries.add("bracelets");
          jeweries.add("pins");
          jeweries.add("pendants");
          jeweries.add("friendship rings");

    }
   private static void initEvents() {
          events.add("a movie");
          events.add("a concert");
          events.add("a concert");
          events.add("a ballet");
          events.add("a baseball game");
          events.add("a basketball game");
          events.add("a soccer game");
    }
    private static void initAnimals1() {
              animals1.add("tadpoles");
              animals1.add("gerbils");
              animals1.add("turtles");
              animals1.add("gopher snakes");
              animals1.add("fish");

    }
    private static void initContests() {
         contests.add("a spelling bee contest");
         contests.add("a math contest");
         contests.add("a drawing contest");
          contests.add("a dancing contest");
          contests.add("a robot building contest");
          contests.add("a jumping rope contest");
  }
  private static void initBoynames() {
    boynames.add("Allen");
    boynames.add("Brad");
    boynames.add("Charles");
    boynames.add("Chris");
    boynames.add("Dale");
    boynames.add("Ethan");
    boynames.add("Frank");
    boynames.add("Henry");
    boynames.add("James");
    boynames.add("Jim");
    boynames.add("Joe");
    boynames.add("John");
    boynames.add("Larry");
    boynames.add("Mark");
    boynames.add("Michael");
    boynames.add("Max");
    boynames.add("Ron");
    boynames.add("Shawn");
    boynames.add("Tim");
    boynames.add("Tom");
    boynames.add("Wesley");
  }

  private static void initGirlnames() {
    girlnames.add("Amy");
    girlnames.add("Annie");
    girlnames.add("Chole");
    girlnames.add("Cathy");
    girlnames.add("Dorthy");
    girlnames.add("Eileen");
    girlnames.add("Ellen");
    girlnames.add("Gabby");
    girlnames.add("Hannah");
    girlnames.add("Jamie");
    girlnames.add("Jess");
    girlnames.add("Lan");
    girlnames.add("Lori");
    girlnames.add("Martha");
    girlnames.add("May");
    girlnames.add("Melanie");
    girlnames.add("Rachel");
    girlnames.add("Susie");
    girlnames.add("Tina");
    girlnames.add("Teresa");
    girlnames.add("Vicki");
  }
  private static void initSchoolnames() {
  schoolnames.add("Sunshine Elementary");
  schoolnames.add("Happy Valley Elementary");
  schoolnames.add("Birchwood Elementary");
  schoolnames.add("Brownsville Elementary");
  schoolnames.add("Lakeview Elementary");
  schoolnames.add("Hopkins Elementary");
  schoolnames.add("Ingraham Elementary");
  schoolnames.add("Jefferson Elementary");
  schoolnames.add("Kendall Elementary");
  schoolnames.add("Liberty Elementary");

  }

  private static void initLastnames() {
   lastnames.add("Smith");
   lastnames.add("Johnson");
   lastnames.add("Williams");
   lastnames.add("Jones");
   lastnames.add("Brown");
   lastnames.add("Davis");
   lastnames.add("Miller");
   lastnames.add("Wilson");
   lastnames.add("Moore");
   lastnames.add("Taylor");
   lastnames.add("Anderson");
   lastnames.add("Thomas");
   lastnames.add("Jackson");
   lastnames.add("White");
   lastnames.add("Harris");
   lastnames.add("Martin");
   lastnames.add("Thompson");
   lastnames.add("Garcia");
   lastnames.add("Martinez");
   lastnames.add("Clark");
   lastnames.add("Rodriguez");
  }
  private static void initObject1(){
  objects1.add("stamps");
  objects1.add("books");
  objects1.add("markers");
  objects1.add("erasers");
  objects1.add("stickers");
  objects1.add("pens");
  objects1.add("notebooks");
  objects1.add("cards");
  objects1.add("gift bags");
  objects1.add("toy cars");
  objects1.add("spoons");
  objects1.add("snow globes");
  objects1.add("shirts");
    objects1.add("tickets");
}
private static void initObject2(){
  objects2.add("markers");
  objects2.add("crayons");
  objects2.add("erasers");
  objects2.add("beads");
  objects2.add("cards");
  objects2.add("file folders");
  objects2.add("gift bags");
  objects2.add("paper flowers");
}
private static void initPlaces1(){
  places1.add("a park");
  places1.add("a parking lot");
  places1.add("a gym");
  places1.add("a movie theater");
  places1.add("a playground");
  places1.add("an auditorium");
  places1.add("a mall");
  places1.add("a cafe");
  places1.add("a race");
  places1.add("a ballpark");
}
private static void initThings1(){
  things1.add("paper airplanes");
  things1.add("origamis");
  things1.add("braclets");
  things1.add("necklaces");
    things1.add("hair pins");
  things1.add("Christmas ornaments");
  things1.add("valentine cards");
  things1.add("doll dresses");

}
private static void initThings2(){
  things2.add("cookies");
   things2.add("ballons");
  things2.add("eggs");
    things2.add("stickers");
     things2.add("trading cards");
  things2.add("juice boxes");
  things2.add("pencils");
    things2.add("markers");
  things2.add("erasers");
  things2.add("water bottles");
  things2.add("noise makers");
  things2.add("pingpong balls");

}
private static void initThings3(){
  things3.add("books");
  things3.add("movie tickets");
  things3.add("toy cars");
  things3.add("soccer balls");
    things3.add("dolls");
  things3.add("shirts");
  things3.add("mugs");
  things3.add("webkinz");
 things3.add("ornaments");
}
private static void initThings4(){
  things4.add("model cars");
  things4.add("model trains");
  things4.add("baseballs");
  things4.add("snow globes");
    things4.add("watches");
  things4.add("mugs");
  things4.add("basketballs");
  things4.add("webkinz");
 things4.add("ornaments");
}
private static void initDesserts(){
  desserts.add("sugar cookies");
  desserts.add("chocolate chip cookies");
  desserts.add("scones");
  desserts.add("muffins");
    desserts.add("brownies");
  desserts.add("cookies");

}
private static void initActivities(){
  activities.add("playing piano");
  activities.add("playing violin");
  activities.add("playing soccer");
  activities.add("playing baseball");
    activities.add("playing chess");
  activities.add("playing saxophone");

}
public static String getJewery (){
  String rString ="a movie"; //default boy name
  int size=jeweries.size();
  int index=generator.nextInt(size);
  rString = (String)jeweries.get(index);
  return rString;
  }
public static String getEvent (){
  String rString ="a movie"; //default boy name
  int size=events.size();
  int index=generator.nextInt(size);
  rString = (String)events.get(index);
  return rString;
  }
  public static String getAnimal (){
  String rString ="fish"; //default boy name
  int size=animals1.size();
  int index=generator.nextInt(size);
  rString = (String)animals1.get(index);
  return rString;
  }
public static String getActivity (){
  String rString ="playing saxophone"; //default boy name
  int size=activities.size();
  int index=generator.nextInt(size);
  rString = (String)activities.get(index);
  return rString;
  }
  public static String getContest (){
  String rString ="a math contest"; //default
  int size=contests.size();
  int index=generator.nextInt(size);
  rString = (String)contests.get(index);
  return rString;
  }
  public static String getCollection1 (){
String rString ="a math contest"; //default
int size=collections1.size();
int index=generator.nextInt(size);
rString = (String)collections1.get(index);
return rString;
  }
  public static String getBoyname (){
    String rString ="Joe"; //default boy name
    int size=boynames.size();
    int index=generator.nextInt(size);
    rString = (String)boynames.get(index);
    return rString;
  }
  public static String getGirlname (){
  String rString ="Lisa"; //default boy name
  int size=girlnames.size();
  int index=generator.nextInt(size);
  rString = (String)girlnames.get(index);
  return rString;
  }
  public static String getSchoolname (){
    String rString ="Jefferson Elementary"; //default boy name
    int size=schoolnames.size();
    int index=generator.nextInt(size);
    rString = (String)schoolnames.get(index);
    return rString;
  }
  public static String getObject1 (){
  String rString ="lollipops"; //default boy name
  int size=objects1.size();
  int index=generator.nextInt(size);
  rString = (String)objects1.get(index);
  return rString;
  }
  public static String getObject2 (){
    String rString ="lollipops"; //default boy name
    int size=objects2.size();
    int index=generator.nextInt(size);
    rString = (String)objects2.get(index);
    return rString;
  }
  public static String getPlace1 (){
    String rString ="a park"; //default boy name
    int size=places1.size();
    int index=generator.nextInt(size);
    rString = (String)places1.get(index);
    return rString;
  }
  public static String getThing1 (){
  String rString ="hair pins"; //default boy name
  int size=things1.size();
  int index=generator.nextInt(size);
  rString = (String)things1.get(index);
  return rString;
  }
  public static String getThing2 (){
  String rString ="hair pins"; //default boy name
  int size=things2.size();
  int index=generator.nextInt(size);
  rString = (String)things2.get(index);
  return rString;
  }
  public static String getThing3 (){
String rString ="hair pins"; //default boy name
int size=things3.size();
int index=generator.nextInt(size);
rString = (String)things3.get(index);
return rString;
  }
  public static String getThing4 (){
String rString ="hair pins"; //default boy name
int size=things4.size();
int index=generator.nextInt(size);
rString = (String)things4.get(index);
return rString;
  }
  public static String getLastname (){
  String rString ="Davis"; //default boy name
  int size=lastnames.size();
  int index=generator.nextInt(size);
  rString = (String)lastnames.get(index);
  return rString;
  }

  public static String getDessert (){
  String rString ="cookeis"; //default boy name
  int size=desserts.size();
  int index=generator.nextInt(size);
  rString = (String)desserts.get(index);
  return rString;
  }
private static String getAdditionQuestions1(int n1, int n2){
init();
  int instance = generator.nextInt(13)+1;  //random number from 1 to 12
  String question = "";
  String object1=getObject1();
  String boyname=getBoyname();
  String girlname=getGirlname();
  String place1=getPlace1();
  String thing1=getThing1();
    String schoolname=getSchoolname();
  switch (instance) {
    case 1:
      question=boyname+" had "+ n1+" " + object1 + ". He then found "+n2+ " more "+object1+". How many "+object1+" does he have in all?";
      break;
    case 2:
      question=girlname +" has "+ n1+" " + object1 + ". "+ boyname+ " has "+ n2+" " + object1 + ". " +"How many "+object1+"  do they have altogether?";
      break;
    case 3:
      question=boyname +" has "+ n1+" " + object1 + ". "+ girlname+ " has "+ n2+" more " + object1 + ". " +"How many "+object1+"  does "+girlname +" have?";
      break;
   case 4:
      question="There are "+n1+" boys and "+n2+" girls in "+place1+". How many kids are there all together?";
      break;
    case 5:
      question="There were "+n1+" boys in "+place1+". "+ n2 +" boys joined them later. How many boys are there all together?";
      break;
    case 6:
       question=girlname + " made " +n1+" "+thing1+" in the morning. She then made "+n2+" " +thing1+ " in the afternoon. How many "+thing1+" did she make all together?";
       break;
    case 7:
       question=boyname +" is "+ n1+" years old. "+ girlname+ " is "+ n2+" years older than him. How old is "+girlname+"?";
      break;
    case 8:
      question=girlname +" is "+ n1+" years old. "+ boyname+ " is "+ n2+" years older. How old is "+boyname+"?";
      break;
    case 9:
      question=girlname +" gave "+ n1+ " " + thing1 + " to her younger sister. Now she only has  "+ n2+ " " + thing1+". How many "+ thing1 + " did she have at first?";
      break;
    case 10:
      question=boyname +" had some "+ object1 + " . He gave "+ n1+ " away and had "+n2+" left. How many "+ object1+" did he have at first?";
      break;
    case 11:
      question=n1+ " teachers from "+schoolname+" received Teacher of the Year awards last year. This year, "+n2+" more teachers received the awards. How many teachers from "+schoolname +" received the awards this year?";
      break;
    case 12:
    	  question=boyname +" has "+ n1+ " " + object1 + ". "+ girlname + " has " + n2 + " " + object1 + ". If " +boyname+ " steals all of " +girlname+ "'s " +object1+ ". How many " +object1+ " will he have?";
    	  break;
    case 13:
        question=boyname +" is "+ n1+" years old. "+ girlname+ " is "+ n2+" years old. What is the sum of their ages?";
       break;  
  }
  return question;

}
private static String getSubtractQuestions1(int n1, int n2){
init();
  int instance = generator.nextInt(14)+1;  //random number from 1 to 12
  String question = "";
  String object1=getObject1();
  String boyname=getBoyname();
  String girlname=getGirlname();
  String place1=getPlace1();
  String thing1=getThing1();
String schoolname=getSchoolname();
switch (instance) {
    case 1:
      question=boyname+" had "+ n1+" " + object1 + ". He then gave "+n2+ " "+object1+" to his brother. How many "+object1+" does he have now?";
      break;
    case 2:
      question=girlname +" has "+ n1+" " + object1 + ". "+ boyname+ " has "+ n2+" " + object1 + ". " +"How many more "+object1+"  does "+ girlname+" have?";
      break;
    case 3:
      question=boyname +" has "+ n1+" " + object1 + ". "+ girlname+ " has "+ n2+" less " + object1 + ". " +"How many "+object1+"  does "+girlname +" have?";
      break;
   case 4:
      question="There are "+n1+" kids in "+place1+". " + n2 + " of them are boys. How many girls are there?";
      break;
    case 5:
      question="There were "+n1+" boys in "+place1+". "+ n2 +" boys have left. How many boys are there now?";
      break;
    case 6:
       question=girlname + " and  her sister made " +n1+" "+thing1+" together. "+ girlname +" made "+n2+" " +thing1+ ". How many "+ thing1 + " did her sister make?";
       break;
    case 7:
       question=girlname +" is "+ n1+" years old. "+ boyname+ " is "+ n2+" years younger than her. How old is "+boyname+"?";
      break;
    case 8:
      question=boyname +" is "+ n1+" years old. "+ girlname+ " is "+ n2+" years younger. How old is "+girlname+"?";
      break;
    case 9:
      question=boyname +" and "+ girlname +" have "+ n1+" "+ object1+ " together. "+ n2+" of them belong to "+girlname+". How many "+object1+" does "+boyname+" have?";
      break;
    case 10:
      question=boyname +" is "+ n1+" years old. How old was he "+ n2+" years ago?";
     break;
   case 11:
     question=girlname +" invited "+ n1+" friends to her birthday party. "+ n2+" of them came.  How many friends did not come to the party?";
     break;
   case 12:
    question="The city museum is "+ n1 + " miles away." + boyname+" has already driven "+ n2 +" miles.  How many miles does he have left to drive?";
    break;
   case 13:
    question=boyname+ " had "+ n2+ " " + object1 + ". He bought some more. Then he had  "+n1+ " "+object1+". How many "+object1+" did he buy?";
   break;
   case 14:
	question=n2+ " teachers from "+schoolname+" received Teacher of the Year awards last year. This year, "+n1+"  teachers received the awards. How many more teachers from "+schoolname +" received the awards this year?";
      break;
      
  }

     return question;

}

private static String getMultiplicationQuestions1(int n1, int n2){
init();
  int instance = generator.nextInt(16)+1;  //random number from 1 to 12
  String question = "";
  String object1=getObject1();
  String boyname=getBoyname();
  String girlname=getGirlname();
  String place1=getPlace1();
  String thing1=getThing1();
  String thing2=getThing2();
    String thing4=getThing4();
String schoolname=getSchoolname();
String lastname=getLastname();
String  dessert = getDessert();
String activity=getActivity();
String contest = getContest();
switch (instance) {
    case 1:
      question="There are "+n1+" rows of seats in a classroom. Each row has "+n2+" seats. How many seats are there in all?";
      break;
    case 2:
      question="A building has "+n1+"  floors. There are  "+n2+" rooms  per floor. How many rooms are in the building?";
      break;
    case 3:
       question=girlname+" bought "+n1+" packages of "+thing2+". There were "+n2+" "+thing2+" in each package. How many "+thing2+" did "+girlname+" buy?";
       break;
    case 4:
        question=boyname+" works "+n1+" hours a day. How many hours does he work in "+n2+" days?";
        break;
    case 5:
        question=boyname+" ordered "+n1+" pizzas for his party. Each pizza was sliced into "+n2+" slices. How many pizza slices were there all together?";
        break;
    case 6:
          question=girlname+" bought "+n1+" dolls. Each doll cost $"+n2+". How many dollars did she spend on the dolls?";
          break;
    case 7:
          question="There are "+n1+" men in "+place1+". "+ n2+" times as many women as men are there. How many women are there ?";
          break;
    case 8:
          question="There are "+n1+" boys in "+schoolname+" "+ activity+". There are " +n2+" times as many girls in "+ schoolname+" "+ activity+". How many girls in "+schoolname+" "+ activity+"?";
          break;
    case 9:
          question=boyname+" drinks "+n1+" ounces of water every hour.  How many ounces of water does he drink in " +n2+" hours?";
          break;
    case 10:
          question=girlname+" wrote a poem with "+n1+" sentences. Each sentence contained "+n2+" words. How many words were in the poem?";
          break;
    case 11:
      question="Mrs. "+lastname+" baked "+n1+" trays of "+dessert+". Each tray has "+n2+" "+dessert+". How many "+dessert+" did she bake in all?";
       break;
    case 12:
      question= boyname+" had "+n1+" gerbils. Each of them had "+n2+" babies last month. How many baby gerbils does "+boyname+" have all together?";
      break;
    case 13:
      question= boyname+" has a collection of "+thing4+". He displayed them on  "+n1+" shelves. Each shelf holds "+n2+ " " +thing4+". How many  "+thing4+" does "+boyname+" have in his collection?";
      break;

    case 14:
       question= "Students in "+schoolname+" are going to have "+contest+" . There will be "+ n1+" teams and each team will have "+n2+ " students. How many students will be in the contest?";
       break;
     case 15:
         question= girlname+" can make "+thing1+" quickly. She can make "+n1+" "+ thing1+" in one day. How many "+thing1+" can she make in "+n2+" days?";
         break;
    case 16:
         question= girlname+" has "+n1+" "+ object1+". "+ boyname+" has "+n2+" times as many "+object1+" as "+girlname+". How many "+object1+" does "+ boyname+" have?";
         break;
    

  }

     return question;

}

private static String getMultiplicationQuestions2(int n1, int n2){
init();
  int instance = generator.nextInt(16)+1;  //random number from 1 to 12
  String question = "";
  String object1=getObject1();
  String boyname=getBoyname();
  String girlname=getGirlname();
  String place1=getPlace1();
  String thing1=getThing1();
  String thing2=getThing2();
    String thing4=getThing4();
String schoolname=getSchoolname();
String lastname=getLastname();
String  dessert = getDessert();
String activity=getActivity();
String contest = getContest();
String animal1=getAnimal();
String jewery=getJewery();
String collection1=getCollection1();
switch (instance) {
    case 1:
      question="There are "+n2+" rows of seats in an auditorium. Each row has "+n1+" seats. How many seats are there in all?";
      break;
    case 2:
      question="A building has "+n2+"  floors. There are  "+n1+" rooms  per floor. How many rooms are in the building?";
      break;
    case 3:
       question=girlname+" bought "+n1+" packages of "+thing2+". There were "+n2+" "+thing2+" in each package. How many "+thing2+" did "+girlname+" buy?";
       break;
    case 4:
        question=boyname+" works "+n2+" hours a day. How many hours does he work in "+n1+" days?";
        break;
    case 5:
        question=girlname+" made "+n2+" "+jewery+" for each of "+n1+" homeless grils in her community. How many "+jewery+" did she make altogether?";
        break;
    case 6:
          question="Mrs. "+lastname +" ordered "+n2+" boxes of "+object1+". There are "+n1+" "+object1+" in each box. How many "+object1+" did she order?";
          break;
    case 7:
          question="There are "+n1+" men gathered in "+place1+" for a rally. There are "+ n2+" times as many women as men. How many women are there?";
          break;
    case 8:
          question="There are "+n1+" boy in "+schoolname+" "+ activity+". There are " +n2+" times as many girls "+ activity+". How many girls in "+schoolname+" "+ activity+"?";
          break;
    case 9:
          question=boyname+" drinks "+n1+" ounces of juice every day. How many ounces of juice does he drink in " +n2+" days?";
          break;
    case 10:
          question=girlname+" solved "+n1+" questions in a math contest. Each question is worth "+n2+" points. How many points did "+ girlname+ " receive in the contest?";
          break;
    case 11:
          question="Mrs. "+lastname+" baked "+n2+" trays of "+dessert+" for the school carnival. Each tray has "+n1+"  "+dessert+". How many "+dessert+" did she bake in all?";
          break;
    case 12:
          question= "A pet store has "+n1+" tanks of "+animal1+". There are "+n2+" "+animal1+" in each tank. How many "+animal1+" are there altogether?";
          break;
    case 13:
          question= boyname+" displays his "+thing4+" collection on  "+n2+" shelves. He placed "+n1+ " " +thing4+" on each shelf. How many  "+thing4+" does "+boyname+" have in his collection?";
          break;
    case 14:
          question= "Students in "+schoolname+" are going to have "+contest+" . There will be "+ n1+" teams and each team will have "+n2+ " students. How many students will be in the contest?";
          break;
     case 15:
          question= girlname+" plans to make "+thing1+" for homeless children. She can make "+n2+" "+ thing1+" in one day. How many "+thing1+" can she make in "+n1+" days?";
          break;
    case 16:
          question= girlname +" has collected "+n1+" "+ collection1+". "+ boyname+" has collected "+n2+" times as many "+collection1+" as "+girlname+". How many "+collection1+" does "+ boyname+" have?";
          break;
  }

     return question;

}
private static String getDivisionQuestions1(int n1, int n2){
init();
  int instance = generator.nextInt(16)+1;  //random number from 1 to 12
  String question = "";
  String object1=getObject1();
  String boyname=getBoyname();
  String girlname=getGirlname();
  String place1=getPlace1();
  String thing1=getThing1();
  String thing2=getThing2();
    String thing4=getThing4();
String schoolname=getSchoolname();
String lastname=getLastname();
String  dessert = getDessert();
String  event = getEvent();
switch (instance) {
    case 1:
      question="There are "+n2+" "+ thing1 + " in each package. "+girlname+" wants to buy "+n1+" "+ thing1 + ". How many packages should she buy?";
      break;
    case 2:
      question=boyname+" reads exactly "+n2+" pages of his new book every day. The book is "+n1+" pages long. How many days will it take him to read the whole book?";
      break;
    case 3:
       question= "If " + girlname+ " can fit "+n2+" "+ thing1 + " in each box, how many boxes should she use to pack "+n1+" "+ thing1+"?";
       break;
    case 4:
      question="If "+ girlname+ " runs "+n2+" miles per day, how many days will it take her to run "+n1+" miles?";
        break;
    case 5:
        question=girlname + " can place "+n2+" "+dessert +" on each plate. How many plates does she need for "+n1+" "+dessert+"?";
        break;
    case 6:
          question="One large pizza can serve "+n2+" children. How many large pizzas do we need to serve "+ n1 +" children?";
          break;
    case 7:
          question="A classroom has "+n2+" rows of seats and each row has the same number of seats. If the classroom can seat "+ n1 +" people, how many seats are in each row?";
          break;
    case 8:
          question=boyname+ " made "+n2+" equal packages of "+thing1+". How many "+thing1+" did "+boyname+" put in each package if he packaged "+n1+" "+thing1 +" in all?";
          break;
    case 9:
          question=girlname+" uses "+n2+" flowers to decorate each table. If she has "+n1+" flowers, how many tables can she decorate?";
          break;
    case 10:
          question="Mrs. "+ lastname+" gave each child "+n2+" "+thing2+". If she has "+n1+" "+thing2+", how many children can she give"+ thing2+" to?";
          break;
    case 11:
      question="Mrs. "+lastname+" baked "+n1+" "+dessert+". She put "+n2+" "+dessert+" on each tray. How many trays did she use?";
       break;
    case 12:
      question= boyname+" volunteers at the library. He works "+n2+" hours every time he goes. Last month "+boyname+" worked a total of "+n1+" hours. How many times did he work in the library last month?";
      break;
    case 13:
      question= "There are "+n1+" students in the school choirs. The music teacher, Mrs. "+ lastname+", wants to have "+n2+ " equal rows of students on stage. How many students should be in each row?";
      break;
    case 14:
        question=girlname + " has to learn "+n1+" lines for the school play. If she learns "+n2 +" lines every days. How many days will it take her to learn all her lines?";
        break;
    case 15:
          question=boyname + " learns "+n2+" new words every day. How many days will it take him to learn "+n1 +" new words?";
          break;
    case 16:
      question=boyname + " went to " + event+" last night. They paid a total of "+n1+" dollars for tickets. Each ticket cost "+n2 +" dollars. How many tickets did they buy altogether?";
      break;

  }
     return question;

}

private static String getDivisionQuestions2(int n1, int n2){
init();
  int instance = generator.nextInt(16)+1;  //random number from 1 to 12
  String question = "";
  String object1=getObject1();
  String boyname=getBoyname();
  String girlname=getGirlname();
  String place1=getPlace1();
  String thing1=getThing1();
  String thing2=getThing2();
    String thing4=getThing4();
String schoolname=getSchoolname();
String lastname=getLastname();
String  dessert = getDessert();
String  event = getEvent();

switch (instance) {
    case 1:
      question="There are "+n2+" "+ thing1 + " in each package. "+girlname+" wants to buy "+n1+" "+ thing1 + ". How many packages should she buy?";
      break;
    case 2:
      question=boyname+" reads exactly "+n2+" pages of his new book every day. The book is "+n1+" pages long. How many days will it take him to finish reading the book?";
      break;
    case 3:
       question= "If " + girlname+ " can fit "+n2+" "+ thing1 + " in each box, how many boxes should she use to pack "+n1+" "+ thing1+"?";
       break;
    case 4:
      question="If "+ girlname+ " runs "+n2+" miles per day, how many days will it take her to run "+n1+" miles?";
        break;
    case 5:
        question=girlname + " can place "+n2+" "+dessert +" on each tray. How many trays does she need for "+n1+" "+dessert+"?";
        break;
    case 6:
          question="One large pizza can serve "+n2+" children. There will be "+n1+" children coming to the carnival. How many large pizzas do we need to buy?";
          break;
    case 7:
          question="An auditorium has "+n2+" rows of seats and each row has the same number of seats. If the auditorium can seat "+ n1 +" people, how many seats are in each row?";
          break;
    case 8:
          question=boyname+ " made "+n2+" equal packages of "+thing1+". How many "+thing1+" did "+boyname+" put in each package if he packaged "+n1+" "+thing1 +" in all?";
          break;
    case 9:
          question=girlname+" use "+n2+" flowers to decorate each table. If she has "+n1+" flowers, how many tables can she decorate?";
          break;
    case 10:
          question="Mrs. "+ lastname+" plans to give each child "+n2+" "+thing2+". If she has "+n1+" "+thing2+", how many children can she give "+ thing2+" to?";
          break;
    case 11:
      question="A baby elephant weighs "+n1+" pounds. It weighs "+n2+" times as many pounds as a baby horse. How many pounds does the baby horse weigh?";
       break;
    case 12:
      question= boyname+" volunteers at the library. He works "+n2+" hours every time he goes. Last semester "+boyname+" worked a total of "+n1+" hours. How many times did he work in the library last semester?";
      break;
    case 13:
      question= "There are "+n1+" students in the school choirs. The music teacher, Mrs. "+ lastname+", wants to have "+n2+ " equal rows of students on stage. How many students should be in each row?";
      break;
    case 14:
        question=girlname + " has to learn "+n1+" lines for the school play. If she learns "+n2 +" lines every days. How many days will it take her to learn all her lines?";
        break;
    case 15:
          question=boyname + " makes "+n2+" new friends every day. How many days will it take him to make "+n1 +" friends?";
          break;
    case 16:
      question=boyname + " and friends went to " + event+" last night. They paid a total of "+n1+" dollars for tickets. Each ticket cost "+n2 +" dollars. How many tickets did they buy altogether?";
      break;

  }
     return question;

}

private static String getAdditionQuestions2(int n1, int n2){
init();
  int instance = generator.nextInt(13)+1;  //random number from 1 to 12
  String question = "";
  String object1=getObject1();
    String object2=getObject2();
  String boyname=getBoyname();
  String girlname=getGirlname();
  String place1=getPlace1();
  String thing1=getThing1();
  String schoolname=getSchoolname();
  switch (instance) {
    case 1:
      question=girlname+" baked "+n1+" sugar cookies and "+n1+" cholocate cookies. How many cookies did she bake in all?";
      break;
    case 2:
      question=girlname +" picked "+n1+" apples on the first day. On the next day, she picked "+n2+" more apples. How many apples did she pick in all?";
      break;
    case 3:
      question=girlname +" has "+ n1+" baseball cards. "+ boyname+ " has "+ n2+" more baseball cards. " +"How many baseball cards does "+boyname+" have?";
      break;
    case 4:
      question=boyname +" has "+ n1+" "+object2 +". "+ girlname+ " has "+ n2+" more "+object2 + ". How many "+object2 + " does "+girlname+" have?";
      break;
    case 5:
      question="There are "+n1+" boys and "+n2+" girls in "+place1+". How many kids are there all together?";
       break;
    case 6:
       question="There were "+n1+" people in "+place1+". "+ n2 +" people joined them later. How many people are there all together?";
       break;
    case 7:
       question=girlname + " has "+n1+" blue "+object2 + " and "+ n2 +" red "+object2 + ". How many "+object2 + " does she have in all? ";
       break;
     case 8:
        question=boyname + " is a farmer. On Saturday, he sold "+n1+" pounds of potatos. On Sunday, he sold another "+ n2 +" pounds of potatos. How many pounds of potatos did he sell in all? ";
       break;
     case 9:
          question=n1 + " kids finished race. "+n2+" kids didn't finish the race. How many kids were in the race? ";
     break;
     case 10:
        question="Coach "+ boyname+ " ordered "+ n1 + " jerseys. Coach "+ girlname + " ordered "+n2+" jerseys. How many jerseys did they order in all? ";
     break;
     case 11:
       question= "In "+schoolname+", "+ n1 + " boys and "+n2+" girls participated in a district math contest. How many students from "+ schoolname+" participated in the math contest? ";
     break;
    case 12:
       question= "Mom planted "+ n1 + " tulip bulbs in the front yard. She planted "+n2+" tulips in the back yard. How many tulip bulbs did Mom plant in all? ";
     break;
   case 13:
      question= "A box office sold "+ n1 + " tickets this morning and "+n2+" tickets this afternoon. How many tickets did they sell in all? ";
    break;
   case 14:
 	  question=boyname +" has "+ n1+ " " + object1 + ". "+ girlname + " has " + n2 + " " + object1 + ". If " +boyname+ " steals all of " +girlname+ "'s " +object1+ ". How many " +object1+ "will he have?";
 	break;
   case 15:
      question=boyname +" is "+ n1+" years old. "+ girlname+ " is "+ n2+" years old. What is the sum of their ages?";
    break;
  }
  
  return question;

}

private static String getSubtractionQuestions2(int n1, int n2){
init();
  int instance = generator.nextInt(13)+1;  //random number from 1 to 12
  String question = "";
  String object1=getObject1();
    String object2=getObject2();
  String boyname=getBoyname();
  String girlname=getGirlname();
  String place1=getPlace1();
  String thing1=getThing1();

  switch (instance) {
    case 1:
      question=boyname+ " has a "+object1+" collection. He had "+ n1+" " + object1 + ". He then gave "+n2+ " "+object1+" to his brother. How many "+object1+" does he have now?";
      break;
    case 2:
      question="Both "+girlname +" and " + boyname+ " have "+ object1+" collections. "+ girlname+" has "+ n1+" " + object1 + ". "+ boyname+ " has "+ n2+" " + object1 + ". " +"How many more "+object1+"  does "+ girlname+" have?";
      break;
    case 3:
      question="Both "+girlname +" and " + boyname+ " have "+ object1+" collections. "+boyname +" has "+ n1+" " + object1 + ". "+ girlname+ " has "+ n2+" less " + object1 + ". " +"How many "+object1+"  does "+girlname +" have?";
      break;
   case 4:
      question="There are "+n1+" kids in "+place1+". " + n2 + " of them are boys. How many girls are there?";
      break;
    case 5:
      question="There were "+n1+" boys in "+place1+". "+ n2 +" boys have left. How many boys are there now?";
      break;
    case 6:
       question=girlname + " and her sister made " +n1+" "+thing1+" together. "+ girlname +" made "+n2+" " +thing1+ ". How many "+ thing1 + " did her sister make?";
       break;
    case 7:
       question=girlname +" is "+ n1+" years old. "+ boyname+ " is "+ n2+" years younger than her. How old is "+boyname+"?";
      break;
    case 8:
      question=boyname +" is "+ n1+" years old. "+ girlname+ " is "+ n2+" years younger. How old is "+girlname+"?";
      break;
    case 9:
      question=boyname +" and "+ girlname +" have "+ n1+" "+ object1+ " together. "+ n2+" of them belong to "+girlname+". How many "+object1+" does "+boyname+" have?";
      break;
    case 10:
      question=boyname +" is "+ n1+" years old. How old was he "+ n2+" years ago?";
     break;
   case 11:
    question="New York city is "+ n1 + " miles away." + boyname+" has already driven "+ n2 +" miles.  How many more miles does he have left to drive?";
    break;
  case 12:
    question=boyname+ " has a "+object1+" collection. He had "+ n2+ " " + object1 + ". He bought some more. Then he had  "+n1+ " "+object1+" How many "+object1+" did he buy?";
    break;
  case 13:
   question=girlname+ " has two ribbons. One ribbon is pink and is "+ n1+ " inches long. The other ribbon is blue and is " + n2 + " inches long. How many inches longer is the pink ribbon than the blue ribbon?";
   break;


  }
  return question;

}
  private static void init(){
    if (!binitiated){
      initBoynames();
      initGirlnames();
      initObject1();
      initObject2();
      initPlaces1();
      initThings1();
      initThings2();
      initThings3();
      initThings4();
      initSchoolnames();
      initLastnames();
      initDesserts();
      initActivities();
      initContests();
      initCollections1();
      initJeweries();
      initEvents();
      initAnimals1();
      binitiated = true;
    }
  }

  public static WPQuestion makeAddition1 (){
	System.out.println("aquestion makingsss");
    init();
    WPQuestion qa =new WPQuestion();
    int n1 = generator.nextInt(8) + 2; //random number from 2 to 9
    int n2 = generator.nextInt(8)+ 2;  //random number from 2 to 9

    String q =getAdditionQuestions1(n1,n2);
    String a = ""+(n1+n2);
    qa.setQuestion(q);
    qa.setAnswer(a);
    return qa;
  }
  public static WPQuestion makeMultiplication1 (){
    init();
    WPQuestion qa =new WPQuestion();
    int n1 = generator.nextInt(8) + 2; //random number from 2 to 9
    int n2 = generator.nextInt(8)+ 2;  //random number from 2 to 9

    String q =getMultiplicationQuestions1(n1,n2);
    String a = ""+(n1*n2);
    qa.setQuestion(q);
    qa.setAnswer(a);
    return qa;
  }
  public static WPQuestion makeDivision1 (){
    init();
    WPQuestion qa =new WPQuestion();
    int n2 = generator.nextInt(8) + 2; //random number from 2 to 9
    int n_a = generator.nextInt(8)+ 2;  //random number from 2 to 9
    int n1=n_a * n2;
    String q =getDivisionQuestions1(n1,n2);
    String a = ""+(n_a);
    qa.setQuestion(q);
    qa.setAnswer(a);
    return qa;
  }

  public static WPQuestion makeSubtraction1 (){
	 System.out.println("question makingsss");
     init();
     WPQuestion qa =new WPQuestion();
     int n1 = generator.nextInt(8) + 2; //random number from 2 to 9
     int n2 = generator.nextInt(8)+ 2;  //random number from 2 to 9

     // to make sure n1 > n2
     if (n1<n2){
       int tmp = n1;
       n1=n2;
       n2=n1;
     }
      if (n1==n2) n1++;

      String q =getSubtractQuestions1(n1,n2);
     String a = ""+(n1-n2);
     qa.setQuestion(q);
     qa.setAnswer(a);
     return qa;
   }

  public static WPQuestion makeAddition2 (){
	System.out.println("aquestion makingsss");
    init();
    WPQuestion qa =new WPQuestion();
    int n1 = generator.nextInt(90) + 10; //random number from 10 to 99
    int n2 = generator.nextInt(90)+ 10;  //random number from 10 to 99

    String q =getAdditionQuestions2(n1,n2);
    String a = ""+(n1+n2);
    qa.setQuestion(q);
    qa.setAnswer(a);
    return qa;
  }
  public static WPQuestion makeMultiplication2 (){
   init();
   WPQuestion qa =new WPQuestion();
   int n1 = generator.nextInt(90) + 10; //random number from 10 to 99
   int n2 = generator.nextInt(8)+ 2;  //random number from 2 to 9

   String q =getMultiplicationQuestions2(n1,n2);
   String a = ""+(n1*n2);
   qa.setQuestion(q);
   qa.setAnswer(a);
   return qa;
  }
  public static WPQuestion makeDivision2 (){
   init();
   WPQuestion qa =new WPQuestion();
   int n2 = generator.nextInt(8) + 2; //random number from 2 to 9
   int n_a = generator.nextInt(50)+ 10;  //random number from 10 to 59
   int n1=n_a * n2;

   String q =getDivisionQuestions2(n1,n2);
   String a = ""+(n_a);
   qa.setQuestion(q);
   qa.setAnswer(a);
   return qa;
  }

  public static WPQuestion makeSubtraction2 (){
	  System.out.println("question makingsss");
      init();
      WPQuestion qa =new WPQuestion();
      int n1 = generator.nextInt(90) + 10; //random number from 10 to 99
      int n2 = generator.nextInt(90)+ 10;  //random number from 10 to 99

      // to make sure n1 > n2
      if (n1<n2){
        int tmp = n1;
        n1=n2;
        n2=n1;
      }

      if (n1==n2) n1++;

      String q =getSubtractionQuestions2(n1,n2);
      String a = ""+(n1-n2);
      qa.setQuestion(q);
      qa.setAnswer(a);
      return qa;
   }

  public static void main(String[] args) {
    for (int i=0;i<20;i++){
      WPQuestion wpquestion = makeAddition1();
      System.out.println("Q:"+wpquestion.getQuestion());
      System.out.println("A:"+wpquestion.getAnswer());
    }
  }
}