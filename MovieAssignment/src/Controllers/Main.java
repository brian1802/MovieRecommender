package Controllers;

import java.util.ArrayList;

import models.Movie;
import asg.cliche.Command;
import asg.cliche.Param;
import asg.cliche.Shell;
import asg.cliche.ShellFactory;

public class Main
{
	private RecommenderAPI recAPI;
	
	public Main() throws Exception{
		recAPI = new RecommenderAPI();
	}
	
	/**
	 * Command what calls the add users method and adds
	 * a user to the users arrayList.
	 * @param userID
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param gender
	 * @param occupation
	 */
	@Command(description="Add a new User")
	public void addUser (@Param(name="userID") int userID, @Param(name="first name") String firstName,
			@Param(name="last name") String lastName,@Param(name="age") int age, @Param(name="gender") String gender, 
			@Param(name="occupation") String occupation)
	{
		recAPI.addUser(userID, firstName, lastName, age, gender, occupation);
	}

	/**
	 * removes a user form the users arrayList.
	 * @param userID
	 */
	@Command(description="Delete a User")
	public void removeUser (@Param(name="usarID") int userID)
	{
		recAPI.removeUser(userID);
	}
	
	/**
	 * calls the the add movie method to add a movie 
	 * to the movies ArrayList
	 * @param movieID
	 * @param title
	 * @param year
	 * @param url
	 * @param category
	 */
	@Command(description="Add a Movie")
	public void addMovie (@Param(name="movieID") int movieID, @Param(name="title") String title, @Param(name="year") String year,
			@Param(name="url") String url, @Param(name="Category") ArrayList category)
	{
		recAPI.addMovie(movieID, title, year, url, category);
	}
	
	/**
	 * prints out the movie arrad based on the movieID
	 * @param movieID
	 */
	@Command(description="get movie detales")
	public void getMovie(@Param(name="movieID") int movieID)
	{
		System.out.println(recAPI.getMovie(movieID));
	}
	
	/**
	 * adds a rating to the rateings ArrayList. 
	 * @param userID
	 * @param movieID
	 * @param rating
	 */
	@Command(description="adds a Rating")
	public void addRating(@Param(name="userID") int userID, @Param(name="movieID") int movieID, @Param(name="rating") int rating)
	{
		recAPI.addRating(userID, movieID, rating);
	}
	
	/**
	 * gets the ratings based on the userID
	 * @param userID
	 */
	@Command(description="get a movie rating")
	public void getRating(@Param(name="userID") int userID)
	{
		recAPI.getUserRatings(userID);
	}
	
	/**
	 * Gets the top 10 movies based on the average rating
	 */
	@Command(description="get the top 10 movies")
	public void getTopTenMovies()
	{
		recAPI.getTopTenMovies();
	}
	
	/**
	 * gets recommendations based on the users ratings. 
	 * @param userID
	 */
	@Command(description="Get recomandations based on the users ratings")
	public void getUserRecommendations(@Param(name="userID") int userID){
		recAPI.getUserRecommendations(userID);	//Dose not work because the UserRecommendations method is empty
	}
	
	public static void main(String[] args) throws Exception
	{
		Main main = new Main();
		Shell shell = ShellFactory.createConsoleShell("mR", "Welcome to movie Recommender - ?help for instructions", main);
		shell.commandLoop();
		main.recAPI.store();
	}
}