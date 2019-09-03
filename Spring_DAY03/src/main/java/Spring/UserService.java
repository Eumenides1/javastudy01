package Spring;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Eumenides
 */
@Component
public class UserService {

    @Resource(name = "userDao")
    private IUserDao userDao;


    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }

    public void reg(){
        System.out.println("UserService.reg");
        userDao.insert();
    }
}
