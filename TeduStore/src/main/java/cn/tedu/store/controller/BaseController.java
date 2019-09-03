package cn.tedu.store.controller;

import javax.servlet.http.HttpSession;

/**
 * 从session中获取当前用户的用户id
 */
public abstract class BaseController {
    protected  Integer getUidFromSession(HttpSession session){
        Object uidObject = session.getAttribute("uid");

        if(uidObject == null){
            return null;
        }else {
            return Integer.valueOf(uidObject.toString());
        }
    }
}
