package ca.mcgill.ecse321.foodtruckmanagement.persistence;

import ca.mcgill.ecse321.foodtruckmanagement.FoodTruckManager;
import ca.mcgill.ecse321.foodtruckmanagement.Staff;

public class PersistenceFoodTruckManager {
	
	private static void initializeXStream()
	{
		PersistenceXStream.setFileName("foodmanager.xml");
		PersistenceXStream.setAlias("staff", Staff.class);
		PersistenceXStream.setAlias("food truck manager", FoodTruckManager.class);
		// TODO all all remaining classes
	}
	public static void loadFoodTruckManagerModel()
	{
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		PersistenceFoodTruckManager.initializeXStream();
	}
}
