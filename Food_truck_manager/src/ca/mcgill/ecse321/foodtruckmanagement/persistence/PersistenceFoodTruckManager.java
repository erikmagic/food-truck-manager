package ca.mcgill.ecse321.foodtruckmanagement.persistence;

import java.io.FileNotFoundException;
import java.util.Iterator;


import ca.mcgill.ecse321.foodtruckmanagement.model.*;

public class PersistenceFoodTruckManager {
	
	private static void initializeXStream(String x)
	{
		PersistenceXStream.setFileName(x);
		PersistenceXStream.setAlias("staff", Staff.class);
		PersistenceXStream.setAlias("manager", FoodTruckManager.class);
		// TODO all all remaining classes
	}
	public static void loadFoodTruckManagerModel(String x)
	{
		
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		PersistenceFoodTruckManager.initializeXStream(x);
		
			FoodTruckManager ftm2 = (FoodTruckManager) PersistenceXStream.loadFromXMLwithXStream();
		
		if (ftm2 != null){
			Iterator<Staff> sIt = ftm2.getStaff().iterator();
			while (sIt.hasNext()){
				ftm.addStaff(sIt.next());
			}
		}
	}
	public static void modifyFileName(String x){
		PersistenceXStream.setFileName(x);
	}
}
