package mathdrill.business.questionMaker;
import java.util.Random;
import mathdrill.business.question.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class BaseMaker {
    static Random generator = new Random();
    static public int intValue (String value) { return  Integer.parseInt(value);}

    static public BaseQuestion makeQuestion(String wsType, String var2,String var3,String var4, String var5, String var6)
        throws MakerException
    {
      BaseQuestion  baseQuestion=null;

      if (wsType.equals("worksheet1")){
        //addition for a fact
        baseQuestion = Maker1.makeQuestion(var2,var3,var4,var5);
      }else
      if (wsType.equals("worksheet2")){
        //fraction comparsion
        baseQuestion = Maker2.makeQuestion(var2,var3,var4,var5);
      }else
      if (wsType.equals("worksheet3")){
        //numbersense comparison
        baseQuestion = Maker3.makeQuestion(var2,var3,var4,var5);
      }
      else if (wsType.equals("worksheet4")){
        //numbersense comparison
        baseQuestion = Maker4.makeQuestion(var2,var3,var4,var5);
      }
      else if (wsType.equals("worksheet5")){
        //numbersense comparison
        baseQuestion = Maker5.makeQuestion(var2,var3,var4,var5);
      }
      else if (wsType.equals("worksheet6")){
        //Decimals : Write numbers in standard form
        baseQuestion = Maker6.makeQuestion(var2,var3,var4,var5);
      }
      else if (wsType.equals("worksheet7")){
      //Decimals: Place value ( ex. what digit is in tenths place? )
       baseQuestion = Maker7.makeQuestion(var2,var3,var4,var5);
      }
      else if (wsType.equals("worksheet8")){
          //Decimals: basic operations
          baseQuestion = Maker8.makeQuestion(var2,var3,var4,var5);
      }
      else if (wsType.equals("worksheet9")){
          //Telling Time
          baseQuestion = Maker9.makeQuestion(var2,var3,var4,var5);
        }
      else if (wsType.equals("worksheet10")){
          //Telling Time : adding and subtracting time
          baseQuestion = Maker10.makeQuestion(var2,var3,var4,var5);
      }
      else if (wsType.equals("worksheet11")){
           //Order of Operation
           baseQuestion = Maker11.makeQuestion(var2,var3,var4,var5);
       }
      else if (wsType.equals("worksheet12")){
             //One Step Pre Algebra
             baseQuestion = Maker12.makeQuestion(var2,var3,var4,var5);
      }
       else if (wsType.equals("worksheet13")){
               //two Step Pre Algebra
               baseQuestion = Maker13.makeQuestion(var2,var3,var4,var5);
       }

       else if (wsType.equals("worksheet14")){
               //Divisibility
               baseQuestion = Maker14.makeQuestion(var2,var3,var4,var5);
       }
       else if (wsType.equals("worksheet15")){
                 //Mixed Divisibility
               baseQuestion = Maker15.makeQuestion(var2,var3,var4,var5);
       }
       else if (wsType.equals("worksheet16")){
                 //Mixed Divisibility
               baseQuestion = Maker16.makeQuestion(var2,var3,var4,var5);
       }
       else if (wsType.equals("worksheet17")){
                    //Mixed Divisibility
                  baseQuestion = Maker17.makeQuestion(var2,var3,var4,var5);
          }
       else if (wsType.equals("worksheet18")){
                        //Mixed Divisibility
                      baseQuestion = Maker18.makeQuestion(var2,var3,var4,var5);
       }
       else if (wsType.equals("worksheet19")){
                        //Mixed Addition/Subtraction
                      baseQuestion = Maker19.makeQuestion(var2,var3,var4,var5);
       }
       else if (wsType.equals("worksheet20")){
                        //Mixed Addition/Subtraction
              baseQuestion = Maker20.makeQuestion(var2,var3,var4,var5);
       }
       else if (wsType.equals("worksheet21")){
                        //Mixed Addition/Subtraction
              baseQuestion = Maker21.makeQuestion(var2,var3,var4,var5);
       }

       else if (wsType.equals("worksheet22")){
                        //counting money
              baseQuestion = Maker22.makeQuestion(var2,var3,var4,var5,var6);
       }
       else if (wsType.equals("worksheet23")){
                       //even or odd number
    	     System.out.println("BASE MAKER file");
             baseQuestion = Maker23.makeQuestion(var2,var3,var4,var5);
      }
      else if (wsType.equals("worksheet24")){
                      //Acute, right or obtuse angle
            baseQuestion = Maker24.makeQuestion(var2,var3,var4,var5);
     }
     else if (wsType.equals("worksheet25")){
                      //Acute, right or obtuse angle
            baseQuestion = Maker25.makeQuestion(var2,var3,var4,var5);
     }
     else if (wsType.equals("worksheet26")){
                      //Make Change
            baseQuestion = Maker26.makeQuestion(var2,var3,var4,var5);
     }
     else if (wsType.equals("worksheet27")){
                      //Make Change
            baseQuestion = Maker27.makeQuestion(var2,var3,var4,var5);
     }
     else if (wsType.equals("worksheet28")){
                      //Make Change
            baseQuestion = Maker28.makeQuestion(var2,var3,var4,var5);
     }

     else if (wsType.equals("worksheet29")){
                      //Make Change
            baseQuestion = Maker29.makeQuestion(var2,var3,var4,var5);
     }
     else if (wsType.equals("worksheet30")){
            //word problems
    	 	 System.out.println("WORKSHEET30");
             baseQuestion = Maker30.makeQuestion(var2,var3,var4,var5);
      }
     else if (wsType.equals("worksheet31")){
         //measuring units conversion worksheets
          baseQuestion = Maker31.makeQuestion(var2,var3,var4,var5);
   }
     else if (wsType.equals("worksheet32")){
         //measuring units conversion worksheets
         baseQuestion = Maker32.makeQuestion(var2,var3,var4,var5);
         
   } else if (wsType.equals("worksheet33")){
       //measuring units conversion worksheets
      baseQuestion = Maker33.makeQuestion(var2,var3,var4,var5);

    } else {
        throw new MakerException("Maker Exception: Unknown worksheet name!");
      }
      return baseQuestion;
    }
}