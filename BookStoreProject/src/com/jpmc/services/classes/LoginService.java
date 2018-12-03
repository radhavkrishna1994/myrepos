package com.jpmc.services.classes;

import com.jpmc.bean.User;
import com.jpmc.dao.classes.LoginDao;
import com.jpmc.dao.interfaces.LoginDaoI;
import com.jpmc.services.interfaces.LoginServiceI;

public class LoginService implements LoginServiceI {
	private LoginDaoI loginDao;

	@Override
	public User validateUser(User user) {
		loginDao=new LoginDao();
		return loginDao.validateUser(user);
	}

}
