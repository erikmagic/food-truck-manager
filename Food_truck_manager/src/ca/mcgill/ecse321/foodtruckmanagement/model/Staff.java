/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.foodtruckmanagement.model;

// line 5 "../../../../../food_truck_management.ump"
// line 79 "../../../../../food_truck_management.ump"
public class Staff
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Staff Attributes
  private String name;
  private String role;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Staff(String aName, String aRole)
  {
    name = aName.trim();
    role = aRole.trim();
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

  public boolean setRole(String aRole)
  {
    boolean wasSet = false;
    role = aRole;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public String getRole()
  {
    return role;
  }

  public void delete()
  {}
  
  
  public boolean equals(Staff aStaff){
	  if (this.name.equals(aStaff.getName()) && this.role.equals(aStaff.getRole())){
		  return true;
	  } else {
		  return false;
	  }
  }
  


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "role" + ":" + getRole()+ "]"
     + outputString;
  }
}