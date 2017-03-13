package ca.mcgill.ecse321.foodtruckmanagement.controller;


import ca.mcgill.ecse321.foodtruckmanagement.persistence.PersistenceFoodTruckManager;
import ca.mcgill.ecse321.foodtruckmanagement.persistence.PersistenceXStream;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.text.StyledEditorKit.ForegroundAction;

import com.thoughtworks.xstream.io.path.Path;
import com.thoughtworks.xstream.mapper.FieldAliasingMapper;

import ca.mcgill.ecse321.foodtruckmanagement.model.*;

/**This Controller is activated by user input in the graphical interface. The controller then calls
 * the model so the information entered by the user in the u.i is saved.
 * @author Erik-Olivier Riendeau, 2016
 *
 */
public class FoodTruckManagementController {

	/**Empty Constuctor
	 * 
	 */
	public FoodTruckManagementController()
	{
		
	}
	
	/**Create a staff with the specific name and role. Throws an invalidInputException if the name 
	 * or the role are empty. Calls the model so the new staff is added to persistence
	 * @param name
	 * @param role
	 * @throws InvalidInputException
	 */
	public void createStaff(String name, String role) throws InvalidInputException {
		// check that the name or role entered is not null or empty
		if (name == null || role == null || name.trim().length() == 0 || role.trim().length() == 0)
		{
			throw new InvalidInputException("Staff name or role cannot be empty or null!");
		}
		
		
		// --- create new staff ----
		Staff s = new Staff(name, role);
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		ftm.addStaff(s);
		PersistenceXStream.saveToXMLwithXStream(ftm);
	}
	
	/**Remove a staff, you only need the name to do so. 
	 * @param name
	 */
	public void deleteStaff(Staff aStaff) throws InvalidInputException {
		// check that the entered name is not empty or null
		if (aStaff.getName() == null || aStaff.getName().trim().length() == 0 || aStaff.getRole() == null || aStaff.getRole().trim().length() == 0 ){
			throw new InvalidInputException("Staff name to be removed cannot be empty or null!");
		}
		// initialize model
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		
		// loops to find the staff n
		int keep_track_index = -1;
		for(int i = 0; i < ftm.getStaff().size(); i++){
			if ( ftm.getStaff(i).equals(aStaff)){
				keep_track_index = i;
			}
		}
		// if the specified staff name is not in the database, throw error
		if (keep_track_index == -1){
			throw new InvalidInputException("Staff to be removed was not found!");
		}
		
		// remove the specified staff
		if(!ftm.removeStaff(ftm.getStaff(keep_track_index))){
			throw new InvalidInputException("Staff was not removed!");
		}
		
		// remove all shifts instance associated to this particular staff
		// TODO
		
		PersistenceXStream.saveToXMLwithXStream(ftm);

	}
	// ---------------------- shifts ----------------------------- //
	
	public void createShift(Staff staff_for_shift, Time startTime, Time endTime, Day day ) throws InvalidInputException{
		
		
		// initialize model
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// find the staff which will have a shift added
		int keep_track_index = -1;
		for(int i = 0; i < ftm.getStaff().size(); i++){
			if ( ftm.getStaff(i).equals(staff_for_shift)){
				keep_track_index = i;
			}
		}
		// if the specified staff name is not in the database, throw error
		if (keep_track_index == -1){
			throw new InvalidInputException("Staff to be removed was not found!");
		}
		
		// check that the Time entered is valid
		if ( startTime == null){
			throw new InvalidInputException("Start time cannot be empty!");
		}
		if ( endTime == null) {
			throw new InvalidInputException("End time cannot be empty!");	
		}
		if ( startTime != null && endTime != null && startTime.getTime() > endTime.getTime()){
			throw new InvalidInputException("Start time cannot be after end time!");
		}
		
		// check that the day is not null
		if ( day == null){
			throw new InvalidInputException("Day cannot be empty!");
		}
		
		// check that the shift does not already exist
		
		
		Iterator<Shift> shIt = ftm.getShift().iterator();
		
		Shift sh = new Shift(startTime, endTime, day, staff_for_shift);
		
		while (shIt.hasNext()){
			Shift tempShift = shIt.next();
			if (tempShift.equals(sh)) {
				throw new InvalidInputException("Shift already exists!");
			} 
		}
		
		
		
		ftm.addShift(sh);
		PersistenceXStream.saveToXMLwithXStream(ftm);
		
		
	}
	
