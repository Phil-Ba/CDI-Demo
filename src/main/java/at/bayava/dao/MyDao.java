package at.bayava.dao;

import javax.inject.Named;

/**
 * Created by pbayer on 10.10.2014.
 */
@Named
public class MyDao {

	public String doStuff(){
		String retValue = "MyDao does stuff!";
		return retValue;
	}

}
