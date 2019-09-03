package web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * @author Eumenides
 */
@WebServlet("/CheckCode")
public class CheckCode extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("CheckCodeServlet's service()");
        /*
         * 绘图
         */
        //创建一个内存映像对象
        BufferedImage image = new BufferedImage(80,30,BufferedImage.TYPE_INT_RGB);
        //获得画笔
        Graphics g = image.getGraphics();
        //给笔设置颜色
        g.setColor(new Color(255,255,255));
        //给画布设置背景颜色
        g.fillRect(0,0,80,30);
        //给笔重新设置颜色(与画布颜色区分开)
        Random r = new Random();
        g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
        //设置字体（类型，风格，大小）
        g.setFont(new Font(null,Font.BOLD,24));
        //生成验证码
        String number = getNumber(5);
        //将验证码绘制到画布上
        g.drawString(number,5,25);

        //加一些干扰线
        for (int i = 0; i < 12; i++) {
            g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
            g.drawLine(r.nextInt(80),r.nextInt(30),r.nextInt(80),r.nextInt(30));
        }
        /*
         * 压缩图片并输出
         */
        //告诉浏览器服务器返回的数据类型(图片)
        response.setContentType("image/jpeg");
        //输出图片字节数据，建一个字节输出流
        OutputStream os = response.getOutputStream();
        //write会将原始图片按照指定格式压缩，然后输出
        javax.imageio.ImageIO.write(image,"jpeg",os);
        os.close();


    }

    private String getNumber(int size) {
        String number = "";
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"+"0123456789";
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            number += chars.charAt(r.nextInt(chars.length()));
        }
        return number;
    }
}
