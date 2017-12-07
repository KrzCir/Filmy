package lab5.services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import lab5.exceptions.RecordNotFoundException;
import lab5.interfaces.IDbConector;
import lab5.interfaces.IFilmService;
import lab5.models.Film;

public class FilmService extends Service<Film> implements IFilmService {

	public FilmService(IDbConector<Film> con) {
		super(con);
	}

	@Override
	public Film findByTitle(String title) {
		for (Film f : this.getConector().getAll()) {
			if (f.getTitle() == title)
				return f;
		}
		return null;
	}

	public Film findByExpression(String expression) throws RecordNotFoundException {
		Pattern p = Pattern.compile(expression);
		Film res = null;

		for (Film f : this.conector.getAll()) {
			if (f.match(p))
				res = f;
		}

		if (res==null)
			throw new RecordNotFoundException();
			
		return res;
	}

	public void removeList(List<Film> list) throws RecordNotFoundException {
		for (Film f : list) {
			this.getConector().delete(f);
		}
	}
}
