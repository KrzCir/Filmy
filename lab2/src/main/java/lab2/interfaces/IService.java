package lab2.interfaces;
import lab2.models.Record;

public interface IService<T extends Record> {

	public IDbConector<T> getConector();

	public void setConector(IDbConector<T> conector);
}
