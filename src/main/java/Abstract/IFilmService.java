package Abstract;

import Model.Film;

public interface IFilmService extends IService {
	
	public Film Get(String title);
}
