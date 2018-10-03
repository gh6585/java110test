package bitcamp.java110test.cms.control.teacher;

import java.util.List;
import java.util.Scanner;

import bitcamp.java110test.cms.App;
import bitcamp.java110test.cms.annotation.Component;
import bitcamp.java110test.cms.annotation.RequestMapping;
import bitcamp.java110test.cms.domain.Teacher;

@Component
public class TeacherListController {
    @RequestMapping("teacher/list")
    public void list(Scanner keyIn) {
        List<Teacher> list = App.teacherDao.findAll();
        
        for(Teacher t : list) {
        System.out.printf("%s, %s, %s, %s, %d, %s\n",
                    t.getName(),
                    t.getEmail(),
                    t.getPassword(),
                    t.getTel(),
                    t.getPay(),
                    t.getSubjects());
        }
    }
}
