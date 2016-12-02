package ca.mcgill.ecse321.foodtruckmanagement.view;

import javax.swing.JFrame;

import java.lang.Object.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import static java.lang.String.*;


import ca.mcgill.ecse321.foodtruckmanagement.controller.Day;
import ca.mcgill.ecse321.foodtruckmanagement.controller.DayMap;
import ca.mcgill.ecse321.foodtruckmanagement.controller.FoodTruckManagementController;
import ca.mcgill.ecse321.foodtruckmanagement.controller.InvalidInputException;
import ca.mcgill.ecse321.foodtruckmanagement.model.*;

import javax.swing.ComboBoxEditor;
import javax.swing.JButton;
import java.util.Calendar;
import java.awt.Font;
import java.awt.List;
import java.awt.Color;

import javax.swing.JOptionPane;
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

import javax.swing.JRadioButton;

import java.awt.Dimension;

import javax.swing.JTextPane;
import javax.swing.JSpinner;


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
	private HashMap<Integer, Ingredient> ingredients;
	private HashMap<Integer, Equipment> equipments;
	private String errorRemoveStaff = "";
	private String errorAddShift = "";
	private int selectedDay = -1;
	
	
	private String errorAddSupply = "";
	private String errorRemoveSupply = "";
	private String errorAddItem = "";
	private String errorRemoveItem = "";;
	
	
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
	
	
	
	private JComboBox<String> ItemNameComboBox;
	
	private JSeparator shiftScheduleSeperator;
	private JLabel addScheduleError;
	private JLabel addShiftScheduleError;
	private JLabel removeShiftScheduleError;
	private JLabel removeScheduleError;
	
	private String errorAddSchedule;
	private String errorAddShiftSchedule;
	private String errorRemoveShiftSchedule;
	private String errorRemoveSchedule;
	private JRadioButton SupplyRadioButton;
	private JRadioButton EquipmentRadioButton;
	private JLabel lblHireNewEmployee;
	private JLabel lblFireEmployee;
	private JLabel lblCreateNewShift;
	private JLabel lblRemoveShift;
	private JLabel lblShift;
	private JLabel label_5;
	private JLabel label_6;
	private JTextField monthScheduleTextField;
	private JTextField dayScheduleTextField;
	private JButton addScheduleButton;
	private JLabel label_23;
	private JLabel label_24;
	private JComboBox<String> selectScheduleToAddShift;
	private JLabel label_25;
	private JButton addShiftToScheduleButton;
	private JLabel label_26;
	private JLabel label_27;
	private JComboBox<String> removeShiftFromScheduleComboBox;
	private JComboBox<String> selectScheduleToRemoveShift;
	private JLabel label_28;
	private JButton removeShiftFromScheduleButton;
	private JLabel label_7;
	private JLabel label_8;
	private JComboBox<String> comboBox_8;
	private JButton removeScheduleButton;
	private JLabel label_29;
	private JLabel label_30;
	private JComboBox<String> removeScheduleComboBox;
	private JButton DisplayScheduleButton;
	private JLabel label_31;
	private JTextField newSupplyNameTextField;
	private JLabel lblItemName;
	private JLabel newSupplyQuantityLabel;
	private JSpinner newSupplyQuantitySpinner;
	private JTextField newSupplyPurchaseDateTextField;
	private JRadioButton newIngridientRadioButton;
	private JRadioButton newEquipmentRadioButton;
	private JButton addNewSupplybutton;
	private JLabel removeSupplyLabel;
	private JLabel label_12;
	private JButton removeSupplyButton;
	private JComboBox<String> removeSupplyspinner;
	private JLabel label_13;
	private JLabel lblAddNewSupply;
	private JLabel label;
	private JTextField addMenuItemNameTextField;
	private JLabel label_1;
	private JLabel label_3;
	private JButton addItemMenuButton;
	private JLabel DeletMenuLabel;
	private JLabel label_9;
	private JButton deleteItemMenuButton;
	private JComboBox<String> deleteMenuItemcomboBox;
	private JLabel addIngridientslabel;
	private JComboBox<String> addIngridientItemNamecomboBox;
	private JLabel label_15;
	private JLabel lblIngredientName;
	private JComboBox<String> addIngridientNamecomboBoxcomboBox;
	private JButton addIngridientsButton;
	private JLabel lblRemoveIngredient;
	private JComboBox<String> itemNameRemoveIngridcomboBox;
	private JLabel ItemNameRemoveIngridientLabel;
	private JComboBox<String> IngridientNameRemoveIngridcomboBox;
	private JLabel IngridientNameRemoveIngridientLabel;
	private JButton removeIngridientButton;
	private JSpinner addMenuItemPriceSpinner;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JComboBox<String> addShiftToScheduleComboBox;
	private JTextField yearScheduleTextField;
	private JLabel monthScheduleLabel;
	private JLabel dayScheduleLabel;
	private JButton PlaceAndPrintOrderButton;
	private JButton addItemCreateOrderButton;
	private JLabel createOrderItemNamelabel;
	private JLabel label_21;
	private JComboBox<String> createOrderItemNamecomboBox;
	private JSeparator separator_3;
	private JTextField endDateGenerateReportTextField;
	private JLabel salesReportEndDatelabel;
	private JTextField startDateGenerateReportTextField;
	private JLabel salesReportStartDatelabel;
	private JButton btnGenerateReportButton;
	private JLabel lblGenertateSalesReport;
	
	
	private boolean ItemPlacedonOrder=false;
	
	
	/**
	 * Create the frame.
	 */
	public WholePage() {
	
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 803);
		yearScheduleLabel = new JPanel();
		yearScheduleLabel.setPreferredSize(new Dimension(21, 21));
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
		addStaffButton.setBounds(10, 101, 140, 23);
		yearScheduleLabel.add(addStaffButton);
		
		staffNameTextField = new JTextField();
		staffNameTextField.setToolTipText("Name");
		staffNameTextField.setBounds(64, 35, 86, 20);
		yearScheduleLabel.add(staffNameTextField);
		staffNameTextField.setColumns(10);
		
		staffRoleTextField = new JTextField();
		staffRoleTextField.setToolTipText("Role");
		staffRoleTextField.setBounds(64, 68, 86, 20);
		yearScheduleLabel.add(staffRoleTextField);
		staffRoleTextField.setColumns(10);
		
		staffNameTextLabel = new JLabel("Name:");
		staffNameTextLabel.setBounds(10, 45, 46, 14);
		yearScheduleLabel.add(staffNameTextLabel);
		
		staffRoletextLabel = new JLabel("Role:");
		staffRoletextLabel.setBounds(10, 74, 46, 14);
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
		removeStaffComboBox.setBounds(10, 157, 140, 20);
		yearScheduleLabel.add(removeStaffComboBox);
		
		removeStaffButton = new JButton("Remove Staff");
		removeStaffButton.setBackground(Color.LIGHT_GRAY);
		removeStaffButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		removeStaffButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				removeStaffButtonActionPerformed(evt);
			}
		});
		removeStaffButton.setBounds(10, 190, 140, 23);
		yearScheduleLabel.add(removeStaffButton);
		
		// ADD SHIFT COMBO BOX
		addShiftComboBox = new JComboBox<String>();
		addShiftComboBox.setToolTipText("");
		addShiftComboBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed ( java.awt.event.ActionEvent evt) {
				JComboBox<String> cb = (JComboBox<String>) evt.getSource();
				selectedStaffShift = cb.getSelectedIndex();
			}
		});
		addShiftComboBox.setBounds(267, 39, 116, 20);
		yearScheduleLabel.add(addShiftComboBox);
		
		staffShiftText = new JLabel("Staff:");
		staffShiftText.setBounds(209, 43, 46, 16);
		yearScheduleLabel.add(staffShiftText);
		
		startTimeText = new JLabel("Start Time:");
		startTimeText.setBounds(209, 70, 71, 16);
		yearScheduleLabel.add(startTimeText);
		
		doubleColonStartTime = new JLabel(":");
		doubleColonStartTime.setFont(new Font("Dialog", Font.BOLD, 15));
		doubleColonStartTime.setEnabled(true);
		doubleColonStartTime.setBounds(330, 69, 15, 16);
		yearScheduleLabel.add(doubleColonStartTime);
		
		startMinsTextField = new JTextField();
		startMinsTextField.setColumns(10);
		startMinsTextField.setBounds(338, 67, 31, 22);
		yearScheduleLabel.add(startMinsTextField);
		
		shiftEndTimeLAbel = new JLabel("End Time:");
		shiftEndTimeLAbel.setBounds(209, 104, 71, 16);
		yearScheduleLabel.add(shiftEndTimeLAbel);
		
		doubleColonEndTime = new JLabel(":");
		doubleColonEndTime.setFont(new Font("Dialog", Font.BOLD, 15));
		doubleColonEndTime.setEnabled(true);
		doubleColonEndTime.setBounds(330, 103, 15, 16);
		yearScheduleLabel.add(doubleColonEndTime);
		
		endMinsShiftText = new JTextField();
		endMinsShiftText.setColumns(10);
		endMinsShiftText.setBounds(338, 101, 31, 22);
		yearScheduleLabel.add(endMinsShiftText);
		
		shiftStaffSeparator = new JSeparator();
		shiftStaffSeparator.setOrientation(SwingConstants.VERTICAL);
		shiftStaffSeparator.setBounds(184, 14, 13, 275);
		yearScheduleLabel.add(shiftStaffSeparator);
		
		addShiftDay = new JLabel("Shift Day:");
		addShiftDay.setBounds(209, 144, 56, 16);
		yearScheduleLabel.add(addShiftDay);
		
		// day of the week combo box
		dayOfTheWeekBox = 	new JComboBox<String>();
		dayOfTheWeekBox.setToolTipText("");
		dayOfTheWeekBox.setBounds(275, 140, 109, 20);
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
		addShiftbtn.setBounds(231, 172, 164, 23);
		addShiftbtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addShiftButtonActionPerformed(evt);
			}
		});
		yearScheduleLabel.add(addShiftbtn);
		
		
		// remove shift combo box
		removeShiftComboBox = new JComboBox<String>();
		removeShiftComboBox.setToolTipText("Shifts");
		removeShiftComboBox.setBounds(275, 233, 116, 20);
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
		removeShift.setBounds(209, 266, 186, 23);
		yearScheduleLabel.add(removeShift);
		
		shiftScheduleSeperator = new JSeparator();
		shiftScheduleSeperator.setOrientation(SwingConstants.VERTICAL);
		shiftScheduleSeperator.setBounds(407, 11, 13, 275);
		yearScheduleLabel.add(shiftScheduleSeperator);
		
		addScheduleError = new JLabel("");
		addScheduleError.setBounds(645, 13, 6, 145);
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
		
		lblHireNewEmployee = new JLabel("Hire New Employee");
		lblHireNewEmployee.setBounds(22, 11, 120, 14);
		yearScheduleLabel.add(lblHireNewEmployee);
		
		lblFireEmployee = new JLabel("Fire Employee");
		lblFireEmployee.setBounds(20, 130, 120, 14);
		yearScheduleLabel.add(lblFireEmployee);
		
		errorRemoveStaffLabel = new JLabel("");
		errorRemoveStaffLabel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		errorRemoveStaffLabel.setForeground(Color.RED);
		errorRemoveStaffLabel.setBounds(162, 173, 164, 52);
		yearScheduleLabel.add(errorRemoveStaffLabel);
		
		errorLabel = new JLabel("");
		errorLabel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		errorLabel.setVerticalAlignment(SwingConstants.TOP);
		errorLabel.setToolTipText("");
		errorLabel.setLabelFor(yearScheduleLabel);
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(161, 76, 140, 48);
		yearScheduleLabel.add(errorLabel);
		
		lblCreateNewShift = new JLabel("Create New Shift");
		lblCreateNewShift.setBounds(230, 11, 120, 14);
		yearScheduleLabel.add(lblCreateNewShift);
		
		endHoursShiftText = new JTextField();
		endHoursShiftText.setColumns(10);
		endHoursShiftText.setBounds(295, 101, 31, 22);
		yearScheduleLabel.add(endHoursShiftText);
		
		startHoursShiftTextBox = new JTextField();
		startHoursShiftTextBox.setBounds(295, 67, 31, 22);
		yearScheduleLabel.add(startHoursShiftTextBox);
		startHoursShiftTextBox.setColumns(10);
		
		lblRemoveShift = new JLabel("Remove Shift");
		lblRemoveShift.setBounds(259, 208, 86, 14);
		yearScheduleLabel.add(lblRemoveShift);
		
		lblShift = new JLabel("Shift:");
		lblShift.setBounds(219, 235, 46, 16);
		yearScheduleLabel.add(lblShift);
		
		label_5 = new JLabel("Create New Schedule");
		label_5.setBounds(8, 315, 140, 14);
		yearScheduleLabel.add(label_5);
		
		label_6 = new JLabel("Year:");
		label_6.setBounds(9, 345, 56, 16);
		yearScheduleLabel.add(label_6);
		
		monthScheduleTextField = new JTextField();
		monthScheduleTextField.setColumns(10);
		monthScheduleTextField.setBounds(77, 375, 99, 22);
		yearScheduleLabel.add(monthScheduleTextField);
		
		dayScheduleTextField = new JTextField();
		dayScheduleTextField.setColumns(10);
		dayScheduleTextField.setBounds(77, 409, 99, 22);
		yearScheduleLabel.add(dayScheduleTextField);
		
		addScheduleButton = new JButton("Add Schedule");
		addScheduleButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		addScheduleButton.setBackground(Color.LIGHT_GRAY);
		addScheduleButton.setBounds(9, 449, 164, 23);
		yearScheduleLabel.add(addScheduleButton);
		
		label_23 = new JLabel("Add Shift to Schedule");
		label_23.setBounds(33, 479, 140, 14);
		yearScheduleLabel.add(label_23);
		
		label_24 = new JLabel("Schedule:");
		label_24.setBounds(11, 511, 76, 16);
		yearScheduleLabel.add(label_24);
		
		selectScheduleToAddShift = new JComboBox<String>();
		selectScheduleToAddShift.setToolTipText("Shifts");
		selectScheduleToAddShift.setBounds(77, 509, 99, 20);
		yearScheduleLabel.add(selectScheduleToAddShift);
		
		label_25 = new JLabel("Shift:");
		label_25.setBounds(11, 544, 76, 16);
		yearScheduleLabel.add(label_25);
		
		addShiftToScheduleButton = new JButton("Add Shift Schedule");
		addShiftToScheduleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		addShiftToScheduleButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		addShiftToScheduleButton.setBackground(Color.LIGHT_GRAY);
		addShiftToScheduleButton.setBounds(11, 578, 165, 23);
		yearScheduleLabel.add(addShiftToScheduleButton);
		
		label_26 = new JLabel("Remove Shift from Schedule");
		label_26.setBounds(10, 614, 174, 14);
		yearScheduleLabel.add(label_26);
		
		label_27 = new JLabel("Schedule:");
		label_27.setBounds(8, 647, 76, 16);
		yearScheduleLabel.add(label_27);
		
		removeShiftFromScheduleComboBox = new JComboBox<String>();
		removeShiftFromScheduleComboBox.setToolTipText("Shifts");
		removeShiftFromScheduleComboBox.setBounds(81, 676, 95, 20);
		yearScheduleLabel.add(removeShiftFromScheduleComboBox);
		
		selectScheduleToRemoveShift = new JComboBox<String>();
		selectScheduleToRemoveShift.setToolTipText("Shifts");
		selectScheduleToRemoveShift.setBounds(79, 647, 97, 20);
		yearScheduleLabel.add(selectScheduleToRemoveShift);
		
		label_28 = new JLabel("Shift:");
		label_28.setBounds(11, 681, 76, 16);
		yearScheduleLabel.add(label_28);
		
		removeShiftFromScheduleButton = new JButton("Remove Shift Schedule");
		removeShiftFromScheduleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		removeShiftFromScheduleButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 10));
		removeShiftFromScheduleButton.setBackground(Color.LIGHT_GRAY);
		removeShiftFromScheduleButton.setBounds(12, 710, 161, 23);
		yearScheduleLabel.add(removeShiftFromScheduleButton);
		
		label_7 = new JLabel("Remove Schedule");
		label_7.setBounds(246, 315, 132, 14);
		yearScheduleLabel.add(label_7);
		
		label_8 = new JLabel("Schedule:");
		label_8.setBounds(209, 345, 76, 16);
		yearScheduleLabel.add(label_8);
		
		comboBox_8 = new JComboBox<String>();
		comboBox_8.setToolTipText("Shifts");
		comboBox_8.setBounds(295, 343, 99, 20);
		yearScheduleLabel.add(comboBox_8);
		
		removeScheduleButton = new JButton("Remove Schedule");
		removeScheduleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		removeScheduleButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		removeScheduleButton.setBackground(Color.LIGHT_GRAY);
		removeScheduleButton.setBounds(209, 373, 186, 23);
		yearScheduleLabel.add(removeScheduleButton);
		
		label_29 = new JLabel("Display Schedule");
		label_29.setBounds(253, 419, 116, 14);
		yearScheduleLabel.add(label_29);
		
		label_30 = new JLabel("Schedule:");
		label_30.setBounds(209, 449, 76, 16);
		yearScheduleLabel.add(label_30);
		
		removeScheduleComboBox = new JComboBox<String>();
		removeScheduleComboBox.setToolTipText("Shifts");
		removeScheduleComboBox.setBounds(296, 447, 99, 20);
		yearScheduleLabel.add(removeScheduleComboBox);
		
		DisplayScheduleButton = new JButton("Display Schedule");
		DisplayScheduleButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		DisplayScheduleButton.setBackground(Color.LIGHT_GRAY);
		DisplayScheduleButton.setBounds(209, 473, 186, 23);
		yearScheduleLabel.add(DisplayScheduleButton);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(184, 311, 13, 422);
		yearScheduleLabel.add(separator);
		
		label_31 = new JLabel("________________________________________________________________________________________");
		label_31.setBounds(0, 288, 620, 16);
		yearScheduleLabel.add(label_31);
		
		//Supply Name Text field
		newSupplyNameTextField = new JTextField();
		newSupplyNameTextField.setColumns(10);
		newSupplyNameTextField.setBounds(517, 41, 86, 22);
		yearScheduleLabel.add(newSupplyNameTextField);
		
		newSupplyQuantityLabel = new JLabel("Quantity:");
		newSupplyQuantityLabel.setBounds(428, 70, 56, 14);
		yearScheduleLabel.add(newSupplyQuantityLabel);
		
		
		//Supply Quantity Spinner
		newSupplyQuantitySpinner = new JSpinner();
		newSupplyQuantitySpinner.setBounds(573, 67, 30, 22);
		yearScheduleLabel.add(newSupplyQuantitySpinner);
		
		newSupplyPurchaseDateTextField = new JTextField();
		newSupplyPurchaseDateTextField.setText("yyyy-mm-dd");
		newSupplyPurchaseDateTextField.setColumns(10);
		newSupplyPurchaseDateTextField.setBounds(516, 88, 86, 22);
		yearScheduleLabel.add(newSupplyPurchaseDateTextField);
		
		//New Ingridient Radio Button
		newIngridientRadioButton = new JRadioButton("Ingr.");
		newIngridientRadioButton.setBounds(426, 115, 71, 25);
		yearScheduleLabel.add(newIngridientRadioButton);
		
		//New Equipment Radio Button
		newEquipmentRadioButton = new JRadioButton("Equipment");
		newEquipmentRadioButton.setBounds(503, 115, 99, 25);
		yearScheduleLabel.add(newEquipmentRadioButton);
		
		//Add new Supply Button
		addNewSupplybutton = new JButton("Add Supply");
		addNewSupplybutton.setBackground(Color.LIGHT_GRAY);
		addNewSupplybutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewSupplybuttonActionPerformed(e);				
			}
		});
		addNewSupplybutton.setBounds(451, 140, 134, 25);
		yearScheduleLabel.add(addNewSupplybutton);
		
		removeSupplyLabel = new JLabel("Remove Supply");
		removeSupplyLabel.setBounds(465, 194, 97, 14);
		yearScheduleLabel.add(removeSupplyLabel);
		
		label_12 = new JLabel("Item Name:");
		label_12.setBounds(428, 220, 69, 14);
		yearScheduleLabel.add(label_12);
		
		//Remove a supply Button
		removeSupplyButton = new JButton("Remove Supply");
		removeSupplyButton.setBackground(Color.LIGHT_GRAY);
		removeSupplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeSupplyButtonActionPerformed(e);
			}
		});
		removeSupplyButton.setBounds(453, 251, 132, 25);
		yearScheduleLabel.add(removeSupplyButton);
		
		//Remove Supply spinner
		removeSupplyspinner = new JComboBox<String>();
		removeSupplyspinner.setBounds(503, 216, 100, 22);
		yearScheduleLabel.add(removeSupplyspinner);
		
		
		label_13 = new JLabel("Purchase Date:");
		label_13.setBounds(428, 92, 89, 14);
		yearScheduleLabel.add(label_13);
		
		lblAddNewSupply = new JLabel("Add New Supply");
		lblAddNewSupply.setBounds(451, 14, 120, 14);
		yearScheduleLabel.add(lblAddNewSupply);
		
		errorAddShiftLabel = new JLabel("");
		errorAddShiftLabel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		errorAddShiftLabel.setForeground(Color.RED);
		errorAddShiftLabel.setBounds(416, 114, 155, 81);
		yearScheduleLabel.add(errorAddShiftLabel);
		
		errorRemoveShift = new JLabel("");
		errorRemoveShift.setForeground(Color.RED);
		errorRemoveShift.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		errorRemoveShift.setBounds(407, 245, 164, 52);
		yearScheduleLabel.add(errorRemoveShift);
		
		label = new JLabel("Add new Menu Item");
		label.setBounds(457, 315, 120, 14);
		yearScheduleLabel.add(label);
		
		//Add Menu to Item Text Field
		addMenuItemNameTextField = new JTextField();
		addMenuItemNameTextField.setColumns(10);
		addMenuItemNameTextField.setBounds(517, 334, 86, 22);
		yearScheduleLabel.add(addMenuItemNameTextField);
		
		label_1 = new JLabel("Item Name:");
		label_1.setBounds(421, 338, 71, 14);
		yearScheduleLabel.add(label_1);
		
		label_3 = new JLabel("Item Price:");
		label_3.setBounds(417, 372, 67, 14);
		yearScheduleLabel.add(label_3);
		
		//Add an Item to Menu Button
		addItemMenuButton = new JButton("Add Item");
		addItemMenuButton.setBackground(Color.LIGHT_GRAY);
		addItemMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItemMenuButtonActionPerformed(e);				
			}
		});
		addItemMenuButton.setBounds(451, 394, 134, 25);
		yearScheduleLabel.add(addItemMenuButton);
		
		DeletMenuLabel = new JLabel("Delete a menu item");
		DeletMenuLabel.setBounds(457, 432, 120, 14);
		yearScheduleLabel.add(DeletMenuLabel);
		
		label_9 = new JLabel("Item Name:");
		label_9.setBounds(428, 452, 69, 14);
		yearScheduleLabel.add(label_9);
		
		//Delete an Item from Menu Button
		deleteItemMenuButton = new JButton("Delete Item");
		deleteItemMenuButton.setBackground(Color.LIGHT_GRAY);
		deleteItemMenuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteItemMenuButtonActionPerformed(e);
			}
		});
		deleteItemMenuButton.setBounds(451, 479, 134, 25);
		yearScheduleLabel.add(deleteItemMenuButton);
		
		deleteMenuItemcomboBox = new JComboBox<String>();
		deleteMenuItemcomboBox.setBounds(503, 448, 100, 22);
		yearScheduleLabel.add(deleteMenuItemcomboBox);
		
		addIngridientslabel = new JLabel("Add Ingredient");
		addIngridientslabel.setBounds(465, 520, 120, 14);
		yearScheduleLabel.add(addIngridientslabel);
		
		addIngridientItemNamecomboBox = new JComboBox<String>();
		addIngridientItemNamecomboBox.setBounds(532, 543, 71, 22);
		yearScheduleLabel.add(addIngridientItemNamecomboBox);
		
		label_15 = new JLabel("Item Name:");
		label_15.setBounds(436, 547, 69, 14);
		yearScheduleLabel.add(label_15);
		
		lblIngredientName = new JLabel("Ingredient Name:");
		lblIngredientName.setBounds(418, 582, 118, 14);
		yearScheduleLabel.add(lblIngredientName);
		
		addIngridientNamecomboBoxcomboBox = new JComboBox<String>();
		addIngridientNamecomboBoxcomboBox.setBounds(534, 574, 69, 22);
		yearScheduleLabel.add(addIngridientNamecomboBoxcomboBox);
		
		//Add Ingridient Button
		addIngridientsButton = new JButton("Add Ingred.");
		addIngridientsButton.setBackground(Color.LIGHT_GRAY);
		addIngridientsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addIngridientsButtonActionPerformed(e);			
			}
		});
		addIngridientsButton.setBounds(451, 605, 134, 25);
		yearScheduleLabel.add(addIngridientsButton);
		
		lblRemoveIngredient = new JLabel("Remove Ingredient");
		lblRemoveIngredient.setBounds(465, 631, 120, 14);
		yearScheduleLabel.add(lblRemoveIngredient);
		
		itemNameRemoveIngridcomboBox = new JComboBox<String>();
		itemNameRemoveIngridcomboBox.setBounds(534, 658, 69, 22);
		yearScheduleLabel.add(itemNameRemoveIngridcomboBox);
		
		ItemNameRemoveIngridientLabel = new JLabel("Item Name:");
		ItemNameRemoveIngridientLabel.setBounds(436, 670, 69, 14);
		yearScheduleLabel.add(ItemNameRemoveIngridientLabel);
		
		IngridientNameRemoveIngridcomboBox = new JComboBox<String>();
		IngridientNameRemoveIngridcomboBox.setBounds(534, 690, 70, 22);
		yearScheduleLabel.add(IngridientNameRemoveIngridcomboBox);
		
		IngridientNameRemoveIngridientLabel = new JLabel("Ingredient Name:");
		IngridientNameRemoveIngridientLabel.setBounds(426, 694, 110, 14);
		yearScheduleLabel.add(IngridientNameRemoveIngridientLabel);
		
		//Remove Ingridient Button
		removeIngridientButton = new JButton("Remove Ingred.");
		removeIngridientButton.setBackground(Color.LIGHT_GRAY);
		removeIngridientButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				removeIngridientButtonActionPerformed(e);
			}
		});
		removeIngridientButton.setBounds(451, 722, 134, 25);
		yearScheduleLabel.add(removeIngridientButton);
		
		addMenuItemPriceSpinner = new JSpinner();
		addMenuItemPriceSpinner.setBounds(573, 364, 30, 22);
		yearScheduleLabel.add(addMenuItemPriceSpinner);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(615, 14, 13, 275);
		yearScheduleLabel.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(407, 317, 13, 421);
		yearScheduleLabel.add(separator_2);
		
		
		// show all shifts
		addShiftToScheduleComboBox = new JComboBox<String>();
		addShiftToScheduleComboBox.setToolTipText("Shifts");
		addShiftToScheduleComboBox.setBounds(77, 542, 97, 20);
		yearScheduleLabel.add(addShiftToScheduleComboBox);
		
		yearScheduleTextField = new JTextField();
		yearScheduleTextField.setBounds(77, 342, 97, 22);
		yearScheduleLabel.add(yearScheduleTextField);
		yearScheduleTextField.setColumns(10);
		
		
		monthScheduleLabel = new JLabel("Month:");
		monthScheduleLabel.setBounds(10, 378, 56, 16);
		yearScheduleLabel.add(monthScheduleLabel);		
		
		
		dayScheduleLabel = new JLabel("Day:");
		dayScheduleLabel.setBounds(10, 412, 56, 16);
		yearScheduleLabel.add(dayScheduleLabel);
		
		lblItemName = new JLabel("Item Name:");
		lblItemName.setBounds(428, 47, 77, 14);
		yearScheduleLabel.add(lblItemName);
		
		PlaceAndPrintOrderButton = new JButton("Place & Print Order !!");
		PlaceAndPrintOrderButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 14));
		PlaceAndPrintOrderButton.setBackground(Color.LIGHT_GRAY);
		PlaceAndPrintOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlaceAndPrintOrderButtonActionPerformed(e);
			}
		});
		PlaceAndPrintOrderButton.setBounds(645, 374, 189, 42);
		yearScheduleLabel.add(PlaceAndPrintOrderButton);
		
		addItemCreateOrderButton = new JButton("Add Item");
		addItemCreateOrderButton.setBackground(Color.LIGHT_GRAY);
		addItemCreateOrderButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addItemCreateOrderButtonActionPerformed(e);
			}
		});
		addItemCreateOrderButton.setBounds(645, 333, 97, 25);
		yearScheduleLabel.add(addItemCreateOrderButton);
		
		createOrderItemNamelabel = new JLabel("Item Name:");
		createOrderItemNamelabel.setBounds(658, 306, 69, 14);
		yearScheduleLabel.add(createOrderItemNamelabel);
		
		label_21 = new JLabel("Create Order");
		label_21.setBounds(690, 237, 116, 52);
		yearScheduleLabel.add(label_21);
		
		createOrderItemNamecomboBox = new JComboBox<String>();
		createOrderItemNamecomboBox.setBounds(765, 307, 69, 22);
		yearScheduleLabel.add(createOrderItemNamecomboBox);
		
		separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(615, 311, 13, 427);
		yearScheduleLabel.add(separator_3);
		
		endDateGenerateReportTextField = new JTextField();
		endDateGenerateReportTextField.setText("yyyy-mm-dd");
		endDateGenerateReportTextField.setColumns(10);
		endDateGenerateReportTextField.setBounds(733, 614, 86, 22);
		yearScheduleLabel.add(endDateGenerateReportTextField);
		
		salesReportEndDatelabel = new JLabel("End Date:");
		salesReportEndDatelabel.setBounds(645, 618, 89, 14);
		yearScheduleLabel.add(salesReportEndDatelabel);
		
		startDateGenerateReportTextField = new JTextField();
		startDateGenerateReportTextField.setText("yyyy-mm-dd");
		startDateGenerateReportTextField.setColumns(10);
		startDateGenerateReportTextField.setBounds(733, 578, 86, 22);
		yearScheduleLabel.add(startDateGenerateReportTextField);
		
		salesReportStartDatelabel = new JLabel("Start Date:");
		salesReportStartDatelabel.setBounds(645, 582, 89, 14);
		yearScheduleLabel.add(salesReportStartDatelabel);
		
		btnGenerateReportButton = new JButton("Generate Report");
		btnGenerateReportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGenerateReportButtonActionPerformed(e);
			}
		});
		btnGenerateReportButton.setBackground(Color.LIGHT_GRAY);
		btnGenerateReportButton.setBounds(685, 657, 134, 25);
		yearScheduleLabel.add(btnGenerateReportButton);
		
		lblGenertateSalesReport = new JLabel("Generate Sales Report");
		lblGenertateSalesReport.setBounds(658, 526, 148, 52);
		yearScheduleLabel.add(lblGenertateSalesReport);
	
		
		// show initialData
		initialData();
	}
	
	private void initialData(){
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		
		// staffs spinner
		
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
		
		// shifts spinner
		
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
		
		
		// supplies spinner
		
		Iterator<Ingredient> ingIt = ftm.getIngredients().iterator();
		ingredients = new HashMap<Integer, Ingredient>();
		while (ingIt.hasNext()){
			// add the ingredient to the appropriate spinners
			Ingredient tempIng = ingIt.next();
			ingredients.put(index, tempIng);
			removeSupplyspinner.addItem(tempIng.getName());
			addIngridientItemNamecomboBox.addItem(tempIng.getName());
			IngridientNameRemoveIngridcomboBox.addItem(tempIng.getName());
			index++;
		}
		index=0;
		Iterator<Equipment> equipIt = ftm.getEquipment().iterator();
		equipments = new HashMap<Integer, Equipment>();
		while(equipIt.hasNext()){
			// add the equipment to the appropriate spinners
			Equipment tempEquip = equipIt.next();
			equipments.put(index, tempEquip);
			removeSupplyspinner.addItem(tempEquip.getName());
			index++;
		}
		index = 0;
		
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
			addShiftComboBox.removeAllItems();
			Iterator<Staff> sIt = ftm.getStaff().iterator();
			Integer index = 0;
			while (sIt.hasNext()){
				Staff s = sIt.next();
				staffs.put(index, s);
				removeStaffComboBox.addItem(s.getName() + " - " + s.getRole());
				addShiftComboBox.addItem(s.getName() + " - " + s.getRole());
				index++;
			}
			selectedStaff = -1;
			removeStaffComboBox.setSelectedItem(selectedStaff);
			addShiftComboBox.setSelectedItem(selectedStaffShift);
			
			staffNameTextField.setText("");
			staffRoleTextField.setText("");
			
		}
		
		// remove staff
		
		if ( errorRemoveStaff == null || errorRemoveStaff.length() == 0){
			staffs = new HashMap<Integer, Staff>();
			removeStaffComboBox.removeAllItems();
			addShiftComboBox.removeAllItems();
			Iterator<Staff> sIt = ftm.getStaff().iterator();
			Integer index = 0;
			while (sIt.hasNext()){
				Staff s = sIt.next();
				staffs.put(index, s);
				removeStaffComboBox.addItem(s.getName() + " - " + s.getRole());
				addShiftComboBox.addItem(s.getName() + " - " + s.getRole());
				index++;
			}
			selectedStaff= -1;
			removeStaffComboBox.setSelectedItem(selectedStaff);
			addShiftComboBox.setSelectedItem(selectedStaffShift);
			
			
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
		
		// add Supplies
		if (errorRemoveSupply.length() == 0){
			newIngridientRadioButton.setSelected(false);
			newEquipmentRadioButton.setSelected(false);
			newSupplyNameTextField.setText("");
			newSupplyQuantitySpinner.setValue(0);
			
			
		}
		
		// remove supply 
		
		
		
	}
	
	private void addStaffButtonActionPerformed(java.awt.event.ActionEvent evt)
	{
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		errorStaff = "";
		try {
			ftmc.createStaff(staffNameTextField.getText(), staffRoleTextField.getText());
		} catch (InvalidInputException e) {
			//  Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			//e.getMessage();
		}
		// update visuals
		refreshData();

	}
	
	
	//Add Supplies Button
	private void addNewSupplybuttonActionPerformed (java.awt.event.ActionEvent evt){
		
		errorAddSupply = "";
		String newSupplyName =""; 
		String newEquipmentName =""; 
		boolean correct_input = true;		
		int newSupplyQuantity = 0;
		int newEquipmentQuantity = 0;

		if(newSupplyNameTextField.getText().length()==0){
			JOptionPane.showMessageDialog(null, "Supply name cannot be empty!");
			errorAddSupply += "Supply name cannot be empty!";
			correct_input=false;
		} 
		if((int)newSupplyQuantitySpinner.getValue()<=0){
			JOptionPane.showMessageDialog(null, "Supply quantity cannot be 0 or less!");
			errorAddSupply += "Supply quantity cannot be 0 or less!";
			correct_input=false;
		}
		if( (newIngridientRadioButton.isSelected() && newEquipmentRadioButton.isSelected()) 
				|| (!newIngridientRadioButton.isSelected() && !newEquipmentRadioButton.isSelected()) ){

			JOptionPane.showMessageDialog(null, "Select one type of supply!");
			errorAddSupply += "Select one type of supply!";
			correct_input=false;
		}

		if(correct_input){
			FoodTruckManagementController ftmc = new FoodTruckManagementController();
			if(newIngridientRadioButton.isSelected()){
				newSupplyName = newSupplyNameTextField.getText();
				newSupplyQuantity = (int)newSupplyQuantitySpinner.getValue();
				try {
					ftmc.createIngredient(newSupplyName, newSupplyQuantity, 1);
				} catch (InvalidInputException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			} else{

				newEquipmentName = newSupplyNameTextField.getText();
				newEquipmentQuantity = (int)newSupplyQuantitySpinner.getValue();
				try {
					ftmc.createEquipment(newEquipmentName, newEquipmentQuantity, 1);
				} catch (InvalidInputException e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}		
		}	

		refreshData();		
	}
	
	//Remove a supply Button
	private void removeSupplyButtonActionPerformed(java.awt.event.ActionEvent evt){
		errorRemoveSupply = "";
		boolean correct_input = true;

		if(removeSupplyspinner.getSelectedIndex()==-1){
			JOptionPane.showMessageDialog(null, "Item name needs to be selected!");
			errorRemoveSupply += "Item name needs to be selected!";
			correct_input = false;
		}
		if(correct_input){
			//Controller connects here !
		}
		
		refreshData();
	}
	
	
	
	
	private void addItemMenuButtonActionPerformed(java.awt.event.ActionEvent evt){

		String itemName =""; 
		boolean correct_input = true;		
		int itemPrice = 0;

		if(addMenuItemNameTextField.getText().length()==0){		
			JOptionPane.showMessageDialog(null, "Item name cannot be empty");
			correct_input=false;
		} 
		if((int)addMenuItemPriceSpinner.getValue()<=0){	
			JOptionPane.showMessageDialog(null, "Item price cannot be <=0");			
			correct_input=false;
		}

		if(correct_input){
			itemName = addMenuItemNameTextField.getText();
			itemPrice = (int)addMenuItemPriceSpinner.getValue();		
			//Controller connects here !

		}	
		//update Visuals
		addMenuItemNameTextField.setText("");
		addMenuItemPriceSpinner.setValue(0);
	}
	
	
	//Delete an Item from Menu Button
	private void deleteItemMenuButtonActionPerformed(java.awt.event.ActionEvent evt){
			
		boolean correct_input = true;
		
		if(deleteMenuItemcomboBox.getSelectedIndex()==-1){	
			JOptionPane.showMessageDialog(null, "Item name needs to be selected");
			correct_input = false;
		}	
		if(correct_input){			
		//Controller connects here !
		}	
	}
	
	
	//Add Ingredient to an Item Button
	private void addIngridientsButtonActionPerformed(java.awt.event.ActionEvent evt){

		boolean correct_input = true;

		if(addIngridientItemNamecomboBox.getSelectedIndex()==-1){	
			JOptionPane.showMessageDialog(null, "Select item to add ingridients to it ");
			correct_input = false;
		}
		if(addIngridientNamecomboBoxcomboBox.getSelectedIndex()==-1){	
			JOptionPane.showMessageDialog(null, "Select Ingridient Name to be added");
			correct_input = false;
		}
		if(correct_input){			
			//Controller connects here !
		}
	}

	// Remove Ingridient from an Item Button
	private void removeIngridientButtonActionPerformed(java.awt.event.ActionEvent evt){

		boolean correct_input = true;

		if(itemNameRemoveIngridcomboBox.getSelectedIndex()==-1){	
			JOptionPane.showMessageDialog(null, "Select Item Name to remove ingridient from");
			correct_input = false;
		}	
		if(IngridientNameRemoveIngridcomboBox.getSelectedIndex()==-1){	
			JOptionPane.showMessageDialog(null, "Select Ingridient to be removed");
			correct_input = false;
		}	
		if(correct_input){			
			//Controller connects here !
		}		
	}
	
	
	//Add Item to the Order Button
private void addItemCreateOrderButtonActionPerformed(java.awt.event.ActionEvent evt){
		
	boolean correct_input = true;
	
	if(createOrderItemNamecomboBox.getSelectedIndex()==-1){	
		JOptionPane.showMessageDialog(null, "Select an Item to be added to the Order");
		correct_input = false;
	}
	
	if(correct_input){			
		
		ItemPlacedonOrder = true;
		//Controller connects here !
	
	
	}
			
	}

	//Place and Print Order Button
	private void PlaceAndPrintOrderButtonActionPerformed(java.awt.event.ActionEvent evt){

		//check if an Item has been placed on the order
		if(ItemPlacedonOrder){
			
			
		}
	
	}


	//Generate Report Button
	private void btnGenerateReportButtonActionPerformed(java.awt.event.ActionEvent evt){
	}
	

	
	private void removeStaffButtonActionPerformed( java.awt.event.ActionEvent evt ) {
		
		errorRemoveStaff = "";
		if (selectedStaff < 0){
			JOptionPane.showMessageDialog(null, "Staff needs to be selected for removal!");
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
			JOptionPane.showMessageDialog(null, "Staff needs to be selected before adding a shift!");
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
			JOptionPane.showMessageDialog(null, "Shift needs to be selected for removal!");
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
