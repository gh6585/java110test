package bitcamp.java110test.cms.control.teacher;

import java.util.Scanner;

import bitcamp.java110test.cms.annotation.Autowired;
import bitcamp.java110test.cms.annotation.Component;
import bitcamp.java110test.cms.annotation.RequestMapping;
import bitcamp.java110test.cms.dao.TeacherDao;
import bitcamp.java110test.cms.domain.Teacher;

@Component
public class TeacherAddController {
    
 TeacherDao teacherDao;
    
    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao =teacherDao;
    }
    
    @RequestMapping("teacher/add")
    public void add(Scanner keyIn) {
        while(true) {
            Teacher t=new Teacher();
            System.out.println("아이디");
            t.setName(keyIn.nextLine());
            System.out.println("이메일");
            t.setEmail(keyIn.nextLine());
            System.out.println("비밀번호");
            t.setPassword(keyIn.nextLine());
            System.out.println("전화?");
            t.setTel(keyIn.nextLine());
            System.out.println("시급");
            t.setPay(Integer.parseInt(keyIn.nextLine()));
            System.out.println("과목");
            t.setSubjects(keyIn.nextLine());

            if(teacherDao.insert(t) > 0) {
                System.out.println("저장하였습니다");
            } else {
                System.out.println("같은 이메일의 강사가 존재합니다.");
            }
            
            System.out.println("계속 입력하시겠습니까??");
            String yn=keyIn.nextLine();
            if(yn.toUpperCase().equals("N"))
                break;

        }

    }
}
