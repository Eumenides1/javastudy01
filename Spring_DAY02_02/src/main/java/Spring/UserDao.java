package Spring;

public class UserDao implements IUserDao {

	public void insert() {
		System.out.println("UserDao.insert() -> 开始");
		System.out.println("UserDao.insert() -> 结束");
	}
	
}