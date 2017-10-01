package Abstract;

import Model.Record;

public interface IService {

	public void Add(Record rec);
	public void Delete(Record rec);
	public void Update(Record rec);
	public Record Get(int Id);
}
