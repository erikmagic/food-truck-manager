/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.foodtruckmanagement.model;
import java.sql.Date;

// line 65 "../../../../../food_truck_management.ump"
// line 119 "../../../../../food_truck_management.ump"
public class Equipment extends Supply
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Equipment(String aName, double aQuantity, Date aPurchasedDate, double aPrice)
  {
    super(aName, aQuantity, aPurchasedDate, aPrice);
  }

  //------------------------
  // INTERFACE
  //------------------------

  public void delete()
  {
    super.delete();
  }

}