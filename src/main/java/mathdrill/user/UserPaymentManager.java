package mathdrill.user;

import mathdrill.data.DataManager;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import mathdrill.data.util.QueryBuilder;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Noetic Learning </p>
 * @author Li Kelty
 * @version 1.0
 */

public class UserPaymentManager extends BaseManager {

  public UserPaymentManager() {
  }

  public static void insertPayPalTxDetail (String txn_id, String receiver_email, String payment_status, String item_name,
      String payment_gross, String payer_email, int user_id, boolean userUpdated) throws UserException{
   String exceptionMsg="";

    Connection con =null;
    Statement statement =null;

   try {

     con = DataManager.getConnection();
     statement = con.createStatement();
     java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
     String sqlStatement ="insert into paypal_tx_details (txn_id,receiver_email,payment_status,item_name,payment_gross,payer_email,user_id,txn_date,user_updated) values ("+
                           makeStringParam(txn_id)+","+
                          makeStringParam(receiver_email)+","+
                            makeStringParam(payment_status)+","+
                           makeStringParam(item_name)+","+
                          makeStringParam(payment_gross)+","+
                          makeStringParam(payer_email)+","+
                           user_id+","+
                          makeStringParam(today.toString() ) +","+
                            makeStringParam(""+userUpdated)+ ");";

      
     int result = statement.executeUpdate(sqlStatement);
   }
   catch (SQLException e){
     System.out.println( "SQLException:"+e.getMessage());
     e.printStackTrace();
     exceptionMsg = "Account Creation Failed: SQL error. Contact System Administrator. Detail Error:"+e.getMessage();
      throw new UserException(exceptionMsg);
   }
   catch (Exception e){
     System.out.println( "Exception:"+e.getMessage());
     e.printStackTrace();
     exceptionMsg = "Account Creation Failed: System error. Contact System Administrator";
      throw new UserException(exceptionMsg);
   }
   finally{
    	DataManager.close(statement);
    	DataManager.close(con);
    }


  }


  public static void main(String args[]) {
try{
    insertPayPalTxDetail("03212","noetic.learning@gmail.com","Completed","worksheet creator 1 month", "$15.00", "liqiank@yahoo.com",2,false);
}
catch (Exception e){
  System.out.println(e.getMessage());
}
    }

}