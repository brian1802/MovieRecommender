package models;

public class Rating {

	private int userID, movieID, rating;
	
	public Rating(int userID, int movieID, int rating){
		
		this.userID = userID;
		this.movieID = movieID;
		this.rating = rating;
		
	}
	
	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * @return the movieID
	 */
	public int getMovieID() {
		return movieID;
	}

	/**
	 * @param movieID the movieID to set
	 */
	public void setMovieID(int movieID) {
		this.movieID = movieID;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Rating [userID=" + userID + ", movieID=" + movieID
				+ ", rating=" + rating + "]";
	}
}