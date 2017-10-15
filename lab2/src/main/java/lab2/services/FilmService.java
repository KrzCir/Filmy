package lab2.services;

import lab2.interfaces.IFilmService;
import lab2.models.Film;

public class FilmService extends Service<Film> implements IFilmService {

	public Film find(String title) {
		for(Film f : cache)
		{
			if (f.getTitle() == title)
				return f;
		}		
		return null;
	}
}
