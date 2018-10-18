package ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Text01 {
 public static void main(String[] args) {
        
        // 생성자에 넘겨준 스프링 설정 파일의 경로는 
        // 자바의 classpath 경로이다.
        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex02/app-context-1.xml");
        
    }

}
