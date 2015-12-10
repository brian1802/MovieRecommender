package models;

import java.util.ArrayList;


public class Movie implements Comparable<Movie>{
	
	private String title, url, year;
	private int movieID;
	private double totalRating;
	private ArrayList<Genre> genre;
	
	
	public Movie(int movieID, String title, String year, String url, ArrayList genre){
		
		this.title = title;
		this.url = url;
		this.year = year;
		this.movieID = movieID;
		this.genre = genre;
		
	}
	
	/**
	 * The method will determine if the total rating is higher or lower than 
	 * the next rating for the next movie. 
	 */
	public int compareTo(Movie compare){
		if(this.totalRating < compare.getTotalRating()){
			return -1;
		}
		if(this.totalRating > compare.getTotalRating()){
			return 1;
		}
		return 0;
	}
	public int compareTo(Movie compare){
		if(this.totalRating < compare.getTotalRating()){
			return 1;
		}
		if(this.totalRating > compare.getTotalRating()){
			return -1;
		}
		return 0;
	}
	
	/**
	 * gets the movie title
	 * @return
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * sets the movie title
	 * @param title
	 */
	public void setTitle(String title){
		this.title = title;
	}
	
	/**
	 * gets the URL
	 * @return
	 */
	public String getUrl(){
		return url;
	}
	
	/**
	 * sets the URL
	 * @param url
	 */
	public void setUrl(String url){
		this.url = url;
	}
	
	/**
	 * gets the year the movie was created.
	 * @return
	 */
	public String getYear(){
		return year;
	}
	
	/**
	 * sets the year
	 * @param year
	 */
	public void setYear(String year){
		this.year = year;
	}
	
	/**
	 * gets the movie ID
	 * @return
	 */
	public int getMovieID(){
		return movieID;
	}
	
	/**
	 * sets the movie ID
	 * @param movieID
	 */
	public void setMovieID(int movieID){
		this.movieID = movieID;
	}
	/**
	 * gets the totlal rating on a movie
	 * @return
	 */
	public double getTotalRating(){
		return totalRating;
	}
	
	/**
	 * sets the total rating
	 * @param totalRating
	 */
	public void setTotalRating(double totalRating){
		this.totalRating = totalRating;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", url=" + url + ", year=" + year
				+ ", movieID=" + movieID + ", totalRating=" + totalRating
				+ ", genre=" + genre + "]";
	}
}
