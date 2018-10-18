package ex02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Textc3 {
    private void mian() {
        
        // 생성자에 넘겨주는 값은 스프링 설정 정보를 담고 있는 자바 클래스 타입니다.
        // 이 스프링 IoC 컨테이너는 지정된 클래스의 객체를 만든 다음에,
        // 애노테이션 명령에 따라 메서드를 호출한 후 그 리턴 값을 보관한다.
        ApplicationContext iocContainer = 
                new AnnotationConfigApplicationContext(AppConfig.class);
        
        
    }
}
