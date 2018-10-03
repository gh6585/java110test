package bitcamp.java110test.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110test.cms.App;
import bitcamp.java110test.cms.annotation.Component;
import bitcamp.java110test.cms.annotation.RequestMapping;
import bitcamp.java110test.cms.domain.Teacher;

@Component
public class TeacherDetailController {
    @RequestMapping("teacher/detail")
    public void detailTeacher(Scanner keyIn) {
        System.out.println("조회할 강사의 이메일으??");
        String email = keyIn.nextLine();
        Teacher t = App.teacherDao.findByEmail(email);
        
        if( t== null) {
            System.out.println("해당 이메일의 강사가 없습니다.");
            return;
        }
        
        System.out.printf("이름: %s\n",t.getName());
        System.out.printf("이메일: %s\n",t.getEmail());
        System.out.printf("비번: %s\n",t.getPassword());
        System.out.printf("전화: %s\n",t.getTel());
        System.out.printf("돈: %s\n",t.getPay());
        System.out.printf("과목: %s\n",t.getSubjects());
    }
}
