package Spring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Sample {

	public static void main(String[] args) {
		// 加载Spring配置，获取Spring容器
		String fileName 
			= "applicationContext.xml";
		AbstractApplicationContext ac
			= new ClassPathXmlApplicationContext(
				fileName);
		
		// 通过Spring容器获取UserService的对象
		UserService userService
			= ac.getBean(
				"userService", UserService.class);
		// 测试
		userService.reg();
		
		// 释放资源
		ac.close();
	}

}
