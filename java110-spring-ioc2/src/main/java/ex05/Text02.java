// 객체 생성 : XML에 객체 생성을 설정하는 방법과 컨테이너에 보관된 객체 확인하기
// XML 문법
//      <bean id="객체명" class="클래스명">
//          <property name="프로퍼티명" value="파라미터값">
//      </bean>
//
package ex05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Text02 {
 public static void main(String[] args) {
        
        // 생성자에 넘겨준 스프링 설정 파일의 경로는 
        // 자바의 classpath 경로이다.
        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex05/app-context-1.xml");
        
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
        
        
    }

}
