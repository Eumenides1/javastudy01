package reflect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 注解生存范围有三个：
 *  源代码期间有效
 *  字节码文件当中有效
 *  运行期间有效
 * @author Eumenides
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {

    public String value();

}
