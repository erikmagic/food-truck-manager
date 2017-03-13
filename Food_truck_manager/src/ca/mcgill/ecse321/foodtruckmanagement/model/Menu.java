/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.foodtruckmanagement.model;
import java.util.*;

// line 46 "../../../../../food_truck_management.ump"
// line 101 "../../../../../food_truck_management.ump"
public class Menu
{

  //------------------------
  // STATIC VARIABLES
  //------------------------

  private static Menu theInstance = null;

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Menu Associations
  private List<Item> item;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  private Menu()
  {
    item = new ArrayList<Item>();
  }

  public static Menu getInstance()
  {
    if(theInstance == null)
    {
      theInstance = new Menu();
    }
    return theInstance;
  }

  //------------------------
  // INTERFACE
  //------------------------

  public Item getItem(int index)
  {
    Item aItem = item.get(index);
    return aItem;
  }

  public List<Item> getItem()
  {
    List<Item> newItem = Collections.unmodifiableList(item);
    return newItem;
  }

  public int numberOfItem()
  {
    int number = item.size();
    return number;
  }

  public boolean hasItem()
  {
    boolean has = item.size() > 0;
    return has;
  }

  public int indexOfItem(Item aItem)
  {
    int index = item.indexOf(aItem);
    return index;
  }

  public static int minimumNumberOfItem()
  {
    return 0;
  }

  public boolean addItem(Item aItem)
  {
    boolean wasAdded = false;
    if (item.contains(aItem)) { return false; }
    item.add(aItem);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeItem(Item aItem)
  {
    boolean wasRemoved = false;
    if (item.contains(aItem))
    {
      item.remove(aItem);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addItemAt(Item aItem, int index)
  {  
    boolean wasAdded = false;
    if(addItem(aItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItem()) { index = numberOfItem() - 1; }
      item.remove(aItem);
      item.add(index, aItem);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveItemAt(Item aItem, int index)
  {
    boolean wasAdded = false;
    if(item.contains(aItem))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfItem()) { index = numberOfItem() - 1; }
      item.remove(aItem);
      item.add(index, aItem);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addItemAt(aItem, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    item.clear();
  }

}