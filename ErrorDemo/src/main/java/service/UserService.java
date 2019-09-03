package service;

import dao.UserDao;
import vo.UserInfo;

public class UserService {
	private static UserService instance;

	public synchronized static UserService getInstance() {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}

	private UserService() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * �����˺Ż�ȡ�û���Ϣ
	 * 
	 * @param account
	 * @return
	 */
	public UserInfo findUserByAccount(String account) {
		return UserDao.getInstance().findByAccount(account);
	}
}
