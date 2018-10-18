package ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Text02 {
 public static void main(String[] args) {
        
        // 생성자에 넘겨준 스프링 설정 파일의 경로는
        // OS 파일 시스템 기준이다.
        // 이클립스에서 자바 클래스를 실행시키면,
        // 폴더의 현재 위치는 프로젝트 경로이다.
        // 따라서 다음 경로는 이 프로젝트 경로를 기준으로 찾는다.
        ApplicationContext iocContanier =
                new FileSystemXmlApplicationContext(
                        "src/main/java/ex02/app-context-1.xml");
     
    }

}
