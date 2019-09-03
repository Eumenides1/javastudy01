package Spring;

import org.springframework.stereotype.Component;

/**
 * @author Eumenides
 */
//组件注解
@Component("userDao")
public class UserDaoImpl implements IUserDao{

    public void insert(){
        System.out.println("UserDao.insert()");
    }
}
