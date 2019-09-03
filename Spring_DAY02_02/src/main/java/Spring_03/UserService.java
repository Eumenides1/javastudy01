package Spring_03;


public class UserService {
	

	private UserDao userDao;
	
	// 与属性名称匹配的SET方法
	// 后续Spring会自动调用该方法为属性赋值
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	// 模拟调用Dao工作的方法
	public void reg() {
		// 日志
		System.out.println("UserService.reg()");
		// 调用Dao工作
		userDao.insert();
	}

}
