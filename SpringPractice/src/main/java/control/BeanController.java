package control;

import data.TestDao;

public class BeanController {
	//were going to ask spring to create this for us
	private TestDao testDao;
	
	public void callDao() 
	{
		testDao.go();
	}

	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}

	
}
