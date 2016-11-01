package ca.mcgill.ecse321.foodtruckmanagement.view;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import ca.mcgill.ecse321.foodtruckmanagement.controller.FoodTruckManagementController;
import ca.mcgill.ecse321.foodtruckmanagement.controller.InvalidInputException;

public class FoodTruckManagerPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8862633160814339919L;

	
	// UI elements
	private JLabel errorMessage;
	private JTextField staffNameTextField;
	private JTextField staffRoleTextField;
	private JLabel staffNameLabel;
	private JLabel staffRoleLabel;
	private JButton addStaffButton;
	
	private String error = null;
	/**
	 * creates new form Page
	 */
	public FoodTruckManagerPage()
	{
		initComponents();
		refreshData();
	}
	
	/**
	 * called in the constructor to initialize
	 * the graphical components
	 */
	public void initComponents()
	{
		// elements for error messagee
		errorMessage = new JLabel();
		errorMessage.setForeground(Color.RED);
		
		// elements for staff
		staffNameTextField = new JTextField();
		staffRoleTextField = new JTextField();
		staffNameLabel = new JLabel();
		staffRoleLabel = new JLabel();
		addStaffButton = new JButton();
		
		// global settings and listeners
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setTitle("Food Truck Manager");
		
		// text besides the boxes
		staffNameLabel.setText("Name:");
		staffRoleLabel.setText("Role:");
		addStaffButton.setText("Add Staff");
		// add the listener for adding a staff
		addStaffButton.addActionListener(new java.awt.event.ActionListener()
				{
					public void actionPerformed(java.awt.event.ActionEvent evt)
					{
						addStaffButtonActionPerformed(evt);
					}
				}
			);
		// layout 
		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(
				layout.createParallelGroup()
				.addComponent(errorMessage)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup()
							.addComponent(staffNameLabel)
							.addComponent(staffRoleLabel)
							)
					.addGroup(layout.createParallelGroup()
							.addComponent(staffNameTextField, 200, 200, 400)
							.addComponent(staffRoleTextField, 200, 200, 400)
							.addComponent(addStaffButton)
							)
					)
				);
		layout.linkSize(SwingConstants.HORIZONTAL, new java.awt.Component[] 
				{
					addStaffButton, staffNameTextField, staffRoleTextField
		});
		layout.setVerticalGroup(
				layout.createSequentialGroup()
				.addComponent(errorMessage)
				.addGroup(layout.createParallelGroup()
						.addComponent(staffNameLabel)
						.addComponent(staffNameTextField, 20, 20, 40)
						)
				.addGroup(layout.createParallelGroup()
						.addComponent(staffRoleLabel)
						.addComponent(staffRoleTextField, 20, 20, 40)
						
						)
				.addComponent(addStaffButton)
				
				);
		pack();
	}
	
	/**
	 * refreshes the text boxes by clearing them
	 */
	private void refreshData()
	{
		// error
		errorMessage.setText(error);
		// staff
		staffNameTextField.setText("");
		staffRoleTextField.setText("");
		
		// size of the windows changes if error
		pack();
	}
	private void addStaffButtonActionPerformed(java.awt.event.ActionEvent evt)
	{
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		try {
			ftmc.createStaff(staffNameTextField.getText(), staffRoleTextField.getText());
		} catch (InvalidInputException e) {
			//  Auto-generated catch block
			error = e.getMessage();
		}
		// update visuals
		refreshData();

	}
}
