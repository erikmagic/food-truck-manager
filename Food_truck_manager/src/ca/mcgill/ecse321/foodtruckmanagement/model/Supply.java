/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.foodtruckmanagement.model;
import java.sql.Date;

// line 53 "../../../../../food_truck_management.ump"
// line 109 "../../../../../food_truck_management.ump"
public class Supply
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Supply Attributes
  private String name;
  private double quantity;
  private Date purchasedDate;
  private double price;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Supply(String aName, double aQuantity, Date aPurchasedDate, double aPrice)
  {
    name = aName;
    quantity = aQuantity;
    purchasedDate = aPurchasedDate;
    price = aPrice;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public boolean setQuantity(double aQuantity)
  {
    boolean wasSet = false;
    quantity = aQuantity;
    wasSet = true;
    return wasSet;
  }

  public boolean setPurchasedDate(Date aPurchasedDate)
  {
    boolean wasSet = false;
    purchasedDate = aPurchasedDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setPrice(double aPrice)
  {
    boolean wasSet = false;
    price = aPrice;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public double getQuantity()
  {
    return quantity;
  }

  public Date getPurchasedDate()
  {
    return purchasedDate;
  }

  public double getPrice()
  {
    return price;
  }

  public void delete()
  {}


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "quantity" + ":" + getQuantity()+ "," +
            "price" + ":" + getPrice()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "purchasedDate" + "=" + (getPurchasedDate() != null ? !getPurchasedDate().equals(this)  ? getPurchasedDate().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}