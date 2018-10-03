package bitcamp.java110test.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110test.cms.App;
import bitcamp.java110test.cms.annotation.Component;
import bitcamp.java110test.cms.annotation.RequestMapping;

@Component
public class TeacherDeleteController {
    @RequestMapping("teacher/delete")
    public void delete(Scanner keyIn) {
        System.out.println("삭제할 강사의 이메일은?");
        String email = keyIn.nextLine();
        
        if(App.teacherDao.delete(email) > 0) {
        System.out.println("삭제하였습니다.");
        }else {
            System.out.println("이메일에 해당하는 강사가 없습니다.");
        }
    }
}
