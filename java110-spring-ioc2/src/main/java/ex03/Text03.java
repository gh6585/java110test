// 객체 생성 : 객체의 아이디와 별명
// 1) 객체의 아이디를 지정하기
//  - 오직 한 개의 아이디만 지정할 수 있다.
//  - 문법
//      <bean id="객체명" class="클래스명"/>
//
// 2) 객체의 별명 지정하기
//  - 한 개 이상의 이름을 지정할 수 있다.
//  - id를 지정하지 않으면 첫 번째 별명이 id로 사용된다.
//  - 콤마(,)/세미콜론(;)/공백() 으로 별명을 구분한다.
//  - 문법
//      <bean name="별명1 별명2 별명3" class="클래스명"/>
//      <bean name="별명1, 별명2, 별명3" class="클래스명"/>
//      <bean name="별명1; 별명2; 별명3" class="클래스명"/>
//
// 3) 객체의 아이디나 별명을 지정하지 않기
//      - 번호가 붙은 클래스의 이름(패키지명 포함)이 객체의 이름으로 사용된다.
//          예) ex03.Car#0
//      - 만약 그 타입의 첫 번째 익명 객체라면 클래스 이름(패키지명 포함)이 별명으로 설정된다.
//          예) ex03.Car
//      - 그 타입의 두 번째 익명 객체일 경우 별명이 붙지 않는다.

package ex03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Text03 {
 public static void main(String[] args) {
        
        ApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex03/app-context-3.xml");
        
        System.out.println("--------------");
        
        // 컨테이너에 들어 있는 객체의 개수와 이름 알아내기
        int count = iocContainer.getBeanDefinitionCount();
        System.out.printf("bean 개수 = %d\n", count);
        
        String[] names = iocContainer.getBeanDefinitionNames();
        for(String name : names) {
            System.out.printf("[%s : %s]\n",
                    name,
                    iocContainer.getType(name).getName());
        
            String[] aliases = iocContainer.getAliases(name);
            System.out.println("   별명들:");
            for (String alias : aliases) {
                System.out.println("   =>" + alias);
            }
            System.out.println();
        }
        
        // 1) 이름으로 꺼내기
        Car c1 = (Car)iocContainer.getBean("n1");
        System.out.println(c1);
        
        // 2) 별명으로 꺼낼 때도 같은 메서드를 사용한다.
        Car c2 = (Car)iocContainer.getBean("a1");
        System.out.println(c2);
        
        // 3) 타입으로 꺼낼 수 있다.
        Car c3 = (Car)iocContainer.getBean(Car.class);
        System.out.println(c3);
        
        
        // 컨테이너느 기본으로 한 개의 객체만 생성한다.
        if (c1 == c2) System.out.println("c1 == c2");
        if (c1 == c2) System.out.println("c1 == c3");
        
        // 존자해지 않는 객체를 꺼내려 할 떄는 예외 발생!
        try {
            Car c4 = (Car)iocContainer.getBean("xx");
            System.out.println(c4);
            
        } catch(Exception e) {
            System.out.println("xx라는 이름의 객체가 업습니다.");
        }
        
        
    }

}






