	public void deleteShift(Shift aShift) throws InvalidInputException{
		
		// initialize model
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// search for the shift in the database
		int keep_track_index = -1;
		for(int i = 0; i < ftm.getShift().size(); i++){
			if ( ftm.getShift(i).equals(aShift)){
				keep_track_index = i;
			}
		}
		if ( keep_track_index == -1){
			throw new InvalidInputException("Shift to be removed was not found!");
			
		}
		
		if (!ftm.removeShift(ftm.getShift(keep_track_index))){
			throw new InvalidInputException("Shift was not removed!");
		}
		
		PersistenceXStream.saveToXMLwithXStream(ftm);
	}
	
	// -------------------- schedule --------------------------- //
	
	public void createSchedule(Date startWeek) throws InvalidInputException{
		
		// initialize model
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		
		if ( startWeek == null){
			throw new InvalidInputException("Date cannot be set to null!");
		}
		
		// find the closest first day of the week to create a new schedule from the new week
		
		Calendar c = Calendar.getInstance();
		
		c.setTime(startWeek);
		int firstDayWeek = c.getFirstDayOfWeek();
		
		int todayDay = c.get(Calendar.DAY_OF_WEEK);
				
		c.set(Calendar.DAY_OF_WEEK, (firstDayWeek - todayDay));
		Date day = new Date(c.getTimeInMillis());
		
		
		
				
		// date.sql
		Schedule sch = new Schedule( day);
		
		
		// check if the schedule already exists
		
		Iterator it = ftm.getSchedule().iterator();
		while ( it.hasNext()){
			Schedule toCompare = (Schedule) it.next();
			if (toCompare.equals(sch)){
				throw new InvalidInputException("Schedule already exists!");
			}
		}
		
		ftm.addSchedule(sch);
		
		PersistenceXStream.saveToXMLwithXStream(ftm);
		
		
	}
	
	public void addShiftToSchedule(Schedule aSchedule, Shift aShift) throws InvalidInputException{
		
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// check that the schedule is indeed in the database
		int counter = 0;
		Iterator scIt = ftm.getSchedule().iterator();
		int scheduleIndex =-1;
		while ( scIt.hasNext()){
			Schedule tempSchedule = (Schedule) scIt.next();
			
			if ( aSchedule.equals(tempSchedule)){
				scheduleIndex = counter;
			}
			counter++;
		}
		if (scheduleIndex == -1){
			throw new InvalidInputException("Schedule not found int the database!");
		}
		// check that shift is indeed in the database
		
		Iterator it = ftm.getShift().iterator();
		
		int shiftIndex = -1;
		counter = 0;
		while ( it.hasNext()){
			Shift tempShift = (Shift) it.next();
			
			if(tempShift.equals(aShift)){
				shiftIndex = counter;
				break;
			}
			counter++;
		}
		if (shiftIndex == -1){
			throw new InvalidInputException("Shift not found in the database!");
		}
		
		Iterator<Shift> shIt = ftm.getSchedule(scheduleIndex).getShift().iterator();
		
		while( shIt.hasNext()){
			Shift tempShift = shIt.next();
			if ( tempShift.equals(aShift)){
				throw new InvalidInputException("Shift already exists in the current schedule!");
			}
		}
		
		ftm.getSchedule(scheduleIndex).addShift(aShift);
		
		PersistenceXStream.saveToXMLwithXStream(ftm);
	}
	
