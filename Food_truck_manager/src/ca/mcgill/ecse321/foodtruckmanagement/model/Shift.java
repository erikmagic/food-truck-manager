/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.foodtruckmanagement.model;
import java.sql.Time;


import ca.mcgill.ecse321.foodtruckmanagement.controller.Day;
import ca.mcgill.ecse321.foodtruckmanagement.controller.DayMap;

// line 13 "../../../../../food_truck_management.ump"
// line 89 "../../../../../food_truck_management.ump"
public class Shift
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Shift Attributes
  private Time startingHour;
  private Time finishingHour;
  private Day day;

  //Shift Associations
  private Staff staff;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Shift(Time aStartingHour, Time aFinishingHour, Day aDay, Staff aStaff)
  {
    startingHour = aStartingHour;
    finishingHour = aFinishingHour;
    day = aDay;
    if (!setStaff(aStaff))
    {
      throw new RuntimeException("Unable to create Shift due to aStaff");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

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

  public boolean setDay(Day aDay)
  {
    boolean wasSet = false;
    day = aDay;
    wasSet = true;
    return wasSet;
  }

  public Time getStartingHour()
  {
    return startingHour;
  }

  public Time getFinishingHour()
  {
    return finishingHour;
  }

  public Day getDay()
  {
    return day;
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

  // helpers
  public boolean equals(Shift otherShift){
	  if (this.startingHour != otherShift.startingHour) return false;
	  else if ( this.finishingHour != otherShift.finishingHour) return false;
	  else if ( this.staff != otherShift.staff) return false;
	  else if (this.day != otherShift.day) return false;
	  else return true;
  }
  
  /** first.compareTo(second)
 * @param otherShift
 * @return 0 if both shifts starts at the same time
 * 1 if the first is before second
 * -1 if the first is after second
 */
public int compareTo(Shift otherShift){
	  if (this.equals(otherShift)) return 0;
	  
	  if (!this.day.equals(otherShift.day)){
		  
		  int thisDay = DayMap.getNumberDay(this.day);
		  int otherDay = DayMap.getNumberDay(otherShift.day);
		  
		  if (thisDay > otherDay) return 1;
		  else return -1;
		  
	  }
	  else {
		  
		  Time thisTime = this.startingHour;
		  Time otherTime = otherShift.startingHour;
		  
		  if ( thisTime.getTime() == otherTime.getTime()	) return 0;
		  else if ( thisTime.getTime() < otherTime.getTime()) return 1;
		  else return -1;
		  
	  }
  }
  
  
  
  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "startingHour" + "=" + (getStartingHour() != null ? !getStartingHour().equals(this)  ? getStartingHour().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "finishingHour" + "=" + (getFinishingHour() != null ? !getFinishingHour().equals(this)  ? getFinishingHour().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "day" + "=" + (getDay() != null ? !getDay().equals(this)  ? getDay().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "staff = "+(getStaff()!=null?Integer.toHexString(System.identityHashCode(getStaff())):"null")
     + outputString;
  }
}