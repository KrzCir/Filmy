package lab2.interfaces;

import java.util.List;
import lab2.models.Record;
import lab2.exceptions.*;

public interface IDbConector <T extends Record> {

	public void insert(T rec);
	public void delete(T rec) throws RecordNotFoundException;
	public void update(T rec) throws RecordNotFoundException;
	public List<T> getAll();
}
