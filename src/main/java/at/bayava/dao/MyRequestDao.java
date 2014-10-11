package at.bayava.dao;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Created by pbayer on 10.10.2014.
 */
@Named
@RequestScoped
public class MyRequestDao{

	public String doStuff() {
		return "MyRequestDao does stuff!";
	}
}
