package lab2.interfaces;

import java.util.List;
import java.util.regex.Pattern;
import lab2.exceptions.RecordNotFoundException;

import lab2.models.Film;;

public interface IFilmService {
	public Film findByTitle(String title);
	public List<Film> findByExpression(Pattern p);
	public boolean removeList(List<Film> list) throws RecordNotFoundException;
}
