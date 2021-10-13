package JavaSenior.AnnotationDemo;
import java.lang.annotation.*;

public class zhujie {
    @Documented
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface MyAnnotation1 {

        String value() default "hello";
    }

    @Retention(RetentionPolicy.SOURCE)

        @interface MyAnnotation{}



}
