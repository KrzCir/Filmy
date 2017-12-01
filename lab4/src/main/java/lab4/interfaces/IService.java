package lab4.interfaces;
import lab4.models.Record;

public interface IService<T extends Record> {

	public IDbConector<T> getConector();

	public void setConector(IDbConector<T> conector);
}
