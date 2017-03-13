/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.foodtruckmanagement.model;

// line 59 "../../../../../food_truck_management.ump"
public class Ingredient extends Supply
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Ingredient(String aName, double aQuantity, double aPrice)
  {
    super(aName, aQuantity, aPrice);
  }

  //------------------------
  // INTERFACE
  //------------------------
  public boolean equals(Ingredient otherIngredient){
	  if ( !super.getName().equals(otherIngredient.getName())) return false;
	  else if ( super.getPrice() != otherIngredient.getPrice()) return false;
	  else if ( super.getQuantity() != otherIngredient.getQuantity()) return false;
	  else return true;
	  
  }
  public void delete()
  {
    super.delete();
  }

}