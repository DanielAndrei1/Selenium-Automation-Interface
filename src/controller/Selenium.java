package controller;

import java.awt.Color;
import java.io.OutputStream;
import java.io.FileOutputStream;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.StyledEditorKit.BoldAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.manager.*;
import org.openqa.selenium.remote.http.*;



import SeleniumUI.SeleniumUI;
import threads.*;

public class Selenium {
	
	static SeleniumUI seleniumUI = new SeleniumUI();
	public String elementString  = seleniumUI.getFindElementBy().getText();
	static String actionString = seleniumUI.getaddField().getText();
	
	private static ArrayList<String> savedDatArrayList = new ArrayList<>();
	 // Create a new HashMap
    static Map<Integer, String > counterFindByMap = new HashMap<>();
    static int countClicked = 1;
    private static int counter = 0;
   
    private static List<JPanel> rowPanels = new ArrayList<>();
	private static JPanel[] rowPanel = seleniumUI.getRowPanels();
	private static JLabel[] rowNumberJLabel = seleniumUI.getRowNumberJLabel();
	private static JComboBox comboBoxesFindby[] = seleniumUI.getComboBoxesFindBy();
	private static JTextField JTextFieldsAtrribute[] = seleniumUI.getJTextFieldsAtrribute();
	private static JComboBox comboBoxesActions2[] = seleniumUI.getcomboBoxesActionsRule();
	private static JTextField addActionInJTextField[] = seleniumUI.getAddActionInJTextField();
	private static JRadioButton[] radioWaitTimeRadioButtons = seleniumUI.getRadioButtonRule();
	private static JRadioButton submitRadioButtonsRule[] = seleniumUI.getsubmitRadioButtonsRule();
    
	public Boolean newRuleAddedBoolean = false;
	
    //Map dictinary
	public Map<Integer, String> getCounterFindByDictonaryMap() {
			return counterFindByMap;
		}
	
	public static int getcounter() {
    	return counter;
    }
    public static int getcountClicker() {
    	return countClicked;
    }
	
	
	public ArrayList<String> getSavedDatArrayList() {
		return savedDatArrayList;
	}

	public void ClearDataArrayList() {
		this.savedDatArrayList.clear();
	}
				    	
	public Selenium() throws InterruptedException {
		ActionListiners();
		NewRule();
	}


