package lab3.interfaces;
import lab3.models.Record;

public interface IService<T extends Record> {

	public IDbConector<T> getConector();

	public void setConector(IDbConector<T> conector);
}
