
import Files.payLoad;
import io.restassured.path.json.JsonPath;

public class ComplexParseJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js = new JsonPath(payLoad.CoursePrice());

		 //Print No of courses returned by API
		
	int count =	js.getInt("courses.size()");
	System.out.println(count);
	
	//Print Purchase Amount
	
	int totalAmount = js.getInt("dashboard.purchaseAmount");
	System.out.println(totalAmount);
	
	//Print Title of the first course
	
	String firstCourseTitle = js.getString("courses[0].title");
	
System.out.println(firstCourseTitle);

	 //Print All course titles and their respective Prices

for(int i=0; i<count; i++)
{
	//String courseTitles = js.get("courses["+i+"].title");
	//int coursePrices = js.getInt("courses["+i+"].price");
	//System.out.println(courseTitles + coursePrices);
	//System.out.println(courseTitles);
	System.out.println(js.get("courses["+i+"].title").toString());
	System.out.println(js.get("courses["+i+"].price").toString());
}

//Print no of copies sold by RPA Course

System.out.println("Print no of copies sold by RPA Course");
for(int i=0; i<count; i++)
{
	String courseTitles = js.get("courses["+i+"].title");
	if(courseTitles.equalsIgnoreCase("RPA")) {
		int copies = js.get("courses["+i+"].copies");
		System.out.println(copies);
		break;
		
	}
	
}



/*for(int i=0; i<count; i++) {
	System.out.println(js.get("courses["+i+"].copies").toString());
}*/
//System.out.println(js.get("courses[2].copies").toString());


		
	}

}
