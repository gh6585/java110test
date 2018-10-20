// 객체 생성 : XML에 객체 생성을 설정하는 방법과 컨테이너에 보관된 객체 확인하기
// XML 문법
//      <bean id="객체명" class="클래스명/>
//  - 객체명:
//      컨테이너에 객체를 보관할 떄 사용할 이름
//  - 클래스명:
//      패키지명을 포함한 클래스 이름(fully ualified name; FQName; QName).
//

package ex04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Text01 {
 public static void main(String[] args) {
        
        // 생성자에 넘겨준 스프링 설정 파일의 경로는 
        // 자바의 classpath 경로이다.
        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex04/app-context-1.xml");
        
        System.out.println("------------------------");
        
        // 컨테이너에 들어 있는 객체의 개수와 이름 알아내기
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 개수 = %d\n", count);
        
        String[] names = iocContainer.getBeanDefinitionNames();
        for (String name : names) {
            System.out.printf("=> %s : %s\n", 
                    name, 
                    iocContainer.getType(name).getName());
        }
        System.out.println("--------------------");
        
        
        Car c1 = (Car)iocContainer.getBean("c1");
        System.out.println(c1);
        
        Car c2 = (Car)iocContainer.getBean("c2");
        System.out.println(c2);
        
        Car c3 = (Car)iocContainer.getBean("c3");
        System.out.println(c3);
        
        Car c4 = (Car)iocContainer.getBean("c4");
        System.out.println(c4);
        
        
    }

}
