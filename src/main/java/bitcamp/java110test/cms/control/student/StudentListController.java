package bitcamp.java110test.cms.control.student;

import java.util.Scanner;

import bitcamp.java110test.cms.App;
import bitcamp.java110test.cms.annotation.Component;
import bitcamp.java110test.cms.annotation.RequestMapping;
import bitcamp.java110test.cms.domain.Student;

@Component
public class StudentListController {
    
    @RequestMapping("student/list")
    public void list(Scanner keyIn) {
        for(int i = 0; i < App.students.size(); i++) {
            Student s= App.students.get(i);
            System.out.printf("%s, %s, %s, %s, %b, %s\n",
                    s.getName(),
                    s.getEmail(),
                    s.getPassword(),
                    s.getTel(),
                    s.isWorking(),
                    s.getSchool());
        }
    }
}
