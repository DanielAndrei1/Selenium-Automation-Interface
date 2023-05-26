package SeleniumUI;

import javax.swing.border.Border;

import controller.Selenium;
import net.miginfocom.swing.*;
import image.*;

import javax.swing.*;
import java.awt.*;


public class SeleniumUI {
	private String[] operatingSystemStrings ={"Windows", "Mac", "Linux"};
	private String[] chromeVersionStrings = {"109","110", "111", "112", "113", "114"};
	private String[] optionsToChoose = {"Default","Id", "Name", "Class Name", "Xpath", "Link Text"
			, "Partial Link Text"};
	

	private String[] optionsToChooseActions = {"Click", "Input text", "Move to element"};
	
	private JComboBox<String> jComboBoxOperatingSystem = new JComboBox<>(operatingSystemStrings);
	private JComboBox<String> jComboBoxChromeVersions = new JComboBox<>(chromeVersionStrings);
	private JComboBox<String> jComboBoxSearchByMethod = new JComboBox<>(optionsToChoose);
	private JComboBox<String> jComboBoxActions = new JComboBox<>(optionsToChooseActions);

	ImagePanel imagePanel = new ImagePanel();
	//Frame
	private static JFrame frame;
	
	
	//Panels
	private JPanel mainJPanel = new JPanel(new MigLayout("center", "[][][]", "[][][]"));
	 // Create a new JPanel to hold both mainJPanel and borderJPanel
	private JPanel contentPanel = new JPanel(new GridBagLayout());

	 // Create a JPanel with transparent background
	private JPanel borderJPanel = new JPanel(new GridBagLayout()) {
           @Override
           protected void paintComponent(Graphics g) {
               // Set the background color to transparent
               g.setColor(new Color(0, 0, 0, 0));
               g.fillRect(0, 0, getWidth(), getHeight());
               
               // Call the superclass's paintComponent method
               super.paintComponent(g);
           }
       };
       
       // Create a JPanel with transparent background
   	private JPanel globalVariablesJPanel = new JPanel(new MigLayout("center", "", "20[]")) {
              @Override
              protected void paintComponent(Graphics g) {
                  // Set the background color to transparent
                  g.setColor(new Color(0, 0, 0, 0));
                  g.fillRect(0, 0, getWidth(), getHeight());
                  
                  // Call the superclass's paintComponent method
                  super.paintComponent(g);
              }
          };
          
         
          
    //Grid Bag Constrains
    GridBagConstraints c = new GridBagConstraints();
    // Create a GridBagConstraints instance
    GridBagConstraints gbc = new GridBagConstraints();
    GridBagConstraints gbc2 = new GridBagConstraints();

     
    // JTextField
 	private static JTextField URL = new JTextField(16);
 	private static JTextField Findelementbytype = new JTextField(16);
 	private static JTextField addTextToField = new JTextField(16);

 	

 	public JTextField getWaitGlobalJTextField() {
		return waitGlobalVisibilityJTextField;
	}
 	
 	public JTextField getWaitActionJTextField() {
		return waitGlobalActionsJTextField;
	}
 	
 	
	//Buttons
 	private JButton addNewRule = new JButton("New Rule");
 	private JButton go = new JButton("Start Automation");
 	private JButton deleteButton = new JButton("Delete Rule");

     // Create a button to save the values
     private JButton saveButton = new JButton("Save");
     private JButton loadButton = new JButton("Load");
    
   //Labels
 	private JLabel labelURL = new JLabel("Enter a page");
 	private JLabel errorLabel = new JLabel("");
 	private JLabel selectFindBy = new JLabel("Select find by type");
 	private JLabel EnterAttribute = new JLabel("Select find by element");
 	private JLabel EnterAction = new JLabel("Select action type");
 	private JLabel inputText = new JLabel("Enter Action");
 	private JLabel chromeVersion = new JLabel("Chrome Version:");
 	private JLabel operatingSystem = new JLabel("Operating System:");
 	private JLabel enterInputJLabeL = new JLabel("Enter input");
 	
