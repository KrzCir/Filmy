package lab2.interfaces;

import java.util.List;
import java.util.regex.Pattern;
import lab2.exceptions.RecordNotFoundException;

import lab2.models.Film;;

public interface IFilmService extends IService<Film> {
	public Film findByTitle(String title);
	public Film findByExpression(String expression) throws RecordNotFoundException;
	public void removeList(List<Film> list) throws RecordNotFoundException;
}
