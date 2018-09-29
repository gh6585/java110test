package bitcamp.java110test.cms.control;
import java.util.Scanner;

import bitcamp.java110test.cms.domain.Member;

public class StudentController {
    
    static Student[] students = new Student[100];
    static int studentIndex=0;
    public static Scanner keyIn;
    
    static class Student extends Member{
        protected String school;
        protected boolean working;
        protected String tel;
        public String getSchool() {
            return school;
        }
        public void setSchool(String school) {
            this.school = school;
        }
        public boolean isWorking() {
            return working;
        }
        public void setWorking(boolean working) {
            this.working = working;
        }
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
    }
    public static void serviceStduentMenu() {
        while(true) {
            System.out.println("학생 관리> ");
            String command = keyIn.nextLine();
            if(command.equals("list")){
                ptrintStudents();
            } else if (command.equals("add")) {
                inputStudents();
            }else if (command.equals("delete")) {
                deleteStudent();
            }else if (command.equals("detail")) {
                detailStudent();
            } else if (command.equals("quit")) {
                break;
            } else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        } 
    }
    static void inputStudents() {
        while(true) {
            Student m=new Student();
            System.out.println("아이디");
            m.setName(keyIn.nextLine());
            System.out.println("이메일");
            m.setEmail(keyIn.nextLine());
            System.out.println("비밀번호");
            m.setPassword(keyIn.nextLine());
            System.out.println("전화");
            m.setTel(keyIn.nextLine());
            System.out.println("재직여부?(true/false)");
            m.setWorking(Boolean.parseBoolean(keyIn.nextLine()));
            System.out.println("최종학력?");
            m.setSchool(keyIn.nextLine());

            if(studentIndex == students.length) {
                increaseStorage();
            }
            
            students[studentIndex++]=m;

            System.out.println("계속 입력하시겠습니까??");
            String yn=keyIn.nextLine();
            if(yn.toUpperCase().equals("N"))
                break;

        }

    }
    static void ptrintStudents() {
        int count =0;
        for(Student s: students) {
            if(count++ == studentIndex)
                break;
            System.out.printf("%s, %s, %s, %s, %b, %s\n",
                    s.getName(),
                    s.getEmail(),
                    s.getPassword(),
                    s.getTel(),
                    s.isWorking(),
                    s.getSchool());
        }
    }
    
    private static void increaseStorage() {
        Student[] newList = new Student[students.length + 3];
        for (int i= 0; i< students.length; i++) {
            newList[i] = students[i];
        }
        students = newList;
    }
    
    private static void deleteStudent() {
        System.out.println("삭제할 번호?");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if(no<0 || no>= studentIndex) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        for(int i= no; i<studentIndex - 1;i++) {
            students[i] = students[i+1];
        }
        studentIndex--;
        System.out.println("삭제하였습니다.");
    }
    
    private static void detailStudent() {
        System.out.println("조회할 번호?");
        int no= Integer.parseInt(keyIn.nextLine());
        
        if(no<0 || no>= studentIndex) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        System.out.printf("이름: %s\n",students[no].getName());
        System.out.printf("이메일: %s\n",students[no].getEmail());
        System.out.printf("비번: %s\n",students[no].getPassword());
        System.out.printf("전화: %s\n",students[no].getTel());
        System.out.printf("일: %s\n",students[no].isWorking());
        System.out.printf("학교: %s\n",students[no].getSchool());
    }
}
