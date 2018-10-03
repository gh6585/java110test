package bitcamp.java110test.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110test.cms.App;
import bitcamp.java110test.cms.annotation.Component;
import bitcamp.java110test.cms.annotation.RequestMapping;
import bitcamp.java110test.cms.domain.Manager;

@Component
public class ManagerAddController {
    @RequestMapping("manager/add")
    public void add(Scanner keyIn) {
        while(true) {
            Manager m=new Manager();
            System.out.println("아이디");
            m.setName(keyIn.nextLine());
            System.out.println("이메일");
            m.setEmail(keyIn.nextLine());
            System.out.println("비밀번호");
            m.setPassword(keyIn.nextLine());
            System.out.println("전화");
            m.setTel(keyIn.nextLine());
            System.out.println("직위");
            m.setPosition(keyIn.nextLine());

            if (App.managerDao.inser(m) >0) {
                System.out.println("저장하였습니다.");
            } else {
                System.out.println("같은 이메일의 매이저가 존재합니다.");
            }
            
            System.out.println("계속 입력하시겠습니까??");
            String yn=keyIn.nextLine();
            if(yn.toUpperCase().equals("N"))
                break;

        }
    }
}
