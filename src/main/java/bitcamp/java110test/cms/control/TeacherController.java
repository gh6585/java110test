package bitcamp.java110test.cms.control;
import java.util.Scanner;

import bitcamp.java110test.cms.domain.Member;

public class TeacherController {

    static Teacher[] teachers = new Teacher[100];
    static int teacherIndex=0;
    public static Scanner keyIn;
    
    static  class Teacher extends Member{
        protected String tel;
        protected int pay;
        protected String subjects;
        public String getTel() {
            return tel;
        }
        public void setTel(String tel) {
            this.tel = tel;
        }
        public int getPay() {
            return pay;
        }
        public void setPay(int pay) {
            this.pay = pay;
        }
        public String getSubjects() {
            return subjects;
        }
        public void setSubjects(String subjects) {
            this.subjects = subjects;
        }
    }
    
    public static void serviceTeacherMenu() {
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
    static void inputTeachers() {
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
            
            if(teacherIndex == teachers.length) {
                increaseStorage();
            }

            teachers[teacherIndex++]=t;

            System.out.println("계속 입력하시겠습니까??");
            String yn=keyIn.nextLine();
            if(yn.toUpperCase().equals("N"))
                break;

        }

    }

    static void ptrintTeachers() {
        int count =0;
        for(Teacher t: teachers) {
            if(count++ == teacherIndex)
                break;
            System.out.printf("%s, %s, %s, %s, %d, %s\n",
                    t.getName(),
                    t.getEmail(),
                    t.getPassword(),
                    t.getTel(),
                    t.getPay(),
                    t.getSubjects());
        }
    }
    
    private static void increaseStorage() {
        Teacher[] newList = new Teacher[teachers.length + 3];
        for (int i= 0; i< teachers.length; i++) {
            newList[i] = teachers[i];
        }
        teachers = newList;
    }
    
    private static void deleteTeacher() {
        System.out.println("삭제할 번호?");
        int no = Integer.parseInt(keyIn.nextLine());
        
        if(no<0 || no>= teacherIndex) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        for(int i= no; i<teacherIndex - 1;i++) {
            teachers[i] = teachers[i+1];
        }
        teacherIndex--;
        System.out.println("삭제하였습니다.");
    }
    
    private static void detailTeacher() {
        System.out.println("조회할 번호?");
        int no= Integer.parseInt(keyIn.nextLine());
        
        if(no<0 || no>= teacherIndex) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        System.out.printf("이름: %s\n",teachers[no].getName());
        System.out.printf("이메일: %s\n",teachers[no].getEmail());
        System.out.printf("비번: %s\n",teachers[no].getPassword());
        System.out.printf("전화: %s\n",teachers[no].getTel());
        System.out.printf("돈: %s\n",teachers[no].getPay());
        System.out.printf("과목: %s\n",teachers[no].getSubjects());
    }
}
