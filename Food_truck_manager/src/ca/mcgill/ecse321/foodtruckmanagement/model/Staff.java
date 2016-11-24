/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.foodtruckmanagement.model;
import java.util.*;
import java.sql.Time;

// line 5 "../../../../../food_truck_management.ump"
// line 84 "../../../../../food_truck_management.ump"
public class Staff
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Staff Attributes
  private String name;
  private String role;

  //Staff Associations
  private List<Shift> shift;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Staff(String aName, String aRole)
  {
    name = aName;
    role = aRole;
    shift = new ArrayList<Shift>();
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

  public Shift getShift(int index)
  {
    Shift aShift = shift.get(index);
    return aShift;
  }

  public List<Shift> getShift()
  {
    List<Shift> newShift = Collections.unmodifiableList(shift);
    return newShift;
  }

  public int numberOfShift()
  {
    int number = shift.size();
    return number;
  }

  public boolean hasShift()
  {
    boolean has = shift.size() > 0;
    return has;
  }

  public int indexOfShift(Shift aShift)
  {
    int index = shift.indexOf(aShift);
    return index;
  }

  public static int minimumNumberOfShift()
  {
    return 0;
  }

  public boolean addShift(Shift aShift)
  {
    boolean wasAdded = false;
    if (shift.contains(aShift)) { return false; }
    if (shift.contains(aShift)) { return false; }
    shift.add(aShift);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeShift(Shift aShift)
  {
    boolean wasRemoved = false;
    if (shift.contains(aShift))
    {
      shift.remove(aShift);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addShiftAt(Shift aShift, int index)
  {  
    boolean wasAdded = false;
    if(addShift(aShift))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShift()) { index = numberOfShift() - 1; }
      shift.remove(aShift);
      shift.add(index, aShift);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveShiftAt(Shift aShift, int index)
  {
    boolean wasAdded = false;
    if(shift.contains(aShift))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfShift()) { index = numberOfShift() - 1; }
      shift.remove(aShift);
      shift.add(index, aShift);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addShiftAt(aShift, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    shift.clear();
  }
  
  // helpers
  
  public boolean equals(Staff aStaff){
	  if ( !this.getName().equals(aStaff.getName())) return false;
	  else if ( !this.getRole().equals(aStaff.getRole())) return false;
	  else return true;
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