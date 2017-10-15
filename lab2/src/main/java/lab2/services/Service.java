package lab2.services;

import lab2.interfaces.IDbConector;
import lab2.models.Record;

public abstract class Service<T extends Record>{

	private IDbConector<T> conector;
	
	protected Service(IDbConector<T> con)
	{
		this.setConector(con);
	}

	public IDbConector<T> getConector() {
		return conector;
	}

	public void setConector(IDbConector<T> conector) {
		this.conector = conector;
	}
	
	public boolean exists(T rec)
	{
		for(T r : this.getConector().getAll())
		{
			if (r.getId() == rec.getId())
				return true;
		}
		return false;
	}
}
