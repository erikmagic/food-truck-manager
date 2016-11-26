/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.22.0.5146 modeling language!*/

package ca.mcgill.ecse321.foodtruckmanagement.model;
import java.util.*;

// line 39 "../../../../../food_truck_management.ump"
// line 96 "../../../../../food_truck_management.ump"
public class Item
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Item Attributes
  private String name;
  private double price;
  private boolean availability;

  //Item Associations
  private List<Ingredient> Ingredient;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Item(String aName, double aPrice, boolean aAvailability)
  {
    name = aName;
    price = aPrice;
    availability = aAvailability;
    Ingredient = new ArrayList<Ingredient>();
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

  public boolean setPrice(double aPrice)
  {
    boolean wasSet = false;
    price = aPrice;
    wasSet = true;
    return wasSet;
  }

  public boolean setAvailability(boolean aAvailability)
  {
    boolean wasSet = false;
    availability = aAvailability;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }

  public double getPrice()
  {
    return price;
  }

  public boolean getAvailability()
  {
    return availability;
  }

  public boolean isAvailability()
  {
    return availability;
  }

  public Ingredient getIngredient(int index)
  {
    Ingredient aIngredient = Ingredient.get(index);
    return aIngredient;
  }

  public List<Ingredient> getIngredient()
  {
    List<Ingredient> newIngredient = Collections.unmodifiableList(Ingredient);
    return newIngredient;
  }

  public int numberOfIngredient()
  {
    int number = Ingredient.size();
    return number;
  }

  public boolean hasIngredient()
  {
    boolean has = Ingredient.size() > 0;
    return has;
  }

  public int indexOfIngredient(Ingredient aIngredient)
  {
    int index = Ingredient.indexOf(aIngredient);
    return index;
  }

  public static int minimumNumberOfIngredient()
  {
    return 0;
  }

  public boolean addIngredient(Ingredient aIngredient)
  {
    boolean wasAdded = false;
    if (Ingredient.contains(aIngredient)) { return false; }
    Ingredient.add(aIngredient);
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeIngredient(Ingredient aIngredient)
  {
    boolean wasRemoved = false;
    if (Ingredient.contains(aIngredient))
    {
      Ingredient.remove(aIngredient);
      wasRemoved = true;
    }
    return wasRemoved;
  }

  public boolean addIngredientAt(Ingredient aIngredient, int index)
  {  
    boolean wasAdded = false;
    if(addIngredient(aIngredient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIngredient()) { index = numberOfIngredient() - 1; }
      Ingredient.remove(aIngredient);
      Ingredient.add(index, aIngredient);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveIngredientAt(Ingredient aIngredient, int index)
  {
    boolean wasAdded = false;
    if(Ingredient.contains(aIngredient))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfIngredient()) { index = numberOfIngredient() - 1; }
      Ingredient.remove(aIngredient);
      Ingredient.add(index, aIngredient);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addIngredientAt(aIngredient, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    Ingredient.clear();
  }


  public String toString()
  {
	  String outputString = "";
    return super.toString() + "["+
            "name" + ":" + getName()+ "," +
            "price" + ":" + getPrice()+ "," +
            "availability" + ":" + getAvailability()+ "]"
     + outputString;
  }
}