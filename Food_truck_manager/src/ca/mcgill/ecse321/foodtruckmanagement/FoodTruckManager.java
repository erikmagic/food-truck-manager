/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.foodtruckmanagement;
import java.util.*;

// line 4 "../../../../UmpleCode.ump"
// line 22 "../../../../UmpleCode.ump"
public class FoodTruckManager
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static FoodTruckManager theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //FoodTruckManager Associations
  private List<Staff> staff;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private FoodTruckManager()
  {
    staff = new ArrayList<Staff>();
  }

  public static FoodTruckManager getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new FoodTruckManager();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Staff getStaff(int index)
  {
    Staff aStaff = staff.get(index);
    return aStaff;
  }

  public List<Staff> getStaff()
  {
    List<Staff> newStaff = Collections.unmodifiableList(staff);
    return newStaff;
  }

  public int numberOfStaff()
  {
    int number = staff.size();
    return number;
  }

  public boolean hasStaff()
  {
    boolean has = staff.size() > 0;
    return has;
  }

  public int indexOfStaff(Staff aStaff)
  {
    int index = staff.indexOf(aStaff);
    return index;
  }

  public static int minimumNumberOfStaff()
  {
    return 0;
  }

  public boolean addStaff(Staff aStaff)
  {
    boolean wasAdded = false;
    if (staff.contains(aStaff)) { return false; }
    staff.add(aStaff);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeStaff(Staff aStaff)
  {
    boolean wasRemoved = false;
    if (staff.contains(aStaff))
    {
      staff.remove(aStaff);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addStaffAt(Staff aStaff, int index)
  {  
    boolean wasAdded = false;
    if(addStaff(aStaff))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStaff()) { index = numberOfStaff() - 1; }
      staff.remove(aStaff);
      staff.add(index, aStaff);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveStaffAt(Staff aStaff, int index)
  {
    boolean wasAdded = false;
    if(staff.contains(aStaff))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfStaff()) { index = numberOfStaff() - 1; }
      staff.remove(aStaff);
      staff.add(index, aStaff);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addStaffAt(aStaff, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    staff.clear();
  }

}