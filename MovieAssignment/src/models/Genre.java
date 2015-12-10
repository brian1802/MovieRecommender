package models;

import java.io.File;

import edu.princeton.cs.introcs.In;

public class Genre{
	
	private int genreID;
	private String genreName;
	
	public Genre(String genreName, int genreID){
		this.genreID = genreID;
		this.genreName = genreName; 
	}

	/**
	 * @return the genreID
	 */
	public int getGenreID() {
		return genreID;
	}

	/**
	 * @param genreID the genreID to set
	 */
	public void setGenreID(int genreID) {
		this.genreID = genreID;
	}

	/**
	 * @return the genreName
	 */
	public String getGenreName() {
		return genreName;
	}

	/**
	 * @param genreName the genreName to set
	 */
	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}
}