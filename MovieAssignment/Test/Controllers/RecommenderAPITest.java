package Controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import models.User;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecommenderAPITest 
{
	private RecommenderAPI recommender;

/*	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}*/

	@Before
	public void setUp() throws Exception {
		recommender = new RecommenderAPI();
		 for (User user : recommender.getUsers()){
			  recommender.getUsers().add(new User(user.userID, user.firstName, user.lastName, user.age, user.gender, user.occupation));
		 }
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
