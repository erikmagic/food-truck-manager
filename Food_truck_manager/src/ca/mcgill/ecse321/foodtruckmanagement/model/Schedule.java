/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.foodtruckmanagement.model;
import java.sql.Date;
import java.util.*;
import java.sql.Time;

// line 20 "../../../../../food_truck_management.ump"
// line 94 "../../../../../food_truck_management.ump"
public class Schedule
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Schedule Attributes
  private Date week;

  //Schedule Associations
  private List<Shift> shift;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Schedule(Date aWeek)
  {
    week = aWeek;
    shift = new ArrayList<Shift>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setWeek(Date aWeek)
  {
    boolean wasSet = false;
    week = aWeek;
    wasSet = true;
    return wasSet;
  }

  public Date getWeek()
  {
    return week;
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


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "week" + "=" + (getWeek() != null ? !getWeek().equals(this)  ? getWeek().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}