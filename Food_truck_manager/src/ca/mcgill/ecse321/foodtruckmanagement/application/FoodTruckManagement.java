package ca.mcgill.ecse321.foodtruckmanagement.application;

import ca.mcgill.ecse321.foodtruckmanagement.persistence.PersistenceFoodTruckManager;
import ca.mcgill.ecse321.foodtruckmanagement.view.FoodTruckManagerPage;

public class FoodTruckManagement {

	public static void main(String[] args) {
		
		PersistenceFoodTruckManager.loadFoodTruckManagerModel();
		// start user interface
		java.awt.EventQueue.invokeLater(new Runnable()
				{
					public void run() 
					{
						new FoodTruckManagerPage().setVisible(true);
					}
				}
				
				);
		
		
	}

}
