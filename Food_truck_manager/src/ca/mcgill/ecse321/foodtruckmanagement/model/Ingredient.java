/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.foodtruckmanagement.model;
import java.sql.Date;

// line 59 "../../../../../food_truck_management.ump"
public class Ingredient extends Supply
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Ingredient Attributes
  private Date expirationDate;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ingredient(String aName, double aQuantity, double aPrice, Date aExpirationDate)
  {
    super(aName, aQuantity, aPrice);
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
  
  public boolean equals(Ingredient otherIngredient){
	  if ( !this.expirationDate.equals(otherIngredient.expirationDate)) return false;
	  else if ( !super.getName().equals(otherIngredient.getName())) return false;
	  else if ( super.getPrice() != otherIngredient.getPrice()) return false;
	  else if ( super.getQuantity() != otherIngredient.getQuantity()) return false;
	  else return true;
	  
  }

  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "expirationDate" + "=" + (getExpirationDate() != null ? !getExpirationDate().equals(this)  ? getExpirationDate().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}