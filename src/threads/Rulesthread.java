package threads;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SeleniumUI.SeleniumUI;

import org.openqa.selenium.interactions.*;
import org.openqa.selenium.remote.http.*;

public class Rulesthread extends Thread{
	private volatile boolean execute;

	
	private int threadint;
	private ChromeDriver driver;
	private WebDriverWait wait;
	private SeleniumUI seleniumUI;
	private Actions action;
	private Map<Integer, String> counteFindByMap;
	
	public Rulesthread(ChromeDriver driver,WebDriverWait wait, SeleniumUI seleniumUI, Actions action, Map<Integer, String> counteFindByMap) {
		this.driver = driver;
		this.wait = wait;
		this.seleniumUI = seleniumUI;
		this.action = action;
		this.counteFindByMap = counteFindByMap;
	}
    
   
 
   

    @Override
	public void run(){  
    	this.execute = true;

    	
    	while (this.execute) {
    		//Switch statement for new rules
    		//.............................
    		///..............................
    		///............................		
    		if(seleniumUI.getWaitActionJTextField() != null) {
			    		try {
							Thread.sleep(Integer.parseInt(seleniumUI.getWaitActionJTextField().getText())*1000);

						} catch (NumberFormatException | InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
			    		}
    		if(counteFindByMap.size() >= 0) {
				
				for (Map.Entry<Integer, String> entry : counteFindByMap.entrySet()) {
					System.out.println(entry.getKey());
					System.out.println(entry.getValue());
					
					
					
    		switch(entry.getValue()) {
    					
    					case "Id":
    						
    						WebElement elementID;
							if(seleniumUI.getRadioButtonRules(entry.getKey())) {
								// Wait for an element to be visible
								elementID = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(seleniumUI.getJTextFieldAttribute(entry.getKey()))));
							}else {
								elementID = driver.findElement(By.id(seleniumUI.getJTextFieldAttribute(entry.getKey())));
								
							}
    						
    						System.out.println("ID");

	        						switch (seleniumUI.getComboBoxesActions2(entry.getKey())) {
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
										elementID.sendKeys(seleniumUI.getaddActionInJTextField(entry.getKey()).getText());		
										if(seleniumUI.getSubmitRadioButtonsRule(entry.getKey())) {
											elementID.submit();
										}
		        						break;

									}
									default:
										throw new IllegalArgumentException("Unexpected value: " + seleniumUI.getComboBoxesActions2(entry.getKey()));
									}
	        						
	
    			
    			
    								break;
    					case "Name":
    					{
    						WebElement elementName;
							if(seleniumUI.getRadioButtonRules(entry.getKey())) {
								// Wait for an element to be visible
								elementName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(seleniumUI.getJTextFieldAttribute(entry.getKey()))));
							}else {
								elementName = driver.findElement(By.name(seleniumUI.getJTextFieldAttribute(entry.getKey())));
								
							}
    						System.out.println("Name");

	        						switch (seleniumUI.getComboBoxesActions2(entry.getKey())) {
									case "Click": {
										
										System.out.println(" Name Clicked.");
										elementName.click();
		        						break;
		        						}
									case "Move to element":
									{
	    								action.moveToElement(elementName).perform();								
		        						break;

									}
									case "Input text":
									{
										elementName.click();
										elementName.sendKeys(seleniumUI.getaddActionInJTextField(entry.getKey()).getText());		
										if(seleniumUI.getSubmitRadioButtonsRule(entry.getKey())) {
											elementName.submit();
										}
		        						break;

									}
									default:
										throw new IllegalArgumentException("Unexpected value: " + seleniumUI.getComboBoxesActions2(entry.getKey()));
									}
    					}			
	
    				break;
    					case "Class Name":
    					{

    						WebElement elementClassName;
    						if(seleniumUI.getRadioButtonRules(entry.getKey())) {
								// Wait for an element to be visible
	        					elementClassName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(seleniumUI.getJTextFieldAttribute(entry.getKey()))));
							}else {
								elementClassName = driver.findElement(By.className(seleniumUI.getJTextFieldAttribute(entry.getKey())));
								
							}
    						System.out.println("Name");

	        					
	        						switch (seleniumUI.getComboBoxesActions2(entry.getKey())) {
									case "Click": {
										
										System.out.println("Clicked.");
										elementClassName.click();
		        						break;
		        						}
									case "Move to element":
									{
	    								action.moveToElement(elementClassName).perform();								
		        						break;

									}
									case "Input text":
									{
										elementClassName.click();
										elementClassName.sendKeys(seleniumUI.getaddActionInJTextField(entry.getKey()).getText());		
										if(seleniumUI.getSubmitRadioButtonsRule(entry.getKey())) {
											elementClassName.submit();
										}
		        						break;

									}
									default:
										throw new IllegalArgumentException("Unexpected value: " + seleniumUI.getComboBoxesActions2(entry.getKey()));
									}
    					}		
    						break;

    					case "Xpath":
    					{
    						
    						System.out.println("");

	        					
	        					WebElement elementPath;
								if(seleniumUI.getRadioButtonRules(entry.getKey())) {
									// Wait for an element to be visible
									elementPath = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(seleniumUI.getJTextFieldAttribute(entry.getKey()))));
								}else {
									elementPath = driver.findElement(By.xpath(seleniumUI.getJTextFieldAttribute(entry.getKey())));
									
								}
	        					
	        						switch (seleniumUI.getComboBoxesActions2(entry.getKey())) {
									case "Click": {
										
										System.out.println("Xpath Clicked.");
										elementPath.click();
		        						break;
		        						}
									case "Move to element":
									{
	    								action.moveToElement(elementPath).perform();								
		        						break;

									}
									case "Input text":
									{
										elementPath.click();
										elementPath.sendKeys(seleniumUI.getaddActionInJTextField(entry.getKey()).getText());		
										if(seleniumUI.getSubmitRadioButtonsRule(entry.getKey())) {
											elementPath.submit();
										}
		        						break;

									}
									default:
										throw new IllegalArgumentException("Unexpected value: " + seleniumUI.getComboBoxesActions2(entry.getKey()));
									}
	        						
	
    					}
    					
    						break;

    					case "Css Selector":
    						if(seleniumUI.getjComboBoxActionString() == "Input text") {driver.findElement(By.cssSelector(seleniumUI.getFindElementBy().getText())).sendKeys();}
    						break;

    					case "Link Text": 
    					{
    						
        						
        					WebElement elementLinkTextElement;
							if(seleniumUI.getRadioButtonRules(entry.getKey())) {
								// Wait for an element to be visible
								elementLinkTextElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(seleniumUI.getJTextFieldAttribute(entry.getKey()))));
							}else {
								elementLinkTextElement = driver.findElement(By.linkText(seleniumUI.getJTextFieldAttribute(entry.getKey())));
							}	
							
    						System.out.println("Link Text");
    								switch (seleniumUI.getComboBoxesActions2(entry.getKey())) {
										case "Click": {
								
											elementLinkTextElement.click();
									   break;
										}
										case "Move to element":
										{
											action.moveToElement(elementLinkTextElement).perform();								

										}
										case "Input text":
										{
											elementLinkTextElement.click();
											elementLinkTextElement.sendKeys(seleniumUI.getaddActionInJTextField(entry.getKey()).getText());		
											if(seleniumUI.getSubmitRadioButtonsRule(entry.getKey())) {
												elementLinkTextElement.submit();
											}
			        						break;

										}
										default:
											throw new IllegalArgumentException("Unexpected value: " + seleniumUI.getComboBoxesActions2(entry.getKey()));
    								}
	        				
    								
   
    					}
    						break;
    					
    					case "Partial Link Text":
    					{
    						
    					
    						
    						System.out.println("Partial");
    							WebElement elementPartialLinkText;
    							if(seleniumUI.getRadioButtonRules(entry.getKey())) {
    								// Wait for an element to be visible
    	        					elementPartialLinkText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(seleniumUI.getJTextFieldAttribute(entry.getKey()))));
    							}else {
    								elementPartialLinkText = driver.findElement(By.partialLinkText(seleniumUI.getJTextFieldAttribute(entry.getKey())));
    							}
	        					
	        						switch (seleniumUI.getComboBoxesActions2(entry.getKey())) {
									case "Click": {
										
										System.out.println("Clicked.");
		        						elementPartialLinkText.click();
		        						break;
		        						}
									case "Move to element":
									{
	    								action.moveToElement(elementPartialLinkText).perform();								
		        						break;

									}
									case "Input text":
									{
										elementPartialLinkText.click();
										elementPartialLinkText.sendKeys(seleniumUI.getaddActionInJTextField(entry.getKey()).getText());		
										if(seleniumUI.getSubmitRadioButtonsRule(entry.getKey())) {
											elementPartialLinkText.submit();
										}
		        						break;

									}
									default:
										throw new IllegalArgumentException("Unexpected value: " + seleniumUI.getComboBoxesActions2(entry.getKey()));
									}
	        						
    					}
    				break;
    			default:
					throw new IllegalArgumentException("Unexpected value: " + seleniumUI.getComboBoxesFindByString(entry.getKey()));
					
				} //Switch
    		
    		
    		
    		} // for loop
    			
    	} // if condition
    		
				
			
     		
    	//for(; ;) {
       //}
    	  
    	} //while
		System.out.println("thread" + this.threadint + " is stopped..."); 
		/*driver.close(); //Closes current browser
		driver.quit(); // Closes all tab browsers opened by selenium script */
		
    	} // class
		
    
   	

    public void stopExecuting() {
        this.execute = false;
    }
}
