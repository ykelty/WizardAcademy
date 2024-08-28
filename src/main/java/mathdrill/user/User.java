package mathdrill.user;

import java.util.Date;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: Noetic Learning</p>
 * @author Li Kelty
 * @version 1.0
 */

public class User {
  private int userId;
  private String userName="";
  private String email="";
  private String phone="";
  private String password;
  private String referer_email="";
  private String promotion_code="";
  private String how_heardofus="";
  private String status;
  private Date status_effective_start_date;
  private Date status_effective_end_date;
  private Date created_date;
  private Date last_login_date;

  public User() {
  }
  public int getUserId (){return userId;}
  public void setUserId (int newValue){ userId=newValue;}
  public String getUserName(){return userName;}
  public void setUserName (String newValue){ userName=newValue;}
  public String getEmail(){return email;}
  public void setEmail (String newValue){ email=newValue;}
  public String getPhone(){return phone;}
  public void setPhone (String newValue){ phone=newValue;}
  public String getPassword(){return password;}
  public void setPassword (String newValue){ password=newValue;}
  public String getStatus(){return status;}
  public void setStatus (String newValue){ status=newValue;}
  public String getReferer_email(){return referer_email;}
  public void setReferer_email (String newValue){ referer_email=newValue;}
  public String getPromotion_code(){return promotion_code;}
  public void setPromotion_code (String newValue){ promotion_code=newValue;}
  public Date getStatus_effective_start_date(){return status_effective_start_date;}
  public void setStatus_effective_start_date (Date newValue){ status_effective_start_date=newValue;}

  public Date getStatus_effective_end_date(){return status_effective_end_date;}
  public void setStatus_effective_end_date (Date newValue){ status_effective_end_date=newValue;}

  public Date getCreated_date(){return created_date;}
  public void setCreated_date (Date newValue){ created_date=newValue;}

  public Date getLast_login_date(){return last_login_date;}
  public void setLast_login_date (Date newValue){ last_login_date=newValue;}

  public String getHow_heardofus(){return how_heardofus;}
  public void setHow_heardofus (String newValue){ how_heardofus=newValue;}

  public String toString(){return ""+userId+","+userName+","+email;}

}