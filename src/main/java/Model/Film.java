package Model;

import Enums.Genres;

public class Film extends Record {
	 
	private Genres Genre;
	private String Title;
	private String Production;
	private String Direction;
	
	// Generate Getters and Setters
	public String getDirection() {
		return Direction;
	}
	public void setDirection(String direction) {
		Direction = direction;
	}
	public String getProduction() {
		return Production;
	}
	public void setProduction(String production) {
		Production = production;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public Genres getGenre() {
		return Genre;
	}
	public void setGenre(Genres genre) {
		Genre = genre;
	}
}
