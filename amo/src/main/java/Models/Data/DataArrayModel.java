package Models.Data;

import java.util.ArrayList;


/**
 * 
 * @author amrkh
 *
 *A generic class to be the container of all our ArrayLists to be sent
 *as objects instead of ArrayLists.
 *
 *
 * @param <T>
 */
public class DataArrayModel<T> {

	private ArrayList<T> _ArrayList;

	public ArrayList<T> get_ArrayList() {
		return _ArrayList;
	}

	public void set_ArrayList(ArrayList<T> _ArrayList) {
		this._ArrayList = _ArrayList;
	}
	
}
