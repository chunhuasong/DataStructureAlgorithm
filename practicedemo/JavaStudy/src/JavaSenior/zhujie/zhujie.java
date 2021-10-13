package JavaSenior.zhujie;
import java.lang.annotation.*;

public class zhujie {
    @Documented
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyAnnotation1 {
    }
}