	public void removeShiftFromSchedule(Schedule aSchedule, Shift aShift) throws InvalidInputException{
		
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// check that the schedule is indeed in the database
		int counter = 0;
		Iterator scIt = ftm.getSchedule().iterator();
		int scheduleIndex =-1;
		while ( scIt.hasNext()){
			Schedule tempSchedule = (Schedule) scIt.next();
			
			if ( aSchedule.equals(tempSchedule)){
				scheduleIndex = counter;
			}
			counter++;
		}
		if (scheduleIndex == -1){
			throw new InvalidInputException("Schedule not found int the database!");
		}
		// check that shift is indeed in the database
		
		Iterator it = ftm.getShift().iterator();
		
		int shiftIndex = -1;
		counter = 0;
		while ( it.hasNext()){
			Shift tempShift = (Shift) it.next();
			
			if(tempShift.equals(aShift)){
				shiftIndex = counter;
				break;
			}
			counter++;
		}
		if (shiftIndex == -1){
			throw new InvalidInputException("Shift not found in the database!");
		}
		
		// should never happen
		if (!ftm.getSchedule(scheduleIndex).removeShift(ftm.getSchedule(scheduleIndex).getShift(shiftIndex))){
			throw new InvalidInputException("Shift was not deleted!");
		}
		
		PersistenceXStream.saveToXMLwithXStream(ftm);
		
	}
	
	public void deleteSchedule(Schedule aSchedule) throws InvalidInputException{
		
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// find the schedule in the database
		
		Iterator<Schedule> schIt = ftm.getSchedule().iterator();
		
		int scheduleIndex = -1;
		int counter = 0;
		while ( schIt.hasNext()){
			Schedule tempSchedule = schIt.next();
			
			if ( tempSchedule.equals(aSchedule)){
				scheduleIndex = counter;
			}
			counter++;
		}
		if (scheduleIndex == -1){
			throw new InvalidInputException("Schedule not found in the database!");
		}
		
		// should never happen
		if (!ftm.removeSchedule(ftm.getSchedule(scheduleIndex))){
			throw new InvalidInputException("Schedule was not removed!");
		}
		
		PersistenceXStream.saveToXMLwithXStream(ftm);
		
	}
	
	// ------------------------------ food controller -------------------------------------- //
	
	// ingredient 
	
	public void createIngredient(String aName, double aQuantity, double aPrice) throws InvalidInputException{
		
		// load model
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// check that the parameters are fine
		
		if ( aName == null || aName.trim().length() == 0){
			throw new InvalidInputException("Ingredient name cannot be null or empty!");
		}
		
		if ( aQuantity == 0){
			throw new InvalidInputException("Ingredient quantity cannot be 0!");
		}
		if ( aQuantity < 0){
			throw new InvalidInputException("Ingredient quantity cannot be negative!");
		}
		// ingredients price can be 0
		if ( aPrice < 0){
			throw new InvalidInputException("Ingredient price cannot be negative");
		}
		
		
		
		// check if the ingredient already exists
		Iterator<Ingredient> ingIt = ftm.getIngredients().iterator();
		Ingredient ingredient = new Ingredient(aName, aQuantity, aPrice);
		
		while ( ingIt.hasNext()){
			Ingredient tempIng = ingIt.next();
			if ( ingredient.equals(tempIng) ){
				throw new InvalidInputException("Ingredient already exists!");
			}	
		}
		
		ftm.addIngredient(ingredient);
		
		PersistenceXStream.saveToXMLwithXStream(ftm);
		
	}
	
	public void removeIngredient(Ingredient ingredient) throws InvalidInputException{
		
		// load model
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// check if ingredient if in the database
		Iterator<Ingredient> ingIt = ftm.getIngredients().iterator();
		
		int ingredientIndex = -1;
		int counter = 0;
		while ( ingIt.hasNext()){
			Ingredient tempIng = ingIt.next();
			if ( ingredient.equals(tempIng) ){
				ingredientIndex = counter;
			}	
			counter++;
		}
		if (ingredientIndex == -1){
			throw new InvalidInputException("Ingredient was not found in the database!");
		}
		
		// should not throw errors
		if ( !ftm.removeIngredient(ftm.getIngredient(ingredientIndex))){
			throw new InvalidInputException("Ingredient not removed!");
		}
		PersistenceXStream.saveToXMLwithXStream(ftm);
	}
	
