/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.foodtruckmanagement.model;
import java.sql.Time;

// line 12 "../../../../../food_truck_management.ump"
// line 84 "../../../../../food_truck_management.ump"
public class Shift
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Shift Attributes
  private int day;
  private Time startingHour;
  private Time finishingHour;

  //Shift Associations
  private Staff staff;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Shift(int aDay, Time aStartingHour, Time aFinishingHour, Staff aStaff)
  {
    day = aDay;
    startingHour = aStartingHour;
    finishingHour = aFinishingHour;
    if (!setStaff(aStaff))
    {
      throw new RuntimeException("Unable to create Shift due to aStaff");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDay(int aDay)
  {
    boolean wasSet = false;
    day = aDay;
    wasSet = true;
    return wasSet;
  }

  public boolean setStartingHour(Time aStartingHour)
  {
    boolean wasSet = false;
    startingHour = aStartingHour;
    wasSet = true;
    return wasSet;
  }

  public boolean setFinishingHour(Time aFinishingHour)
  {
    boolean wasSet = false;
    finishingHour = aFinishingHour;
    wasSet = true;
    return wasSet;
  }

  public int getDay()
  {
    return day;
  }

  public Time getStartingHour()
  {
    return startingHour;
  }

  public Time getFinishingHour()
  {
    return finishingHour;
  }

  public Staff getStaff()
  {
    return staff;
  }

  public boolean setStaff(Staff aNewStaff)
  {
    boolean wasSet = false;
    if (aNewStaff != null)
    {
      staff = aNewStaff;
      wasSet = true;
    }
    return wasSet;
  }

  public void delete()
  {
    staff = null;
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "day" + ":" + getDay()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "startingHour" + "=" + (getStartingHour() != null ? !getStartingHour().equals(this)  ? getStartingHour().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "finishingHour" + "=" + (getFinishingHour() != null ? !getFinishingHour().equals(this)  ? getFinishingHour().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "staff = "+(getStaff()!=null?Integer.toHexString(System.identityHashCode(getStaff())):"null")
     + outputString;
  }
}