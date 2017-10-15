package lab2.interfaces;

import java.util.List;

public interface IService <T> {

	public T insert(T rec);
	public boolean delete(T rec);
	public void update(T rec);
	public T find(int Id);
	
	public List<T> records();
}
