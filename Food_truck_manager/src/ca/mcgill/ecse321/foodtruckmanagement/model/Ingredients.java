/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.foodtruckmanagement.model;
import java.sql.Date;

// line 60 "../../../../../food_truck_management.ump"
// line 114 "../../../../../food_truck_management.ump"
public class Ingredients extends Supply
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Ingredients Attributes
  private Date expirationDate;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ingredients(String aName, double aQuantity, Date aPurchasedDate, double aPrice, Date aExpirationDate)
  {
    super(aName, aQuantity, aPurchasedDate, aPrice);
    expirationDate = aExpirationDate;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setExpirationDate(Date aExpirationDate)
  {
    boolean wasSet = false;
    expirationDate = aExpirationDate;
    wasSet = true;
    return wasSet;
  }

  public Date getExpirationDate()
  {
    return expirationDate;
  }

  public void delete()
  {
    super.delete();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "expirationDate" + "=" + (getExpirationDate() != null ? !getExpirationDate().equals(this)  ? getExpirationDate().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}