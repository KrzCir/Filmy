package lab1.interfaces;

import java.util.List;

public interface IService <T> {

	public void insert(T rec);
	public void delete(T rec);
	public void update(T rec);
	public T find(int Id);
	
	public List<T> records();
}
