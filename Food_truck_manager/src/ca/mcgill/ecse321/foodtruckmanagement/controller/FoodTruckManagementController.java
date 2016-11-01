package ca.mcgill.ecse321.foodtruckmanagement.controller;

import ca.mcgill.ecse321.foodtruckmanagement.FoodTruckManager;
import ca.mcgill.ecse321.foodtruckmanagement.Staff;
import ca.mcgill.ecse321.foodtruckmanagement.persistence.PersistenceXStream;

public class FoodTruckManagementController {

	// ----- constructor -----
	public FoodTruckManagementController()
	{
		
	}
	// create staff
	public void createStaff(String name, String role) throws
		InvalidInputException
	{
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
}
