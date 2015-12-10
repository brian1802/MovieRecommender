package Controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import utils.Serializer;
import models.Genre;
import models.Movie;
import models.Rating;
import models.User;
import edu.princeton.cs.introcs.In;

public class RecommenderAPI{

	private ArrayList<User> users;
	private ArrayList<Movie> movies;
	private ArrayList<Rating>rateings;
	private ArrayList<Genre>genres; 
	private Serializer serializer;
	
	public RecommenderAPI() throws Exception{
		
		users = new ArrayList<>();
		rateings = new ArrayList<>();	
		movies = new ArrayList<>();
		genres = new ArrayList<>();
		readData();
		averageRating();
		serializer = serializer;
		
		}
	
/*	public void movie(){
		CSVLoader loader = new CSVLoader();
		List<>
	}*/
	/**
	 * Gets the array of users. 
	 * @return
	 */
	public ArrayList<User> getUsers() {
		return users;
	}
	
	/*public void setUsers(ArrayList<Users> users) {
		this.users = users;
	}*/
	
	public static void main (String args[]) throws Exception{
		RecommenderAPI app = new RecommenderAPI();
	}
	/**
	 * Reads the external data from a file and adds it to an array.
	 * @throws Exception
	 */
	public void readData() throws Exception{
		
		 File genre = new File("moviedata_small (2)/genre.dat");
		    In inGenre = new In(genre);
		    //each field is separated(delimited) by a '|'
		    String delims3 = "[|]";
		    while (!inGenre.isEmpty()) {
		         // get user and rating from data source
	           String genreDetails = inGenre.readLine();

		            // parse user details string
		            String[] genreTokens = genreDetails.split(delims3);

		            genres.add(new Genre(genreTokens[0], Integer.parseInt(genreTokens[1])));
		    }
		
		File usersFile = new File("moviedata_small (2)/users5.dat");
	    In inUsers = new In(usersFile);
	    //each field is separated(delimited) by a '|'
	    String delims = "[|]";
	    while (!inUsers.isEmpty()) {
	         // get user and rating from data source
           String userDetails = inUsers.readLine();

	            // parse user details string
	            String[] userTokens = userDetails.split(delims);

	            // output user data to console.
	            if (userTokens.length == 7) {
	                users.add(new User(Integer.parseInt(userTokens[0]),userTokens[1],userTokens[2],
	                		Integer.parseInt(userTokens[3]),userTokens[4],userTokens[5]));
	            }else
	            {
	                throw new Exception("Invalid member length: "+userTokens.length);
	            }
	        }
	    
	    
	    File Movies = new File("moviedata_small (2)/items5.dat");
	    In inMovie = new In(Movies);
	    //each field is separated(delimited) by a '|'
	    String delims1 = "[|]";
	    ArrayList<String> catagory = new ArrayList<String>();
	    
	    while (!inMovie.isEmpty()) {
	    	catagory = new ArrayList<String>();
	         // get user and rating from data source
           String movieDetails = inMovie.readLine();

	            // parse user details string
	            String[] movieTokens = movieDetails.split(delims1);

	            // output user data to console.
	            	for(int i=4; i<23; i++){
	            		if(trueOrFalse(Integer.parseInt(movieTokens[i])) == true){
	            			String str = genres.get(i-4).getGenreName();
	            			catagory.add(str);
	            		}
	            	}
	                movies.add(new Movie(Integer.parseInt(movieTokens[0]),movieTokens[1],movieTokens[2],
	                		movieTokens[3], catagory));
	    }
	    
	    File Ratings = new File("moviedata_small (2)/ratings5.dat");
	    In inRatings = new In(Ratings);
	    //each field is separated(delimited) by a '|'
	    String delims2 = "[|]";
	    while (!inRatings.isEmpty()) {
	         // get user and rating from data source
           String ratingDetails = inRatings.readLine();

	            // parse user details string
	            String[] ratingTokens = ratingDetails.split(delims2);

	            // output user data to console.
	            if (ratingTokens.length == 4) {
	                rateings.add(new Rating(Integer.parseInt(ratingTokens[0]),Integer.parseInt(ratingTokens[1]),
	                		Integer.parseInt(ratingTokens[2])));
	            }else
	            {
	                throw new Exception("Invalid member length: "+ratingTokens.length);
	            }
	    }
	}
	/**
	 * If i = 1 then the category is true and is assigned to that movie.
	 * if i = 0 then the category is not added to the movie. 
	 * @param i
	 * @return
	 */
	public boolean trueOrFalse(int i){
		if(i == 1){
			return true;
		}else
			return false;
	}
	
	/**
	 * This method adds a user to the array list Users.
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param gender
	 * @param occupation
	 */
	public void addUser(int userID, String firstName, String lastName, int age, String gender, String occupation){
	
	users.add(new User(userID, firstName, lastName, age, gender, occupation));
	
	}
	
	/**
	 * Removes a user from the array list.
	 */
	public void removeUser(int userID){
		
		users.remove(userID-1);
	
	}
	
	/**
	 * Adds a Movie to the ArrayList movies
	 */
	public void addMovie(int movieID, String title, String year, String url, ArrayList category){
		
		movies.add(new Movie(movieID, title, year, url, category));
	
	}
	
	/**
	 * Gets the detailes of a movie 
	 * @param movieID
	 */
	public String getMovie(int i){	
		return movies.get(i).toString();
	}

	/**
	 * add a rating to the arraylist ratings
	 * @param userID
	 * @param movieID
	 * @param rating
	 */
	public void addRating(int userID, int movieID, int rating){
		
		rateings.add(new Rating(userID, movieID, rating));

	}
	
	/**
	 * gets the Ratings based off the user ID
	 * @param i
	 */
	public void getUserRatings(int i){
		for(Rating currentRating : rateings){
			if(i == currentRating.getUserID()){
			System.out.println(currentRating);
			}
		}
	}
	
	/**
	 * gets the average of the ratings for a movie
	 */
	public void averageRating(){
	for(int i = 0; i<movies.size(); i++){
		int count = 0;
		double avgRating = 0; //The Average Rating For each movie
		for(int j = 0; j < rateings.size(); j++){
			if(movies.get(i).getMovieID() == rateings.get(j).getMovieID()){
				count++;
				avgRating += rateings.get(j).getRating();
				}
			}
		movies.get(i).setTotalRating(avgRating/count);
	  	}
	}
	
	/**
	 * Sorts the movies based on the average rating. 
	 * Then will print out the top 1 movies. 
	 */
	public void getTopTenMovies(){
		Collections.sort(movies);
		for(int i = 0; i < 10; i++){
			System.out.println(movies.get(i).toString());
		}
	}
	
	public void getUserRecommendations(int userID){
		
	}
	
	/**
	 * Reads in the data from the serializer and 
	 * populates the arrays. 
	 * @throws Exception
	 */
	public void load() throws Exception{
		serializer.read();
		movies = (ArrayList<Movie>) serializer.pop();
		users = (ArrayList<User>) serializer.pop();
		rateings = (ArrayList<Rating>) serializer.pop();
		User.counter = (Long) serializer.pop();
	}
	
	/**
	 * Pushes the serializer to a stack of the array. 
	 * @throws Exception
	 */
	public void store() throws Exception{
		serializer.push(movies);
		serializer.push(users);
		serializer.push(rateings);
		serializer.write();
	}

}	