package testAcademy;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_Annotations {
	
	
	@Test
	public void Atest() {
		System.out.println("A");
	}
	
	@Test(dataProvider = "testa")
	public void atest(String obj) {
		System.out.println("a");
		//System.out.println(obj);
	}
	
	@Test(dependsOnMethods = {"Atest", "atest"})
	public void btest() {
		System.out.println("b");
		
	}
	
	@DataProvider(name = "testa")
	public Object[][] getData(){
		
		Object[][] data = new Object[1][1];
		
		data[0][0] = "testing Data";
		
		return data;
	}

}
