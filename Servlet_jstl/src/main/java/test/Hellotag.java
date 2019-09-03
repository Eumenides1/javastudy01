package test;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * @author Eumenides
 */
public class Hellotag extends SimpleTagSupport {
    private String msg;
    private int qty;

    public Hellotag(){
        System.out.println("Hello's constuctor()");
    }


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public void doTag() throws JspException, IOException {
        System.out.println("doTag()");
        /**
         * 通过继承自SimpleTagSupport提供的
         * getJspContext方法来获得pageContext
         */
        PageContext pc = (PageContext) getJspContext();
        /**
         * pageContext提供了获得其他所有隐含对象的方法
         */
        JspWriter out = pc.getOut();

        for (int i = 0; i < qty; i++) {
            out.println(msg+"<br/>");
        }
    }
}