 	//Label global settings
 	private JLabel waitJLabel  = new JLabel("Increase Visibility Wait time:");
 	private JLabel waitTimeActionsJLabel  = new JLabel("Wait time betwen actions:");
 	
 	//Label global JTextFields
 	private JTextField waitGlobalVisibilityJTextField = new JTextField(8);
 	private JTextField waitGlobalActionsJTextField = new JTextField(8);

	// Colors Buttons
	//Color btnColor = new Color(152, 152, 152);
	Color btnColor = new Color(39, 190, 146);
	Color btnColorOnHover = new Color(157, 62, 29);

	//Radio Button
	private JRadioButton radioButton = new JRadioButton("Wait for page to load?");
	private JRadioButton maximiJRadioButton = new JRadioButton("Maximise?");
	private JRadioButton submitButton = new JRadioButton("Submit?");
	private JRadioButton endButtonJRadioButton = new JRadioButton("Terminate current browser window?");
	private JRadioButton closeBrowserButtonJRadioButton = new JRadioButton("Terminate all browser tabs?");
 	
 	
    //Getters and setters
    public String[] getOperatingSystemStrings() {
   		return operatingSystemStrings;
   	}

   	public String[] getOptionsToChooseMethodsFindByStrings() {
   		return optionsToChoose;
   	}

   	public String[] getOptionsToChooseActions() {
   		return optionsToChooseActions;
   	}

   	public JLabel getOperatingSystem() {
   		return operatingSystem;
   	}
    public JPanel getBorderJPanel() {
		return borderJPanel;
	}

	public void setBorderJPanel(JPanel borderJPanel) {
		this.borderJPanel = borderJPanel;
	}

	
   
	public GridBagConstraints getConstraints() {
		return c;
	}

	public void setC(GridBagConstraints c) {
		this.c = c;
	}

	public GridBagConstraints getGbc() {
		return gbc;
	}

	public void setGbc(GridBagConstraints gbc) {
		this.gbc = gbc;
	}

	
    
    public JButton getdeletButton() {
		return deleteButton;
	}
    
    public JButton getaddNewRule() {
		return addNewRule;
	}
    
	public JButton getLoadButton() {
		return loadButton;
	}


	public JButton getSaveButton() {
		return saveButton;
	}

	

	public JLabel getEnterInputJLabelRule() 
	{
		return enterInputJLabeL;
	}

 

	 
	
    public JFrame getFrame() {
    	return frame;
    }



	public JRadioButton getEndButtonJRadioButton() {
		return endButtonJRadioButton;
	}
	
	public JRadioButton getCloseBrowserButtonJRadioButton() {
		return closeBrowserButtonJRadioButton;
	}
	//Border
	Border emptyBorder = BorderFactory.createEmptyBorder();
	
	private JComboBox<String>[] comboBoxesFindby = new JComboBox[20]; // Array to store the JComboBox references
    private JComboBox<String>[] comboBoxesActionsRule = new JComboBox[20]; // Array to store the JComboBox references
    private JTextField[] JTextFieldsAtrribute = new JTextField[20];
    private JTextField[] addActionInJTextField = new JTextField[20];
	public JTextField[] getAddActionInJTextField() {
		return addActionInJTextField;
	}
	public JTextField[] getJTextFieldsAtrribute() {
		return JTextFieldsAtrribute;
	}
	public JComboBox<String>[] getcomboBoxesActionsRule() {
		return comboBoxesActionsRule;
	}
	private JRadioButton[] radioWaitTimeRadioButtons = new JRadioButton[20];
	public JRadioButton[] getRadioButtonRule() {
		return radioWaitTimeRadioButtons;
	}
	public JRadioButton[] getsubmitRadioButtonsRule() {
		return submitRadioButtonsRule;
	}
	private JRadioButton[] submitRadioButtonsRule = new JRadioButton[20];
	private JLabel rowNumberJLabel[] = new JLabel[20];
	private JPanel rowPanel[] = new JPanel[20];
	
