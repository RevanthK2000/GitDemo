

import org.testng.Assert;
import org.testng.annotations.Test;

import Files.payLoad;
import io.restassured.path.json.JsonPath;

public class SumValidation {

	//Verify if Sum of all Course prices matches with Purchase Amount

	@Test
	
	public void sumOfCourses() {
		int sum = 0;
		JsonPath js = new JsonPath(payLoad.CoursePrice());
		int count =	js.getInt("courses.size()");
		for(int i=0; i<count; i++) {
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			int amount = price * copies;
			System.out.println(amount);
			sum = sum + amount;
					}
		System.out.println(sum);
		int purchaseAmount = js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(sum, purchaseAmount);
		System.out.println("First Comment");
		
		System.out.println("NEW BRANCH");
		System.out.println("Total Sum = "+sum);

                System.out.println("Second NEW BRANCH");
                 System.out.println("Third NEW BRANCH");
		

		
	}
}
