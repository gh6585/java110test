package bitcamp.java110test.cms.control;

import java.util.Scanner;

import bitcamp.java110test.cms.annotation.Component;
import bitcamp.java110test.cms.annotation.RequestMapping;

@Component("hello")
public class HelloController {
    
    
    @RequestMapping
    public void service(Scanner keyIn) {
        System.out.println("안녕하세요!!");
    }
}
