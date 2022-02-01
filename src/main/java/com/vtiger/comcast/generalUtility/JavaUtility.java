package com.vtiger.comcast.generalUtility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Date;
import java.util.Random;

/**
 *This class contains java specific generic libraries
 * @author puneeth
 *
 */

public class JavaUtility {
	
	private Random ranDom;
	/**
	 * It is used to generate the integer Random number with in the boundary of 0 to 1000
	 * @return intData
	 */
public int getRandomNumber() {
	 Random ranDom = new Random();
	 int ranDomNum = ranDom.nextInt(10000);
	 return ranDomNum;

}
/**
 * It is used to get the current System date and time
 * @return
 */
public String getSystemDate()
{
	 Date date = new Date();
	String systemDateandTime = date.toString();
	return systemDateandTime;		
}
/**
 * It is used to get the current System date with YYYY-MM-DD formate
 * @return
 * 
 */

public String getSystemDate_YYYY_MM_DD()
{
	Date date = new Date();
	String systemDateandTime = date.toString();
	System.out.println(systemDateandTime);
	String[] arr = systemDateandTime.split("");
	String DD= arr[2];
	String YYYY = arr[5];
	int MM = date.getMonth()+1;
	
	String finalFormat = YYYY+"-"+MM+"-"+DD;
	return finalFormat;	
}
/**
 * used to pass Virtual Key to OS
 * @throws Throwable
 */
public void pressVirtualEnterKey() throws Throwable
{
Robot rc = new Robot();
rc.keyPress(KeyEvent.VK_ENTER);
rc.keyRelease(KeyEvent.VK_ENTER);
}
public String getRandomData() {
	// TODO Auto-generated method stub
	return null;
}

}