	/**updates the quantity of an ingredient if the ingredient has sufficiant quantity ( supports + and -)
	 * @exception insufficiant quantity
	 * @param item
	 */
	public void updateQuantity(Ingredient ingredient, double update) throws InvalidInputException{
		// load model
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// check if the item is in the database
		Iterator<Ingredient> ingIt = ftm.getIngredients().iterator();
		int counter = 0;
		int ingredientIndex = -1;
		while(ingIt.hasNext()){
			Ingredient tempIngredient = ingIt.next();
			if (ingredient.equals(tempIngredient)){
				ingredientIndex = counter;
			}
			counter++;
		}
		
		if (ingredientIndex == -1){
			throw new InvalidInputException("Ingredient not found in the database!");
		}
		
		// check if the updated quantity is not negative
		if (ftm.getIngredient(ingredientIndex).getQuantity()+update < 0){
			throw new InvalidInputException("Not enough " + ftm.getIngredient(ingredientIndex).getName() + " !");
		}
		
		// update the quantity of the desired item
		ftm.getIngredient(ingredientIndex).setQuantity(ftm.getIngredient(ingredientIndex).getQuantity() + update);
		
		PersistenceXStream.saveToXMLwithXStream(ftm);
	}
	
	
	// equipment
	
	public void createEquipment(String aName, double aQuantity, double aPrice) throws InvalidInputException{
		
		// load model
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		if ( aName == null || aName.trim().length() == 0){
			throw new InvalidInputException("Equipment name cannot be null or empty!");
		}
		
		if ( aQuantity == 0){
			throw new InvalidInputException("Equipment quantity cannot be 0!");
		}
		if ( aQuantity < 0){
			throw new InvalidInputException("Equipment quantity cannot be negative!");
		}
		
		// equipment price can be 0
		if ( aPrice < 0){
			throw new InvalidInputException("Equipment price cannot be negative!");
		}
		
		// check if equipment already exists
		Iterator<Equipment> equipIt = ftm.getEquipment().iterator();
		Equipment equipment = new Equipment(aName, aQuantity, aPrice);
		
		while ( equipIt.hasNext()){
			Equipment tempEquip = equipIt.next();
			if ( equipment.equals(tempEquip)){
				throw new InvalidInputException("Equipment already exists!");
			}
		}
		
		// create equipment
		
		ftm.addEquipment(equipment);
		
		PersistenceXStream.saveToXMLwithXStream(ftm);
	}
	
	public void removeEquipment(Equipment equipment) throws InvalidInputException{
		
		// load model
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// check if ingredient if in the database
		Iterator<Equipment> equipIt = ftm.getEquipment().iterator();
		
		int equipmentIndex = -1;
		int counter = 0;
		while ( equipIt.hasNext()){
			Equipment tempEquip = equipIt.next();
			if ( equipment.equals(tempEquip) ){
				equipmentIndex = counter;
			}	
			counter++;
		}
		if (equipmentIndex == -1){
			throw new InvalidInputException("Equipment was not found in the database!");
		}
		
		// should not throw errors
		if (!ftm.removeEquipment(ftm.getEquipment(equipmentIndex))){
			throw new InvalidInputException("Equipment does not exists!");
		}
		PersistenceXStream.saveToXMLwithXStream(ftm);
	}
	
	// items
	
	public void createItem(String aName, double aPrice, boolean aAvailability) throws InvalidInputException{
		
		// load model
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// check parameters
		
		if (aName == null || aName.trim().length() == 0){
			throw new InvalidInputException("Item name cannot be empty or null!");
		}
		// price can be 0
		if (aPrice < 0){
			throw new InvalidInputException("Item price cannot be negative!");
		}
		
		// check if the item already exists
		Iterator<Item> itIt = ftm.getItem().iterator();
		Item item = new Item(aName, aPrice, aAvailability);
		
		while (itIt.hasNext()){
			Item tempItem = itIt.next();
			if (item.equals(tempItem)){
				throw new InvalidInputException("Item already exists!");
			}
		}
		 
		// add to model
		
		ftm.addItem(item);
		
		// save
		PersistenceXStream.saveToXMLwithXStream(ftm);	
	}
	
