package lab2.services;

import java.util.ArrayList;
import java.util.List;

import lab2.interfaces.IService;
import lab2.models.Record;

public abstract class Service<T extends Record> implements IService<T> {

	protected List<T> cache = null;
	protected int currentId =0;
	protected int numOfRecords = 0;
	
	protected Service()
	{
		this.cache = new ArrayList<T>();
		this.numOfRecords = 0;
	}
	
	public T insert(T rec)
	{
		rec.setId(this.currentId++);
		cache.add(rec);
		numOfRecords++;
		return rec;
	}
	
	public boolean delete(T rec)
	{
		if (rec.getId() >= 0 && rec.getId() <= this.currentId)
		{
			this.cache.remove(rec.getId());
			numOfRecords--;
			return true;
		}
		return false;
	}
	
	public void update(T rec)
	{
		this.cache.set(rec.getId(), rec);
	}
	
	public T find(int Id)
	{	
		T res = null;
		try
		{
			res = (Id > currentId) ? null : cache.get(Id);
		}
		catch (java.lang.IndexOutOfBoundsException e)
		{
			res = null;
		}
		return res;
	}
	
	public List<T> records()
	{
		return cache;
	}
}
