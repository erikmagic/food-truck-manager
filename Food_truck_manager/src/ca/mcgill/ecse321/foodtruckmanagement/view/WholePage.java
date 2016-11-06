package ca.mcgill.ecse321.foodtruckmanagement.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import ca.mcgill.ecse321.foodtruckmanagement.controller.FoodTruckManagementController;
import ca.mcgill.ecse321.foodtruckmanagement.controller.InvalidInputException;
import ca.mcgill.ecse321.foodtruckmanagement.model.*;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.List;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WholePage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6005169480932163746L;
	private JPanel contentPane;
	private JTextField staffNameTextField;
	private JTextField staffRoleTextField;
	private String errorStaff = "";
	private JLabel errorLabel;
	private JLabel staffRoletextLabel;
	JLabel staffNameTextLabel;
	private JComboBox removeStaffComboBox;
	JButton removeStaffButton ;
	
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
		
		JButton btnNewButton = new JButton("Add Staff");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setFont(new Font("Yu Gothic", Font.BOLD, 13));
		btnNewButton.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				addStaffButtonActionPerformed(evt);
			}
		});
		btnNewButton.setBounds(31, 71, 115, 23);
		contentPane.add(btnNewButton);
		
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
		errorLabel.setVerticalAlignment(SwingConstants.TOP);
		errorLabel.setToolTipText("");
		errorLabel.setLabelFor(contentPane);
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(10, 105, 159, 48);
		contentPane.add(errorLabel);
		
		staffNameTextLabel = new JLabel("Name:");
		staffNameTextLabel.setBounds(10, 14, 46, 14);
		contentPane.add(staffNameTextLabel);
		
		staffRoletextLabel = new JLabel("Role:");
		staffRoletextLabel.setBounds(8, 43, 46, 14);
		contentPane.add(staffRoletextLabel);
		
		removeStaffComboBox = new JComboBox(showAllStaff());
		removeStaffComboBox.setToolTipText("");
		removeStaffComboBox.setBounds(10, 180, 140, 20);
		contentPane.add(removeStaffComboBox);
		
		removeStaffButton = new JButton("Remove Staff");
		removeStaffButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		removeStaffButton.setBounds(31, 211, 115, 23);
		contentPane.add(removeStaffButton);
	}
	
	private void refreshData()
	{
		// error
		errorLabel.setText("<html>" +errorStaff + "</html>"); // html tags make sure the text is displayed as 2 lines if needed
		// staff
		staffNameTextField.setText("");
		staffRoleTextField.setText("");
		
		// size of the windows changes if error
		// pack();
	}
	private void addStaffButtonActionPerformed(java.awt.event.ActionEvent evt)
	{
		FoodTruckManagementController ftmc = new FoodTruckManagementController();
		
		try {
			ftmc.createStaff(staffNameTextField.getText(), staffRoleTextField.getText());
		} catch (InvalidInputException e) {
			//  Auto-generated catch block
			errorStaff = e.getMessage();
		}
		// update visuals
		refreshData();

	}
	private void removeStaffButtonActionPerformed(java.awt.event.ActionEvent evt){
		FoodTruckManagementController ftmc = new 
	}
	private String[] showAllStaff(){
		FoodTruckManager ftm = FoodTruckManager.getInstance();
		String[] staffArrayNames = new String[ftm.getStaff().size()];
		for (int i = 0; i < ftm.getStaff().size(); i++){
			staffArrayNames[i] = ftm.getStaff(i).getName();
		}
		return staffArrayNames;
	}
}
