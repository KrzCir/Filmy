package lab4.interfaces;

import java.util.List;

import lab4.exceptions.*;
import lab4.models.Record;

public interface IDbConector <T extends Record> {

	public void insert(T rec);
	public void delete(T rec) throws RecordNotFoundException;
	public void update(T rec) throws RecordNotFoundException;
	public List<T> getAll();
	public T get(int id) throws RecordNotFoundException;
	public T get(String expression) throws RecordNotFoundException;
}
