package lab4.services;

import lab4.interfaces.IDbConector;
import lab4.interfaces.IService;
import lab4.models.Record;

public abstract class Service<T extends Record> implements IService<T> {

	protected IDbConector<T> conector;

	protected Service(IDbConector<T> con) {
		this.setConector(con);
	}

	public IDbConector<T> getConector() {
		return conector;
	}

	public void setConector(IDbConector<T> conector) {
		this.conector = conector;
	}

	public boolean exists(T rec) {
		for (T r : this.getConector().getAll()) {
			if (r.getId() == rec.getId())
				return true;
		}
		return false;
	}

}
