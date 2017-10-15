package lab1.services;

import java.util.ArrayList;
import java.util.List;

import lab1.models.Record;
import lab1.exceptions.RecordNotFoundException;
import lab1.interfaces.IService;

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
	
	public boolean correctId(int Id)
	{
		return (Id >= 0 && Id <= this.currentId);
	}
	
	public void delete(T rec) throws RecordNotFoundException
	{
		if (this.correctId(rec.getId()))
		{
			this.cache.remove(rec.getId());
			numOfRecords--;
		}
		else
			throw new RecordNotFoundException();
	}
	
	public void update(T rec) throws RecordNotFoundException
	{
		if (this.correctId(rec.getId()))
		{
			this.cache.set(rec.getId(), rec);
		}
		else
			throw new RecordNotFoundException();
	}
	
	public T find(int Id) throws RecordNotFoundException
	{	
		T res = null;
		if (this.correctId(Id))
		{
			try
			{
				res = cache.get(Id);
			}
			catch (java.lang.IndexOutOfBoundsException e)
			{
				res = null;
			}
		}
		else
			throw new RecordNotFoundException();

		return res;
	}
	
	public List<T> records()
	{
		return cache;
	}
	
	public T findFirst()
	{
		for(T t : cache)
		{
			return t;
		}
		return null;
	}
}
