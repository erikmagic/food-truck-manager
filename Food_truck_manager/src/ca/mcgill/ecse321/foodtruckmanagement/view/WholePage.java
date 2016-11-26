package ca.mcgill.ecse321.foodtruckmanagement.view;

import javax.swing.JFrame;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ca.mcgill.ecse321.foodtruckmanagement.controller.Day;
import ca.mcgill.ecse321.foodtruckmanagement.controller.DayMap;
import ca.mcgill.ecse321.foodtruckmanagement.controller.FoodTruckManagementController;
import ca.mcgill.ecse321.foodtruckmanagement.controller.InvalidInputException;
import ca.mcgill.ecse321.foodtruckmanagement.model.*;

import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.List;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Calendar;
import java.sql.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import org.jdatepicker.impl.SqlDateModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.DateModel;
import java.util.Properties;


public class WholePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6005169480932163746L;
	private JPanel yearScheduleLabel;
	private JTextField staffNameTextField;
	private JTextField staffRoleTextField;
	private JLabel errorLabel;
	private JLabel errorRemoveStaffLabel;
	private JLabel staffRoletextLabel;
	private JLabel staffNameTextLabel;
	private JComboBox<String> removeStaffComboBox;
	private JButton removeStaffButton ;
	private JButton addStaffButton;
	private JSeparator shiftStaffSeparator;
	private JLabel addShiftDay;
	private JComboBox<String> dayOfTheWeekBox;
	private JButton addShiftbtn;
	
	private String errorStaff = "";
	private Integer selectedStaff = -1;
	private Integer selectedStaffShift = -1;
	private HashMap<Integer, Staff> staffs;
	private String errorRemoveStaff = "";
	private String errorAddShift = "";
	private int selectedDay = -1;

	
	private HashMap<Integer, Shift> shifts;
	private Integer selectedShiftRemoval = -1;
	private String errorRemovalShift = "";
	
	private JComboBox<String> addShiftComboBox;
	private JLabel staffShiftText;
	private JLabel startTimeText;
	private JTextField startHoursShiftTextBox;
	private JLabel doubleColonStartTime;
	private JTextField startMinsTextField;
	private JLabel shiftEndTimeLAbel;
	private JTextField endHoursShiftText;
	private JLabel doubleColonEndTime;
	private JTextField endMinsShiftText;
	private JLabel errorAddShiftLabel;
	private JButton removeShift;
	private JComboBox<String> removeShiftComboBox;
	private JLabel errorRemoveShift;
	private JTextField yearScheduleTextField;
	private JTextField monthScheduleTextField;
	private JTextField dayScheduleTextField;
	
	private JLabel lblYear;
	
	private JLabel monthScheduleLabel;
	
	private JLabel dayScheduleLabel;
	
	private JButton addScheduleButton;
	
	private JComboBox<String> addShiftToScheduleComboBox;
		
	private JButton addShiftToScheduleButton;
	
	private JComboBox<String> removeShiftFromScheduleComboBox;
	
	private JButton removeShiftFromScheduleButton;
	
	private JComboBox<String> removeScheduleComboBox;
	
	private JButton removeScheduleButton;
	
	private JSeparator shiftScheduleSeperator;
	private JLabel addScheduleError;
	private JLabel addShiftScheduleError;
	private JLabel removeShiftScheduleError;
	private JLabel removeScheduleError;
	
	private String errorAddSchedule;
	private String errorAddShiftSchedule;
	private String errorRemoveShiftSchedule;
	private String errorRemoveSchedule;
	
	
	/**
	 * Create the frame.
	 */
	public WholePage() {
	
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 602);
		yearScheduleLabel = new JPanel();
		yearScheduleLabel.setBackground(new Color(240, 240, 240));
		yearScheduleLabel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(yearScheduleLabel);
		yearScheduleLabel.setLayout(null);
		
		addStaffButton = new JButton("Add Staff");
		addStaffButton.setBackground(Color.LIGHT_GRAY);
		addStaffButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		addStaffButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addStaffButtonActionPerformed(evt);
			}
		});
		addStaffButton.setBounds(10, 73, 140, 23);
		yearScheduleLabel.add(addStaffButton);
		
		staffNameTextField = new JTextField();
		staffNameTextField.setToolTipText("Name");
		staffNameTextField.setBounds(64, 11, 86, 20);
		yearScheduleLabel.add(staffNameTextField);
		staffNameTextField.setColumns(10);
		
		staffRoleTextField = new JTextField();
		staffRoleTextField.setToolTipText("Role");
		staffRoleTextField.setBounds(64, 40, 86, 20);
		yearScheduleLabel.add(staffRoleTextField);
		staffRoleTextField.setColumns(10);
		
		errorLabel = new JLabel("");
		errorLabel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		errorLabel.setVerticalAlignment(SwingConstants.TOP);
		errorLabel.setToolTipText("");
		errorLabel.setLabelFor(yearScheduleLabel);
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(162, 11, 140, 48);
		yearScheduleLabel.add(errorLabel);
		
		staffNameTextLabel = new JLabel("Name:");
		staffNameTextLabel.setBounds(10, 14, 46, 14);
		yearScheduleLabel.add(staffNameTextLabel);
		
		staffRoletextLabel = new JLabel("Role:");
		staffRoletextLabel.setBounds(8, 43, 46, 14);
		yearScheduleLabel.add(staffRoletextLabel);
		
		// REMOVE STAFF COMBO BOX
		removeStaffComboBox = new JComboBox<String>();
		removeStaffComboBox.setToolTipText("");
		removeStaffComboBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed ( java.awt.event.ActionEvent evt) {
				JComboBox<String> cb = (JComboBox<String>) evt.getSource();
				selectedStaff = cb.getSelectedIndex();
			}
		});
		removeStaffComboBox.setBounds(10, 106, 140, 20);
		yearScheduleLabel.add(removeStaffComboBox);
		
		removeStaffButton = new JButton("Remove Staff");
		removeStaffButton.setBackground(Color.LIGHT_GRAY);
		removeStaffButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		removeStaffButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				removeStaffButtonActionPerformed(evt);
			}
		});
		removeStaffButton.setBounds(10, 137, 140, 23);
		yearScheduleLabel.add(removeStaffButton);
		
		errorRemoveStaffLabel = new JLabel("");
		errorRemoveStaffLabel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		errorRemoveStaffLabel.setForeground(Color.RED);
		errorRemoveStaffLabel.setBounds(162, 108, 164, 52);
		yearScheduleLabel.add(errorRemoveStaffLabel);
		
		// ADD SHIFT COMBO BOX
		addShiftComboBox = new JComboBox<String>();
		addShiftComboBox.setToolTipText("");
		addShiftComboBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed ( java.awt.event.ActionEvent evt) {
				JComboBox<String> cb = (JComboBox<String>) evt.getSource();
				selectedStaffShift = cb.getSelectedIndex();
			}
		});
		addShiftComboBox.setBounds(255, 11, 140, 20);
		yearScheduleLabel.add(addShiftComboBox);
		
		staffShiftText = new JLabel("Staff:");
		staffShiftText.setBounds(209, 13, 56, 16);
		yearScheduleLabel.add(staffShiftText);
		
		startTimeText = new JLabel("Start Time:");
		startTimeText.setBounds(209, 42, 71, 16);
		yearScheduleLabel.add(startTimeText);
		
		startHoursShiftTextBox = new JTextField();
		startHoursShiftTextBox.setBounds(301, 39, 31, 22);
		yearScheduleLabel.add(startHoursShiftTextBox);
		startHoursShiftTextBox.setColumns(10);
		
		doubleColonStartTime = new JLabel(":");
		doubleColonStartTime.setFont(new Font("Dialog", Font.BOLD, 15));
		doubleColonStartTime.setEnabled(true);
		doubleColonStartTime.setBounds(334, 41, 15, 16);
		yearScheduleLabel.add(doubleColonStartTime);
		
		startMinsTextField = new JTextField();
		startMinsTextField.setColumns(10);
		startMinsTextField.setBounds(344, 39, 31, 22);
		yearScheduleLabel.add(startMinsTextField);
		
		shiftEndTimeLAbel = new JLabel("End Time:");
		shiftEndTimeLAbel.setBounds(209, 76, 71, 16);
		yearScheduleLabel.add(shiftEndTimeLAbel);
		
		endHoursShiftText = new JTextField();
		endHoursShiftText.setColumns(10);
		endHoursShiftText.setBounds(301, 73, 31, 22);
		yearScheduleLabel.add(endHoursShiftText);
		
		doubleColonEndTime = new JLabel(":");
		doubleColonEndTime.setFont(new Font("Dialog", Font.BOLD, 15));
		doubleColonEndTime.setEnabled(true);
		doubleColonEndTime.setBounds(334, 75, 15, 16);
		yearScheduleLabel.add(doubleColonEndTime);
		
		endMinsShiftText = new JTextField();
		endMinsShiftText.setColumns(10);
		endMinsShiftText.setBounds(344, 73, 31, 22);
		yearScheduleLabel.add(endMinsShiftText);
		
		shiftStaffSeparator = new JSeparator();
		shiftStaffSeparator.setOrientation(SwingConstants.VERTICAL);
		shiftStaffSeparator.setBounds(184, 14, 13, 315);
		yearScheduleLabel.add(shiftStaffSeparator);
		
		addShiftDay = new JLabel("Day:");
		addShiftDay.setBounds(209, 108, 56, 16);
		yearScheduleLabel.add(addShiftDay);
		
		// day of the week combo box
		dayOfTheWeekBox = 	new JComboBox<String>();
		dayOfTheWeekBox.setToolTipText("");
		dayOfTheWeekBox.setBounds(255, 105, 140, 20);
		dayOfTheWeekBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed ( java.awt.event.ActionEvent evt) {
				JComboBox<Day> cb = (JComboBox<Day>) evt.getSource();
				selectedDay = cb.getSelectedIndex();
			}
		});
		yearScheduleLabel.add(dayOfTheWeekBox);
		
		addShiftbtn = new JButton("Add Shift");
		addShiftbtn.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		addShiftbtn.setBackground(Color.LIGHT_GRAY);
		addShiftbtn.setBounds(209, 136, 186, 23);
		addShiftbtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addShiftButtonActionPerformed(evt);
			}
		});
		yearScheduleLabel.add(addShiftbtn);
		
		errorAddShiftLabel = new JLabel("");
		errorAddShiftLabel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		errorAddShiftLabel.setForeground(Color.RED);
		errorAddShiftLabel.setBounds(426, 79, 155, 81);
		yearScheduleLabel.add(errorAddShiftLabel);
		
		
		// remove shift combo box
		removeShiftComboBox = new JComboBox<String>();
		removeShiftComboBox.setToolTipText("Shifts");
		removeShiftComboBox.setBounds(209, 172, 186, 20);
		removeShiftComboBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed ( java.awt.event.ActionEvent evt) {
				JComboBox<Day> cb = (JComboBox<Day>) evt.getSource();
				selectedShiftRemoval = cb.getSelectedIndex();
			}
		});
		yearScheduleLabel.add(removeShiftComboBox);
		
		
		// remove shift button
		removeShift = new JButton("Remove Shift");
		removeShift.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				removeShiftButtonActionPerformed(evt);
			}
		});
		removeShift.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		removeShift.setBackground(Color.LIGHT_GRAY);
		removeShift.setBounds(209, 205, 186, 23);
		yearScheduleLabel.add(removeShift);
		
		errorRemoveShift = new JLabel("");
		errorRemoveShift.setForeground(Color.RED);
		errorRemoveShift.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		errorRemoveShift.setBounds(407, 173, 164, 52);
		yearScheduleLabel.add(errorRemoveShift);
		
		lblYear = new JLabel("Year:");
		lblYear.setBounds(451, 13, 56, 16);
		yearScheduleLabel.add(lblYear);
		
		monthScheduleLabel = new JLabel("Month:");
		monthScheduleLabel.setBounds(451, 42, 56, 16);
		yearScheduleLabel.add(monthScheduleLabel);
		
		dayScheduleLabel = new JLabel("Day:");
		dayScheduleLabel.setBounds(451, 76, 56, 16);
		yearScheduleLabel.add(dayScheduleLabel);
		
		yearScheduleTextField = new JTextField();
		yearScheduleTextField.setBounds(519, 10, 116, 22);
		yearScheduleLabel.add(yearScheduleTextField);
		yearScheduleTextField.setColumns(10);
		
		monthScheduleTextField = new JTextField();
		monthScheduleTextField.setBounds(519, 39, 116, 22);
		yearScheduleLabel.add(monthScheduleTextField);
		monthScheduleTextField.setColumns(10);
		
		dayScheduleTextField = new JTextField();
		dayScheduleTextField.setBounds(519, 73, 116, 22);
		yearScheduleLabel.add(dayScheduleTextField);
		dayScheduleTextField.setColumns(10);
		
		addScheduleButton = new JButton("Add Schedule");
		addScheduleButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		addScheduleButton.setBackground(Color.LIGHT_GRAY);
		addScheduleButton.setBounds(451, 104, 186, 23);
		yearScheduleLabel.add(addScheduleButton);
		
		// show all shifts
		addShiftToScheduleComboBox = new JComboBox<String>();
		addShiftToScheduleComboBox.setToolTipText("Shifts");
		addShiftToScheduleComboBox.setBounds(451, 140, 186, 20);
		yearScheduleLabel.add(addShiftToScheduleComboBox);
		
		addShiftToScheduleButton = new JButton("Add Shift to Schedule");
		addShiftToScheduleButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		addShiftToScheduleButton.setBackground(Color.LIGHT_GRAY);
		addShiftToScheduleButton.setBounds(449, 170, 186, 23);
		yearScheduleLabel.add(addShiftToScheduleButton);
		
		removeShiftFromScheduleComboBox = new JComboBox<String>();
		removeShiftFromScheduleComboBox.setToolTipText("Shifts");
		removeShiftFromScheduleComboBox.setBounds(449, 205, 186, 20);
		yearScheduleLabel.add(removeShiftFromScheduleComboBox);
		
		removeShiftFromScheduleButton = new JButton("Remove Shift from Schedule");
		removeShiftFromScheduleButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 10));
		removeShiftFromScheduleButton.setBackground(Color.LIGHT_GRAY);
		removeShiftFromScheduleButton.setBounds(451, 238, 186, 23);
		yearScheduleLabel.add(removeShiftFromScheduleButton);
		
		removeScheduleComboBox = new JComboBox<String>();
		removeScheduleComboBox.setToolTipText("Shifts");
		removeScheduleComboBox.setBounds(451, 274, 186, 20);
		yearScheduleLabel.add(removeScheduleComboBox);
		
		removeScheduleButton = new JButton("Remove Schedule");
		removeScheduleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		removeScheduleButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		removeScheduleButton.setBackground(Color.LIGHT_GRAY);
		removeScheduleButton.setBounds(451, 306, 186, 23);
		yearScheduleLabel.add(removeScheduleButton);
		
		shiftScheduleSeperator = new JSeparator();
		shiftScheduleSeperator.setOrientation(SwingConstants.VERTICAL);
		shiftScheduleSeperator.setBounds(426, 11, 13, 318);
		yearScheduleLabel.add(shiftScheduleSeperator);
		
		addScheduleError = new JLabel("");
		addScheduleError.setBounds(645, 13, 56, 145);
		yearScheduleLabel.add(addScheduleError);
		
		addShiftScheduleError = new JLabel("");
		addShiftScheduleError.setBounds(647, 174, 56, 155);
		yearScheduleLabel.add(addShiftScheduleError);
		
		removeShiftScheduleError = new JLabel("");
		removeShiftScheduleError.setBounds(647, 174, 56, 155);
		yearScheduleLabel.add(removeShiftScheduleError);
		
		removeScheduleError = new JLabel("");
		removeScheduleError.setBounds(647, 174, 56, 155);
		yearScheduleLabel.add(removeScheduleError);
		
		
		
		// show initialData
		initialData();
	}
	
	private void initialData(){
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		staffs = new HashMap<Integer, Staff>();
		Iterator<Staff> sIt = ftm.getStaff().iterator();
		Integer index = 0;
		while (sIt.hasNext()){
			// add staffs in the remove staff combo box and in the shift staff combo box
			Staff s = sIt.next();
			staffs.put(index, s);
			removeStaffComboBox.addItem(s.getName() + " - " + s.getRole());
			addShiftComboBox.addItem(s.getName() + " - " + s.getRole());
			index++;
		}
		index = 0;
		shifts = new HashMap<Integer, Shift>();
		Iterator<Shift> shIt = ftm.getShift().iterator();
		while (shIt.hasNext()){
			// add shifts to remove shift combo box
			Shift sh = shIt.next();
			shifts.put(index, sh);
			removeShiftComboBox.addItem(sh.getStaff().getName() + " - " + sh.getStartingHour() + " - " + sh.getDay());
			addShiftToScheduleComboBox.addItem(sh.getStaff().getName() + " - " + sh.getStartingHour() + " - " + sh.getFinishingHour() + " - "+ sh.getDay());
			index++;
		}
		index = 0;
		
		// add days in the shift days combo box
		dayOfTheWeekBox.addItem("Monday");
		dayOfTheWeekBox.addItem("Tuesday");
		dayOfTheWeekBox.addItem("Wednesday");
		dayOfTheWeekBox.addItem("Thursday");
		dayOfTheWeekBox.addItem("Friday");
		dayOfTheWeekBox.addItem("Saturday");
		dayOfTheWeekBox.addItem("Sunday");
		
	}
	private void refreshData()
	{	
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// errors
		
		errorLabel.setText("<html>" +errorStaff + "</html>"); // html tags make sure the text is displayed as 2 lines if needed
		errorRemoveStaffLabel.setText("<html>" + errorRemoveStaff + "</html");
		errorAddShiftLabel.setText("<html>" + errorAddShift +"</html>");
		errorRemoveShift.setText("<html>" + errorRemovalShift + "</html>");
		
		// add staff
		if (errorStaff == null || errorStaff.length() == 0){
			
			staffs = new HashMap<Integer, Staff>();
			removeStaffComboBox.removeAllItems();
			Iterator<Staff> sIt = ftm.getStaff().iterator();
			Integer index = 0;
			while (sIt.hasNext()){
				Staff s = sIt.next();
				staffs.put(index, s);
				removeStaffComboBox.addItem(s.getName() + " - " + s.getRole());
				index++;
			}
			selectedStaff = -1;
			removeStaffComboBox.setSelectedItem(selectedStaff);
			
			staffNameTextField.setText("");
			staffRoleTextField.setText("");
			
		}
		
		// remove staff
		
		if ( errorRemoveStaff == null || errorRemoveStaff.length() == 0){
			staffs = new HashMap<Integer, Staff>();
			removeStaffComboBox.removeAllItems();
			Iterator<Staff> sIt = ftm.getStaff().iterator();
			Integer index = 0;
			while (sIt.hasNext()){
				Staff s = sIt.next();
				staffs.put(index, s);
				removeStaffComboBox.addItem(s.getName() + " - " + s.getRole());
				index++;
			}
			selectedStaff= -1;
			removeStaffComboBox.setSelectedItem(selectedStaffShift);
			
			
		}
		
		// add shift
		if ( errorAddShift == null || errorAddShift.length() == 0){
			staffs = new HashMap<Integer, Staff>();
			addShiftComboBox.removeAllItems();
			Iterator<Staff> sIt = ftm.getStaff().iterator();
			Integer index = 0;
			while (sIt.hasNext()){
				Staff s = sIt.next();
				staffs.put(index, s);
				addShiftComboBox.addItem(s.getName() + " - " + s.getRole());
				index++;
			}
			selectedStaffShift = -1;
			addShiftComboBox.setSelectedItem(selectedStaffShift);
			
			selectedDay = -1;
			dayOfTheWeekBox.setSelectedItem(selectedDay);
			
			startHoursShiftTextBox.setText("");
			startMinsTextField.setText("");
			endHoursShiftText.setText("");
			endMinsShiftText.setText("");
			
		}
		
		// remove shift
		
		if (errorRemovalShift == null || errorRemovalShift.length() == 0){
			shifts = new HashMap<Integer, Shift>();
			removeShiftComboBox.removeAllItems();
			Iterator<Shift> shIt = ftm.getShift().iterator();
			Integer index = 0;
			while ( shIt.hasNext()){
				Shift sh = shIt.next();
				shifts.put(index, sh);
				removeShiftComboBox.addItem(sh.getStaff().getName() + " - " + sh.getStartingHour() + " - " + sh.getDay());
				index++;
			}
			
			selectedShiftRemoval = -1;
			removeShiftComboBox.setSelectedItem(selectedShiftRemoval);
		}
		
		
	
	}
	
	private void addStaffButtonActionPerformed(java.awt.event.ActionEvent evt)
	{
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		errorStaff = "";
		try {
			ftmc.createStaff(staffNameTextField.getText(), staffRoleTextField.getText());
		} catch (InvalidInputException e) {
			//  Auto-generated catch block
			errorStaff = e.getMessage();
		}
		// update visuals
		refreshData();

	}
	
	private void removeStaffButtonActionPerformed( java.awt.event.ActionEvent evt ) {
		
		errorRemoveStaff = "";
		if (selectedStaff < 0){
			errorRemoveStaff = "Staff needs to be selected for removal!";
			errorRemoveStaff = errorRemoveStaff.trim();
		}
		if ( errorRemoveStaff.length() == 0) {
			FoodTruckManagementController ftmc = new FoodTruckManagementController();
			
			try {
				ftmc.deleteStaff(staffs.get(selectedStaff));
			} catch (InvalidInputException e) {
				errorRemoveStaff += e.getMessage();
			}
		}
		// update visuals
		refreshData();
	}
	
	private void addShiftButtonActionPerformed ( java.awt.event.ActionEvent evt) {
		
		errorAddShift = "";
		
		
		
		if ( selectedStaffShift < 0) {
			errorAddShift += "Staff needs to be selected before adding a shift!";
		} else if  ( selectedDay < 0){
			errorAddShift += "Day needs to be selected before adding a shift!";
		} else {
			// verifies that the user has entered digits between 0 and 23 in the hours box and 0 to 60 in the minutes box
			errorAddShift += checkTimeConditions();
		}
		
		// handle time written by the user
		// the date is constant and not very important as we use the day specified by the user in a given week
		// only matters that it always the same date, only the time varies.
		if (errorAddShift.trim().length() == 0){
			
			int startHoursValue = 0;
			int startMinsValue = 0;
			int endHoursValue = 0;
			int endMinsValue = 0;
			
			startHoursValue = Integer.parseInt(startHoursShiftTextBox.getText());
			startMinsValue = Integer.parseInt(startMinsTextField.getText());
			endHoursValue = Integer.parseInt(endHoursShiftText.getText());
			endMinsValue = Integer.parseInt(endMinsShiftText.getText());
			
			// in order not to use the deprecated method
			Calendar c = Calendar.getInstance();
			c.set(2016, Calendar.MAY, 22, startHoursValue, startMinsValue, 0);
			Time startTime = new Time(c.getTimeInMillis());
			c.set(2016, Calendar.MAY, 22, endHoursValue, endMinsValue, 0);
			Time endTime = new Time(c.getTimeInMillis());
			
			Day day = DayMap.getDayFromNumber(selectedDay+1);
			
			// initialize controller
			FoodTruckManagementController ftmc = new FoodTruckManagementController();
			
			try {
				ftmc.createShift(staffs.get(selectedStaffShift), startTime, endTime, day);
			} catch (InvalidInputException e) {
				errorAddShift += e.getMessage();
			}
		
		}
		// refresh visuals
		refreshData();
		
	}
	
	private void removeShiftButtonActionPerformed( java.awt.event.ActionEvent evt){
		
		errorRemovalShift = "";
		if (selectedShiftRemoval < 0){
			errorRemovalShift = "Shift needs to be selected for removal!";
			errorRemovalShift = errorRemovalShift.trim();
		}
		if ( errorRemovalShift.length() == 0) {
			FoodTruckManagementController ftmc = new FoodTruckManagementController();
			
			try {
				ftmc.deleteShift(shifts.get(selectedShiftRemoval));
			} catch (InvalidInputException e) {
				errorRemovalShift += e.getMessage();
			}
		}
		// update visuals
		refreshData();
	}

	private void addScheduleActionPerformed ( java.awt.event.ActionEvent evt){
		
		errorAddSchedule = "";
		
		// check years
		String year = yearScheduleTextField.getText();
		if ( year.length() != 4){
			errorAddSchedule += "Year in the format YYYY";
		}
		if (errorAddSchedule.length() == 0){
			for ( int i = 0; i < 4; i++){
				if (!(year.charAt(i) >= '0' && year.charAt(i) <= '9')){
					errorAddSchedule += "Year should consider only of numerical values";
				}
			}
		
			int yearInt = Integer.parseInt(year);
			// check months
			String month = monthScheduleLabel.getText();
			
			if ( month.length() != 1 || month.length() != 2){
				errorAddSchedule += "month in the format mm";
			}
			if (errorAddSchedule.length() == 0){
				for ( int i = 0; i < month.length(); i++){
					if (!(month.charAt(i) >= '0' && month.charAt(i) <= '9')){
						errorAddSchedule += "Month should consider only of numerical values";
					}
				}
			
				int monthInt = Integer.parseInt(month);
				
				// check days
				String day = dayScheduleLabel.getText();
				
				if ( day.length() != 1 || day.length() != 2){
					errorAddSchedule += "Day in the format dd";
				}
				if (errorAddSchedule.length() == 0){
					for ( int i = 0; i < day.length(); i++){
						if (!(day.charAt(i) >= '0' && day.charAt(i) <= '9')){
							errorAddSchedule += "Day should consider only of numerical values";
						}
					}
				
					int dayInt = Integer.parseInt(day);
					
					Calendar c = Calendar.getInstance();
					
					c.set(yearInt, monthInt, dayInt);
					
					Date date = new Date(c.getTimeInMillis());
					// initialize controller
					FoodTruckManagementController ftmc = new FoodTruckManagementController();
					
					try {
						ftmc.createSchedule(date);
					} catch (InvalidInputException e) {
						errorAddSchedule += e.getMessage();
					}
				}
			}
		}
		
		refreshData();
		
	}
	
	private String checkTimeConditions(){
		String errors = "";
		
		String startHours = startHoursShiftTextBox.getText();
		String startMins = startMinsTextField.getText();
		String endHours = endHoursShiftText.getText();
		String endMins = endMinsShiftText.getText();
		
		if ( (startHours.trim().length() > 2 || startHours.trim().length() < 1) || (startMins.trim().length() > 2 || startMins.trim().length() < 1) 
				|| (endHours.trim().length() > 2 || endHours.trim().length() < 1) || (endMins.trim().length() > 2 || endMins.trim().length() < 1)){
			errors += "Enter time in the following format -> hh:mm!";
		} else {
		
				/*// hours first digit can only be 0-2 , mins first digit can only be 0-5
				if (!((startHours.charAt(0) >= 48 && startHours.charAt(0) <= 50)
						&& (startMins.charAt(0) >= 48 && startMins.charAt(0) <= 53) 
						&& (endHours.charAt(0) >= 48 && endHours.charAt(0) <= 50)
						&& (endMins.charAt(0) >= 48 && endMins.charAt(0) <= 53))){
					errors += " 0 Times can only be numerical values!, hours between 0 and 23, mins between 0 and 59";
				}
				// hours second digit between 0 and 3 , mins second digit between 0 and 9
				else if ( startHours.length() == 2 && (!( startHours.charAt(1) >= 48 && startHours.charAt(1) <= 57))){
					errors += " 1 Times can only be numerical values!, hours between 0 and 23, mins between 0 and 59";
				} 
				else if ( startMins.length() == 2 && (!( startMins.charAt(1) >= 48 && startMins.charAt(1) <= 57))){
					errors += " 2 Times can only be numerical values!, hours between 0 and 23, mins between 0 and 59";
				}
				else if ( endHours.length() == 2 && (!( endHours.charAt(1) >= 48 && endHours.charAt(1) <= 57))){
					errors += " 3 Times can only be numerical values!, hours between 0 and 23, mins between 0 and 59";
				} 
				else if ( endMins.length() == 2 && (!( endMins.charAt(1) >= 48 && endMins.charAt(1) <= 57))){
					errors += " 4 Times can only be numerical values!, hours between 0 and 23, mins between 0 and 59";
				} */
				
			
		}
		
			// if still no errors, check that the values entered are  between 0 and 23 and 0 and 59
		if ( errors.trim().length() == 0) {
			int startHoursValue = 0;
			int startMinsValue = 0;
			int endHoursValue = 0;
			int endMinsValue = 0;
			
			startHoursValue = Integer.parseInt(startHours);
			startMinsValue = Integer.parseInt(startMins);
			endHoursValue = Integer.parseInt(endHours);
			endMinsValue = Integer.parseInt(endMins);
			
			if ( startHoursValue > 23 || endHoursValue > 23){
				errors += " Hours should be between 0 and 23!";
			}
			if ( startMinsValue > 59 || endMinsValue > 59){
				errors += " Mins should be between 0 and 59!";
			}
		}
		return errors;
	}
}