	public JPanel[] getRowPanels() 
	{
		return rowPanel;
	}
	public JLabel[] getRowNumberJLabel() 
	{
		return rowNumberJLabel;
	}

	//Radio buttons getters
	public boolean getSubmitRadioButtonsRule(int args) {
		return submitRadioButtonsRule[args].isSelected();
	}
	public boolean getMaximizeJRadioButton() {
		return maximiJRadioButton.isSelected();
	}
	public void setMaximizeJRadioButton(Boolean argBoolean) {
		 this.maximiJRadioButton.setSelected(argBoolean);
	}
	public Boolean getRadioButtonRules(int arg) {
		return radioWaitTimeRadioButtons[arg].isSelected();
	}
	
	

	public Boolean getSubmitButton() {
		return submitButton.isSelected();
	}
	public void setSubmitButton(Boolean argBoolean) {
		 this.submitButton.setSelected(argBoolean);
	}
	//Comboboxes 
	public String getComboBoxesFindByString(int arg) {
		Object selectedValue = comboBoxesFindby[arg].getSelectedItem();

		// Perform necessary type conversion if needed
		if (selectedValue != null) {
		    String selectedString = selectedValue.toString();
		    // Do something with the selected value
			return selectedString;

		} else {
		    // Handle the case when no item is selected
		    System.out.println("No item selected in comboBoxes[0].");
		}
		return null;
	}
	
	public JComboBox<String>[] getComboBoxesFindBy() {
		return comboBoxesFindby;
	}
	public String getjComboBoxOperatingString(){
		return jComboBoxOperatingSystem.getItemAt(jComboBoxOperatingSystem.getSelectedIndex());
	}
	public JComboBox getComboBoxOperatingSystem(){
		return jComboBoxOperatingSystem;
	}
	public String getjComboBoxChromeString(){
		return jComboBoxChromeVersions.getItemAt(jComboBoxChromeVersions.getSelectedIndex());
	}
	public JComboBox getjComboBoxChromeVersion(){
		return jComboBoxChromeVersions;
	}
	
	public String getjComboBoxFindByMethodString(){
		return jComboBoxSearchByMethod.getItemAt(jComboBoxSearchByMethod.getSelectedIndex());
	}
	public JComboBox getComboBoxFindBy(){
		return jComboBoxSearchByMethod;
	}
	
	public String getjComboBoxActionString(){
		return jComboBoxActions.getItemAt(jComboBoxActions.getSelectedIndex());
	}
	public JComboBox getjComboBoxActions(){
		return jComboBoxActions;
	}
	
	public JComboBox getComboBoxesActions2Rule(int arg) {
		return comboBoxesActionsRule[arg];	
		}
	

