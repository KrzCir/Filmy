package lab2.models;

import java.util.regex.Pattern;

import lab2.enums.Genres;

public class Film extends Record {

	private Genres Genre;
	private String Title;
	private String Production;
	private String Direction;

	public boolean match(Pattern p)
	{
		boolean res = false;
		
		if (!res)
			res = p.matcher(""+this.getId()).matches();
		
		if (!res)
			res = p.matcher(this.getTitle()).matches();
		
		if (!res)
			res = p.matcher(this.getDirection()).matches();
		
		if (!res)
			res = p.matcher(this.getProduction()).matches();
		
		if (!res)
			res = p.matcher(this.getGenre().toString()).matches();
		
		if (!res)
			res = super.match(p);
		
		return res;
	}
	
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
