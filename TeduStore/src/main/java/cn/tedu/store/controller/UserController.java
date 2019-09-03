package cn.tedu.store.controller;

import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.bean.User;
import cn.tedu.store.service.IUserService;
import cn.tedu.store.service.UserServiceImpl;
import cn.tedu.store.service.ex.PasswordNotMatchException;
import cn.tedu.store.service.ex.UserNotFoundException;
import cn.tedu.store.service.ex.UsernameAlreadyExistsException;
import cn.tedu.store.service.ex.UsernameNotFoundException;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

    @Resource(name = "userService")
    private IUserService userService;

    @RequestMapping("/register.do")
    public String showRegister(){
        return "register";
    }

    @RequestMapping("/login.do")
    public String showLogin(){
        return "login";

    }

    @RequestMapping("/password.do")
    public String showPassword(){
        return "user_password";
    }

    @RequestMapping("/profile.do")
    public String showProfile(
            ModelMap modelMap,
            HttpSession session){
        //查询当前登录的用户数据
        Integer uid = getUidFromSession(session);
        User user = userService.findUserById(uid);
        //将用户数据转发到前端页面
        modelMap.addAttribute("user",user);
        //执行转发
        return "user_profile";
    }

    @RequestMapping("/check_username.do")
    @ResponseBody
    public ResponseResult<Void> checkUsername(String username) {
        boolean result = userService.checkUsernameExists(username);
        ResponseResult<Void> rr;
         //判断检查结果
        if(result){
            //true表示用户名存在
            rr= new ResponseResult<>(0,"用户名已经被占用");
        }else {
            //false表示用户名尚未存在
            rr = new ResponseResult<>(1,"用户名可以使用");
        }
        return rr;
    }

    @RequestMapping("/check_phone.do")
    @ResponseBody
    public ResponseResult<Void> checkPhone(String phone) {
        boolean result = userService.checkPhoneExists(phone);
        ResponseResult<Void> rr;
        //判断检查结果
        if(result){
            //true表示电话号码存在
            rr= new ResponseResult<>(0,"手机号码已经被占用");
        }else {
            //false表示电话号码尚未存在
            rr = new ResponseResult<>(1,"手机号码可以使用");
        }
        return rr;
    }

    @RequestMapping("/check_email.do")
    @ResponseBody
    public ResponseResult<Void> checkEmail(String email) {
        boolean result = userService.checkEmailExists(email);
        ResponseResult<Void> rr;
        //判断检查结果
        if(result){
            //true表示邮箱存在
            rr= new ResponseResult<>(0,"邮箱已经被占用");
        }else {
            //false表示邮箱尚未存在
            rr = new ResponseResult<>(1,"邮箱可以使用");
        }
        return rr;
    }

    @RequestMapping(value = "/handle_register.do",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Void> handleRegister(
            @RequestParam("uname") String username,
            @RequestParam("upwd") String password,
            @RequestParam("phone") String phone,
            @RequestParam("email") String email){
        ResponseResult<Void> rr;
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        //执行注册
        try {
            userService.register(user);
            rr = new ResponseResult<>(1,"注册成功");
            return rr;
        }catch (UsernameAlreadyExistsException e){
            rr = new ResponseResult<>(0,e.getMessage());
            return rr;
        }

    }

    @RequestMapping(value = "/handle_login.do",method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Void> handleLogin(
             String username,
             String password,
             HttpSession session){
        //调用userService完成登录
        //无论成功与否，都返回ResponseResult对象
        //如果成功，在返回之前，调用Session的setArrtibute方法
        ResponseResult<Void> rr;

        try {
            User user = userService.login(username, password);
            rr = new ResponseResult<>(1);

            session.setAttribute(
                    "uid", user.getId());
            session.setAttribute(
                    "username", user.getUsername());

        }catch (UsernameNotFoundException e){
            rr = new ResponseResult<>(0,e);
        }catch (PasswordNotMatchException e){
            rr = new ResponseResult<>(-1,e);
        }

        return rr;

    }
    @RequestMapping("/logout.do")
    public String handleLogout(HttpSession session, HttpServletRequest request){
        //清除session对象中的数据
        session.invalidate();

        String url = "../main/index.do";

        return "redirect:"+url;
    }

    @RequestMapping(value = "handle_change_password.do",
                    method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Void> handleChangePassword(
           @RequestParam("old_password") String oldPassword,
           @RequestParam("new_password") String newPassword,
            HttpSession session){
        ResponseResult<Void> rr;

        Integer uid = getUidFromSession(session);
        try{
            userService.changePassword(uid,oldPassword,newPassword);
            rr = new ResponseResult<Void>(1,"修改成功");
        }catch (UserNotFoundException e){
            rr  = new ResponseResult<Void>(-1,e);
        }catch (PasswordNotMatchException e){
            rr = new ResponseResult<Void>(-2,e);
        }
        return rr;
    }
    @RequestMapping(value = "/handle_edit_profile",
            method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Void> handleEditProfile(
            String  username,
            Integer gender,
            String  phone,
            String  email,
            HttpSession session
    ){
        //声明返回值
        ResponseResult<Void> rr;
        //调用getUidFromSession()获取Uid
        Integer uid = getUidFromSession(session);
        try{
            //调用userService中的editProfile()方法
            userService.editProfile(uid,username,gender,phone,email);
            //更新Session中的username
            User u= userService.findUserById(uid);
            session.setAttribute("username",u.getUsername());
            //返回操作正确
            rr = new ResponseResult<Void>(1,"修改成功");
        }catch (UserNotFoundException e){
            //返回用户不存在
            rr = new ResponseResult<Void>(-1,e);
        }catch (UsernameAlreadyExistsException e){
            //返回用户名已经被占用
            rr = new ResponseResult<Void>(-2,e);
        }

        return rr;

    }
}
