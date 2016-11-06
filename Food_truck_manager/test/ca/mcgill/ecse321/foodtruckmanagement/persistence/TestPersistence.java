package ca.mcgill.ecse321.foodtruckmanagement.persistence;

import static org.junit.Assert.*;


import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import ca.mcgill.ecse321.foodtruckmanagement.model.*;
public class TestPersistence {

	@Before	
	public void setUp() throws Exception
	{
		// set up singleton instance of food manager
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// ------ create classes to test --------
		Staff s1 = new Staff("Erik-Olivier", "Cook");
		Staff s2 = new Staff("Juan Pedro San Luiz", "Cashier");
		
		
		// ------ add classes to food truck manager ----
		ftm.addStaff(s1);
		ftm.addStaff(s2);
		
	}

	@After
	public void tearDown() throws Exception
	{
		// clear all classes associated to FoodTruckManager
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		ftm.delete();
	}

	@Test
	public void test()
	{
		// directory + last element is the name of the
		// file created ( in this instance = data.xml)
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		PersistenceXStream.setFileName("test"+File.separator
				+"ca"+File.separator+"mcgill"+File.separator
				+"ecse321"+File.separator+"foodtruckmanagement"+
				File.separator+"persistence"+File.separator+"data.xml");
		// associates alias to class names
		PersistenceXStream.setAlias("staff", Staff.class);
		PersistenceXStream.setAlias("manager", FoodTruckManager.class);
		// TODO add all aliases of other classes
		// fails if cannot write to file
		if (!PersistenceXStream.saveToXMLwithXStream(ftm))
		{
			fail("could not save file!");
		}
		
		// create the model in memory
		ftm.delete(); // clears instances created
		// asserts that there is 0 staff
		assertEquals(0, ftm.getStaff().size());
		
		// load model
		ftm = (FoodTruckManager) PersistenceXStream.loadFromXMLwithXStream();
		if (ftm == null)
		{
			fail("could not load file!");
		}
		
		// checks Staff is there
		assertEquals(2, ftm.getStaff().size()); // asserts the correct # of staff
		// checks their name are correct
		assertEquals("Erik-Olivier", ftm.getStaff(0).getName());
		assertEquals("Juan Pedro San Luiz", ftm.getStaff(1).getName());
		// checks that their roles are correct
		assertEquals("Cook", ftm.getStaff(0).getRole());
		assertEquals("Cashier", ftm.getStaff(1).getRole());
		
		// TODO complete with all other classes
	}

}
