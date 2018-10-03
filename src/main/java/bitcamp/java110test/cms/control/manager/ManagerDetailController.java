package bitcamp.java110test.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110test.cms.App;
import bitcamp.java110test.cms.annotation.Component;
import bitcamp.java110test.cms.annotation.RequestMapping;
import bitcamp.java110test.cms.domain.Manager;

@Component
public class ManagerDetailController {
    @RequestMapping("manager/detail")
    public void detail(Scanner keyIn) {
        System.out.println("조회할 번호?");
        int no= Integer.parseInt(keyIn.nextLine());

        if(no<0 || no>= App.managers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        Manager manager = App.managers.get(no);

        System.out.printf("이름: %s\n",manager.getName());
        System.out.printf("이메일: %s\n",manager.getEmail());
        System.out.printf("비번: %s\n",manager.getPassword());
        System.out.printf("전화: %s\n",manager.getTel());
        System.out.printf("직위: %s\n",manager.getPosition());
    }
}