	public void removeItem(Item item) throws InvalidInputException{
		
		// load model
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// search for the item
		int counter = 0;
		int itemIndex = -1;
		Iterator<Item> itIt = ftm.getItem().iterator();
		while (itIt.hasNext()){
			Item tempItem = itIt.next();
			if (tempItem.equals(item)){
				itemIndex = counter;
			}
			counter++;
		}
		if (itemIndex == -1){
			throw new InvalidInputException("Item not found in the database!");
		}
		// should never throw an error
		if (!ftm.removeItem(ftm.getItem(itemIndex))){
			throw new InvalidInputException("Item was not removed!");
		}
		
		PersistenceXStream.saveToXMLwithXStream(ftm);
		
	}
	
	public void addIngredientToItem(Item item, Ingredient ingredient) throws InvalidInputException{
		
		// load model
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// check if the ingredient exists
		
		Iterator<Ingredient> ingIt = ftm.getIngredients().iterator();
		
		int ingredientIndex = -1; 
		int counter = 0;
		while(ingIt.hasNext()){
			Ingredient tempIngredient = ingIt.next();
			if (ingredient.equals(tempIngredient)){
				ingredientIndex = counter;
			}
			counter++;
		}
		if (ingredientIndex == -1){
			throw new InvalidInputException("Ingredient was not found in the database!");
		}
		// chech if the item exists
		Iterator<Item> itIt = ftm.getItem().iterator();
		int itemIndex = -1;
		counter = 0;
		while(itIt.hasNext()){
			Item tempItem = itIt.next();
			if (item.equals(tempItem)){
				itemIndex = counter;
			}
			counter++;
		}
		if (itemIndex == -1){
			throw new InvalidInputException("Item was not found in the database!");
		}
		ftm.getItem(itemIndex).addIngredient(ftm.getIngredient(ingredientIndex));
		
		PersistenceXStream.saveToXMLwithXStream(ftm);
		
	}
	public void removeIngredientFromItem(Item item, Ingredient ingredient) throws InvalidInputException{
	
		// load model
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// check if the item exists
		Iterator<Item> itIt = ftm.getItem().iterator();
		int counter = 0;
		int itemIndex = -1;
		while(itIt.hasNext()){
			Item tempItem = itIt.next();
			if (item.equals(tempItem)){
				itemIndex = counter;
			}
			counter++;
		}
		if (itemIndex == -1){
			throw new InvalidInputException("Item not found in the database!");
		}
		
		
		// check if the ingredient exists in the current item
		Iterator<Ingredient> ingIt = ftm.getItem(itemIndex).getIngredient().iterator();
		counter = 0;
		int ingredientIndex = -1;
		while(ingIt.hasNext()){
			Ingredient tempIngredient = ingIt.next();
			if (ingredient.equals(tempIngredient)){
				ingredientIndex = counter;
			}
			counter++;
		}
		if (ingredientIndex == -1){
			throw new InvalidInputException("Ingredient not found in the specific item");
		}
		
		// should not happen
		if (!ftm.getItem(itemIndex).removeIngredient(ftm.getItem(itemIndex).getIngredient(ingredientIndex))){
			throw new InvalidInputException("Ingredient was not removed!");
		}
		PersistenceXStream.saveToXMLwithXStream(ftm);
	}
	
	public void changeAvailabilityItem(Item item, boolean availability) throws InvalidInputException{
		
		// load model
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// find the item in the database
		int counter = 0, itemIndex = -1;
		Iterator<Item> itIt = ftm.getItem().iterator();
		while (itIt.hasNext()){
			Item tempId = itIt.next();
			if (item.equals(tempId)){
				itemIndex = counter;
			}
			counter++;
		}
		if (itemIndex == -1){
			throw new InvalidInputException("Item was not found in the database!");
		}
		
		// change the availability of the item
		ftm.getItem(itemIndex).setAvailability(availability);
		
		// save
		PersistenceXStream.saveToXMLwithXStream(ftm);
		
	}

	
	// menu
	
