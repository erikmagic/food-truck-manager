package ca.mcgill.ecse321.foodtruckmanagement.controller;


import ca.mcgill.ecse321.foodtruckmanagement.persistence.PersistenceFoodTruckManager;
import ca.mcgill.ecse321.foodtruckmanagement.persistence.PersistenceXStream;

import java.sql.Time;
import java.util.Calendar;
import java.sql.Date;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;

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
		
		
		Shift sh = new Shift(startTime, endTime, day, staff_for_shift);
		
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
		
		// find the closest first day of the week to create a new schedule from the new weed
		
		Calendar c = Calendar.getInstance();
		c.setTime(startWeek);
		while ( c.getFirstDayOfWeek() != c.get(Calendar.DAY_OF_WEEK)){
			c.add(Calendar.DATE, -1);	
		}
		
		// create new schedule
		
		// date.sql
		Schedule sch = new Schedule( startWeek);
		
		
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
		
		ftm.getSchedule(scheduleIndex).addShift(aShift);
		
		PersistenceXStream.saveToXMLwithXStream(ftm);
	}
	
	public void removeShiftFromSchedule(Schedule aSchedule, Shift aShift){
		
		
	}
	
	public void removeSchedule(Schedule aSchedule){
		
		
	}
}
