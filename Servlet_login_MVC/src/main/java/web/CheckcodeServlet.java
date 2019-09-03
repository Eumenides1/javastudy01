package web;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Checkcode")
public class CheckcodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void service(
			HttpServletRequest request,
			HttpServletResponse response) 
					throws ServletException, 
					IOException {
		System.out.println(
				"CheckcodeServlet's service()");
		/*
		 * 绘图
		 */
		//step1.创建内存映像对象(画布)
		BufferedImage image = 
			new BufferedImage(80,30,
					BufferedImage.TYPE_INT_RGB);
		//step2.获得画笔
		Graphics g = image.getGraphics();
		//step3.给笔设置颜色
		g.setColor(new Color(255,255,255));
		//step4.给画布设置背景颜色
		g.fillRect(0, 0, 80, 30);
		//step5.重新给笔设置颜色（跟画布颜色要不一样）
		Random r = new Random();
		g.setColor(new Color(r.nextInt(255),
				r.nextInt(255),r.nextInt(255)));
		//设置字体(类型，风格，大小)
		g.setFont(new Font(null,Font.BOLD,24));
		
		//step6.生成验证码
		String number = getNumber(5);
		
		//将number绑订到session对象上，
		//以便进行后续的验证（与用户提交的验证码进行比较）
		HttpSession session = 
				request.getSession();
		session.setAttribute("number", number);
		
		//step7.将验证码画到图片上
		g.drawString(number, 5, 25);
		
		//step8.加一些干扰线
		for(int i = 0; i < 12; i ++){
			g.setColor(new Color(r.nextInt(255),
					r.nextInt(255),r.nextInt(255)));
			g.drawLine(r.nextInt(80), r.nextInt(30), 
					r.nextInt(80), r.nextInt(30));
		}
		
		
		/*
		 * 压缩图片并输出
		 * 		
		 */
		//告诉浏览器，服务器返回的数据类型（图片）
		response.setContentType("image/jpeg");
		//因为输出的是字节数据，所以要用字节输出流
		OutputStream os = 
				response.getOutputStream();
		//write方法会将原始图片按照指定的格式压缩，
		//然后输出。
		javax.imageio.ImageIO.write(
				image, "jpeg", os);
		os.close();
		
		
		
		
		
		
	}

	/*
	 * 长度为size个字符，并且随机从
		"A~Z,0~9"中选取字符构成的验证码
	 */
	private String getNumber(int size) {
		String number = "";
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789";
		Random r = new Random();
		for(int i = 0; i < size; i ++){
			number += chars.charAt(
					r.nextInt(chars.length()));
		}
		return number;
	}
	
	

}