	public void addItemToMenu(Item item) throws InvalidInputException{
		
		// load model
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// check that the item is in the database
		Iterator<Item> itIt = ftm.getItem().iterator();
		int counter = 0;
		int itemIndex = -1;
		while (itIt.hasNext()){
			Item tempItem = itIt.next();
			if (item.equals(tempItem)){
				itemIndex = counter;
			}
			counter++;
		}
		if ( itemIndex == -1){
			throw new InvalidInputException("Item not found in the database!");
		}
		
		ftm.getMenu().addItem(ftm.getItem(itemIndex));
		PersistenceXStream.saveToXMLwithXStream(ftm);
	}
	
	public void removeItemFromMenu(Item item) throws InvalidInputException{
		// load model
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// check that the item is in the database
		Iterator<Item> itIt = ftm.getItem().iterator();
		int counter = 0;
		int itemIndex = -1;
		while (itIt.hasNext()){
			Item tempItem = itIt.next();
			if (item.equals(tempItem)){
				itemIndex = counter;
			}
			counter++;
		}
		if ( itemIndex == -1){
			throw new InvalidInputException("Item not found in the database!");
		}
		
		ftm.getMenu().removeItem(ftm.getItem(itemIndex));
		PersistenceXStream.saveToXMLwithXStream(ftm);
	}
	
	// order
	
	/**Initial price should always be 0, the date should always be today's date, the orderId increments by one
	 * @throws InvalidInputException 
	 *
	 */
	public int createOrder(Date date) throws InvalidInputException{
		
		// load model 
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// price is 0
		double price = 0.0;
		
		// check that date is not null
		if (date == null){
			throw new InvalidInputException("Date cannot be null!");
		}
		
		// id is the last id + 1
		Iterator<Order> ordIt = ftm.getOrder().iterator();
		int counter = 0;
		while (ordIt.hasNext()){
			counter++;
		}
		
		Order aOrder = new Order(price, date, counter);
		// create the order
		ftm.addOrder(aOrder);
		
		// save to persistence
		PersistenceXStream.saveToXMLwithXStream(ftm);
		
		return counter;
				
	}
	
	public void removeOrder(Order order) throws InvalidInputException{
		
		// load model
		
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// find the id
		Iterator<Order> ordIt = ftm.getOrder().iterator();
		int counter = 0, orderIndex = -1;
		while (ordIt.hasNext()){
			Order tempOrder = ordIt.next();
			if (order.getOrderID() == tempOrder.getOrderID()){
				orderIndex = counter;
			}
			counter++;
		}
		
		if (orderIndex == -1){
			throw new InvalidInputException("Order not found in the database!");
		}
		// remove the order , error should never happen
		if (!ftm.removeOrder(ftm.getOrder(orderIndex))){
			throw new InvalidInputException("Order not removed!");
		}
		
		// save
		
		PersistenceXStream.saveToXMLwithXStream(ftm);
	}
	
	public void addItemToOrder(Order order, Item item, int quantity) throws InvalidInputException{
		
		// load model
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// find the corresponding order
		int counter = 0, orderIndex = -1;
		Iterator<Order> ordIt = ftm.getOrder().iterator();
		while (ordIt.hasNext()){
			Order tempOrder = ordIt.next();
			if (tempOrder.getOrderID() == order.getOrderID()){
				orderIndex = counter;
			}
			counter++;
		}
		
		// error if the order was not found
		if (orderIndex == -1){
			throw new InvalidInputException("Order not found in the database!");
		}
		
		// find the corresponding in the database ( from the menu)
		counter = 0;
		int itemIndex = -1;
		Iterator<Item> itIt = ftm.getMenu().getItem().iterator();
		while (itIt.hasNext()){
			Item tempItem = itIt.next();
			if (item.equals(tempItem)){
				itemIndex = counter;
			}
			counter++;
		}
		
		// error if the item was not found in the database ( in the menu)
		if (itemIndex == -1){
			throw new InvalidInputException("Item is not in the menu!");
		}
		
		// check if the item is available
		if (ftm.getMenu().getItem(itemIndex).getAvailability() == false){
			throw new InvalidInputException("Item not available!");
		}
		// update the item popularity
		ftm.getMenu().getItem(itemIndex).updatePopularity(quantity);
		
		// add the item to the order, also updating the order price 
		
		ftm.getOrder(orderIndex).addItem(ftm.getMenu().getItem(itemIndex), quantity);
		double current_price = ftm.getOrder(orderIndex).getTotalPrice();
		double added_price = ftm.getMenu().getItem(itemIndex).getPrice();
		ftm.getOrder(orderIndex).setTotalPrice(current_price + added_price);
		
		// save
		PersistenceXStream.saveToXMLwithXStream(ftm);
	}
	