	public String getComboBoxesActions2(int arg) {
		Object selectedValue = comboBoxesActionsRule[arg].getSelectedItem();

		// Perform necessary type conversion if needed
		if (selectedValue != null) {
		    String selectedString = selectedValue.toString();
		    // Do something with the selected value
			return selectedString;

		} else {
		    // Handle the case when no item is selected
		    System.out.println("No item selected in comboBoxes[0].");
		}
		return null;	
		}

	
	//Jtextfields getters
	public String getJTextFieldAttribute(int arg) 
	{
		Object selectedValue = JTextFieldsAtrribute[arg].getText();

		// Perform necessary type conversion if needed
		if (selectedValue != null) {
		    String selectedString = selectedValue.toString();
		    // Do something with the selected value
			return selectedString;

		} else {
		    // Handle the case when no item is selected
		    System.out.println("No item selected in comboBoxes[0].");
		}
		return null;	
	}		
	
	
	public String getJTextFieldAction(int arg) 
	{		
		Object selectedValue = addActionInJTextField[arg].getText();

		// Perform necessary type conversion if needed
		if (selectedValue != null) {
		    String selectedString = selectedValue.toString();
		    // Do something with the selected value
			return selectedString;

		} else {
		    // Handle the case when no item is selected
		    System.out.println("No item selected in comboBoxes[0].");
		}
		return null;	
		
	}
	public JTextField getaddActionInJTextField(int args) {
		return addActionInJTextField[args];
	}
	
	
	public JTextField getURL() {
		return SeleniumUI.URL;
	}
	public JTextField getFindElementBy() {
		return SeleniumUI.Findelementbytype;
	}
	public boolean getRadioWaitButton() {
		return radioButton.isSelected();
	}
	public void setRadioWaitButton(Boolean argBoolean) {
		 this.radioButton.setSelected(argBoolean);
	}
	public JTextField getaddField() {
		return addTextToField;
	}
	
	public JLabel getErrorLabel() {
		return this.errorLabel;
	}
	public JLabel getEnterAttributeJLabel() {
		return this.EnterAttribute;
	}
	
	public JLabel getinputTextAction() {
		return this.inputText;
	}
	
