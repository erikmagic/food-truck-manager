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
		
			
		// TODO add to all objects
		if (ftm2 != null){
			// load previous staff objects
			Iterator<Staff> sIt = ftm2.getStaff().iterator();
			while (sIt.hasNext()){
				ftm.addStaff(sIt.next());
			}
			// load previous shift objects
			Iterator<Shift> shIt = ftm2.getShift().iterator();
			while ( shIt.hasNext()){
				ftm.addShift(shIt.next());
			}
			
			Iterator<Schedule> schIt = ftm2.getSchedule().iterator();
			while (schIt.hasNext()){
				ftm.addSchedule(schIt.next());
			}
			
			Iterator<Ingredient> ingIt = ftm2.getIngredients().iterator(); // the s at the end of ingredient is a tolerable bug
			while (ingIt.hasNext()){
				ftm.addIngredient(ingIt.next());
			}
			Iterator<Equipment> equipIt = ftm2.getEquipment().iterator();
			while(ingIt.hasNext()){
				ftm.addEquipment(equipIt.next());
			}
			Iterator<Item> itIt = ftm2.getItem().iterator();
			while (itIt.hasNext()){
				ftm.addItem(itIt.next());
			}
		}
	}
	public static void modifyFileName(String x){
		PersistenceXStream.setFileName(x);
	}
}
