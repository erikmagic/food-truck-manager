package ca.mcgill.ecse321.foodtruckmanagement.controller;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.mcgill.ecse321.foodtruckmanagement.FoodTruckManager;
import ca.mcgill.ecse321.foodtruckmanagement.Staff;
import ca.mcgill.ecse321.foodtruckmanagement.persistence.PersistenceXStream;

public class TestFoodTruckManagementController {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		// ---- set filname (data.xml ) and directory
		PersistenceXStream.setFileName("test"+File.separator
				+"ca"+File.separator+"mcgill"+File.separator
				+"ecse321"+File.separator+"foodtruckmanagement"+
				File.separator+"persistence"+File.separator+"data.xml");
		// associates alias to class names
		PersistenceXStream.setAlias("staff", Staff.class);
		PersistenceXStream.setAlias("manager", FoodTruckManager.class);
		// TODO add all other aliases for all classes
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception
	{
		
	}

	@After
	public void tearDown() throws Exception
	{
		// clear everything in the management system
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		ftm.delete();
	}
	
	// checks that the name of staff is not null
	@Test
	public void testCreateStaffNameNull()
	{
		// creates new instance of food truck manager
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// checks that there is not staff already there
		assertEquals(0, ftm.getStaff().size());
		
		// initialize name to null
		String name = null;
		String role = "Cook";
		
		// initialize controller
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		// set up error to null
		String error = null;
		
		// add staff to controller
		try {
			ftmc.createStaff(name, role);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		// check whether the error corresponds to the error expected in the controller
		assertEquals(error, "name or role cannot be empty!");
		
		// check that error cause no changes in memory
		assertEquals(0, ftm.getStaff().size());
	}
	
	// check that the role of staff is not set to null
	@Test
	public void testCreateStaffRoleNull()
	{
		// creates new instance of food truck manager
				FoodTruckManager ftm = FoodTruckManager.getInstance();
				// checks that there is not staff already there
				assertEquals(0, ftm.getStaff().size());
				
				// initialize role to null
				String name = "Erik-Olivier";
				String role = null;
				
				// initialize controller
				FoodTruckManagementController ftmc = new FoodTruckManagementController();
				
				// set up error to null
				String error = null;
				
				// add staff to controller
				try {
					ftmc.createStaff(name, role);
				} catch (InvalidInputException e) {
					error = e.getMessage();
				}
				
				// check whether the error corresponds to the error expected in the controller
				assertEquals(error, "name or role cannot be empty!");
				
				// check that error cause no changes in memory
				assertEquals(0, ftm.getStaff().size());
	}
	
	@Test
	public void testCreateStaffNameEmpty()
	{
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// checks that there is not staff already there
		assertEquals(0, ftm.getStaff().size());
		
		// initialize name empty
		String name = "";
		String role = "Cook";
		
		// initialize controller
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		// set up error to null
		String error = null;
		
		// add staff to controller
		try {
			ftmc.createStaff(name, role);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		// check whether the error corresponds to the error expected in the controller
		assertEquals(error, "name or role cannot be empty!");
		
		// check that error cause no changes in memory
		assertEquals(0, ftm.getStaff().size());
	}
	
	@Test
	public void testCreateStaffRoleEmpty()
	{
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// checks that there is not staff already there
		assertEquals(0, ftm.getStaff().size());
		
		// initialize role empty
		String name = "Erik-Olivier";
		String role = "";
		
		// initialize controller
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		// set up error to null
		String error = null;
		
		// add staff to controller
		try {
			ftmc.createStaff(name, role);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		// check whether the error corresponds to the error expected in the controller
		assertEquals(error, "name or role cannot be empty!");
		
		// check that error cause no changes in memory
		assertEquals(0, ftm.getStaff().size());
	}
	
	@Test
	public void testCreateStaffNameSpaces()
	{
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// checks that there is not staff already there
		assertEquals(0, ftm.getStaff().size());
		
		// initialize name with only spaces
		String name = "     ";
		String role = "Cook";
		
		// initialize controller
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		// set up error to null
		String error = null;
		
		// add staff to controller
		try {
			ftmc.createStaff(name, role);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		// check whether the error corresponds to the error expected in the controller
		assertEquals(error, "name or role cannot be empty!");
		
		// check that error cause no changes in memory
		assertEquals(0, ftm.getStaff().size());
	}
	
	@Test
	public void testCreateStaffRoleSpaces()
	{
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// checks that there is not staff already there
		assertEquals(0, ftm.getStaff().size());
		
		// initialize role with only spaces
		String name = "Erik-Olivier";
		String role = "    ";
		
		// initialize controller
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		// set up error to null
		String error = null;
		
		// add staff to controller
		try {
			ftmc.createStaff(name, role);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		// check whether the error corresponds to the error expected in the controller
		assertEquals(error, "name or role cannot be empty!");
		
		// check that error cause no changes in memory
		assertEquals(0, ftm.getStaff().size());
	}
	
	@Test
	public void testCreateStaff()
	{
		// creates new instance of food truck manager
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// asserts that there is no staff in the instance
		assertEquals(0, ftm.getStaff().size());
		
		// name and role for a new staff
		String name = "Erik-Olivier";
		String role = "Cook";
		
		// ---- create a new food manager controller ---
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		// -------- create staff with input ------
		try {
			ftmc.createStaff(name, role);
		} catch (InvalidInputException e) {
			// Auto-generated catch block
			fail();
		}
		
		//-------------  check model in memory  ---------
		// check if there is the correct amount of staff
		assertEquals(1, ftm.getStaff().size());
		// check if the name is good
		assertEquals(name, ftm.getStaff(0).getName());
		// check if the role is good
		assertEquals(role, ftm.getStaff(0).getRole());
		// TODO add all the other classes while asserting that their size is 0
		
		// ----- import model from memory ---
		FoodTruckManager ftm2 = (FoodTruckManager) PersistenceXStream.loadFromXMLwithXStream();
		
		// ----- check file content in memory ------
		// check for the correct amount of staff
		assertEquals(1, ftm2.getStaff().size());
		// check for the good name and role
		assertEquals(name, ftm2.getStaff(0).getName());
		assertEquals(role, ftm2.getStaff(0).getRole());
		// TODO add all the other classes while asserting size 0
		// TODO refractor
	}

}
