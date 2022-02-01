package TestNgPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BookTicket {

	@Test(dataProvider = "dataProvider_bookTicketTest")
	
	public void bookTicketTest(String src , String dest)
	{
		System.out.println("book ticket from "+ src +" to "+dest);
	}
	@DataProvider
	public Object[][] dataProvider_bookTicketTest(){
	Object[][] objArr = new Object[5][2];
	

	objArr[0][0]="bangalore";
	objArr[0][1]="goa";
	
	objArr[1][0]="bangalore";
	objArr[1][1]="mysore";
	
	objArr[2][0]="bangalore";
	objArr[2][1]="pune";
	
	objArr[3][0]="bangalore";
	objArr[3][1]="hyderabad";
	
	objArr[4][0]="bangalore";
	objArr[4][1]="delhi";
	
	return objArr;
	
		
	}
	
	
	
	
	
}



