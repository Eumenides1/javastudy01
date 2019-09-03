package cn.tedu.Spring_02;

/**
 * @author Eumenides
 */
public class UserService {
    //声明类型为UserDao的属性
    //推荐userDao作为属性名称
    private UserDao userDao;
    //与属性名称匹配的Set方法
    //后续Spring会调用该方法为属性赋值
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    //模拟调用DAO工作的方法
    public void reg(){
        //日志
        System.out.println("UserService.reg()");
        //调用Dao工作
        userDao.insert();
    }

}