	private static void ActionListiners() throws InterruptedException {
		
		
		seleniumUI.getStartButton().addActionListener(new ActionListener() {
		Map<Integer, String > AddDataFindByMap = new HashMap<>();
		int waitTime = 10;
		String filePath = new File("").getAbsolutePath();
		ChromeDriver driver;
		
			
		    @Override
		    public void actionPerformed(ActionEvent g) {
		    	
		    	if(seleniumUI.getURL().getText().endsWith("/") == true) {
		    		seleniumUI.getErrorLabel().setText("Please enter a URL! Or remove the / at the end of the URL.");
		    		} else {
		    			
		    			//Chrome Version plus nested switch for operating system
		    			switch (seleniumUI.getjComboBoxChromeString()) {
		    			case "109": {
							switch (seleniumUI.getjComboBoxOperatingString()) {
							case "Windows": {
								
								String chromeDriverPathString = "/Drivers/chromeDriver/109/Windows/chromedriver.exe";
								InputStream inputStream = getClass().getResourceAsStream(chromeDriverPathString);

								File tempFile = null;
								try {
									tempFile = File.createTempFile("chromedriver", ".exe");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								tempFile.deleteOnExit();

								try (OutputStream outputStream = new FileOutputStream(tempFile)) {
								    byte[] buffer = new byte[8192];
								    int bytesRead;
								    while ((bytesRead = inputStream.read(buffer)) != -1) {
								        outputStream.write(buffer, 0, bytesRead);
								    }
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								String chromeDriverPath = tempFile.getAbsolutePath();

								System.setProperty("webdriver.chrome.driver", chromeDriverPath);
								driver = new ChromeDriver();
				                break;

							}
							case "Mac": {
								
								String chromeDriverPathString = "/Drivers/chromeDriver/109/Mac/chromedriver.exe";
								InputStream inputStream = getClass().getResourceAsStream(chromeDriverPathString);

								File tempFile = null;
								try {
									tempFile = File.createTempFile("chromedriver", ".exe");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								tempFile.deleteOnExit();

								try (OutputStream outputStream = new FileOutputStream(tempFile)) {
								    byte[] buffer = new byte[8192];
								    int bytesRead;
								    while ((bytesRead = inputStream.read(buffer)) != -1) {
								        outputStream.write(buffer, 0, bytesRead);
								    }
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								String chromeDriverPath = tempFile.getAbsolutePath();

								System.setProperty("webdriver.chrome.driver", chromeDriverPath);
								driver = new ChromeDriver();
				                break;

							}
							case "Linux": {
								
								String chromeDriverPathString = "/Drivers/chromeDriver/109/Linux/chromedriver.exe";
								InputStream inputStream = getClass().getResourceAsStream(chromeDriverPathString);

								File tempFile = null;
								try {
									tempFile = File.createTempFile("chromedriver", ".exe");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								tempFile.deleteOnExit();

								try (OutputStream outputStream = new FileOutputStream(tempFile)) {
								    byte[] buffer = new byte[8192];
								    int bytesRead;
								    while ((bytesRead = inputStream.read(buffer)) != -1) {
								        outputStream.write(buffer, 0, bytesRead);
								    }
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								String chromeDriverPath = tempFile.getAbsolutePath();

								System.setProperty("webdriver.chrome.driver", chromeDriverPath);
								driver = new ChromeDriver();
				                break;

							}
							default:
								throw new IllegalArgumentException("Unexpected value: " + seleniumUI);
							}
							break;

		    			}
		    			case "110": {
							switch (seleniumUI.getjComboBoxOperatingString()) {
							case "Windows": {
								
								String chromeDriverPathString = "/Drivers/chromeDriver/110/Windows/chromedriver.exe";
								InputStream inputStream = getClass().getResourceAsStream(chromeDriverPathString);

								File tempFile = null;
								try {
									tempFile = File.createTempFile("chromedriver", ".exe");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								tempFile.deleteOnExit();

								try (OutputStream outputStream = new FileOutputStream(tempFile)) {
								    byte[] buffer = new byte[8192];
								    int bytesRead;
								    while ((bytesRead = inputStream.read(buffer)) != -1) {
								        outputStream.write(buffer, 0, bytesRead);
								    }
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								String chromeDriverPath = tempFile.getAbsolutePath();

								System.setProperty("webdriver.chrome.driver", chromeDriverPath);
								driver = new ChromeDriver();
				                break;

							}
							case "Mac": {
								
								String chromeDriverPathString = "/Drivers/chromeDriver/110/Mac/chromedriver.exe";
								InputStream inputStream = getClass().getResourceAsStream(chromeDriverPathString);

								File tempFile = null;
								try {
									tempFile = File.createTempFile("chromedriver", ".exe");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								tempFile.deleteOnExit();

								try (OutputStream outputStream = new FileOutputStream(tempFile)) {
								    byte[] buffer = new byte[8192];
								    int bytesRead;
								    while ((bytesRead = inputStream.read(buffer)) != -1) {
								        outputStream.write(buffer, 0, bytesRead);
								    }
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								String chromeDriverPath = tempFile.getAbsolutePath();

								System.setProperty("webdriver.chrome.driver", chromeDriverPath);
								driver = new ChromeDriver();
				                break;

							}
							case "Linux": {
								
								String chromeDriverPathString = "/Drivers/chromeDriver/110/Linux/chromedriver.exe";
								InputStream inputStream = getClass().getResourceAsStream(chromeDriverPathString);

								File tempFile = null;
								try {
									tempFile = File.createTempFile("chromedriver", ".exe");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								tempFile.deleteOnExit();

								try (OutputStream outputStream = new FileOutputStream(tempFile)) {
								    byte[] buffer = new byte[8192];
								    int bytesRead;
								    while ((bytesRead = inputStream.read(buffer)) != -1) {
								        outputStream.write(buffer, 0, bytesRead);
								    }
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								String chromeDriverPath = tempFile.getAbsolutePath();

								System.setProperty("webdriver.chrome.driver", chromeDriverPath);
								driver = new ChromeDriver();
				                break;

							}
							default:
								throw new IllegalArgumentException("Unexpected value: " + seleniumUI);
							}
							break;

		    			}
		    			case "111": {
							switch (seleniumUI.getjComboBoxOperatingString()) {
							case "Windows": {
								
								String chromeDriverPathString = "/Drivers/chromeDriver/111/Windows/chromedriver.exe";
								InputStream inputStream = getClass().getResourceAsStream(chromeDriverPathString);

								File tempFile = null;
								try {
									tempFile = File.createTempFile("chromedriver", ".exe");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								tempFile.deleteOnExit();

								try (OutputStream outputStream = new FileOutputStream(tempFile)) {
								    byte[] buffer = new byte[8192];
								    int bytesRead;
								    while ((bytesRead = inputStream.read(buffer)) != -1) {
								        outputStream.write(buffer, 0, bytesRead);
								    }
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								String chromeDriverPath = tempFile.getAbsolutePath();

								System.setProperty("webdriver.chrome.driver", chromeDriverPath);
								driver = new ChromeDriver();
				                break;

							}
							case "Mac": {
								
								String chromeDriverPathString = "/Drivers/chromeDriver/111/Mac/chromedriver.exe";
								InputStream inputStream = getClass().getResourceAsStream(chromeDriverPathString);

								File tempFile = null;
								try {
									tempFile = File.createTempFile("chromedriver", ".exe");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								tempFile.deleteOnExit();

								try (OutputStream outputStream = new FileOutputStream(tempFile)) {
								    byte[] buffer = new byte[8192];
								    int bytesRead;
								    while ((bytesRead = inputStream.read(buffer)) != -1) {
								        outputStream.write(buffer, 0, bytesRead);
								    }
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								String chromeDriverPath = tempFile.getAbsolutePath();

								System.setProperty("webdriver.chrome.driver", chromeDriverPath);
								driver = new ChromeDriver();
				                break;

							}
							case "Linux": {
								
								String chromeDriverPathString = "/Drivers/chromeDriver/111/Linux/chromedriver.exe";
								InputStream inputStream = getClass().getResourceAsStream(chromeDriverPathString);

								File tempFile = null;
								try {
									tempFile = File.createTempFile("chromedriver", ".exe");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								tempFile.deleteOnExit();

								try (OutputStream outputStream = new FileOutputStream(tempFile)) {
								    byte[] buffer = new byte[8192];
								    int bytesRead;
								    while ((bytesRead = inputStream.read(buffer)) != -1) {
								        outputStream.write(buffer, 0, bytesRead);
								    }
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								String chromeDriverPath = tempFile.getAbsolutePath();

								System.setProperty("webdriver.chrome.driver", chromeDriverPath);
								driver = new ChromeDriver();
				                break;

							}
							default:
								throw new IllegalArgumentException("Unexpected value: " + seleniumUI);
							}
							break;

		    			
		    			}
		    			case "112": {
							switch (seleniumUI.getjComboBoxOperatingString()) {
							case "Windows": {
								
								String chromeDriverPathString = "/Drivers/chromeDriver/112/Windows/chromedriver.exe";
								InputStream inputStream = getClass().getResourceAsStream(chromeDriverPathString);

								File tempFile = null;
								try {
									tempFile = File.createTempFile("chromedriver", ".exe");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								tempFile.deleteOnExit();

								try (OutputStream outputStream = new FileOutputStream(tempFile)) {
								    byte[] buffer = new byte[8192];
								    int bytesRead;
								    while ((bytesRead = inputStream.read(buffer)) != -1) {
								        outputStream.write(buffer, 0, bytesRead);
								    }
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								String chromeDriverPath = tempFile.getAbsolutePath();

								System.setProperty("webdriver.chrome.driver", chromeDriverPath);
								driver = new ChromeDriver();
				                break;

							}
							case "Mac": {
								
								String chromeDriverPathString = "/Drivers/chromeDriver/112/Mac/chromedriver.exe";
								InputStream inputStream = getClass().getResourceAsStream(chromeDriverPathString);

								File tempFile = null;
								try {
									tempFile = File.createTempFile("chromedriver", ".exe");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								tempFile.deleteOnExit();

								try (OutputStream outputStream = new FileOutputStream(tempFile)) {
								    byte[] buffer = new byte[8192];
								    int bytesRead;
								    while ((bytesRead = inputStream.read(buffer)) != -1) {
								        outputStream.write(buffer, 0, bytesRead);
								    }
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								String chromeDriverPath = tempFile.getAbsolutePath();

								System.setProperty("webdriver.chrome.driver", chromeDriverPath);
								driver = new ChromeDriver();
				                break;

							}
							case "Linux": {
								
								String chromeDriverPathString = "/Drivers/chromeDriver/112/Linux/chromedriver.exe";
								InputStream inputStream = getClass().getResourceAsStream(chromeDriverPathString);

								File tempFile = null;
								try {
									tempFile = File.createTempFile("chromedriver", ".exe");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								tempFile.deleteOnExit();

								try (OutputStream outputStream = new FileOutputStream(tempFile)) {
								    byte[] buffer = new byte[8192];
								    int bytesRead;
								    while ((bytesRead = inputStream.read(buffer)) != -1) {
								        outputStream.write(buffer, 0, bytesRead);
								    }
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								String chromeDriverPath = tempFile.getAbsolutePath();

								System.setProperty("webdriver.chrome.driver", chromeDriverPath);
								driver = new ChromeDriver();
				                break;

							}
							default:
								throw new IllegalArgumentException("Unexpected value: " + seleniumUI);
							}
							break;

		    			}
		    			case "113": {
							switch (seleniumUI.getjComboBoxOperatingString()) {
							case "Windows": {
								
								String chromeDriverPathString = "/Drivers/chromeDriver/113/Windows/chromedriver.exe";
								InputStream inputStream = getClass().getResourceAsStream(chromeDriverPathString);

								File tempFile = null;
								try {
									tempFile = File.createTempFile("chromedriver", ".exe");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								tempFile.deleteOnExit();

								try (OutputStream outputStream = new FileOutputStream(tempFile)) {
								    byte[] buffer = new byte[8192];
								    int bytesRead;
								    while ((bytesRead = inputStream.read(buffer)) != -1) {
								        outputStream.write(buffer, 0, bytesRead);
								    }
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								String chromeDriverPath = tempFile.getAbsolutePath();

								System.setProperty("webdriver.chrome.driver", chromeDriverPath);
								driver = new ChromeDriver();


				                break;

							}
							case "Mac": {
								
								String chromeDriverPathString = "/Drivers/chromeDriver/113/Mac/chromedriver.exe";
								InputStream inputStream = getClass().getResourceAsStream(chromeDriverPathString);

								File tempFile = null;
								try {
									tempFile = File.createTempFile("chromedriver", ".exe");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								tempFile.deleteOnExit();

								try (OutputStream outputStream = new FileOutputStream(tempFile)) {
								    byte[] buffer = new byte[8192];
								    int bytesRead;
								    while ((bytesRead = inputStream.read(buffer)) != -1) {
								        outputStream.write(buffer, 0, bytesRead);
								    }
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								String chromeDriverPath = tempFile.getAbsolutePath();

								System.setProperty("webdriver.chrome.driver", chromeDriverPath);
								driver = new ChromeDriver();

				                break;

							}
							case "Linux": {
								
								String chromeDriverPathString = "/Drivers/chromeDriver/113/Linux/chromedriver.exe";
								InputStream inputStream = getClass().getResourceAsStream(chromeDriverPathString);

								File tempFile = null;
								try {
									tempFile = File.createTempFile("chromedriver", ".exe");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								tempFile.deleteOnExit();

								try (OutputStream outputStream = new FileOutputStream(tempFile)) {
								    byte[] buffer = new byte[8192];
								    int bytesRead;
								    while ((bytesRead = inputStream.read(buffer)) != -1) {
								        outputStream.write(buffer, 0, bytesRead);
								    }
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								String chromeDriverPath = tempFile.getAbsolutePath();

								System.setProperty("webdriver.chrome.driver", chromeDriverPath);
								driver = new ChromeDriver();
								
				                break;

							}
							default:
								throw new IllegalArgumentException("Unexpected value: " + seleniumUI.getjComboBoxOperatingString());
							}
							break;

						}
		    			case "114": {
							switch (seleniumUI.getjComboBoxOperatingString()) {
							case "Windows": {
								
								String chromeDriverPathString = "/Drivers/chromeDriver/114/Windows/chromedriver.exe";
								InputStream inputStream = getClass().getResourceAsStream(chromeDriverPathString);

								File tempFile = null;
								try {
									tempFile = File.createTempFile("chromedriver", ".exe");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								tempFile.deleteOnExit();

								try (OutputStream outputStream = new FileOutputStream(tempFile)) {
								    byte[] buffer = new byte[8192];
								    int bytesRead;
								    while ((bytesRead = inputStream.read(buffer)) != -1) {
								        outputStream.write(buffer, 0, bytesRead);
								    }
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								String chromeDriverPath = tempFile.getAbsolutePath();

								System.setProperty("webdriver.chrome.driver", chromeDriverPath);
								driver = new ChromeDriver();
				                break;

							}
							case "Mac": {
								
								String chromeDriverPathString = "/Drivers/chromeDriver/114/Mac/chromedriver.exe";
								InputStream inputStream = getClass().getResourceAsStream(chromeDriverPathString);

								File tempFile = null;
								try {
									tempFile = File.createTempFile("chromedriver", ".exe");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								tempFile.deleteOnExit();

								try (OutputStream outputStream = new FileOutputStream(tempFile)) {
								    byte[] buffer = new byte[8192];
								    int bytesRead;
								    while ((bytesRead = inputStream.read(buffer)) != -1) {
								        outputStream.write(buffer, 0, bytesRead);
								    }
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								String chromeDriverPath = tempFile.getAbsolutePath();

								System.setProperty("webdriver.chrome.driver", chromeDriverPath);
								driver = new ChromeDriver();
				                break;

							}
							case "Linux": {
								
								String chromeDriverPathString = "/Drivers/chromeDriver/114/Linux/chromedriver.exe";
								InputStream inputStream = getClass().getResourceAsStream(chromeDriverPathString);

								File tempFile = null;
								try {
									tempFile = File.createTempFile("chromedriver", ".exe");
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								tempFile.deleteOnExit();

								try (OutputStream outputStream = new FileOutputStream(tempFile)) {
								    byte[] buffer = new byte[8192];
								    int bytesRead;
								    while ((bytesRead = inputStream.read(buffer)) != -1) {
								        outputStream.write(buffer, 0, bytesRead);
								    }
								} catch (FileNotFoundException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}

								String chromeDriverPath = tempFile.getAbsolutePath();

								System.setProperty("webdriver.chrome.driver", chromeDriverPath);
								driver = new ChromeDriver();
				                break;

							}
							default:
								throw new IllegalArgumentException("Unexpected value: " + seleniumUI);
							}
							break;

		    			}
						}
		    			//maximize chrome
		    			if(seleniumUI.getMaximizeJRadioButton()) {
			    			//Mazimize current window
			    			driver.manage().window().maximize();
			    		}
			    		
			    		driver.get(seleniumUI.getURL().getText());
			    		// Create WebDriverWait instance with a timeout of 10 seconds
			    		Actions action = new Actions(driver);
			    		
			    		seleniumUI.getWaitGlobalJTextField().addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								waitTime =Integer.parseInt(seleniumUI.getWaitGlobalJTextField().getText());

							}
						});

			    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime));
			    		System.out.println(waitTime);
			    		
			    		if(seleniumUI.getWaitActionJTextField() != null) {
			    		try {
							Thread.sleep(Integer.parseInt(seleniumUI.getWaitActionJTextField().getText())*1000);
						} catch (NumberFormatException | InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			    		}
			    		
			    		
			    		switch(seleniumUI.getjComboBoxFindByMethodString()) {
			    		case "Default":
			    			break;
			    		
			    		case "Id":
			    		{
			    			WebElement elementID;
							if(seleniumUI.getRadioWaitButton()) {
								// Wait for an element to be visible
								elementID = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(seleniumUI.getFindElementBy().getText())));
							}else {
								elementID = driver.findElement(By.id(seleniumUI.getFindElementBy().getText()));
								
							}
    						
    						System.out.println("ID");

	        						switch (seleniumUI.getjComboBoxActionString()) {
									case "Click": {
										
										System.out.println("Id Clicked.");
										elementID.click();
		        						break;
		        						}
									case "Move to element":
									{
	    								action.moveToElement(elementID).perform();								
		        						break;

									}
									case "Input text":
									{
										elementID.click();
										elementID.sendKeys(seleniumUI.getaddField().getText());
										
										if(seleniumUI.getSubmitButton()) {
											elementID.submit();
										}
										
										break;

									}
									default:
										throw new IllegalArgumentException("Unexpected value: " + seleniumUI.getjComboBoxActionString());
									}
	        						
	
    			
			    		}
    								break;
			    		case "Name":
			    			{
				    			WebElement elementNamWebElement;
								if(seleniumUI.getRadioWaitButton()) {
									// Wait for an element to be visible
									elementNamWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(seleniumUI.getFindElementBy().getText())));
								}else {
									elementNamWebElement = driver.findElement(By.name(seleniumUI.getFindElementBy().getText()));
									
								}
	    						
	    						System.out.println("Name");

		        						switch (seleniumUI.getjComboBoxActionString()) {
										case "Click": {
											
											System.out.println("Name Clicked 0.");
											elementNamWebElement.click();
			        						break;
			        						}
										case "Move to element":
										{
		    								action.moveToElement(elementNamWebElement).perform();								
			        						break;

										}
										case "Input text":
										{	
											elementNamWebElement.click();
											elementNamWebElement.sendKeys(seleniumUI.getaddField().getText());
											if(seleniumUI.getSubmitButton()) {
												elementNamWebElement.submit();
											}
											
											break;

										}
										default:
											throw new IllegalArgumentException("Unexpected value: " + seleniumUI.getjComboBoxActionString());
										}
		        						
		
	    			
				    		}
			    	
			                break;

			    		case "Class Name":
			    			{
				    			WebElement elementClassNamWebElement;
								if(seleniumUI.getRadioWaitButton()) {
									// Wait for an element to be visible
									elementClassNamWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(seleniumUI.getFindElementBy().getText())));
								}else {
									elementClassNamWebElement = driver.findElement(By.className(seleniumUI.getFindElementBy().getText()));
									
								}
	    						
	    						System.out.println("Class Name");

		        						switch (seleniumUI.getjComboBoxActionString()) {
										case "Click": {
											
											System.out.println("Class Name Clicked 0.");
											elementClassNamWebElement.click();
			        						break;
			        						}
										case "Move to element":
										{
		    								action.moveToElement(elementClassNamWebElement).perform();								
			        						break;

										}
										case "Input text":
										{
											elementClassNamWebElement.click();
											elementClassNamWebElement.sendKeys(seleniumUI.getaddField().getText());
											if(seleniumUI.getSubmitButton()) {
												elementClassNamWebElement.submit();
											}
											break;

										}
										default:
											throw new IllegalArgumentException("Unexpected value: " + seleniumUI.getjComboBoxActionString());
										}
		        						
		
	    			
				    		}
	    					break;
			    		case "Xpath":
			    		{
			    			WebElement elementXpathWebElement;
							if(seleniumUI.getRadioWaitButton()) {
								// Wait for an element to be visible
								elementXpathWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(seleniumUI.getFindElementBy().getText())));
							}else {
								elementXpathWebElement = driver.findElement(By.xpath(seleniumUI.getFindElementBy().getText()));
								
							}
    						
    						System.out.println("Xpath");

	        						switch (seleniumUI.getjComboBoxActionString()) {
									case "Click": {
										
										System.out.println("Xpath Clicked. 0");
										elementXpathWebElement.click();
		        						break;
		        						}
									case "Move to element":
									{
	    								action.moveToElement(elementXpathWebElement).perform();								
		        						break;

									}
									case "Input text":
									{
										elementXpathWebElement.click();
										elementXpathWebElement.sendKeys(seleniumUI.getaddField().getText());
										if(seleniumUI.getSubmitButton()) {
											elementXpathWebElement.submit();
										}
										break;

									}
									default:
										throw new IllegalArgumentException("Unexpected value: " + seleniumUI.getjComboBoxActionString());
									}
	        						
	
    			
			    		}
    					break;
			    		case "Css Selector":
			    			if(seleniumUI.getjComboBoxActionString() == "Input text") {driver.findElement(By.cssSelector(seleniumUI.getFindElementBy().getText())).sendKeys(actionString);}
			                break;

			    		case "Link Text":
			    		{
			    			WebElement elementLinkTextWebElement;
							if(seleniumUI.getRadioWaitButton()) {
								// Wait for an element to be visible
								elementLinkTextWebElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(seleniumUI.getFindElementBy().getText())));
							}else {
								elementLinkTextWebElement = driver.findElement(By.linkText(seleniumUI.getFindElementBy().getText()));
								
							}
    						
    						System.out.println("Link Text");

	        						switch (seleniumUI.getjComboBoxActionString()) {
									case "Click": {
										
										System.out.println("Link Text Clicked 0.");
										elementLinkTextWebElement.click();
		        						break;
		        						}
									case "Move to element":
									{
	    								action.moveToElement(elementLinkTextWebElement).perform();								
		        						break;

									}
									case "Input text":
									{
										elementLinkTextWebElement.click();
										elementLinkTextWebElement.sendKeys(seleniumUI.getaddField().getText());
										if(seleniumUI.getSubmitButton()) {
											elementLinkTextWebElement.submit();
										}
										break;

									}
									default:
										throw new IllegalArgumentException("Unexpected value: " + seleniumUI.getjComboBoxActionString());
									}
	        						
	
    			
			    		}
    					break;

			    		case "Partial Link Text":
			    		{
			    			WebElement elementPartiallinkTextElement;
							if(seleniumUI.getRadioWaitButton()) {
								// Wait for an element to be visible
								elementPartiallinkTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(seleniumUI.getFindElementBy().getText())));
							}else {
								elementPartiallinkTextElement = driver.findElement(By.partialLinkText(seleniumUI.getFindElementBy().getText()));
								
							}
    						
    						System.out.println("Partial Link Text");

	        						switch (seleniumUI.getjComboBoxActionString()) {
									case "Click": {
										
										System.out.println("Partial Link Text Clicked 0.");
										elementPartiallinkTextElement.click();
		        						break;
		        						}
									case "Move to element":
									{
	    								action.moveToElement(elementPartiallinkTextElement).perform();								
		        						break;

									}
									case "Input text":
									{
										elementPartiallinkTextElement.click();
										elementPartiallinkTextElement.sendKeys(seleniumUI.getaddField().getText());
										if(seleniumUI.getSubmitButton()) {
											elementPartiallinkTextElement.submit();
										}
										break;

									}
									default:
										throw new IllegalArgumentException("Unexpected value: " + seleniumUI.getjComboBoxActionString());
									}
	        						
	
    			
			    		}
    					break;


			    		}

			    		Rulesthread rulesthread = new Rulesthread(driver, wait, seleniumUI, action, counterFindByMap);
			    		rulesthread.start();
			    		//driver.close(); //Closes current browser
			    		//driver.quit(); // Closes all tab browsers opened by selenium script */
			    		
			    		if(seleniumUI.getEndButtonJRadioButton().isSelected()) {
			    			driver.close(); //Program closes
			    			rulesthread.stopExecuting();
			  		   	} else if(seleniumUI.getEndButtonJRadioButton().isSelected() && seleniumUI.getCloseBrowserButtonJRadioButton().isSelected()) {
			    			driver.close(); //Program closes
				    		driver.quit(); // Closes all tab browsers opened by selenium script */
				    		rulesthread.stopExecuting();
			  		   	} else if(seleniumUI.getCloseBrowserButtonJRadioButton().isSelected()) {
				    		driver.quit(); // Closes all tab browsers opened by selenium script */
				    		rulesthread.stopExecuting();
			  		   	}
			    		
			    		
			    			
			    		
		    		}
		    	
		    	
		    }
		    
			}
		);
		
		
		
		
		seleniumUI.getComboBoxFindBy().addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent g) {
		    	
		    	seleniumUI.getEnterAttributeJLabel().setText("Enter " + seleniumUI.getjComboBoxFindByMethodString());
		    	
		    }
		    }
		);
		
		
		
		
		
		
		seleniumUI.getjComboBoxActions().addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent g) {
		    	if (seleniumUI.getjComboBoxActionString() != null) {
		    	if(seleniumUI.getjComboBoxActionString().equals("Input text") ) {
		    		seleniumUI.getaddField().setVisible(true);
		    		seleniumUI.getinputTextAction().setVisible(true);
			    	seleniumUI.getinputTextAction().setText("Enter " + seleniumUI.getjComboBoxActionString());

		    	}else {
		    		seleniumUI.getaddField().setVisible(false);
		    		seleniumUI.getinputTextAction().setVisible(false);
		    		
		    	}
		    	}
		    }
		    }
		
		);
		
		//Save button Action Listener
		   seleniumUI.getSaveButton().addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                // Get the selected option from the combo box
	            	SaveData();
	        
	            }
	            });
		   
		   	// Create a button to load the values
		   seleniumUI.getLoadButton().addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	LoadData();
	            	
	            }
	        });
		   
		   
		//driver.findElement(By.id(""));
		//System.out.println(driver.getTitle());
		//driver.getCurrentUrl(); gets the link
		//driver.get("https://infinitystudiogames.com");
		
		//Select s = new Select(driver.findElement(By.id("id")); finds the select tag ex <select></select>
		//s.selectByValue("2"); Selects the value 2 if there is an attribute value
		//s.selectByVisibleText("Text")
		//driver.navigate().back();
		//driver.navigate().forward();
		   
		  
		 
		
	}
	
	
	
	private static void NewRule() throws InterruptedException {
		
		
		seleniumUI.getaddNewRule().addActionListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent e) {
		    	JLabel enterInputJLabel = new JLabel("Enter Input");
		    	seleniumUI.getEndButtonJRadioButton().setSelected(false);
    			seleniumUI.getCloseBrowserButtonJRadioButton().setSelected(false);
				for (int i = getcounter() + 1; i <= getcountClicker(); i++) {
					GridBagConstraints gbc = new GridBagConstraints();
				    gbc.gridx = 0;
				    gbc.gridy = i;
				    gbc.anchor = GridBagConstraints.NORTH;
				    // Create a JPanel with transparent background
			        rowPanel[i] = new JPanel() {
			            @Override
			            protected void paintComponent(Graphics g) {
			                // Set the background color to transparent
			                g.setColor(new Color(0, 0, 0, 0));
			                g.fillRect(0, 0, getWidth(), getHeight());
			                
			                // Call the superclass's paintComponent method
			                super.paintComponent(g);
			            }
			        };
			        rowPanel[i].setOpaque(false);
			        
			        seleniumUI.getBorderJPanel().add(rowPanel[i], gbc);
					for (int j = 0; j < 1; j++) {
						seleniumUI.getConstraints().gridx = j;
						seleniumUI.getConstraints().gridy = i;
						seleniumUI.getConstraints().anchor = GridBagConstraints.CENTER;
						seleniumUI.getConstraints().insets = new Insets(0, 10, 0 ,10);
					    
						String jlabelNumber = Integer.toString(i);
					    
						rowNumberJLabel[i] = new JLabel(jlabelNumber);
					    rowNumberJLabel[i].setForeground(Color.white);

					    rowPanel[i].add(rowNumberJLabel[i], seleniumUI.getConstraints());
					    }
					
				    for (int j = 1; j < 2; j++) {
				    	seleniumUI.getConstraints().gridx = j;
				    	seleniumUI.getConstraints().gridy = i;
				    	seleniumUI.getConstraints().anchor = GridBagConstraints.CENTER;
				    	seleniumUI.getConstraints().insets = new Insets(0, 10, 0 ,10);
				    	JLabel selectFindByNewRule = new JLabel("Select find by type");
				    	selectFindByNewRule.setForeground(Color.white);

				    	rowPanel[i].add(selectFindByNewRule, seleniumUI.getConstraints());
				    }
				
				    for (int j = 2; j < 3; j++) {
				    	seleniumUI.getConstraints().gridx = j;
				    	seleniumUI.getConstraints().gridy = i;
				    	seleniumUI.getConstraints().anchor = GridBagConstraints.CENTER;
				    	seleniumUI.getConstraints().insets = new Insets(0, 10, 0 ,10);
				    	
				    	comboBoxesFindby[i] = new JComboBox<>(seleniumUI.getOptionsToChooseMethodsFindByStrings());
				    
				    	rowPanel[i].add(comboBoxesFindby[i], seleniumUI.getConstraints());

				    }
				    
				
				    for (int j = 3; j < 4; j++) {
				    	seleniumUI.getConstraints().gridx = j;
				    	seleniumUI.getConstraints().gridy = i;
				    	seleniumUI.getConstraints().anchor = GridBagConstraints.CENTER;
				    	seleniumUI.getConstraints().insets = new Insets(0, 10, 0 ,10);
				    	JLabel EnterAttributeNewRule = new JLabel("Select find by element");

				    	EnterAttributeNewRule.setForeground(Color.white);

				    	rowPanel[i].add(EnterAttributeNewRule, seleniumUI.getConstraints());
				    }
				    
				    for (int j = 4; j < 5; j++) {
				    	seleniumUI.getConstraints().gridx = j;
				    	seleniumUI.getConstraints().gridy = i;
				    	seleniumUI.getConstraints().anchor = GridBagConstraints.CENTER;
				    	seleniumUI.getConstraints().insets = new Insets(0, 10, 0 ,10);
				    	JTextFieldsAtrribute[i] = new JTextField(16);
				    	
				    	rowPanel[i].add(JTextFieldsAtrribute[i], seleniumUI.getConstraints());
				    }
				    
				    for (int j = 5; j < 6; j++) {
				    	seleniumUI.getConstraints().gridx = j;
				    	seleniumUI.getConstraints().gridy = i;
				    	seleniumUI.getConstraints().anchor = GridBagConstraints.CENTER;
				    	seleniumUI.getConstraints().insets = new Insets(0, 10, 0 ,10);
				    	JLabel EnterActionNewRule = new JLabel("Select action");

				    	EnterActionNewRule.setForeground(Color.white);

				    	rowPanel[i].add(EnterActionNewRule, seleniumUI.getConstraints());
				    }
				    for (int j = 6; j < 7; j++) {
				    	seleniumUI.getConstraints().gridx = j;
				    	seleniumUI.getConstraints().gridy = i;
				    	seleniumUI.getConstraints().anchor = GridBagConstraints.CENTER;
				    	seleniumUI.getConstraints().insets = new Insets(0, 10, 0 ,10);
				    	comboBoxesActions2[i] = new JComboBox<>(seleniumUI.getOptionsToChooseActions());
				    	rowPanel[i].add(comboBoxesActions2[i], seleniumUI.getConstraints());
				    }					    
				    for (int j = 7; j < 8; j++) {
				    	seleniumUI.getConstraints().gridx = j;
				    	seleniumUI.getConstraints().gridy = i;
				    	seleniumUI.getConstraints().anchor = GridBagConstraints.CENTER;

				    	seleniumUI.getConstraints().insets = new Insets(0, 10, 0 ,10);
				    	rowPanel[i].add(enterInputJLabel, seleniumUI.getConstraints());
				    	enterInputJLabel.setForeground(Color.white);
				    	enterInputJLabel.setVisible(false);

				    }
				    for (int j = 8; j < 9; j++) {
				    	seleniumUI.getConstraints().gridx = j;
				    	seleniumUI.getConstraints().gridy = i;
				    	seleniumUI.getConstraints().anchor = GridBagConstraints.CENTER;
				    	seleniumUI.getConstraints().insets = new Insets(0, 10, 0 ,10);
				    	addActionInJTextField[i] = new JTextField(16);
				    	
				    	rowPanel[i].add(addActionInJTextField[i], seleniumUI.getConstraints());
				    	addActionInJTextField[i].setVisible(false);
				    }
				    for (int j = 9; j < 10; j++) {
				    	seleniumUI.getConstraints().gridx = j;
				    	seleniumUI.getConstraints().gridy = i;
				    	seleniumUI.getConstraints().anchor = GridBagConstraints.CENTER;
				    	seleniumUI.getConstraints().insets = new Insets(0, 10, 0 ,10);
				    	radioWaitTimeRadioButtons[i] = new JRadioButton("Wait time?");
				    	radioWaitTimeRadioButtons[i].setOpaque(false);
				    	radioWaitTimeRadioButtons[i].setBorder(BorderFactory.createEmptyBorder());
				    	radioWaitTimeRadioButtons[i].setForeground(Color.white);
				    	rowPanel[i].add(radioWaitTimeRadioButtons[i], seleniumUI.getConstraints());
				    }
				    
				    for (int j = 10; j < 11; j++) {
				    	seleniumUI.getConstraints().gridx = j;
				    	seleniumUI.getConstraints().gridy = i;
				    	seleniumUI.getConstraints().anchor = GridBagConstraints.CENTER;
				    	seleniumUI.getConstraints().insets = new Insets(0, 10, 0 ,10);
				    	submitRadioButtonsRule[i] = new JRadioButton("Submit?");
				    	submitRadioButtonsRule[i].setOpaque(false);
				    	submitRadioButtonsRule[i].setBorder(BorderFactory.createEmptyBorder());
				    	submitRadioButtonsRule[i].setForeground(Color.white);
				    	rowPanel[i].add(submitRadioButtonsRule[i], seleniumUI.getConstraints());
				    }
				    
				    
				    System.out.println("SeleniumUI 469: " + getcounter());
				    System.out.println("SeleniumUI 470: " + comboBoxesFindby);
				
				    

				    // Add the row panel to the rowPanels list
				    rowPanels.add(rowPanel[i]);
					
					comboBoxesActions2[i].addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.out.println("Merge");

						if(comboBoxesActions2[counter].getSelectedItem().equals("Input text")) {
							addActionInJTextField[counter].setVisible(true);
							enterInputJLabel.setVisible(true);
						} else {
							addActionInJTextField[counter].setVisible(false);
							enterInputJLabel.setVisible(false);
							
						}
					}
				});
					
				    comboBoxesFindby[i].addActionListener(new ActionListener() {

						    @Override
						    public void actionPerformed(ActionEvent g) {
						    	counterFindByMap.put(counter, comboBoxesFindby[counter].getSelectedItem().toString()); 
								
								
						    }
						    }
						);

				}
				

				
				
				counter++;
				countClicked++;

				

				// Add the JComboBox instances to your desired container (e.g., a JPanel)
				// For example, assuming you have a JPanel called "containerPanel":
				
		      
		        
				// Repaint the container panel to update the UI
				seleniumUI.getBorderJPanel().revalidate();
				seleniumUI.getBorderJPanel().repaint();
			}
		});
		
		
		 // ActionListener for the "Delete Row" button
        seleniumUI.getdeletButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Prompt the user to enter the row number to delete
                String input = JOptionPane.showInputDialog("Enter the row number to delete:");

                // Parse the user input to an integer
                int rowNumber = Integer.parseInt(input);

                // Check if the row number is valid
                if (rowNumber >= 0 && rowNumber <= countClicked) {
                    // Calculate the index of the row panel associated with the row
                    int panelIndex = rowNumber - 1;

                    // Retrieve the row panel from the list
                    JPanel rowPanel = rowPanels.get(panelIndex);

                    // Remove the row panel from the parent container (borderJPanel)
                    seleniumUI.getBorderJPanel().remove(rowPanel);

                    
                    // Repaint the parent container to reflect the changes
                    seleniumUI.getBorderJPanel().revalidate();
                    seleniumUI.getBorderJPanel().repaint();
                } else {
                    // Display an error message if the row number is invalid
                    JOptionPane.showMessageDialog(null, "Invalid row number!");
                }
            }
        });
        
        
	}
	
	
	private static void SaveData() {
		 String operatingSystemString = seleniumUI.getjComboBoxOperatingString();
         String chromeversion = seleniumUI.getjComboBoxChromeString();
         String Page = seleniumUI.getURL().getText();
         String selectedFindByMethod = seleniumUI.getjComboBoxFindByMethodString();
         String selectedAction = seleniumUI.getjComboBoxActionString();
         String findByText = seleniumUI.getFindElementBy().getText();
         String ActionText = seleniumUI.getaddField().getText();
         Boolean submitString = seleniumUI.getSubmitButton();
         Boolean waiTime =seleniumUI.getRadioWaitButton();
         Boolean maximiBoolean = seleniumUI.getMaximizeJRadioButton();

        /* // Get the values from the text fields
         String[] fieldValues = new String[9];
         for (int i = 0; i < 9; i++) {
             fieldValues[i] = Findelementbytype[i].getText();
         } */
         
         // Get the current timestamp
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         String timestamp = dateFormat.format(new Date());

         
         // Save the values to a file
         try (PrintWriter writer = new PrintWriter(new FileWriter("saved_values.txt", true))) {
             writer.println("=====");  // Separator between sessions
            // writer.println("Time: " + timestamp);
             writer.println(operatingSystemString);
             writer.println(chromeversion);
             writer.println(Page);
             writer.println(selectedFindByMethod);
             writer.println(selectedAction);
             writer.println(findByText);
             writer.println(ActionText);
             writer.println(submitString);
             writer.println(waiTime);
             writer.println(maximiBoolean);

           /*  for (String value : fieldValues) {
                 writer.println(value);
             } */
             writer.flush();
         } catch (IOException ex) {
             ex.printStackTrace();
         }
     }
		
	
	
	private static void LoadData() {
		
		 // Read the values from the file
       try (BufferedReader reader = new BufferedReader(new FileReader("saved_values.txt"))) {
           String line;
           while ((line = reader.readLine()) != null) {
               if (line.equals("=====")) {
                   // Separator between sessions
                   // Process the saved values for each session
                   String selectedOption = reader.readLine();
                   System.out.println("Selected option: " + selectedOption);
                   savedDatArrayList.add(selectedOption);

                   for (int i = 0; i < 9; i++) {
                       String fieldValue = reader.readLine();
                       System.out.println("Field " + (i + 1) + " value: " + fieldValue);
                       savedDatArrayList.add(fieldValue);
                   }
                   System.out.println(savedDatArrayList);
 
                   seleniumUI.getComboBoxOperatingSystem().setSelectedItem(savedDatArrayList.get(0));
                   seleniumUI.getjComboBoxChromeVersion().setSelectedItem(savedDatArrayList.get(1));
                   seleniumUI.getURL().setText(savedDatArrayList.get(2));
                   seleniumUI.getComboBoxFindBy().setSelectedItem(savedDatArrayList.get(3));
                   seleniumUI.getjComboBoxActions().setSelectedItem(savedDatArrayList.get(4));
                   seleniumUI.getFindElementBy().setText(savedDatArrayList.get(5));
                   seleniumUI.getaddField().setText(savedDatArrayList.get(6));
	               Boolean submitBoolean = Boolean.parseBoolean(savedDatArrayList.get(7));
	               seleniumUI.setSubmitButton(submitBoolean);
	               Boolean waitBoolean = Boolean.parseBoolean(savedDatArrayList.get(8));
	               seleniumUI.setRadioWaitButton(waitBoolean);
	               Boolean maximizeBoolean = Boolean.parseBoolean(savedDatArrayList.get(9));
	               seleniumUI.setMaximizeJRadioButton(maximizeBoolean);
	                
	               savedDatArrayList.clear();
                   
                   
               }
           }
       } catch (IOException ex) {
           ex.printStackTrace();
       }
	}
}
