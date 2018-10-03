package bitcamp.java110test.cms.control.student;

import java.util.Scanner;

import bitcamp.java110test.cms.App;
import bitcamp.java110test.cms.annotation.Component;
import bitcamp.java110test.cms.annotation.RequestMapping;
import bitcamp.java110test.cms.domain.Student;

@Component
public class StudentDetailController {
    
    @RequestMapping("student/detail")
    public void detail(Scanner keyIn) {
        System.out.println("조회할 번호?");
        int no= Integer.parseInt(keyIn.nextLine());
        
        if(no<0 || no>= App.students.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        Student student = App.students.get(no);
        
        System.out.printf("이름: %s\n",student.getName());
        System.out.printf("이메일: %s\n",student.getEmail());
        System.out.printf("비번: %s\n",student.getPassword());
        System.out.printf("전화: %s\n",student.getTel());
        System.out.printf("일: %s\n",student.isWorking());
        System.out.printf("학교: %s\n",student.getSchool());
    }
}
