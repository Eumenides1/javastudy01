package test;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Eumenides
 */
public class dateDemo extends SimpleTagSupport {
    private String pattern;

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public void doTag() throws JspException, IOException {


        PageContext pc = (PageContext) getJspContext();
        JspWriter out= pc.getOut();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        out.println(sdf.format(date));

    }
}
