/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.foodtruckmanagement.model;
import java.sql.Date;
import java.util.*;

// line 75 "../../../../../food_truck_management.ump"
// line 128 "../../../../../food_truck_management.ump"
public class Report
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Report Attributes
  private Date startingDate;
  private Date endingDate;
  private Date generatedDate;
  private String reportName;

  //Report Associations
  private List<Order> order;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Report(Date aStartingDate, Date aEndingDate, Date aGeneratedDate, String aReportName)
  {
    startingDate = aStartingDate;
    endingDate = aEndingDate;
    generatedDate = aGeneratedDate;
    reportName = aReportName;
    order = new ArrayList<Order>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setStartingDate(Date aStartingDate)
  {
    boolean wasSet = false;
    startingDate = aStartingDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setEndingDate(Date aEndingDate)
  {
    boolean wasSet = false;
    endingDate = aEndingDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setGeneratedDate(Date aGeneratedDate)
  {
    boolean wasSet = false;
    generatedDate = aGeneratedDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setReportName(String aReportName)
  {
    boolean wasSet = false;
    reportName = aReportName;
    wasSet = true;
    return wasSet;
  }

  public Date getStartingDate()
  {
    return startingDate;
  }

  public Date getEndingDate()
  {
    return endingDate;
  }

  public Date getGeneratedDate()
  {
    return generatedDate;
  }

  public String getReportName()
  {
    return reportName;
  }

  public Order getOrder(int index)
  {
    Order aOrder = order.get(index);
    return aOrder;
  }

  public List<Order> getOrder()
  {
    List<Order> newOrder = Collections.unmodifiableList(order);
    return newOrder;
  }

  public int numberOfOrder()
  {
    int number = order.size();
    return number;
  }

  public boolean hasOrder()
  {
    boolean has = order.size() > 0;
    return has;
  }

  public int indexOfOrder(Order aOrder)
  {
    int index = order.indexOf(aOrder);
    return index;
  }

  public static int minimumNumberOfOrder()
  {
    return 0;
  }

  public boolean addOrder(Order aOrder)
  {
    boolean wasAdded = false;
    if (order.contains(aOrder)) { return false; }
    order.add(aOrder);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeOrder(Order aOrder)
  {
    boolean wasRemoved = false;
    if (order.contains(aOrder))
    {
      order.remove(aOrder);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addOrderAt(Order aOrder, int index)
  {  
    boolean wasAdded = false;
    if(addOrder(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrder()) { index = numberOfOrder() - 1; }
      order.remove(aOrder);
      order.add(index, aOrder);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveOrderAt(Order aOrder, int index)
  {
    boolean wasAdded = false;
    if(order.contains(aOrder))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfOrder()) { index = numberOfOrder() - 1; }
      order.remove(aOrder);
      order.add(index, aOrder);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addOrderAt(aOrder, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    order.clear();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "reportName" + ":" + getReportName()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "startingDate" + "=" + (getStartingDate() != null ? !getStartingDate().equals(this)  ? getStartingDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "endingDate" + "=" + (getEndingDate() != null ? !getEndingDate().equals(this)  ? getEndingDate().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "generatedDate" + "=" + (getGeneratedDate() != null ? !getGeneratedDate().equals(this)  ? getGeneratedDate().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}