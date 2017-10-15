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
	
	public List<Film> findByExpression(Pattern p)
	{
		List<Film> res = new ArrayList<Film>();
		boolean add = false;
		
		for(Film f : this.getConector().getAll())
		{
			if (f.match(p))
				res.add(f);
		}
		
		return res;
	}
	
	public boolean removeList(List<Film> list) throws RecordNotFoundException
	{
		boolean ret = true;
		
		for(Film f : list)
		{
			if (!this.exists(f))
				throw new RecordNotFoundException();
		}
		
		
		return ret;
	}
}
