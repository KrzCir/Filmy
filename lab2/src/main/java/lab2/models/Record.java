package lab2.models;

import java.util.regex.Pattern;

public abstract class Record {
	private int Id;

	public boolean match(Pattern p)
	{
		return p.matcher(""+this.getId()).matches();
	}
	
	// Generate Getters and Setters
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
}
