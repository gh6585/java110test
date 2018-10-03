package bitcamp.java110test.cms.control.student;

import java.util.Scanner;

import bitcamp.java110test.cms.App;
import bitcamp.java110test.cms.annotation.Component;
import bitcamp.java110test.cms.annotation.RequestMapping;
import bitcamp.java110test.cms.dao.StudentDao;

@Component
public class StudentDeleteController {
    
 StudentDao studentDao;
    
    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    @RequestMapping("student/delete")
    public void delete(Scanner keyIn) {
        System.out.println("삭제할 학생의 이메일");
        String email = keyIn.nextLine();
        
        if(App.studentDao.delete(email)>0) {
            System.out.println("저장해였습니다");
        }else {
            System.out.println("이메일에 해당하는 학생이 없습니다.");
        }
        
        System.out.println("삭제하였습니다.");
    }
}