	public void removeItemFromOrder(Item item, Order order) throws InvalidInputException{
		
		// load model
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// find the order in the database
		int counter = 0, orderIndex = -1;
		Iterator<Order> ordIt = ftm.getOrder().iterator();
		while (ordIt.hasNext()){
			Order tempOrder = ordIt.next();
			if (tempOrder.getOrderID() == order.getOrderID()){
				orderIndex = counter;
			}
			counter++;
		}
		counter = 0;
		if (orderIndex == -1){
			throw new InvalidInputException("Order was not found in the database!");
		}
		// find item in the order
		int itemIndex = -1;
		Iterator<Item> itIt = ftm.getOrder(orderIndex).getItem().iterator();
		while (itIt.hasNext()){
			Item tempItem = itIt.next();
			if (item.equals(tempItem)){
				itemIndex = counter;
			}
			counter++;
		}
		
		if (itemIndex == -1){
			throw new InvalidInputException("Item is not in the specified order!");
		}
		
		// search for the item in the menu for updating its popularity afterwards
		Iterator<Item> menuIt = ftm.getMenu().getItem().iterator();
		counter = 0;
		int indexItemInMenu = -1;
		while (menuIt.hasNext()){
			Item tempItem = menuIt.next();
			if ( item.equals(tempItem)){
				indexItemInMenu = counter;
			}
			counter++;
		}
		if (indexItemInMenu == -1){
			throw new InvalidInputException("Item is not in the menu!");
		}
		// remove the item from the order, also updating the price and the popularity of the item
		
		double current_price = ftm.getOrder(orderIndex).getTotalPrice();
		double update_price = ftm.getOrder(orderIndex).getItem(item).getPrice();
		
		// remove item
		int update_pop = -ftm.getOrder(orderIndex).removeItem(item);
		
		// update price
		ftm.getOrder(orderIndex).setTotalPrice(current_price-update_price);
		
		// update popularity
		ftm.getMenu().getItem(itemIndex).updatePopularity(update_pop);
		
		
	}
	
	// report 
	
	/**takes all the order between the two dates and creates a text files with the data
	 * @param initialDate
	 * @param endingDate
	 * @param name
	 * @throws IOException 
	 */
	public void generateReport(Date initialDate, Date endingDate, String name) throws IOException{
		
		// load model
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// loads all orders between the two dates
		Iterator<Order> orderIt =ftm.getOrder().iterator();
		ArrayList<Order> orders = new ArrayList<Order>();
		while (orderIt.hasNext()){
			Order tempOrder = orderIt.next();
			if (tempOrder.compareDate(initialDate, endingDate)){
				orders.add(tempOrder);
			}
		}
		// now that we have a list of orders, parses all items, updating their quantities
		
		orderIt = orders.iterator();
		HashMap<Item, Integer> itemQuantity = new HashMap<Item, Integer>();
		while (orderIt.hasNext()){
			Order tempOrder = orderIt.next();
			itemQuantity.putAll(tempOrder.getMap());
		}
		
		// find todays' date
		Calendar c = Calendar.getInstance();
		Date today = new Date(c.getTimeInMillis());
		String file_name = "report-" + today.toString();
		
		// create the file
		File file = new File("." + file_name);
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));

		
		// append all the keys - values to a list of strings 
		Iterator<Entry<Item, Integer>> itemInteger = itemQuantity.entrySet().iterator();
		
		while (itemInteger.hasNext()){
			Entry<Item, Integer> tempEntry = itemInteger.next();
			String tempString = "" + tempEntry.getKey().getName() + ":" + tempEntry.getValue();
			writer.write(tempString);
		}

		
		
		
		writer.close();
	}
	
	
	
}
