package bitcamp.java110test.cms.control;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bitcamp.java110test.cms.annotation.Component;
import bitcamp.java110test.cms.annotation.RequestMapping;
import bitcamp.java110test.cms.domain.Student;

@Component("student")
public class StudentController {
    
    private List<Student> students = new ArrayList<>();
    
    @RequestMapping
    public void student(Scanner keyIn) {
        while(true) {
            System.out.println("학생 관리> ");
            String command = keyIn.nextLine();
            if(command.equals("list")){
                ptrintStudents();
            } else if (command.equals("add")) {
                inputStudents(keyIn);
            }else if (command.equals("delete")) {
                deleteStudent(keyIn);
            }else if (command.equals("detail")) {
                detailStudent(keyIn);
            } else if (command.equals("quit")) {
                break;
            } else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        } 
    }
   private void inputStudents(Scanner keyIn) {
        while(true) {
            Student s=new Student();
            System.out.println("아이디");
            s.setName(keyIn.nextLine());
            System.out.println("이메일");
            s.setEmail(keyIn.nextLine());
            System.out.println("비밀번호");
            s.setPassword(keyIn.nextLine());
            System.out.println("전화");
            s.setTel(keyIn.nextLine());
            System.out.println("재직여부?(true/false)");
            s.setWorking(Boolean.parseBoolean(keyIn.nextLine()));
            System.out.println("최종학력?");
            s.setSchool(keyIn.nextLine());

            students.add(s);

            System.out.println("계속 입력하시겠습니까??");
            String yn=keyIn.nextLine();
            if(yn.toUpperCase().equals("N"))
                break;

        }

    }
    private void ptrintStudents() {
        for(int i = 0; i < students.size(); i++) {
            Student s= students.get(i);
            System.out.printf("%s, %s, %s, %s, %b, %s\n",
                    s.getName(),
                    s.getEmail(),
                    s.getPassword(),
                    s.getTel(),
                    s.isWorking(),
                    s.getSchool());
        }
    }
    
    private void deleteStudent(Scanner keyIn) {
        System.out.println("삭제할 번호?");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if(no<0 || no>= students.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        students.remove(no);
        System.out.println("삭제하였습니다.");
    }
    
    private void detailStudent(Scanner keyIn) {
        System.out.println("조회할 번호?");
        int no= Integer.parseInt(keyIn.nextLine());
        
        if(no<0 || no>= students.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        Student student = students.get(no);
        
        System.out.printf("이름: %s\n",student.getName());
        System.out.printf("이메일: %s\n",student.getEmail());
        System.out.printf("비번: %s\n",student.getPassword());
        System.out.printf("전화: %s\n",student.getTel());
        System.out.printf("일: %s\n",student.isWorking());
        System.out.printf("학교: %s\n",student.getSchool());
    }
}
