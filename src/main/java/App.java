import java.lang.reflect.Method;
import java.util.Scanner;

import bitcamp.java110test.cms.annotation.RequestMapping;
import bitcamp.java110test.cms.context.ApplicationContext;

public class App {

    static Scanner keyIn=new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        ApplicationContext iocContainer =
                new ApplicationContext("bitcamp.java110test.cms.control");
        
        while(true) {
            String menu = promtMenu();
            if(menu.equals("0")) {
                System.out.println("안녕히 가세요");
                break;
            }
         

        Object controller =iocContainer.getBean(menu);
        if(controller == null) {
            System.out.println("해당 메뉴가 없습니다.");
            continue;
        }
            
        
        Method method = FindRequestMapping(controller.getClass());
        if(method == null) {
            System.out.println("해당 메뉴가 없습니다.");
            continue;
        }
            method.invoke(controller, keyIn);
        }
        keyIn.close();
    }
    
    private static Method FindRequestMapping(Class<?> clazz) {
        
        // => 클래스의 메서드 목록을 꺼낸다.
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m : methods) {
            
            // => 메서드에서 @RequestMapping 정보를 추출한다.
             RequestMapping anno = m.getAnnotation(RequestMapping.class);
             
             if (anno != null)
                 return m;
        }
        return null;
    }

    private static String promtMenu() {
        System.out.println("메뉴>");
        return keyIn.nextLine();
    }
}

