package JavaSenior.StringDemo;

import org.junit.Test;

public class StringDebug {
@Test
        public void TestDebug(){
    String str = null;
    StringBuffer sb = new StringBuffer();
    sb.append(str);
    System.out.println(sb.length());// 4
    System.out.println(sb);//"null"
    StringBuffer sb1 = new StringBuffer(str);//抛异常NullPointerException
//        public StringBuffer(String str) {
//        super(str.length() + 16);  str空指针
//        append(str);
//    }
    System.out.println(sb1);//
}


}
