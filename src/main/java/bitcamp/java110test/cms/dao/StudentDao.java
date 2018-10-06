package bitcamp.java110test.cms.dao;

import java.util.List;

import bitcamp.java110test.cms.domain.Student;

public interface StudentDao {
   int insert(Student student);
   List<Student> findAll();
   Student findByEmail(String email);
   int delete(String email);
}
