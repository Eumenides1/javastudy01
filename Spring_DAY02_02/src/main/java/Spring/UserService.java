package Spring;

public class UserService {
	
	// 声明类型为UserDao的属性
	// 这个属性不需要赋值
	// 推荐使用userDao作为属性的名称
	// 当习惯了这样的命名之后
	// 相关配置也使用相同的命名风格
	// 则便于统一，不容易出错
	private IUserDao userDao;
	
	// 与属性名称匹配的SET方法
	// 后续Spring会自动调用该方法为属性赋值
	public void setUserDao(IUserDao userDao) {
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
