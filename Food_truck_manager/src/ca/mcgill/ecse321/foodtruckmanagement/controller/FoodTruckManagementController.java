package ca.mcgill.ecse321.foodtruckmanagement.controller;


import ca.mcgill.ecse321.foodtruckmanagement.persistence.PersistenceXStream;
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
			throw new InvalidInputException("name or role cannot be empty!");
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
	public void removeStaff(String name) throws InvalidInputException {
		// check that the entered name is not empty or null
		if (name == null | name.trim().length() == 0 ){
			throw new InvalidInputException("name cannot be empty");
		}
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// loops to find the staff name
		int keep_track_index = 0;
		for (int i = 0; i < ftm.getStaff().size(); i++){
			if (ftm.getStaff(i).getName().equals(name)) keep_track_index = i;
		}
		// if the specified staff name is not in the database, throw error
		if (keep_track_index == 0){
			throw new InvalidInputException("staff not found");
		}
		
		// remove the specified staff
		ftm.getStaff(keep_track_index).delete();
		PersistenceXStream.saveToXMLwithXStream(ftm);
	}
}
