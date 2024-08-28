package mathdrill.user;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class MembershipTerm {
    private int id;
    private int months;
    private String name;
    private String paypal;
    private String promotioncode;
    private String price;

    public int getId (){return id;}
    public void setId (int newValue){ id=newValue;}
    public int getMonths (){return months;}
    public void setMonths (int newValue){ months=newValue;}
    public String getName(){return name;}
    public void setName (String newValue){ name=newValue;}
    public String getPaypal(){return paypal;}
    public void setPaypal (String newValue){ paypal=newValue;}
    public String getPromotioncode(){return promotioncode;}
    public void setPromotioncode (String newValue){ promotioncode=newValue;}
    public String getPrice(){return price;}
    public void setPrice (String newValue){ price=newValue;}
}