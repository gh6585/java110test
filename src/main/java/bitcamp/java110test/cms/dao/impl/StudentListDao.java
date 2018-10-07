package bitcamp.java110test.cms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import bitcamp.java110test.cms.dao.StudentDao;
import bitcamp.java110test.cms.domain.Student;

public class StudentListDao implements StudentDao{

    private List<Student> list = new ArrayList<>();

    @Override
    public int insert(Student student) {
        for (Student item : list) {
            if(item.getEmail().equals(student.getEmail())) {
                return 0;
            }
        }
        list.add(student);
        return 1;
    }

    @Override
    public List<Student> findAll() {
        return list;
    }

    @Override
    public Student findByEmail(String email) {
        for (Student item : list) {
            if(item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public int delete(String email) {
        for (Student item : list) {
            if (item.getEmail().equals(email)) {
                list.remove(item);
                return 1;
            }
        }
        return 0;
    }
    
    
}
