package lab4.services;

import java.util.ArrayList;
import java.util.List;

import lab4.exceptions.RecordNotFoundException;
import lab4.interfaces.IDbConector;
import lab4.models.Record;

public class DbConector implements IDbConector<Record> {

	protected List<Record> cache = null;
	private int currentId;
	private int numOfRecords;
	
	public DbConector() {
		cache = new ArrayList<Record>();
		this.numOfRecords = 0;
		this.currentId = 1;
	}
	
	@Override
	public void insert(Record rec) {
		rec.setId(this.currentId);
		cache.add(rec);
		this.numOfRecords++;
		this.currentId++;
	}

	@Override
	public void delete(Record rec) throws RecordNotFoundException {
		cache.remove(rec.getId());
		this.numOfRecords--;
	}

	@Override
	public void update(Record rec) throws RecordNotFoundException {
		this.cache.set(rec.getId(), rec);
	}

	@Override
	public List<Record> getAll() {
		return this.cache;
	}

	@Override
	public Record get(int id) throws RecordNotFoundException {
		return this.cache.get(id);
	}

	@Override
	public Record get(String expression) throws RecordNotFoundException {
		return null;
	}
}
