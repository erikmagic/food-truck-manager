package ca.mcgill.ecse321.foodtruckmanagement.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import java.util.HashMap;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class WholePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6005169480932163746L;
	private JPanel contentPane;
	private JTextField staffNameTextField;
	private JTextField staffRoleTextField;
	private JLabel errorLabel;
	private JLabel errorRemoveStaffLabel;
	private JLabel staffRoletextLabel;
	private JLabel staffNameTextLabel;
	private JComboBox removeStaffComboBox;
	private JButton removeStaffButton ;
	private JButton addStaffButton;
	
	
	// data elements
	private String errorStaff = "";
	private Integer selectedStaff = -1;
	private HashMap<Integer, Staff> staffs;
	private String errorRemoveStaff = "";
	
	
	/**
	 * Create the frame.
	 */
	public WholePage() {
	

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 380);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addStaffButton = new JButton("Add Staff");
		addStaffButton.setBackground(Color.LIGHT_GRAY);
		addStaffButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		addStaffButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addStaffButtonActionPerformed(evt);
			}
		});
		addStaffButton.setBounds(10, 73, 140, 23);
		contentPane.add(addStaffButton);
		
		staffNameTextField = new JTextField();
		staffNameTextField.setToolTipText("Name");
		staffNameTextField.setBounds(64, 11, 86, 20);
		contentPane.add(staffNameTextField);
		staffNameTextField.setColumns(10);
		
		staffRoleTextField = new JTextField();
		staffRoleTextField.setToolTipText("Role");
		staffRoleTextField.setBounds(64, 40, 86, 20);
		contentPane.add(staffRoleTextField);
		staffRoleTextField.setColumns(10);
		
		errorLabel = new JLabel("");
		errorLabel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		errorLabel.setVerticalAlignment(SwingConstants.TOP);
		errorLabel.setToolTipText("");
		errorLabel.setLabelFor(contentPane);
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(162, 11, 159, 48);
		contentPane.add(errorLabel);
		
		staffNameTextLabel = new JLabel("Name:");
		staffNameTextLabel.setBounds(10, 14, 46, 14);
		contentPane.add(staffNameTextLabel);
		
		staffRoletextLabel = new JLabel("Role:");
		staffRoletextLabel.setBounds(8, 43, 46, 14);
		contentPane.add(staffRoletextLabel);
		
		
		removeStaffComboBox = new JComboBox<String>();
		// show staffs in the comboBox
		initialData();
		removeStaffComboBox.setToolTipText("");
		removeStaffComboBox.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed ( java.awt.event.ActionEvent evt) {
				JComboBox<String> cb = (JComboBox<String>) evt.getSource();
				selectedStaff = cb.getSelectedIndex();
			}
		});
		removeStaffComboBox.setBounds(10, 106, 140, 20);
		contentPane.add(removeStaffComboBox);
		
		removeStaffButton = new JButton("Remove Staff");
		removeStaffButton.setBackground(Color.LIGHT_GRAY);
		removeStaffButton.setFont(new Font("Yu Gothic UI Semilight", Font.BOLD, 13));
		removeStaffButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				removeStaffButtonActionPerformed(evt);
			}
		});
		removeStaffButton.setBounds(10, 137, 140, 23);
		contentPane.add(removeStaffButton);
		
		errorRemoveStaffLabel = new JLabel("");
		errorRemoveStaffLabel.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 13));
		errorRemoveStaffLabel.setForeground(Color.RED);
		errorRemoveStaffLabel.setBounds(157, 108, 164, 52);
		contentPane.add(errorRemoveStaffLabel);
	}
	
	private void initialData(){
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		staffs = new HashMap<Integer, Staff>();
		Iterator<Staff> sIt = ftm.getStaff().iterator();
		Integer index = 0;
		while (sIt.hasNext()){
			Staff s = sIt.next();
			staffs.put(index, s);
			removeStaffComboBox.addItem(s.getName() + " ; " + s.getRole());
			index++;
		}
		
	}
	private void refreshData()
	{	
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		// error
		errorLabel.setText("<html>" +errorStaff + "</html>"); // html tags make sure the text is displayed as 2 lines if needed
		errorRemoveStaffLabel.setText("<html>" + errorRemoveStaff + "</html");
		// staff
		if (errorStaff == null || errorStaff.length() == 0){
			
			staffs = new HashMap<Integer, Staff>();
			removeStaffComboBox.removeAllItems();
			Iterator<Staff> sIt = ftm.getStaff().iterator();
			Integer index = 0;
			while (sIt.hasNext()){
				Staff s = sIt.next();
				staffs.put(index, s);
				removeStaffComboBox.addItem(s.getName() + " ; " + s.getRole());
				index++;
			}
			selectedStaff = -1;
			removeStaffComboBox.setSelectedItem(selectedStaff);
			
			staffNameTextField.setText("");
			staffRoleTextField.setText("");
			
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
				// TODO Auto-generated catch block
				errorRemoveStaff = e.getMessage();
			}
		}
		// update visuals
		refreshData();
	}
}