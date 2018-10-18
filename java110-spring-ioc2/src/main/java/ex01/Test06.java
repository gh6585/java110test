package ex01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test06 {
    public static void main(String[] args) {
        
        // 객체의 생성, 소멸 의족객체 주입을 관리하는
        // bean container(=IoC 컨테이너) 생성하기
        ClassPathXmlApplicationContext iocContainer =
                new ClassPathXmlApplicationContext("ex01/app-context3.xml");
        
        Car obj = (Car)iocContainer.getBean("factory");
        
        System.out.println(obj);

        iocContainer.close();
    }
}
