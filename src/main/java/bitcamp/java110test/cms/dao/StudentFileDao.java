package bitcamp.java110test.cms.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110test.cms.domain.Student;

public class StudentFileDao implements StudentDao{
    
    private List<Student> list = new ArrayList<>();
    
    public StudentFileDao() {
        
    }

    private void save() {
        File dataFile = new File("data/student.dat");
        try(BufferedWriter out =
                new BufferedWriter(new FileWriter(dataFile))
                ){
            for (Student s : list) {
                out.write(
                        String.format("%s,%s,%s,%s,%s,%b\n",
                                s.getEmail(),
                                s.getName(),
                                s.getPassword(),
                                s.getSchool(),
                                s.getTel(),
                                s.isWorking()));
            }
            out.flush();
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public int insert(Student student) {
        for (Student item : list) {
            if(item.getEmail().equals(student.getEmail())) {
                return 0;
            }
        }
        list.add(student);
        save();
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
            if(item.getEmail().equals(email)) {
                list.remove(item);
                return 1;
            }
        }
        save();
        return 0;
    }
    
    
}
