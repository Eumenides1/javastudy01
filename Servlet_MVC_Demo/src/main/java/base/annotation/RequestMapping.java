package base.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author Eumenides
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    public String value();
}
