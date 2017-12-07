package lab5.interfaces;

import java.util.List;
import java.util.regex.Pattern;

import lab5.exceptions.RecordNotFoundException;
import lab5.models.Film;;

public interface IFilmService extends IService<Film> {
	public Film findByTitle(String title);
	public Film findByExpression(String expression) throws RecordNotFoundException;
	public void removeList(List<Film> list) throws RecordNotFoundException;
}
