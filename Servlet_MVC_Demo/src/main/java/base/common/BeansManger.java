package base.common;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 负责解析配置文件（config.xml）
 * 并且利用java反射，将配置文件中的类实例化，
 * 然后将这些实例添加到集合中
 * @author Eumenides
 */
public class BeansManger {
    private List beans = new ArrayList();

    public List getBeans() {
        return beans;
    }

    public void parse(String fileName) throws ClassNotFoundException, InstantiationException, DocumentException, IllegalAccessException {
        /*
         * 解析配置文件，利用java反射，将配置文件中的类实例化并存放到集合中
         */
        SAXReader sax = new SAXReader();
        InputStream in = getClass().getClassLoader().getResourceAsStream(fileName);
        try {
            Document doc = sax.read(in);
            //获得根元素
            Element root = doc.getRootElement();
            //获得根元素下面的所有子元素
            List<Element> eles = root.elements();
            for (Element ele :
                    eles) {
                //读取bean元素的class属性值
                String className = ele.attributeValue("class");
                System.out.println("className:"+className);
                //利用反射，将类实例化
                Object obj = Class.forName(className).newInstance();
                //将这些实例添加到集合当中
                beans.add(obj);
            }
            System.out.println("bean:"+beans);

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
