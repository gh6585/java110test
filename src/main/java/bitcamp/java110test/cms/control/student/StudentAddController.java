package bitcamp.java110test.cms.control.student;

import java.util.Scanner;

import bitcamp.java110test.cms.App;
import bitcamp.java110test.cms.annotation.Component;
import bitcamp.java110test.cms.annotation.RequestMapping;
import bitcamp.java110test.cms.domain.Student;


@Component
public class StudentAddController {

    @RequestMapping("student/add")
    public void add(Scanner keyIn) {
        while(true) {
            Student s=new Student();
            System.out.println("아이디");
            s.setName(keyIn.nextLine());
            System.out.println("이메일");
            s.setEmail(keyIn.nextLine());
            System.out.println("비밀번호");
            s.setPassword(keyIn.nextLine());
            System.out.println("전화");
            s.setTel(keyIn.nextLine());
            System.out.println("재직여부?(true/false)");
            s.setWorking(Boolean.parseBoolean(keyIn.nextLine()));
            System.out.println("최종학력?");
            s.setSchool(keyIn.nextLine());

            if(App.studentDao.insert(s) > 0) {
                System.out.println("저장하였습니다.");
            } else {
                System.out.println("같은 이메일의 학생이 존재합니다.");
            }
            
            System.out.println("계속 입력하시겠습니까??");
            String yn=keyIn.nextLine();
            if(yn.toUpperCase().equals("N"))
                break;

        }
    }
}
