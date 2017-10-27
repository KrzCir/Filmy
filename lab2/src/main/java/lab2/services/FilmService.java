package lab2.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import lab2.exceptions.RecordNotFoundException;
import lab2.interfaces.IDbConector;
import lab2.interfaces.IFilmService;
import lab2.models.Film;

public class FilmService extends Service<Film> implements IFilmService{

	public FilmService(IDbConector<Film> con)
	{
		super(con);
	}

	@Override
	public Film findByTitle(String title) {
		for(Film f : this.getConector().getAll())
		{
			if (f.getTitle() == title)
				return f;
		}
		return null;
	}
	
	public Film findByExpression(String expression) throws RecordNotFoundException
	{
		Pattern p = Pattern.compile(expression);
		Film res = null; 
		
		for( Film f : this.conector.getAll())
		{
			if (f.match(p))
				res = f;
		}
		
		return res;
	}
	
	public void removeList(List<Film> list) throws RecordNotFoundException
	{
		for(Film f : list)
		{
			this.getConector().delete(f);
		}
	}
}
