package lab2.interfaces;

import lab2.models.Film;

public interface IFilmService extends IService<Film> {
	
	public Film find(String title);
}
