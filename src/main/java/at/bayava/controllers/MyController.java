package at.bayava.controllers;

import at.bayava.dao.MyDao;

import javax.inject.Inject;

/**
 * Created by pbayer.
 */
public class MyController {

	@Inject
	MyDao dao;

	/**
	 * makes the dao do stuff
	 *
	 * @return the result of MyDao.doStuff()
	 */
	public String makeDaoDoStuff() {
		return dao.doStuff();
	}
}
