package ca.mcgill.ecse321.foodtruckmanagement.controller;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ca.mcgill.ecse321.foodtruckmanagement.model.*;
import ca.mcgill.ecse321.foodtruckmanagement.persistence.PersistenceXStream;

public class TestFoodTruckManagementController {
	
	// once at the beginning 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public void setUp() throws Exception {
		
	}

	// after each tests
	@After
	public void tearDown() throws Exception {
		// clear everything in the management system
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		ftm.delete();
	}
	
	// ------------------ REMOVE STAFF -------------------------- //
	
	/*
	// check that nothing happens if the user tries to remove a staff with the name null
	@Test
	public void removeStaffNameNull(){
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// assert that there is no staff in memory
		assertEquals(0, ftm.getStaff().size());
		
		// set name to be removed to null
		String name = null;
		String role = "Cashier";
		// initialize controller and error message
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		String error = null;
		
		try {
			ftmc.deleteStaff(name, role);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		// check that the correct error shows up
		assertEquals(error, "Staff name to be removed cannot be empty or null!");
		
		// check that there was no change in model memory
		assertEquals(0, ftm.getStaff().size());
		
	}
	// check that nothing happens if the user tries to remove a staff with a null role
	@Test
	public void removeStaffRoleNull(){
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// assert that there is no staff in memory
		assertEquals(0, ftm.getStaff().size());
		
		// set name to be removed to null
		String name = "Juan";
		String role = null;
		// initialize controller and error message
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		String error = null;
		
		try {
			ftmc.deleteStaff(name, role);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		// check that the correct error shows up
		assertEquals(error, "Staff name to be removed cannot be empty or null!");
		
		// check that there was no change in model memory
		assertEquals(0, ftm.getStaff().size());
	}
	
	// check that nothing happens if the user tries to remove a staff with only spaces
	@Test
	public void removeStaffNameSpaces(){
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// assert that there is no staff in memory
		assertEquals(0, ftm.getStaff().size());
		
		// set name to be removed to null
		String name = "	";
		String role = "Cashier";
		
		// initialize controller and error message
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		String error = null;
		
		try {
			ftmc.deleteStaff(name, role);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		// check that the correct error shows up
		assertEquals(error, "Staff name to be removed cannot be empty or null!");
		
		// check that there was no change in model memory
		assertEquals(0, ftm.getStaff().size());
	}
	
	// check that nothing happens if the user tries to remove a staff with a role that is only spaces
	@Test
	public void removeStaffRoleSpaces(){
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// assert that there is no staff in memory
		assertEquals(0, ftm.getStaff().size());
		
		// set name to be removed to null
		String name = "Juan";
		String role = "  ";
		
		// initialize controller and error message
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		String error = null;
		
		try {
			ftmc.deleteStaff(name, role);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		// check that the correct error shows up
		assertEquals(error, "Staff name to be removed cannot be empty or null!");
		
		// check that there was no change in model memory
		assertEquals(0, ftm.getStaff().size());
	}
	
	// check that nothing happens if the user tries to remove an empty staff
	@Test
	public void removeStaffNameEmpty(){
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// assert that there is no staff in memory
		assertEquals(0, ftm.getStaff().size());
		
		// set name to be removed to null
		String name = "";
		String role = "cook";
		
		// initialize controller and error message
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		String error = null;
		
		try {
			ftmc.deleteStaff(name, role);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		// check that the correct error shows up
		assertEquals(error, "Staff name to be removed cannot be empty or null!");
		
		// check that there was no change in model memory
		assertEquals(0, ftm.getStaff().size());
	}
	
	// check that nothing happens if the user tries to remove a staff with an empty role
	@Test
	public void removeStaffRoleEmpty(){
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// assert that there is no staff in memory
		assertEquals(0, ftm.getStaff().size());
		
		// set name to be removed to null
		String name = "Francis";
		String role = "";
		
		// initialize controller and error message
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		String error = null;
		
		try {
			ftmc.deleteStaff(name,role);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		// check that the correct error shows up
		assertEquals(error, "Staff name to be removed cannot be empty or null!");
		
		// check that there was no change in model memory
		assertEquals(0, ftm.getStaff().size());
	}
	*/
	// check that nothing happens if the user tries to remove a staff when there is no staff
	@Test
	public void removeStaffNoStaff(){
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// assert that there is no staff already here
		assertEquals(0, ftm.getStaff().size());
		
		// initialize a staff
		String name = "Francis";
		String role = "Cook";
		Staff wrongStaff = new Staff(name, role);
		
		// initialize controller
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
			
		
		// set up error
		String error = null;
		
		
		// try removing the staff
		try {
			ftmc.deleteStaff(wrongStaff);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		// check that the error is showed
		assertEquals(error, "Staff to be removed was not found!");
		
		// check that there is no change in memory
		assertEquals(0, ftm.getStaff().size());
		
		
	}
	
	// check that nothing happens if the user tries to remove a staff that does not exist
	@Test
	public void removeStaffDoesNotExist(){
		// create new instance of food manager
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// check that there is no staff already here
		assertEquals(0, ftm.getStaff().size());
		
		
		// initialize with a random name
		String name = "Joseph";
		String role = "Cook";
		Staff wrongStaff = new Staff(name, role);
		
		// initialize controller
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		// set up error to null
		String error = null;
		
		// add bogus staff
		String name1 = "Juan";
		String role1 = "Cook";
		
		String name2 = "Francis";
		String role2 = "Cashier";
		
		try {
			ftmc.createStaff(name1, role1);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		try {
			ftmc.createStaff(name2, role2);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		assertEquals(2, ftm.getStaff().size());
		
		// remove staff
		try {
			ftmc.deleteStaff(wrongStaff);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		// check that the error has been detected
		assertEquals(error, "Staff to be removed was not found!");
		// check that there is no change in memory
		assertEquals(2, ftm.getStaff().size());
		
		// TODO assert with all classes in memory
	}
	
	// check that remove an existing staff works
	@Test
	public void testRemoveStaff(){
		// create new instance of food manager
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// check that there is no staff already here
		assertEquals(0, ftm.getStaff().size());
		
		
		// initialize with a random name
		String name_to_be_deleted = "Francis";
		String role_to_be_deleted = "Cashier";
		Staff staff_to_be_deleted = new Staff(name_to_be_deleted, role_to_be_deleted);
		
		// initialize controller
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		// set up error to null
		String error = null;
		
		// add bogus staff
		String name1 = "Juan";
		String role1 = "Cook";
		
		String name2 = "Francis";
		String role2 = "Cashier";
		
		try {
			ftmc.createStaff(name1, role1);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		assertEquals(error, null);
		
		try {
			ftmc.createStaff(name2, role2);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		assertEquals(error, null);
		assertEquals(2, ftm.getStaff().size());
		assertEquals(name1, ftm.getStaff(0).getName());
		assertEquals(role1, ftm.getStaff(0).getRole());
		assertEquals(name2, ftm.getStaff(1).getName());
		assertEquals(role2, ftm.getStaff(1).getRole());
		
		// remove staff
		try {
			ftmc.deleteStaff(staff_to_be_deleted)	;
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
	
		assertEquals(error, null);
		
		// check that the staff was correctly removed
		assertEquals(1, ftm.getStaff().size());
		
		assertEquals("Juan", ftm.getStaff(0).getName());
		assertEquals("Cook", ftm.getStaff(0).getRole());
		
		// check that the model in memory was correctly updated
		FoodTruckManager ftm2 = (FoodTruckManager) PersistenceXStream.loadFromXMLwithXStream();
		
		assertEquals(ftm.getStaff().size(), ftm2.getStaff().size());
		
		assertEquals(ftm.getStaff(0).getName(), ftm2.getStaff(0).getName());
		assertEquals(ftm.getStaff(0).getName(), ftm2.getStaff(0).getName());
		
		
		
	}
	
	// ------------------- ADD STAFF --------------------------- //
	// checks that the name of staff is not null
	@Test
	public void testCreateStaffNameNull() {
		// creates new instance of food truck manager
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// checks that there is no staff already there
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
		assertEquals(error, "Staff name or role cannot be empty or null!");
		
		// check that error cause no changes in memory
		assertEquals(0, ftm.getStaff().size());
	}
	
	// check that the role of staff is not set to null
	@Test
	public void testCreateStaffRoleNull() {
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
				assertEquals(error, "Staff name or role cannot be empty or null!");
				
				// check that error cause no changes in memory
				assertEquals(0, ftm.getStaff().size());
	}
	
	@Test
	public void testCreateStaffNameEmpty() {
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
		assertEquals(error, "Staff name or role cannot be empty or null!");
		
		// check that error cause no changes in memory
		assertEquals(0, ftm.getStaff().size());
	}
	
	@Test
	public void testCreateStaffRoleEmpty() {
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
		assertEquals(error, "Staff name or role cannot be empty or null!");
		
		// check that error cause no changes in memory
		assertEquals(0, ftm.getStaff().size());
	}
	
	@Test
	public void testCreateStaffNameSpaces() {
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
		assertEquals(error, "Staff name or role cannot be empty or null!");
		
		// check that error cause no changes in memory
		assertEquals(0, ftm.getStaff().size());
	}
	
	@Test
	public void testCreateStaffRoleSpaces() {
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
		assertEquals(error, "Staff name or role cannot be empty or null!");
		
		// check that error cause no changes in memory
		assertEquals(0, ftm.getStaff().size());
	}
	
	@Test
	public void testCreateStaff() {
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