	public JButton getStartButton(){
		return go;
	}
	
	
	

	
	public SeleniumUI() {
		// TODO Auto-generated constructor stub
		//Frame stuff
		frame = new JFrame("Automation"); // Creation of a new JFrame with the title 
		frame.setVisible(true); // To display the frame
		frame.setBounds(400, 400, 1200, 800); // To set the locations of the frame.
		frame.setLayout(new BorderLayout());
		//Stops the program on exit
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(imagePanel, BorderLayout.CENTER);
		frame.setLocationRelativeTo(null);
		frame.setResizable(true);
	    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

	    //Grid Bag Constrains coordonates
	     c.gridx = 0;
	     c.gridy = 1;
	     c.anchor = GridBagConstraints.FIRST_LINE_END;
			
			
		 gbc.gridx = 0;
		 gbc.gridy = 0;
		 gbc.anchor = GridBagConstraints.NORTH;
		 

		 //Panels 
		 // Set the opacity of the frame
		 mainJPanel.setOpaque(false);
	     borderJPanel.setOpaque(false);
		 contentPanel.setOpaque(false);
		 globalVariablesJPanel.setOpaque(false);

		 // Add mainJPanel to contentPanel
		 contentPanel.add(mainJPanel, gbc);
		 
		 //set border for global settings
		 globalVariablesJPanel.setBorder(BorderFactory.createBevelBorder(0, btnColorOnHover, btnColor));
		 
		 imagePanel.add(globalVariablesJPanel, BorderLayout.NORTH);
		 // Increment the gridy value to move to the next row
		 gbc.gridy++;

		 // Add borderJPanel to contentPanel
		 contentPanel.add(borderJPanel, gbc);

		 // Add contentPanel to imagePanel
		 imagePanel.add(contentPanel);


		 frame.add(imagePanel, BorderLayout.CENTER);
	
		
		//Buttons
		//............
		//................
		go.setBackground(btnColor);
		go.setOpaque(true);
		go.setBorder(emptyBorder);
		go.setFocusPainted(false);
		go.setForeground(Color.white);

		
		//Input text
		URL.setSize(150,40);
		URL.setBorder(emptyBorder);
		URL.setForeground(Color.BLACK);
		URL.setText("https://");
		
		Findelementbytype.setSize(150, 40);
		
		addTextToField.setSize(150,40);
		addTextToField.setVisible(false);
		

		
		//Combo box
		jComboBoxSearchByMethod.setSize(150,40);
		//Font Color
		labelURL.setForeground(Color.white);
		errorLabel.setForeground(Color.BLACK);
		selectFindBy.setForeground(Color.white);
		EnterAttribute.setForeground(Color.white);
		EnterAction.setForeground(Color.white);
		inputText.setForeground(Color.white);
		chromeVersion.setForeground(Color.WHITE);
		operatingSystem.setForeground(Color.WHITE);

		
		//Font size
		//chromeVersion.setFont(new Font("Arial", Font.PLAIN)); // Set the font size to 18;
	
		//Labels
		inputText.setVisible(false);
		
	
        
        //Operating system version label      
        mainJPanel.add(operatingSystem, "");
        
    	//Combo box for Operating system
        mainJPanel.add(jComboBoxOperatingSystem, "wrap");

        //Chrome version label
	    mainJPanel.add(chromeVersion);
	        
        //Combo box for chrome version
	    mainJPanel.add(jComboBoxChromeVersions, "wrap");
	        
	        
	     //Label URL
	     mainJPanel.add(labelURL);
	    
	     mainJPanel.add(URL);
	        
	     //Error no input provided in URL textfield
	     mainJPanel.add(errorLabel, "wrap");
        	
	     //Label Select Find Element by method
	     mainJPanel.add(selectFindBy);
	          
	     mainJPanel.add(jComboBoxSearchByMethod, "wrap");
	        
	       
	     mainJPanel.add(EnterAttribute);
	   
	     mainJPanel.add(Findelementbytype, "wrap");
	        
	   
	     mainJPanel.add(EnterAction);
	      
	     mainJPanel.add(jComboBoxActions, "wrap");
	        
	     mainJPanel.add(inputText);
	  	        
	  	 mainJPanel.add(addTextToField, "wrap 15"); 
	        	
	  	 submitButton.setOpaque(false);
	  	 submitButton.setBorder(emptyBorder);
	  	 submitButton.setForeground(Color.white);
	        
	      
	     mainJPanel.add(submitButton, "wrap, span 2 ,align center");
	        
	     radioButton.setOpaque(false);
	     radioButton.setBorder(emptyBorder);
	     radioButton.setForeground(Color.white);
	        
	     mainJPanel.add(radioButton, "wrap, span 2 ,align center");
	        
	    ;
	     
	     mainJPanel.add(endButtonJRadioButton, "wrap, span2, align center");
	     endButtonJRadioButton.setOpaque(false);
	     endButtonJRadioButton.setBorder(emptyBorder);
	     endButtonJRadioButton.setForeground(Color.white);
	     
	     mainJPanel.add(closeBrowserButtonJRadioButton, "wrap, span2, align center");
	     closeBrowserButtonJRadioButton.setOpaque(false);
	     closeBrowserButtonJRadioButton.setBorder(emptyBorder);
	     closeBrowserButtonJRadioButton.setForeground(Color.white);
	     
	    
	     mainJPanel.add(addNewRule,  "wrap, span 2 ,align center");


	     // Add the save button to the frame
	     mainJPanel.add(deleteButton, "wrap, span 2 ,align center");
	     mainJPanel.add(saveButton, "align center");
	     mainJPanel.add(loadButton, "wrap, align center");

	     mainJPanel.add(go, "span 2 ,align center");
	     imagePanel.revalidate();
		 imagePanel.repaint();
		 
		 
		 ///globalVariablesJPanel add components
		 globalVariablesJPanel.add(waitTimeActionsJLabel);
		 waitTimeActionsJLabel.setForeground(Color.white);

		 globalVariablesJPanel.add(waitGlobalActionsJTextField);
		 globalVariablesJPanel.add(waitJLabel);
		 waitJLabel.setForeground(Color.white);

		 globalVariablesJPanel.add(waitGlobalVisibilityJTextField);
		 globalVariablesJPanel.add(maximiJRadioButton);
		 maximiJRadioButton.setOpaque(false);
	     maximiJRadioButton.setBorder(emptyBorder);
	     maximiJRadioButton.setForeground(Color.white);
	     
	     

	}
}

