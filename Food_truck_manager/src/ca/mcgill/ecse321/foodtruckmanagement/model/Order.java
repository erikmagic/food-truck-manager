/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.foodtruckmanagement.model;
import java.sql.Date;
import java.util.*;

// line 67 "../../../../../food_truck_management.ump"
// line 121 "../../../../../food_truck_management.ump"
public class Order
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Order Attributes
  private double totalPrice;
  private Date orderDate;
  private long orderID;

  //Order Associations
  private HashMap<Item, Integer> item;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Order(double aTotalPrice, Date aOrderDate, long aOrderID)
  {
    totalPrice = aTotalPrice;
    orderDate = aOrderDate;
    orderID = aOrderID;
    item = new HashMap<Item, Integer>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setTotalPrice(double aTotalPrice)
  {
    boolean wasSet = false;
    totalPrice = aTotalPrice;
    wasSet = true;
    return wasSet;
  }

  public boolean setOrderDate(Date aOrderDate)
  {
    boolean wasSet = false;
    orderDate = aOrderDate;
    wasSet = true;
    return wasSet;
  }

  public boolean setOrderID(long aOrderID)
  {
    boolean wasSet = false;
    orderID = aOrderID;
    wasSet = true;
    return wasSet;
  }

  public double getTotalPrice()
  {
    return totalPrice;
  }

  public Date getOrderDate()
  {
    return orderDate;
  }

  public long getOrderID()
  {
    return orderID;
  }

  public Set<Item> getItem()
  {
    Set<Item> newItem = Collections.unmodifiableSet(item.keySet());
    return newItem;
  }
  public Item getItem(Item it){
	  Iterator<Item> itIt = item.keySet().iterator();
	  while(itIt.hasNext()){
		  Item tempItem = itIt.next();
		  if (it.equals(tempItem)){
			  return tempItem;
		  }
	  }
	  return null;
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


  public static int minimumNumberOfItem()
  {
    return 0;
  }

  public boolean addItem(Item aItem, int quantity)
  {
    boolean wasAdded = false;
    if (item.keySet().contains(aItem)) { return false; }
    item.put(aItem, quantity);
    wasAdded = true;
    return wasAdded;
  }

  public int removeItem(Item aItem)
  {
	  int value = 0;
	  if (!item.keySet().contains(aItem)) { return value; }
	  value = item.remove(aItem);
	  return value;
  }


  public void delete()
  {
    item.clear();
  }
  
  public boolean equals(Order other){
	  if (this.orderID == other.getOrderID()) return true;
	  else return false;
  }
  
  public HashMap<Item, Integer> getMap(){
	  return this.item;
  }
  public boolean compareDate(Date initial, Date end){
	  // if the date is between the two others, return true
	  long one =initial.getTime();
	  long two = end.getTime();
	  
	  if (this.orderDate.getTime() >= one && this.orderDate.getTime() <= two){
		  return true;
	  }
	  
	  return false;
  }

  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "totalPrice" + ":" + getTotalPrice()+ "," +
            "orderID" + ":" + getOrderID()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "orderDate" + "=" + (getOrderDate() != null ? !getOrderDate().equals(this)  ? getOrderDate().toString().replaceAll("  ","    ") : "this" : "null")
     + outputString;
  }
}