package lab1.services;

import lab1.interfaces.IFilmService;
import lab1.models.Film;

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
