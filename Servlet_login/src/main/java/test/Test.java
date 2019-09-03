package test;

import java.util.List;

import dao.UserDAO;
import entity.User;

public class Test {
	public static void test1(){
		UserDAO dao = new UserDAO();
		List<User> users = dao.findAll();
		System.out.println(users);
	}
	
	public static void test2(){
		UserDAO dao = new UserDAO();
		User user = new User();
		user.setUsername("Tom");
		user.setPhone("123");
		user.setPwd("test");
		dao.save(user);
	}
	
	public static void test3(){
		UserDAO dao = new UserDAO();
		dao.delete(1);
	}
	
	public static void test4(){
		UserDAO dao = new UserDAO();
		User user = dao.find("Sally");
		System.out.println(user);
	}

	public static void main(String[] args) {
		test4();
	}

}
