package lab5.interfaces;
import lab5.models.Record;

public interface IService<T extends Record> {

	public IDbConector<T> getConector();

	public void setConector(IDbConector<T> conector);
}
