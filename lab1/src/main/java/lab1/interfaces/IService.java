package lab1.interfaces;

import java.util.List;
import lab1.exceptions.RecordNotFoundException;

public interface IService <T> {

	public T insert(T rec);
	public void delete(T rec) throws RecordNotFoundException;
	public void update(T rec) throws RecordNotFoundException;
	public T find(int Id) throws RecordNotFoundException;
	
	public T findFirst();
	
	public List<T> records();
}
