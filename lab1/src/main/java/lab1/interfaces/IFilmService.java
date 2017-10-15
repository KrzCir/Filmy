package lab1.interfaces;

import lab1.models.Film;

public interface IFilmService extends IService<Film> {
	
	public Film find(String title);
}
