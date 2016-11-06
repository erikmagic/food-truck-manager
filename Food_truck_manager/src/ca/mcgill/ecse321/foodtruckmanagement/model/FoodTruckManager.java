/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.foodtruckmanagement.model;
import java.util.*;

import java.sql.Date;

// line 25 "../../../../../food_truck_management.ump"
// line 129 "../../../../../food_truck_management.ump"
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
  private List<Supply> supply;
  private List<Order> order;
  private Menu menu;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private FoodTruckManager()
  {
    staff = new ArrayList<Staff>();
    supply = new ArrayList<Supply>();
    order = new ArrayList<Order>();
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

  public Supply getSupply(int index)
  {
    Supply aSupply = supply.get(index);
    return aSupply;
  }

  public List<Supply> getSupply()
  {
    List<Supply> newSupply = Collections.unmodifiableList(supply);
    return newSupply;
  }

  public int numberOfSupply()
  {
    int number = supply.size();
    return number;
  }

  public boolean hasSupply()
  {
    boolean has = supply.size() > 0;
    return has;
  }

  public int indexOfSupply(Supply aSupply)
  {
    int index = supply.indexOf(aSupply);
    return index;
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

  public Menu getMenu()
  {
    return menu;
  }

  public boolean hasMenu()
  {
    boolean has = menu != null;
    return has;
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

  public static int minimumNumberOfSupply()
  {
    return 0;
  }

  public boolean addSupply(Supply aSupply)
  {
    boolean wasAdded = false;
    if (supply.contains(aSupply)) { return false; }
    supply.add(aSupply);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeSupply(Supply aSupply)
  {
    boolean wasRemoved = false;
    if (supply.contains(aSupply))
    {
      supply.remove(aSupply);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addSupplyAt(Supply aSupply, int index)
  {  
    boolean wasAdded = false;
    if(addSupply(aSupply))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSupply()) { index = numberOfSupply() - 1; }
      supply.remove(aSupply);
      supply.add(index, aSupply);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveSupplyAt(Supply aSupply, int index)
  {
    boolean wasAdded = false;
    if(supply.contains(aSupply))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfSupply()) { index = numberOfSupply() - 1; }
      supply.remove(aSupply);
      supply.add(index, aSupply);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addSupplyAt(aSupply, index);
    }
    return wasAdded;
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

  public boolean setMenu(Menu aNewMenu)
  {
    boolean wasSet = false;
    menu = aNewMenu;
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    staff.clear();
    supply.clear();
    order.clear();
    menu = null;
  }

}