package ca.mcgill.ecse321.foodtruckmanagement.controller;

import static org.junit.Assert.*;



import java.io.File;
import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

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
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		
	}

	@Before
	public void setUp() throws Exception {
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

	// after each tests
	@After
	public void tearDown() throws Exception {
		// clear everything in the management system
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		ftm.delete();
		
		
		
	}
	
	// test compare date in Order in Model
	@Test
	public void testCompareDate(){
		
		Calendar c = Calendar.getInstance();
		c.set(2016, 05, 22);
		Date date_initial = new Date(c.getTimeInMillis());
		Date date = new Date(c.getTimeInMillis());
		c.set(2016, 05, 29);
		Date date_final = new Date(c.getTimeInMillis());
		
		// create new Order
		Order newOrder = new Order(10,date, 1);
		
		// check if the order is between the two dates, should be true
		// first case is when the order is the first day of the partition
		boolean order_between_dates = newOrder.compareDate(date_initial, date_final);
		assertEquals(true, order_between_dates);
		
		date = new Date(c.getTimeInMillis());
		
		// check when the date is the last day of the partition
		order_between_dates = false;
		newOrder.setOrderDate(date);
		order_between_dates = newOrder.compareDate(date_initial, date_final);
		assertEquals(true, order_between_dates);
		
		// check when the date is in the middle of the partition
		order_between_dates = false;
		c.set(2016, 05, 25);
		date = new Date(c.getTimeInMillis());
		newOrder.setOrderDate(date);
		order_between_dates = newOrder.compareDate(date_initial, date_final);
		assertEquals(true, order_between_dates);
		
		// check when the date is out of the partition, should be false
		c.set(2016, 05, 21);
		date = new Date(c.getTimeInMillis());
		newOrder.setOrderDate(date);
		order_between_dates = true;
		order_between_dates = newOrder.compareDate(date_initial, date_final);
		order_between_dates = newOrder.compareDate(date_initial, date_final);
		assertEquals(false, order_between_dates);
		
	}
	
	// tests enum
	@Test
	public void enumMap(){
		int number_received = -1;
		
		// monday
		number_received = DayMap.getNumberDay(Day.MONDAY);
		assertEquals(1, number_received);
		number_received = -1;
		// tuesday
		number_received = DayMap.getNumberDay(Day.TUESDAY);
		assertEquals(2, number_received);
		number_received = -1;
		// wednesday
		number_received = DayMap.getNumberDay(Day.WEDNESDAY);
		assertEquals(3, number_received);
		number_received = -1;
		// thursday
		number_received = DayMap.getNumberDay(Day.THURSDAY);
		assertEquals(4, number_received);
		number_received = -1;
		// friday
		number_received = DayMap.getNumberDay(Day.FRIDAY);
		assertEquals(5, number_received);
		number_received = -1;
		// saturday
		number_received = DayMap.getNumberDay(Day.SATURDAY);
		assertEquals(6, number_received);
		number_received = -1;
		// sunday
		number_received = DayMap.getNumberDay(Day.SUNDAY);
		assertEquals(7, number_received);
		number_received = -1;
	}
	
	@Test 
	public void testSeeWhichShiftsComeBefore(){
		
		
		
	}
	
	@Test
	public void testEqualsMethod(){
		
		String name1 = "Jack";
		String role1 = "Janitor";
		
		String name2 = "Jack";
		String role2 = "Janitor";
		
		String name3 = "Joe";
		String role3 = "Janitor";
		
		Staff staff1 = new Staff(name1, role1);
		Staff staff2 = new Staff(name2, role2);
		Staff staff3 = new Staff(name3, role3);
		
		boolean staffsTrue = staff1.equals(staff2);
		boolean staffsFalse = staff2.equals(staff3);
		assertEquals(true, staffsTrue);
		assertEquals(false, staffsFalse);
		
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.HOUR_OF_DAY, 0);
		
		Time time1 = new Time(c.getTimeInMillis());
		
		c.set(Calendar.HOUR_OF_DAY, 2);
		
		Time time2 = new Time(c.getTimeInMillis());
		
		boolean differentTime = time1.equals(time2);
		
		assertEquals(false, differentTime);
		
		Day day1 = Day.WEDNESDAY;
		
		Day day2 = Day.FRIDAY;
		
		boolean differentDay = day1.equals(day2);
		assertEquals(false, differentDay);
		
		
		Shift shift1 = new Shift(time1, time2, day1, staff1);
		
		Shift shift2 = new Shift(time1, time2, day1, staff2);
		
		Shift shift3 = new Shift(time1, time2, day2, staff3);
		
		boolean differentShift = shift1.equals(shift3);
		boolean sameShift = shift2.equals(shift1);
		assertEquals(false, differentShift);
		assertEquals(true, sameShift);
		
		/*c.set(Calendar.DATE, 0);
		
		Date date1 = new Date(c.getTimeInMillis());
		
		c.set(Calendar.DATE, -2);
		
		Date date2 = new Date(c.getTimeInMillis());
		
		c.set(Calendar.DATE, 2);
		
		Date date3 = new Date(c.getTimeInMillis());*/
		
		c.clear();
		
		int firstDateInt = 22;
		int secondDateInt = 24;
		
		
		c.set(2016, 05, firstDateInt);
		Date date1 = new Date(c.getTimeInMillis());
		
		c.set(2016, 05, secondDateInt);
		Date date2 = new Date(c.getTimeInMillis());
		
		c.set(2016, 05, firstDateInt);
		Date date3 = new Date(c.getTimeInMillis());
		
		boolean differentDate = date1.equals(date2);
		boolean sameDate = date3.equals(date1);
		assertEquals(false, differentDate);
		assertEquals(true, sameDate);
		
		Schedule schedule1 = new Schedule(date1);
		Schedule schedule2 = new Schedule(date3);
		
		boolean sameSchedule = schedule1.equals(schedule2);
		assertEquals(true, sameSchedule);
		
		
		
	
	}
	
	// ------------------ SCHEDULE ------------------------------- //
	
	@Test
	public void testAddShiftScheduleErrorNoShift(){
		
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		String error = "";
		
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0); // today
		Time startTime = new Time(c.getTimeInMillis());
		Date today = new Date(c.getTimeInMillis());
		
		
		c.set(Calendar.HOUR_OF_DAY, 2); // today plus 2 hours
		Time endTime = new Time(c.getTimeInMillis());
		
		Day day = Day.MONDAY;
		
		Staff staff = new Staff("Jack", "Cook");
		
		Shift newShift = new Shift(startTime, endTime, day, staff);
		
		// initialize controller
		
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		// create schedule
		
		try {
			ftmc.createSchedule(today);
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		assertEquals(1, ftm.getSchedule().size());
		assertEquals("", error);
		
		
		try {
			ftmc.addShiftToSchedule(ftm.getSchedule(0), newShift);
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		assertEquals("Shift not found in the database!", error);
		assertEquals(0, ftm.getSchedule(0).getShift().size());
		
		
	}
	
	@Test
	public void testCreateScheduleDateNull(){
		
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		String error = "";
		
		// date.sql
		Date badDate = null;
		
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		try {
			ftmc.createSchedule(badDate);
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		assertEquals("Date cannot be set to null!", error);
		
		assertEquals(0, ftm.getSchedule().size());
		
		
	}
	
	@Test
	public void testCreateSchedule(){
		
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		String error = "";
		
		// todays date
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		
		Date today = new Date(c.getTimeInMillis());
		
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		try {
			ftmc.createSchedule(today);
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
				
		assertEquals("", error);
		assertEquals(1, ftm.getSchedule().size());
		
		PersistenceXStream.saveToXMLwithXStream(ftm);
		
		
		
		
	}
	@Test
	public void testCreateScheduleAndSeeIfTheScheduleStartsFirstDayWeek(){
		
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		String error = "";
		
		// todays date
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		
		Date today = new Date(c.getTimeInMillis());
		
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		try {
			ftmc.createSchedule(today);
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		int firstDayWeek = c.getFirstDayOfWeek();
		
		int todayDay = c.get(Calendar.DAY_OF_WEEK);
				
		c.set(Calendar.DAY_OF_WEEK, (firstDayWeek - todayDay));
		
		Date firstDay = new Date(c.getTimeInMillis());
		
		
		assertEquals("", error);
		assertEquals(1, ftm.getSchedule().size());
		assertEquals(firstDay, ftm.getSchedule(0).getWeek());
		
		PersistenceXStream.saveToXMLwithXStream(ftm);
		
		
		
		
	}
	
	@Test 
	public void testCreateScheduleAlreadyExists(){
		
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		String error = "";
		
		Calendar c = Calendar.getInstance();
		
		c.set(Calendar.HOUR_OF_DAY, 0);
		
		Date today = new Date(c.getTimeInMillis());
		
		// create first schedule
		
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		try {
			ftmc.createSchedule(today);
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		assertEquals(1, ftm.getSchedule().size());
		assertEquals("", error);
		
		// check that the schedule is in the database
		FoodTruckManager ftm2 = (FoodTruckManager) PersistenceXStream.loadFromXMLwithXStream();
		
		assertEquals(1, ftm2.getSchedule().size());
		
		
		// create new schedule with same date
		
		try {
			ftmc.createSchedule(today);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}

		
		assertEquals("Schedule already exists!", error);
		assertEquals(1, ftm.getSchedule().size());
		
		
		
	}
	
	// test add a nonexistent shift to a schedule
	@Test
	public void testAddNonExistentShiftSchedule(){
		
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// initialize controller
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		String error = "";
		
		// create temp staff that does not exist in the database
		String goodName = "Henri";
		String goodRole = "Cashier";
		
		// add the staff to the databas
		try{
			ftmc.createStaff(goodName, goodRole);
		} catch (InvalidInputException e){
			error = e.getMessage();
		}
		// asssert that the staff has been successfully created
		assertEquals(1, ftm.getStaff().size());
		
		
		// good start time and good end time  and days
		Calendar c = Calendar.getInstance();
		c.set(2016, Calendar.MAY, 22, 9, 0, 0);
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2016, Calendar.MAY, 22, 10, 0, 0);
		Time endTime = new Time(c.getTimeInMillis());
		
		Day day = Day.MONDAY;
		
	
		// shift that is not in the database
		Shift newShift = new Shift(startTime, endTime, day, ftm.getStaff(0));
		
		c.set(Calendar.HOUR_OF_DAY, 0);
		
		Date today = new Date(c.getTimeInMillis());
		
		try {
			ftmc.createSchedule(today);
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		assertEquals("", error);
		assertEquals(1, ftm.getSchedule().size());
		
		
		try {
			ftmc.addShiftToSchedule(ftm.getSchedule(0), newShift);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		assertEquals("Shift not found in the database!", error);
		assertEquals(0, ftm.getSchedule(0).getShift().size());
			
	}
	
	// test that it is impossible to add shifts to non existent schedule
	@Test
	public void testAddShiftToNonExistentSchedule(){
		
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		String error = "";
		
		String name = "Charles";
		String role = "Janitor";
		
		Staff charles = new Staff(name, role);
		
		// correct times and days
		Calendar c = Calendar.getInstance();
		c.set(2016, Calendar.MAY, 22, 9, 0, 0);
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2016, Calendar.MAY, 22, 12, 0, 0);
		Time endTime = new Time(c.getTimeInMillis());
		
		Day day = Day.MONDAY;
		
		// initialize controller
		
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		try {
			ftmc.createStaff(name, role);
		} catch (InvalidInputException e1) {
			error += e1.getMessage();
		}
		
		try {
			ftmc.createShift(ftm.getStaff(0), startTime, endTime, day);
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		assertEquals(1, ftm.getShift().size());
		assertEquals("", error);
		
		c.set(Calendar.HOUR_OF_DAY, 0);
		
		Date today = new Date(c.getTimeInMillis());
		
		Schedule newSchedule = new Schedule(today);
		
		try {
			ftmc.addShiftToSchedule(newSchedule, ftm.getShift(0));
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		assertEquals("Schedule not found int the database!", error);
		assertEquals(0, ftm.getSchedule().size());
		
		
	}
	// add the same shift twice to the same schedule
	@Test
	public void testAddShiftTwiceSameSchedule(){
		
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// initialize controller
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		String error = "";
		
		// create temp staff that does not exist in the database
		String goodName = "Henri";
		String goodRole = "Cashier";
		
		// add the staff to the databas
		try{
			ftmc.createStaff(goodName, goodRole);
		} catch (InvalidInputException e){
			error = e.getMessage();
		}
		// asssert that the staff has been successfully created
		assertEquals(1, ftm.getStaff().size());
		
		
		// good start time and good end time  and days
		Calendar c = Calendar.getInstance();
		c.set(2016, Calendar.MAY, 22, 9, 0, 0);
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2016, Calendar.MAY, 22, 10, 0, 0);
		Time endTime = new Time(c.getTimeInMillis());
		
		Day day = Day.MONDAY;
		
	
		// create shift in the database
		
		try {
			ftmc.createShift(ftm.getStaff(0), startTime, endTime, day);
		} catch (InvalidInputException e1) {
			error += e1.getMessage();
		}
		
		assertEquals(1, ftm.getShift().size());
		assertEquals("", error);
		
		
		c.set(Calendar.HOUR_OF_DAY, 0);
		
		Date today = new Date(c.getTimeInMillis());
		
		try {
			ftmc.createSchedule(today);
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		assertEquals("", error);
		assertEquals(1, ftm.getSchedule().size());
		
		
		try {
			ftmc.addShiftToSchedule(ftm.getSchedule(0), ftm.getShift(0));
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		assertEquals("", error);
		assertEquals(1, ftm.getSchedule(0).getShift().size());
		
		try {
			ftmc.addShiftToSchedule(ftm.getSchedule(0), ftm.getShift(0));
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		assertEquals("Shift already exists in the current schedule!", error);
		assertEquals(1, ftm.getSchedule(0).getShift().size());
		

		
	}
	
	// test adding shifts to a schedule
	@Test
	public void testAddShiftSchedule(){
		
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// initialize controller
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		String error = "";
		
		// create temp staff that does not exist in the database
		String goodName = "Henri";
		String goodRole = "Cashier";
		
		// add the staff to the databas
		try{
			ftmc.createStaff(goodName, goodRole);
		} catch (InvalidInputException e){
			error = e.getMessage();
		}
		// asssert that the staff has been successfully created
		assertEquals(1, ftm.getStaff().size());
		
		
		// good start time and good end time  and days
		Calendar c = Calendar.getInstance();
		c.set(2016, Calendar.MAY, 22, 9, 0, 0);
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2016, Calendar.MAY, 22, 10, 0, 0);
		Time endTime = new Time(c.getTimeInMillis());
		
		Day day1 = Day.MONDAY;
		
		Day day2 = Day.TUESDAY;
		
		Day day3 = Day.WEDNESDAY;
		
		// create shifts in the database
		
		try {
			ftmc.createShift(ftm.getStaff(0), startTime, endTime, day1);
		} catch (InvalidInputException e1) {
			error += e1.getMessage();
		}
		try {
			ftmc.createShift(ftm.getStaff(0), startTime, endTime, day2);
		} catch (InvalidInputException e1) {
			error += e1.getMessage();
		}
		try {
			ftmc.createShift(ftm.getStaff(0), startTime, endTime, day3);
		} catch (InvalidInputException e1) {
			error += e1.getMessage();
		}
		
		
		assertEquals(3, ftm.getShift().size());
		assertEquals("", error);
		
		
		c.set(Calendar.HOUR_OF_DAY, 0);
		
		Date today = new Date(c.getTimeInMillis());
		
		try {
			ftmc.createSchedule(today);
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		assertEquals("", error);
		assertEquals(1, ftm.getSchedule().size());
		
		
		try {
			ftmc.addShiftToSchedule(ftm.getSchedule(0), ftm.getShift(0));
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		try {
			ftmc.addShiftToSchedule(ftm.getSchedule(0), ftm.getShift(1));
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		try {
			ftmc.addShiftToSchedule(ftm.getSchedule(0), ftm.getShift(2));
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		assertEquals("", error);
		assertEquals(3, ftm.getSchedule(0).getShift().size());
		
		
		
		
	}
	// test remove schedule
	@Test
	public void testRemoveSchedule(){
		
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		String error = "";
		
		// create two schedules
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		Calendar c = Calendar.getInstance();
		
		c.set(2016, 05, 22);
		
		Date date1 = new Date(c.getTimeInMillis());
		
		c.set(2016, 06, 17);
		
		Date date2 = new Date(c.getTimeInMillis());
		
		try {
			ftmc.createSchedule(date1);
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		try {
			ftmc.createSchedule(date2);
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		
		
		assertEquals("", error);
		assertEquals(2, ftm.getSchedule().size());
		
		
		try {
			ftmc.deleteSchedule(ftm.getSchedule(0));
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		assertEquals("", error);
		assertEquals(1, ftm.getSchedule().size());
		
	}
	
	// try to remove a non existent schedule
	@Test
	public void testRemoveNonExistentSchedule(){
		
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		String error = "";
		
		// create two schedules
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		Calendar c = Calendar.getInstance();
		
		c.set(2016, 05, 22);
		
		Date date1 = new Date(c.getTimeInMillis());
		
		c.set(2016, 06, 17);
		
		Date date2 = new Date(c.getTimeInMillis());
		
		try {
			ftmc.createSchedule(date1);
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		
		assertEquals(1, ftm.getSchedule().size());
		assertEquals("", error);
		
		Schedule nonExistent = new Schedule(date2);
		
		try {
			ftmc.deleteSchedule(nonExistent);
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		assertEquals("Schedule not found in the database!", error);
		assertEquals(1, ftm.getSchedule().size());
		
		
	}
	
	// remove shift from a schedule
	@Test
	public void testRemoveShiftFromSchedule(){
		
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// initialize controller
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		String error = "";
		
		// create temp staff that does not exist in the database
		String goodName = "Henri";
		String goodRole = "Cashier";
		
		// add the staff to the databas
		try{
			ftmc.createStaff(goodName, goodRole);
		} catch (InvalidInputException e){
			error = e.getMessage();
		}
		// asssert that the staff has been successfully created
		assertEquals(1, ftm.getStaff().size());
		
		
		// good start time and good end time  and days
		Calendar c = Calendar.getInstance();
		c.set(2016, Calendar.MAY, 22, 9, 0, 0);
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2016, Calendar.MAY, 22, 10, 0, 0);
		Time endTime = new Time(c.getTimeInMillis());
		
		Day day1 = Day.MONDAY;
		
		Day day2 = Day.TUESDAY;
		
		Day day3 = Day.WEDNESDAY;
		
		// create shifts in the database
		
		try {
			ftmc.createShift(ftm.getStaff(0), startTime, endTime, day1);
		} catch (InvalidInputException e1) {
			error += e1.getMessage();
		}
		try {
			ftmc.createShift(ftm.getStaff(0), startTime, endTime, day2);
		} catch (InvalidInputException e1) {
			error += e1.getMessage();
		}
		try {
			ftmc.createShift(ftm.getStaff(0), startTime, endTime, day3);
		} catch (InvalidInputException e1) {
			error += e1.getMessage();
		}
		
		
		assertEquals(3, ftm.getShift().size());
		assertEquals("", error);
		
		
		c.set(Calendar.HOUR_OF_DAY, 0);
		
		Date today = new Date(c.getTimeInMillis());
		
		try {
			ftmc.createSchedule(today);
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		assertEquals("", error);
		assertEquals(1, ftm.getSchedule().size());
		
		
		try {
			ftmc.addShiftToSchedule(ftm.getSchedule(0), ftm.getShift(0));
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		try {
			ftmc.addShiftToSchedule(ftm.getSchedule(0), ftm.getShift(1));
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		try {
			ftmc.addShiftToSchedule(ftm.getSchedule(0), ftm.getShift(2));
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		assertEquals("", error);
		assertEquals(3, ftm.getSchedule(0).getShift().size());
		
		
		try {
			ftmc.removeShiftFromSchedule(ftm.getSchedule(0), ftm.getSchedule(0).getShift(0));
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		assertEquals("", error);
		assertEquals(2, ftm.getSchedule(0).getShift().size());
		
		try {
			ftmc.removeShiftFromSchedule(ftm.getSchedule(0), ftm.getSchedule(0).getShift(0));
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		assertEquals(1, ftm.getSchedule(0).getShift().size());
		
		assertEquals("", error);
		
		
	}
	// ------------------ ADD SHIFT ------------------------------ //
	
	// check that it is impossible to add two identical shifts
	@Test
	public void testAddShifTwice(){
		
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		String error = "";
		
		String name = "Charles";
		String role = "Janitor";
		
		Staff charles = new Staff(name, role);
		
		// correct times and days
		Calendar c = Calendar.getInstance();
		c.set(2016, Calendar.MAY, 22, 9, 0, 0);
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2016, Calendar.MAY, 22, 12, 0, 0);
		Time endTime = new Time(c.getTimeInMillis());
		
		Day day = Day.MONDAY;
		
		// initialize controller
		
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		try {
			ftmc.createStaff(name, role);
		} catch (InvalidInputException e1) {
			error += e1.getMessage();
		}
		
		
		
		try {
			ftmc.createShift(ftm.getStaff(0), startTime, endTime, day);
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		assertEquals(1, ftm.getShift().size());
		assertEquals("", error);
		
		
		try {
			ftmc.createShift(charles, startTime, endTime, day);
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		assertEquals(1, ftm.getShift().size());
		assertEquals("Shift already exists!", error);
		
		
		
		
		
	}
	// check that nothing happens when the staff entered is inexistent
	@Test
	public void addShiftBadStaff(){
		
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		String error = "";
		
		// create temp staff that does not exist in the database
		String badName = "Gregory";
		String badRole = "Plumber";
		
		Staff badStaff = new Staff(badName, badRole);
		
		// correct times and days
		Calendar c = Calendar.getInstance();
		c.set(2016, Calendar.MAY, 22, 9, 0, 0);
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2016, Calendar.MAY, 22, 12, 0, 0);
		Time endTime = new Time(c.getTimeInMillis());
		
		Day day = Day.MONDAY;
		
		// initialize controller
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		try {
			ftmc.createShift(badStaff, startTime, endTime, day);
		} catch (InvalidInputException e) {
			error = e.getMessage();
		}
		
		assertEquals(error, "Staff to be removed was not found!");
		assertEquals(0, ftm.getShift().size());
		
		
		
		
	}
	// check that nothing happens when the time entered is incorrect
	@Test
	public void addShiftEndBeforeStart(){
		
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// initialize controller
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		String error = "";
		
		// create temp staff that does not exist in the database
		String goodName = "Henri";
		String goodRole = "Cashier";
		
		// add the staff to the databas
		try{
			ftmc.createStaff(goodName, goodRole);
		} catch (InvalidInputException e){
			error = e.getMessage();
		}
		// asssert that the staff has been successfully created
		assertEquals(1, ftm.getStaff().size());
		
		
		// bad start time and good end time  and days
		Calendar c = Calendar.getInstance();
		c.set(2016, Calendar.MAY, 22, 9, 0, 0);
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2016, Calendar.MAY, 22, 8, 0, 0);
		Time endTime = new Time(c.getTimeInMillis());
		
		Day day = Day.MONDAY;
		
	
		
		try {
			ftmc.createShift(ftm.getStaff(0), startTime, endTime, day);
		} catch (InvalidInputException e) {
			error =  e.getMessage();
		}
		
		assertEquals(error,  "Start time cannot be after end time!");
		assertEquals(0, ftm.getShift().size());
		
		
	}
	// check that nothing happens when the time entered is incorrect
	@Test
	public void addShift(){
		
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// initialize controller
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		String error = "";
		
		// create temp staff that does not exist in the database
		String goodName = "Henri";
		String goodRole = "Cashier";
		
		// add the staff to the databas
		try{
			ftmc.createStaff(goodName, goodRole);
		} catch (InvalidInputException e){
			error = e.getMessage();
		}
		// asssert that the staff has been successfully created
		assertEquals(1, ftm.getStaff().size());
		
		
		// good start time and good end time  and days
		Calendar c = Calendar.getInstance();
		c.set(2016, Calendar.MAY, 22, 9, 0, 0);
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2016, Calendar.MAY, 22, 10, 0, 0);
		Time endTime = new Time(c.getTimeInMillis());
		
		Day day = Day.MONDAY;
		
	
		
		try {
			ftmc.createShift(ftm.getStaff(0), startTime, endTime, day);
		} catch (InvalidInputException e) {
			error =  e.getMessage();
		}
		
		assertEquals(error,  "");
		assertEquals(1, ftm.getShift().size());
		assertEquals(startTime, ftm.getShift(0).getStartingHour());
		assertEquals(endTime, ftm.getShift(0).getFinishingHour());
		assertEquals(day, ftm.getShift(0).getDay());
		
				
	}
	
	// ------------------ REMOVE SHIFT --------------------------- //
	
	@Test
	public void removeShift(){
		

		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// initialize controller
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		String error = "";
		
		// create temp staff that does not exist in the database
		String goodName = "Henri";
		String goodRole = "Cashier";
		
		// add the staff to the databas
		try{
			ftmc.createStaff(goodName, goodRole);
		} catch (InvalidInputException e){
			error = e.getMessage();
		}
		// asssert that the staff has been successfully created
		assertEquals(1, ftm.getStaff().size());
		
		
		// good start time and good end time  and days
		Calendar c = Calendar.getInstance();
		c.set(2016, Calendar.MAY, 22, 9, 0, 0);
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2016, Calendar.MAY, 22, 10, 0, 0);
		Time endTime = new Time(c.getTimeInMillis());
		
		Day day = Day.MONDAY;
		
	
		
		try {
			ftmc.createShift(ftm.getStaff(0), startTime, endTime, day);
		} catch (InvalidInputException e) {
			error =  e.getMessage();
		}
		
		assertEquals(error,  "");
		assertEquals(1, ftm.getShift().size());
		assertEquals(startTime, ftm.getShift(0).getStartingHour());
		assertEquals(endTime, ftm.getShift(0).getFinishingHour());
		assertEquals(day, ftm.getShift(0).getDay());
		
		FoodTruckManager ftm2 = (FoodTruckManager) PersistenceXStream.loadFromXMLwithXStream();

		assertEquals(1, ftm2.getShift().size());
		
		// remove the shift just created
		
		Shift to_be_removed_shift = new Shift(startTime, endTime, day, ftm.getStaff(0));
		
		try {
			ftmc.deleteShift(to_be_removed_shift);
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		assertEquals(error, "");
		// assert that the shift has succesfully been removed
		assertEquals(0, ftm.getShift().size());
		
		
		
		
	}
	
	@Test
	public void removeInexistantShift(){
		

		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// initialize controller
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		String error = "";
		
		// create temp staff that does not exist in the database
		String goodName = "Henri";
		String goodRole = "Cashier";
		
		// add the staff to the databas
		try{
			ftmc.createStaff(goodName, goodRole);
		} catch (InvalidInputException e){
			error = e.getMessage();
		}
		// asssert that the staff has been successfully created
		assertEquals(1, ftm.getStaff().size());
		
		
		// good start time and good end time  and days
		Calendar c = Calendar.getInstance();
		c.set(2016, Calendar.MAY, 22, 9, 0, 0);
		Time startTime = new Time(c.getTimeInMillis());
		c.set(2016, Calendar.MAY, 22, 10, 0, 0);
		Time endTime = new Time(c.getTimeInMillis());
		
		Day day = Day.MONDAY;
		
	
		
		try {
			ftmc.createShift(ftm.getStaff(0), startTime, endTime, day);
		} catch (InvalidInputException e) {
			error =  e.getMessage();
		}
		
		assertEquals(error,  "");
		assertEquals(1, ftm.getShift().size());
		assertEquals(startTime, ftm.getShift(0).getStartingHour());
		assertEquals(endTime, ftm.getShift(0).getFinishingHour());
		assertEquals(day, ftm.getShift(0).getDay());
		
		// create a new shift not in the database
		
		String randomName = "Pedro";
		String randomRole = "Cook";
		
		try {
			ftmc.createStaff(randomName, randomRole);
		} catch (InvalidInputException e1) {
			error += e1.getMessage();
		}
		
		// asssert that the staff has been successfully created
		assertEquals(2, ftm.getStaff().size());
		
		
		c.set(2016, Calendar.MAY, 22, 12, 0, 0);
		Time startTimeFake = new Time(c.getTimeInMillis());
		c.set(2016, Calendar.MAY, 22, 14, 0, 0);
		Time endTimeFake = new Time(c.getTimeInMillis());
		
		Day dayFake = Day.TUESDAY;
		
		Shift to_be_removed_shift = new Shift( startTimeFake, endTimeFake, dayFake, ftm.getStaff(0));
		
		try {
			ftmc.deleteShift(to_be_removed_shift);
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		assertEquals(error, "Shift to be removed was not found!");
		// assert that the shift has succesfully been removed
		assertEquals(1, ftm.getShift().size());
		
		
		
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
		
		String error = "";
		
		// name and role for a new staff
		String name = "Erik-Olivier";
		String role = "Cook";
		
		// ---- create a new food manager controller ---
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		// -------- create staff with input ------
		try {
			ftmc.createStaff(name, role);
		} catch (InvalidInputException e) {
			error += e.getMessage();
		}
		
		assertEquals("", error);
		// check if there is the correct amount of staff
		assertEquals(1, ftm.getStaff().size());
		// check if the name is good
		assertEquals(name, ftm.getStaff(0).getName());
		// check if the role is good
		assertEquals(role, ftm.getStaff(0).getRole());
		
		
		
	}

}
