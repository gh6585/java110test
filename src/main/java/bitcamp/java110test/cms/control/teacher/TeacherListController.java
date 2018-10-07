package bitcamp.java110test.cms.control.teacher;

import java.util.List;
import java.util.Scanner;

import bitcamp.java110test.cms.annotation.Autowired;
import bitcamp.java110test.cms.annotation.Component;
import bitcamp.java110test.cms.annotation.RequestMapping;
import bitcamp.java110test.cms.dao.TeacherDao;
import bitcamp.java110test.cms.domain.Teacher;

@Component
public class TeacherListController {
    
    TeacherDao teacherDao;
    
    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao =teacherDao;
    }
    
    @RequestMapping("teacher/list")
    public void list(Scanner keyIn) {
        List<Teacher> list = teacherDao.findAll();
        
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
