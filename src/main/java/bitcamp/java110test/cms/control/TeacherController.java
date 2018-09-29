package bitcamp.java110test.cms.control;
import java.util.Scanner;

import bitcamp.java110test.cms.domain.Teacher;
import bitcamp.java110test.cms.util.ArrayList;

public class TeacherController {
    
    private ArrayList teachers = new ArrayList();
    public Scanner keyIn;
    
    public TeacherController(Scanner keyIn) {
        this.keyIn=keyIn;
    }

    public void serviceTeacherMenu() {
        while(true) {
            System.out.println("강사 관리> ");
            String command = keyIn.nextLine();
            if(command.equals("list")){
                ptrintTeachers();
            } else if (command.equals("add")) {
                inputTeachers();
            }else if (command.equals("delete")) {
                deleteTeacher();
            }
            else if (command.equals("detail")) {
                detailTeacher();
            }else if (command.equals("quit")) {
                break;
            } else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        } 
    }
   private void inputTeachers() {
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
            System.out.println("재직여부?(true/false)");
            t.setPay(Integer.parseInt(keyIn.nextLine()));
            System.out.println("전화");
            t.setTel(keyIn.nextLine());

            teachers.add(t);

            System.out.println("계속 입력하시겠습니까??");
            String yn=keyIn.nextLine();
            if(yn.toUpperCase().equals("N"))
                break;

        }

    }

    private void ptrintTeachers() {
        for(int i=0; i<teachers.size(); i++) {
            Teacher t = (Teacher)teachers.get(i);

            System.out.printf("%s, %s, %s, %s, %d, %s\n",
                    t.getName(),
                    t.getEmail(),
                    t.getPassword(),
                    t.getTel(),
                    t.getPay(),
                    t.getSubjects());
        }
    }

    private void deleteTeacher() {
        System.out.println("삭제할 번호?");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no<0 || no>= teachers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }

        teachers.remove(no);

        System.out.println("삭제하였습니다.");
    }

    private void detailTeacher() {
        System.out.println("조회할 번호?");
        int no= Integer.parseInt(keyIn.nextLine());

        if(no<0 || no>= teachers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        Teacher teacher = (Teacher)teachers.get(no);

        System.out.printf("이름: %s\n",teacher.getName());
        System.out.printf("이메일: %s\n",teacher.getEmail());
        System.out.printf("비번: %s\n",teacher.getPassword());
        System.out.printf("전화: %s\n",teacher.getTel());
        System.out.printf("돈: %s\n",teacher.getPay());
        System.out.printf("과목: %s\n",teacher.getSubjects());
    }
}
