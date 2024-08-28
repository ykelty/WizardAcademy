package mathdrill.business.questionMaker;
import mathdrill.business.*;
import mathdrill.business.question.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class Maker30 extends BaseMaker {

  public Maker30() {
  }
  public static BaseQuestion makeQuestion(String var2,String var3,String var4, String var5){
	    System.out.println("MAKE 30");
        BaseQuestion qa = null;
        int digits = intValue(var2);
        String questionType= var3;
        int random = Helper.getRandom(1,2);
        int int1 = Helper.getRandom(1, 9);
       
        System.out.println("MAKEeeee 30");
        if (int1 == 1){
          System.out.println("HELLO");
          if (digits==1)
            qa=WPQuestionHelper.makeAddition1();
          if (digits==2)
            qa=WPQuestionHelper.makeAddition2();

        }

        if (int1 == 2){
          if (digits==1)
             qa=WPQuestionHelper.makeSubtraction1();
           if (digits==2)
             qa= WPQuestionHelper.makeSubtraction2();

       }
       if (int1 == 3){
    	 
         if (random==1){
           if (digits==1)
             qa=WPQuestionHelper.makeAddition1();
           if (digits==2)
             qa=WPQuestionHelper.makeAddition2();         }
         else {
           if (digits==1)
             qa=WPQuestionHelper.makeSubtraction1();
           if (digits==2)
            qa= WPQuestionHelper.makeSubtraction2();
         }
       }
       if (int1 == 4){

           if (digits==1)
             qa=WPQuestionHelper.makeMultiplication1();
           if (digits==2)
              qa=WPQuestionHelper.makeMultiplication2();

        }
        if (int1 == 5){

             if (digits==1)
               qa=WPQuestionHelper.makeDivision1();
             if (digits==2)
                qa=WPQuestionHelper.makeDivision2();

          }

          if (int1 == 6){
        	  System.out.println("ENTERING MIXED 2");
            if (random==1){
              if (digits==1)
                qa=WPQuestionHelper.makeMultiplication1();
              if (digits==2)
                qa=WPQuestionHelper.makeMultiplication2();         }
            else {
              if (digits==1)
                qa=WPQuestionHelper.makeDivision1();
              if (digits==2)
               qa= WPQuestionHelper.makeDivision2();
            }
          }
          if (int1 == 7){
        	  System.out.println("ENTERING GRADE 2");
        	  random = Helper.getRandom(1,20);
        	  if (random==1){
        		  WPQuestion qa1 =new WPQuestion();
        		  qa1.setQuestion("Katie and Catherine are standing in line to buy tickets for a concert. Katie is 8th in line and Catherine is 17th in line. How many people are standing in between Katie and Catherine?");
        		  qa1.setAnswer("8");
        		  qa = qa1;
        	  }
              else if(random == 2) {
            	  WPQuestion qa2 =new WPQuestion();
            	  qa2.setQuestion("Avery bought 4 boxes of popsicles. Each box contains 18 popsicles. How many  popsicles did Avery buy altogether? ");
        		  qa2.setAnswer("72");
        		  qa = qa2;
              }
              else if(random == 3) {
            	  WPQuestion qa3 =new WPQuestion();
            	  qa3.setQuestion("Ronald had 2 quarters, 6 dimes and 3 nickels in his pocket. After he buys an ice cream cone for 75¢, how many cents does he have left?");
        		  qa3.setAnswer("50");
        		  qa = qa3;
              }
              else if(random == 4) {
            	  WPQuestion qa4 =new WPQuestion();
            	  qa4.setQuestion("Rachael was born on March 17, 2002. Today is November 12, 2015. How old will she be on her next birthday?");
        		  qa4.setAnswer("14");
        		  qa = qa4;
              }
              else if(random == 5) {
            	  WPQuestion qa5 =new WPQuestion();
            	  qa5.setQuestion("There are 4 flag poles in a row. The distance between any two flag poles that are next to each other is 18 yards. What is the distance between the first flag pole and the last flag pole?");
        		  qa5.setAnswer("54");
        		  qa=qa5;
              } else if(random == 6){
            	  WPQuestion qa6 =new WPQuestion();
            	  qa6.setQuestion("Arari, Bart, Colton and Dawson are 4 members of a relay race team. During a race, Colton was the first to run. Dawson ran before Bart. Arari ran before Dawson. Who was the last to run?");
        		  qa6.setAnswer("Bart");
        		  qa = qa6;
              } else if(random == 7) {
            	  WPQuestion qa7 =new WPQuestion();
            	  qa7.setQuestion("Yulia and Nata are on the same soccer team. Yulia scored 3 more goals than Nata this  season. Altogether they scored 15 goals. How many goals did Nata score this season?");
        		  qa7.setAnswer("6");
        		  qa = qa7;
              } else if(random == 8) {
            	  WPQuestion qa8 =new WPQuestion();
            	  qa8.setQuestion("Today is Cancer Awareness Day. The three Petersen sisters are each wearing one piece  of pink clothing. One is wearing a pink hat, one is wearing a pink coat, and one is wearing a pink scarf. Their names are Ashley, Barbara and Jamie. Ashley never wears a scarf. Barbara never wears a hat or a scarf. What pink item is Ashley wearing today?");
        		  qa8.setAnswer("hat");
        		  qa = qa8;
              } else if(random == 9) {
            	  WPQuestion qa9 =new WPQuestion();
            	  qa9.setQuestion("It is a perfect day to be outdoors. Truman’s Bike shop is very busy. There are several  bicycles and 6 tricycles in the shop. The total number of bicycle wheels in the shop is the same as the total number of tricycle wheels in the shop. How many bicycles are there in the shop?");
        		  qa9.setAnswer("9");
        		  qa = qa9;
              } else if(random == 10) {
            	  WPQuestion qa10 =new WPQuestion();
            	  qa10.setQuestion("Four friends ordered drinks. Sara ordered milk. Katherine, Tim and Allen ordered juice.  First, Sara decided to switch her drink with Katherine’s drink. Then Tim switched his drink with Allen’s drink. Lastly, Katherine switched her drink with Tim’s drink. Who ended up with milk?");
        		  qa10.setAnswer("Tim");
        		  qa = qa10;
              }
              else if (random==11){
        		  WPQuestion qa1 =new WPQuestion();
        		  qa1.setQuestion("Last week, Greg swam 3 days and ran 5 days. The only day that he did neither running nor swimming is Sunday. How many days did Greg do both running and swimming?");
        		  qa1.setAnswer("2");
        		  qa = qa1;
        	  }
              else if(random == 12) {
            	  WPQuestion qa2 =new WPQuestion();
            	  qa2.setQuestion("Sam eats 2 eggs every day. He bought a box of 12 eggs. He started eating the box of eggs on a Wednesday. On what day of the week did he eat the last 2 eggs in the box?");
        		  qa2.setAnswer("Monday");
        		  qa = qa2;
              }
              else if(random == 13) {
            	  WPQuestion qa3 =new WPQuestion();
            	  qa3.setQuestion("When Sabrina visits the corner coffee shop, she always buys one cup of coffee, one cupcake and nothing else. Each cupcake costs $1 and each cup of coffee costs $2. If Sabrina spent a total of $12 this week in the corner coffee shop, how many times did she visit there this week?");
        		  qa3.setAnswer("4");
        		  qa = qa3;
              }
              else if(random == 14) {
            	  WPQuestion qa4 =new WPQuestion();
            	  qa4.setQuestion("Leslie invented a card game. She needs 12 kings to play her game. There are 54 cards in a standard deck of cards. However, there are only 4 kings in each deck. How many standard decks of cards does Leslie need to get 12 kings?");
        		  qa4.setAnswer("3");
        		  qa = qa4;
              }
              else if(random == 15) {
            	  WPQuestion qa5 =new WPQuestion();
            	  qa5.setQuestion("May 1, 2016 is a Sunday. On what day of the week is May 14, 2016?");
        		  qa5.setAnswer("Saturday");
        		  qa=qa5;
              } else if(random == 16){
            	  WPQuestion qa6 =new WPQuestion();
            	  qa6.setQuestion("Mrs. Brown is buying 2 markers for each of the 12 students in her reading club. Markers are sold in boxes, and there are 8 markers in each box. How many boxes of markers should Mrs. Brown buy?");
        		  qa6.setAnswer("3");
        		  qa = qa6;
              } else if(random == 17) {
            	  WPQuestion qa7 =new WPQuestion();
            	  qa7.setQuestion("Mom cooked 24 dumplings. First Brady ate half of them, then Parker ate four, and  finally Chloe ate the rest. How many dumplings did Chloe eat?");
        		  qa7.setAnswer("8");
        		  qa = qa7;
              } else if(random == 18) {
            	  WPQuestion qa8 =new WPQuestion();
            	  qa8.setQuestion("There are 36 players in a soccer league. If each team has to have exactly 9 players and  each player is on exactly one team, how many teams are in the league?");
        		  qa8.setAnswer("4");
        		  qa = qa8;
              } else if(random == 19) {
            	  WPQuestion qa9 =new WPQuestion();
            	  qa9.setQuestion("There are 6 flowers in a flower pot. Each flower has 4 petals. How many petals are there in all?");
        		  qa9.setAnswer("24");
        		  qa = qa9;
              } else if(random == 20) {
            	  WPQuestion qa10 =new WPQuestion();
            	  qa10.setQuestion("20 + 30 + 40 + 50 = ?");
        		  qa10.setAnswer("140");
        		  qa = qa10;
              }
            }
          if (int1 == 8){
        	  System.out.println("ENTERING GRADE 3");
        	  random = Helper.getRandom(1,10);
        	  if (random==1){
        		  WPQuestion qa1 =new WPQuestion();
        		  qa1.setQuestion("What is the value of 2015 + 2016?");
        		  qa1.setAnswer("4031");
        		  qa = qa1;
        	  }
              else if(random == 2) {
            	  WPQuestion qa2 =new WPQuestion();
            	  qa2.setQuestion("There are 10 balloons numbered 1-10 in a carnival stand. Grace pointed at  the balloons and announced, “If you multiply all the numbers on the balloons that are odd  and greater than 6, you will find my grandma’s age.” How old is Grace’s grandma?");
        		  qa2.setAnswer("63");
        		  qa = qa2;
              }
              else if(random == 3) {
            	  WPQuestion qa3 =new WPQuestion();
            	  qa3.setQuestion("Sherya’s three dogs (Lucky, Butter and Oreo) weigh 110 pounds altogether. Lucky weighs 37  pounds. Butter weighs 6 pounds more than Lucky. How many pounds does Oreo weigh?");
        		  qa3.setAnswer("30");
        		  qa = qa3;
              }
              else if(random == 4) {
            	  WPQuestion qa4 =new WPQuestion();
            	  qa4.setQuestion("Robert is taking medicine for his ear infection. He needs to take the medicine every day for  20 days. He started taking the medicine on a Saturday. Which day of the week will be the last day he needs to take the medicine?");
        		  qa4.setAnswer("Thursday");
        		  qa = qa4;
              }
              else if(random == 5) {
            	  WPQuestion qa5 =new WPQuestion();
            	  qa5.setQuestion("Grandma made 15 cupcakes. After she gave her 3 daughters 1 cupcake each and her 4  grandchildren 2 cupcakes each, how many cupcakes were left?");
        		  qa5.setAnswer("4");
        		  qa=qa5;
              } else if(random == 6){
            	  WPQuestion qa6 =new WPQuestion();
            	  qa6.setQuestion("Ben had 6 packs of licorice. There were 10 pieces of licorice in each pack. Ben ate 1/4 of all his licorice. How many pieces of licorice did he eat?");
        		  qa6.setAnswer("15");
        		  qa = qa6;
              } else if(random == 7) {
            	  WPQuestion qa7 =new WPQuestion();
            	  qa7.setQuestion("Simmone plays music every day. On any given day, she either plays 20 minutes of piano  or she plays 10 minutes of harmonica. Last week she played a total of 60 minutes of piano.  What is the total number of minutes that she practiced harmonica last week?");
        		  qa7.setAnswer("40");
        		  qa = qa7;
              } else if(random == 8) {
            	  WPQuestion qa8 =new WPQuestion();
            	  qa8.setQuestion("Arari, Bart, Colton and Dawson are the 4 members of a relay race team. During a race,  Colton was the first to run. Dawson ran before Bart. Arari ran before Dawson. Who was the  last to run?");
        		  qa8.setAnswer("Bart");
        		  qa = qa8;
              } else if(random == 9) {
            	  WPQuestion qa9 =new WPQuestion();
            	  qa9.setQuestion("Yulia and Nata are on the same soccer team. Yulia scored 3 more goals than Nata this  season. Altogether they scored 15 goals. How many goals did Nata score this season?");
        		  qa9.setAnswer("6");
        		  qa = qa9;
              } else if(random == 10) {
            	  WPQuestion qa10 =new WPQuestion();
            	  qa10.setQuestion("Half of the girls in a school math club own a cell phone. There are 36 students in the math  club. The number of girls in the club is double the number of boys in the club. How many  girls in the club own a cell phone?");
        		  qa10.setAnswer("12");
        		  qa = qa10;
              }
              else if (random==11){
        		  WPQuestion qa1 =new WPQuestion();
        		  qa1.setQuestion("Tomorrow is Teacher Appreciation Day. Madison made some gift bags for her teachers. For some bags, she put 6 cookies in each bag. For the remaining bags, she put 3 cookies and 1 movie ticket in each bag. In total, she used 39 cookies and 5 movie tickets. How many gift bags did she prepare?");
        		  qa1.setAnswer("9");
        		  qa = qa1;
        	  }
              else if(random == 12) {
            	  WPQuestion qa2 =new WPQuestion();
            	  qa2.setQuestion("Mom cooked 20 dumplings. After Brady and Parker finished eating their dumplings,  Chloe ate the remaining 6 dumplings. If Brady ate 2 more than Parker, how many dumplings did Parker eat?");
        		  qa2.setAnswer("6");
        		  qa = qa2;
              }
              else if(random == 13) {
            	  WPQuestion qa3 =new WPQuestion();
            	  qa3.setQuestion("Mathew has $2.70 in coins in his pocket. He has at least one of each of the following  types of coins: penny, nickel, dime and quarter. He has no other types of coins. What is the least possible number of coins he could have?");
        		  qa3.setAnswer("17");
        		  qa = qa3;
              }
              else if(random == 14) {
            	  WPQuestion qa4 =new WPQuestion();
            	  qa4.setQuestion("Yesterday Nicole and Lynn rode their bikes from Columbia to Franklin. They left Columbia at the same time and took the same road. Nicole was faster than Lynn. After Nicole reached Franklin, she rode back on the same route until she met Lynn 3 miles from Franklin. Nicole then rode together with Lynn to Franklin. How many more miles did Nicole ride than Lynn?");
        		  qa4.setAnswer("6");
        		  qa = qa4;
              }
              else if(random == 15) {
            	  WPQuestion qa5 =new WPQuestion();
            	  qa5.setQuestion("When Sabrina visits the corner coffee shop, she always buys one cup of coffee, one  cupcake and nothing else. Each cupcake costs $1 and each cup of coffee costs $2. If Sabrina spent a total of $12 this week in the corner coffee shop, how many times did she visit there this week?");
        		  qa5.setAnswer("4");
        		  qa=qa5;
              } else if(random == 16){
            	  WPQuestion qa6 =new WPQuestion();
            	  qa6.setQuestion("Mrs. Thiemann teaches fourth-grade math, and she wants to buy bagels for her students.  She has 23 students in one class, 22 students in another class, and 21 students in her third class. The bagel store sells bagels by the box. Each box contains one baker’s dozen (13 bagels). If she wants to give one bagel for each student in her three classes, how many boxes of bagels does Mrs. Thiemann have to buy?");
        		  qa6.setAnswer("6");
        		  qa = qa6;
              } else if(random == 17) {
            	  WPQuestion qa7 =new WPQuestion();
            	  qa7.setQuestion("Labor Day in the United States is celebrated on the first Monday in September. This  year, Steve’s birthday is 20 days after Labor Day. What day of the week is Steve’s birthday this year?");
        		  qa7.setAnswer("Sunday");
        		  qa = qa7;
              } else if(random == 18) {
            	  WPQuestion qa8 =new WPQuestion();
            	  qa8.setQuestion("Silvia runs 6 laps every morning and 3 laps every evening, Monday through Friday. She  rests on Saturday and Sunday. How many laps does she run in one week?");
        		  qa8.setAnswer("45");
        		  qa = qa8;
              } else if(random == 19) {
            	  WPQuestion qa9 =new WPQuestion();
            	  qa9.setQuestion("Madison bought 12 sugar cookies, 6 chocolate chip cookies and 2 oatmeal cookies. She  gave half of all her cookies to her friend Stephanie. How many cookies did she give to Stephanie?");
        		  qa9.setAnswer("10");
        		  qa = qa9;
              } else if(random == 20) {
            	  WPQuestion qa10 =new WPQuestion();
            	  qa10.setQuestion("Mrs. Rao is 32 years old. She is four times as old as her daughter Jane. How old is Jane?");
        		  qa10.setAnswer("8");
        		  qa = qa10;
              }
            }
          if (int1 == 9){
        	  System.out.println("ENTERING GRADE 4");
        	  random = Helper.getRandom(1,10);
        	  if (random==1){
        		  WPQuestion qa1 =new WPQuestion();
        		  qa1.setQuestion("It is a perfect day to be outdoors. Truman’s Bike shop is very busy. There are a total of 15  bicycles and tricycles in the shop. The total number of bicycle wheels in the shop is the same as the total number of tricycle wheels in the shop. How many bicycles are there in the  shop?");
        		  qa1.setAnswer("9");
        		  qa = qa1;
        	  }
              else if(random == 2) {
            	  WPQuestion qa2 =new WPQuestion();
            	  qa2.setQuestion("A ticket for the movie Hotel Transylvania 2 costs $15 for an adult and $12 for a student.  Ellie asks her mom to take her and her friends to watch the movie. Ellie’s mom has to buy  an adult ticket for herself, and student tickets for Ellie and her friends. If Ellie’s mom doesn’t want to spend more than $80, at most how many friends can Ellie bring?");
        		  qa2.setAnswer("4");
        		  qa = qa2;
              }
              else if(random == 3) {
            	  WPQuestion qa3 =new WPQuestion();
            	  qa3.setQuestion("A flower shop sells roses for $2.15 each. Hugo only has $20. At most how many roses can  Hugo buy from the shop?");
        		  qa3.setAnswer("9");
        		  qa = qa3;
              }
              else if(random == 4) {
            	  WPQuestion qa4 =new WPQuestion();
            	  qa4.setQuestion("It is recess time. Half of the students in Mrs. Girard’s class are playing soccer and the other  half are playing kickball. There are 20 students in Mrs. Girard’s class. 12 of them are girls.  At least how many girls are playing soccer?");
        		  qa4.setAnswer("2");
        		  qa = qa4;
              }
              else if(random == 5) {
            	  WPQuestion qa5 =new WPQuestion();
            	  qa5.setQuestion("Among the 92 fans watching a youth baseball game, 46 of them are wearing something red,  57 of them are wearing something blue, and 15 of them are wearing both red AND blue.  How many of them are wearing neither red nor blue?");
        		  qa5.setAnswer("4");
        		  qa=qa5;
              } else if(random == 6){
            	  WPQuestion qa6 =new WPQuestion();
            	  qa6.setQuestion("Noshin is shorter than Mary. Esha is taller than Ling and Mary. Noshin is also shorter than  Ling but taller than Heidi. Who is the shortest of them all?");
        		  qa6.setAnswer("Heidi");
        		  qa = qa6;
              } else if(random == 7) {
            	  WPQuestion qa7 =new WPQuestion();
            	  qa7.setQuestion("Mrs. Johnson baked a total of 18 cookies. Two of her daughters, Casey and Carolyn, ate them all. Casey ate twice as many as Carolyn did. How many cookies did Casey eat?  ");
        		  qa7.setAnswer("12");
        		  qa = qa7;
              } else if(random == 8) {
            	  WPQuestion qa8 =new WPQuestion();
            	  qa8.setQuestion("Fall is bulb-planting season. Jada is busy planting bulbs in her flower garden. It takes Jada 1.5 minutes to plant one bulb. How many bulbs can Jada plant in 30 minutes?");
        		  qa8.setAnswer("20");
        		  qa = qa8;
              } else if(random == 9) {
            	  WPQuestion qa9 =new WPQuestion();
            	  qa9.setQuestion(" Uncle Rob told Renee, “My age is a 2-digit number. The tens digit is greater than the ones  digit. The product of the two digits is 35.” How old is Uncle Rob?");
        		  qa9.setAnswer("75");
        		  qa = qa9;
              } else if(random == 10) {
            	  WPQuestion qa10 =new WPQuestion();
            	  qa10.setQuestion("Riya is in a long line waiting for a concert to start. There are twice as many people behind  her as in front of her. She is 24th in line. How many people are there in the line altogether?");
        		  qa10.setAnswer("70");
        		  qa = qa10;
              }
            }
          if (questionType.equals("grade5")){
        	  System.out.println("ENTERING GRADE 5");
        	  random = Helper.getRandom(1,10);
        	  if (random==1){
        		  WPQuestion qa1 =new WPQuestion();
        		  qa1.setQuestion("Brenda is preparing food for a party. For every guest, she prepared one plate of spaghetti.  For every three guests, she prepared one plate of cookies. Brenda prepared a total of 96 plates of food. How many guests did Brenda prepare food for?");
        		  qa1.setAnswer("72");
        		  qa = qa1;
        	  }
              else if(random == 2) {
            	  WPQuestion qa2 =new WPQuestion();
            	  qa2.setQuestion("Laney sold popcorn in a baseball game to raise funds for his baseball club. Laney charged  $2 for each bag, or $3 for 2 bags. He sold 42 bags for a total of $76 during the game. How  many bags of popcorn did Laney sell at the price of $2 a bag?");
        		  qa2.setAnswer("26");
        		  qa = qa2;
              }
              else if(random == 3) {
            	  WPQuestion qa3 =new WPQuestion();
            	  qa3.setQuestion("Sunita did a survey of her school math club. The number of girls in the club who have a  cell phone is double the number of girls who don’t have one. The number of boys who don’t have a cell phone is double the number of boys who do. There are 15 girls and 21 boys in  the club. How many members have a cell phone in the math club?");
        		  qa3.setAnswer("17");
        		  qa = qa3;
              }
              else if(random == 4) {
            	  WPQuestion qa4 =new WPQuestion();
            	  qa4.setQuestion("Marcos had some math homework this weekend. He finished 7 problems on Friday night, he finished 2/3 of the remaining problems on Saturday, and he still had to solve 6 more problems on Sunday. What is the total number of problems Marcos received for his math homework this weekend?");
        		  qa4.setAnswer("25");
        		  qa = qa4;
              }
              else if(random == 5) {
            	  WPQuestion qa5 =new WPQuestion();
            	  qa5.setQuestion("Among the 92 fans watching a youth baseball game, 46 of them are wearing something red,  57 of them are wearing something blue, and 4 of them are wearing neither red nor blue. How  many of them are wearing both red and blue?");
        		  qa5.setAnswer("15");
        		  qa=qa5;
              } else if(random == 6){
            	  WPQuestion qa6 =new WPQuestion();
            	  qa6.setQuestion("Penny played two games of Pac-Man. The points she scored in her second game was 3/4 of the  points she scored in her first game. She scored a total of 280 points from the two games.  How many points did she score in her first game?");
        		  qa6.setAnswer("160");
        		  qa = qa6;
              } else if(random == 7) {
            	  WPQuestion qa7 =new WPQuestion();
            	  qa7.setQuestion("What is the largest three-digit whole number that is a multiple of 7?");
        		  qa7.setAnswer("994");
        		  qa = qa7;
              } else if(random == 8) {
            	  WPQuestion qa8 =new WPQuestion();
            	  qa8.setQuestion("A ticket for the movie Hotel Transylvania 2 costs $15 for an adult and $12 for a student.  Ellie asks her mom to take her and her friends to watch the movie. Ellie’s mom has to buy  an adult ticket for herself and student tickets for Ellie and her friends. If Ellie’s mom doesn’t  want to spend more than $80, at most how many friends can Ellie bring?");
        		  qa8.setAnswer("4");
        		  qa = qa8;
              } else if(random == 9) {
            	  WPQuestion qa9 =new WPQuestion();
            	  qa9.setQuestion("At Emeryville Elementary a bell rings every 40 minutes. At Millbury Elementary a bell rings  every 45 minutes. If both bells ring at 8:30 A.M., when will be the next time both bells ring  at the same time? Please label your answer with A.M. or P.M.");
        		  qa9.setAnswer("2:30 PM");
        		  qa = qa9;
              } else if(random == 10) {
            	  WPQuestion qa10 =new WPQuestion();
            	  qa10.setQuestion("2015 ÷ 5 = ?");
        		  qa10.setAnswer("403");
        		  qa = qa10;
              }
            }
          if (questionType.equals("grade6")){
        	  System.out.println("ENTERING GRADE 6");
        	  random = Helper.getRandom(1,10);
        	  if (random==1){
        		  WPQuestion qa1 =new WPQuestion();
        		  qa1.setQuestion("Brenda is preparing food for a party. For every guest, she prepared one plate of spaghetti. For every two guests, she prepared one plate of chips. For every three guests, she prepared one plate of cookies. Brenda prepared a total of 99 plates of food. How many guests did Brenda prepare food for?");
        		  qa1.setAnswer("54");
        		  qa = qa1;
        	  }
              else if(random == 2) {
            	  WPQuestion qa2 =new WPQuestion();
            	  qa2.setQuestion("Leigh brought 235 pieces of candy to her summer camp. Starting on day 1, she ate 5 pieces of candy every day. Later Leigh decided to let her roommate Mary share her candy. So starting on day 8, Mary ate 3 pieces of candy every day while Leigh continued to eat 5 pieces every day. When they finished all the candy, how many pieces of candy had Leigh eaten?");
        		  qa2.setAnswer("160");
        		  qa = qa2;
              }
              else if(random == 3) {
            	  WPQuestion qa3 =new WPQuestion();
            	  qa3.setQuestion("The ratio of Raymond’s current age to his age three years from now is 3:4 How old is he now?");
        		  qa3.setAnswer("9");
        		  qa = qa3;
              }
              else if(random == 4) {
            	  WPQuestion qa4 =new WPQuestion();
            	  qa4.setQuestion("When 42 is divided by a whole number P, the remainder is 5. What is the value of P?");
        		  qa4.setAnswer("37");
        		  qa = qa4;
              }
              else if(random == 5) {
            	  WPQuestion qa5 =new WPQuestion();
            	  qa5.setQuestion("One full jug of lemonade serves either 24 small glasses or 8 large glasses. Celine made one full jug of lemonade this morning for her party. She has already served 9 small glasses and 1 large glass. How many more small glasses can she serve?");
        		  qa5.setAnswer("12");
        		  qa=qa5;
              } else if(random == 6){
            	  WPQuestion qa6 =new WPQuestion();
            	  qa6.setQuestion("There are only gold, silver and bronze medals in a box. For every 3 bronze medals, there are 2 silver medals. For every 3 silver medals, there are 2 gold medals. There are a total of 12 gold medals in the box. How many bronze medals are there in the box?");
        		  qa6.setAnswer("27");
        		  qa = qa6;
              } else if(random == 7) {
            	  WPQuestion qa7 =new WPQuestion();
            	  qa7.setQuestion("Yesterday Mason jogged at a speed of 130 meters per minute for 1 hour. Today, because of rain, he could only jog at a speed of 100 meters per minute. How many more minutes did it take him to jog the same distance today as he did yesterday?");
        		  qa7.setAnswer("18");
        		  qa = qa7;
              } else if(random == 8) {
            	  WPQuestion qa8 =new WPQuestion();
            	  qa8.setQuestion("What is the largest three-digit whole number that is divisible by 7?");
        		  qa8.setAnswer("994");
        		  qa = qa8;
              } else if(random == 9) {
            	  WPQuestion qa9 =new WPQuestion();
            	  qa9.setQuestion("Half of the students in a math club have a phone. Of the students who have a phone, 30% have a smart phone. What percent of the students in the math club have a smart phone?");
        		  qa9.setAnswer("15%");
        		  qa = qa9;
              } else if(random == 10) {
            	  WPQuestion qa10 =new WPQuestion();
            	  qa10.setQuestion("During a soccer game, 140 fans occupy of the seats in a stadium. How many seats are there in the stadium altogether?");
        		  qa10.setAnswer("350");
        		  qa = qa10;
              }
            }
          if (questionType.equals("grade7")){
        	  System.out.println("ENTERING GRADE 7");
        	  random = Helper.getRandom(1,10);
        	  if (random==1){
        		  WPQuestion qa1 =new WPQuestion();
        		  qa1.setQuestion("Pam and Ryan are both raising money for their favorite charity: the Make-a-Wish Foundation. Pam’s goal is $28 more than Ryan’s goal. We also know that of Pam’s goal is the same as of Ryan’s goal. What is Pam’s goal?");
        		  qa1.setAnswer("48");
        		  qa = qa1;
        	  }
              else if(random == 2) {
            	  WPQuestion qa2 =new WPQuestion();
            	  qa2.setQuestion("The temperature at 6:00 A.M. this morning was °C. It reached 11°C at noon. What was the temperature at 10:00 A.M. this morning assuming the temperature rose at a constant rate during the day?");
        		  qa2.setAnswer("6");
        		  qa = qa2;
              }
              else if(random == 3) {
            	  WPQuestion qa3 =new WPQuestion();
            	  qa3.setQuestion("What is the average of all multiples of 7 between 1 and 100? Express your answer as a decimal rounded to the nearest tenth.");
        		  qa3.setAnswer("52.5");
        		  qa = qa3;
              }
              else if(random == 4) {
            	  WPQuestion qa4 =new WPQuestion();
            	  qa4.setQuestion("Mrs. O’Donnell is driving her daughter Linda and two of her friends, Rebecca and Ming, to a movie theater. There are four seats in the car available for the three girls: one passenger's seat and three seats in the back. Rebecca is the only one who is old enough to sit in the passenger's seat. How many possible seating arrangements are there?");
        		  qa4.setAnswer("12");
        		  qa = qa4;
              }
              else if(random == 5) {
            	  WPQuestion qa5 =new WPQuestion();
            	  qa5.setQuestion("January 1, 2016 is a Friday. There are 366 days in the year 2016. On what day of the week will December 31, 2016 fall?");
        		  qa5.setAnswer("Saturday");
        		  qa=qa5;
              } else if(random == 6){
            	  WPQuestion qa6 =new WPQuestion();
            	  qa6.setQuestion("On the last Noetic Learning Math Contest, the average score of Mrs. J’s class was 74 points and the average score of Mr. K’s class was 69 points. There are 30 students in Mrs. J’s class. There are 20 students in Mr. K’s class. If the scores of both classes are combined, what will be the average score?");
        		  qa6.setAnswer("72");
        		  qa = qa6;
              } else if(random == 7) {
            	  WPQuestion qa7 =new WPQuestion();
            	  qa7.setQuestion("Thirty-two teams participated in the 2014 Men's World Cup. The teams were divided into 8 groups with 4 teams per group. During the first stage of the tournament, every team played every other team in its group one time. No teams played any teams outside its group. What was the total number of games played during the first stage of the 2014 Men’s World Cup?");
        		  qa7.setAnswer("48");
        		  qa = qa7;
              } else if(random == 8) {
            	  WPQuestion qa8 =new WPQuestion();
            	  qa8.setQuestion("Leigh brought 235 pieces of candy to her summer camp. Starting on day 1, she ate 5 pieces of candy every day. Later Leigh decided to let her roommate Mary share her candy. So starting on day 8, Mary ate 3 pieces of candy every day while Leigh continued to eat 5 pieces every day. When they finished all the candy, how many pieces of candy had Leigh eaten?");
        		  qa8.setAnswer("160");
        		  qa = qa8;
              } else if(random == 9) {
            	  WPQuestion qa9 =new WPQuestion();
            	  qa9.setQuestion("Half of the students in a math club have a phone. Of the students who have a phone, 30% of them have a calculator. Of the students who don’t have a phone, 90% of them have a calculator. What percent of the students in the math club have a calculator?");
        		  qa9.setAnswer("60%");
        		  qa = qa9;
              } else if(random == 10) {
            	  WPQuestion qa10 =new WPQuestion();
            	  qa10.setQuestion("There are only gold, silver and bronze medals in a box. For every 3 bronze medals, there are 2 silver medals. For every 3 silver medals, there are 2 gold medals. There are a total of 12 gold medals in the box. How many bronze medals are there in the box?");
        		  qa10.setAnswer("27");
        		  qa = qa10;
              }
            }
          if (questionType.equals("grade8")){
        	  System.out.println("ENTERING GRADE 8");
        	  random = Helper.getRandom(1,10);
        	  if (random==1){
        		  WPQuestion qa1 =new WPQuestion();
        		  qa1.setQuestion("There is a bag with only blue and green marbles. If we remove one green marble, then one third of the remaining marbles will be green. If we remove one blue marble instead, then 40% of the remaining marbles will be green. How many total marbles were there in the bag originally?");
        		  qa1.setAnswer("16");
        		  qa = qa1;
        	  }
              else if(random == 2) {
            	  WPQuestion qa2 =new WPQuestion();
            	  qa2.setQuestion("There are 20 students in Mrs. Xavier’s fourth grade class. Every student in the class is either 9 years old or 10 years old. The sum of all of their ages is a multiple of 16. How many 10-year-old students are there in Mrs. Xavier’s class?");
        		  qa2.setAnswer("12");
        		  qa = qa2;
              }
              else if(random == 3) {
            	  WPQuestion qa3 =new WPQuestion();
            	  qa3.setQuestion("How many three-digit whole numbers are divisible by 9 but not divisible by 7?");
        		  qa3.setAnswer("86");
        		  qa = qa3;
              }
              else if(random == 4) {
            	  WPQuestion qa4 =new WPQuestion();
            	  qa4.setQuestion("Pam and Ryan are both raising money for their favorite charity: the Make-a-Wish Foundation. Pam’s goal is $28 more than Ryan’s goal. We also know that 1/3 of Pam’s goal is the same as 4/5 of Ryan’s goal. What is Pam’s goal?");
        		  qa4.setAnswer("48");
        		  qa = qa4;
              }
              else if(random == 5) {
            	  WPQuestion qa5 =new WPQuestion();
            	  qa5.setQuestion("There are 2 points (P and Q) on a piece of paper. How many different isosceles right triangles can be drawn on that piece of paper with points P and Q as vertices?");
        		  qa5.setAnswer("6");
        		  qa=qa5;
              } else if(random == 6){
            	  WPQuestion qa6 =new WPQuestion();
            	  qa6.setQuestion("Tatiana and Bob had a combined total of 48 markers. After Tatiana gave Bob 20% of her markers, Bob had twice as many as Tatiana. How many markers did Tatiana have originally?");
        		  qa6.setAnswer("20");
        		  qa = qa6;
              } else if(random == 7) {
            	  WPQuestion qa7 =new WPQuestion();
            	  qa7.setQuestion("The temperature at 6:00 A.M. this morning was °C. It reached 11°C at noon. What was the temperature at 10:00 A.M. this morning assuming the temperature rose at a constant rate during the day?");
        		  qa7.setAnswer("6");
        		  qa = qa7;
              } else if(random == 8) {
            	  WPQuestion qa8 =new WPQuestion();
            	  qa8.setQuestion("What percent of an 8-hour work day is 6 minutes? Round your answer to the nearest hundredth of a percent.");
        		  qa8.setAnswer("1.25");
        		  qa = qa8;
              } else if(random == 9) {
            	  WPQuestion qa9 =new WPQuestion();
            	  qa9.setQuestion("January 1, 2016 is a Friday. There are 366 days in the year 2016. On what day of the week will December 31, 2016 fall?");
        		  qa9.setAnswer("Saturday");
        		  qa = qa9;
              } else if(random == 10) {
            	  WPQuestion qa10 =new WPQuestion();
            	  qa10.setQuestion("The number 2015 is the sum of 5 consecutive whole numbers. What number is the smallest of the 5 consecutive whole numbers?");
        		  qa10.setAnswer("401");
        		  qa = qa10;
              }
            }
    System.out.println("QUESTION END: ");
    System.out.println(qa);
    return qa;
  }
}
