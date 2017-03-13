/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.foodtruckmanagement.model;

// line 63 "../../../../../food_truck_management.ump"
// line 116 "../../../../../food_truck_management.ump"
public class Equipment extends Supply
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Equipment(String aName, double aQuantity, double aPrice)
  {
    super(aName, aQuantity, aPrice);
  }

  //------------------------
  // INTERFACE
  //------------------------
  public boolean equals(Equipment otherEquipment){
	  
	  if ( !super.getName().equals(otherEquipment.getName())) return false;
	  else if ( super.getPrice() != otherEquipment.getPrice()) return false;
	  else if ( super.getQuantity() != otherEquipment.getQuantity()) return false;
	  else return true;
  }
  public void delete()
  {
    super.delete();
  }

}