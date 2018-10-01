package bitcamp.java110test.cms.control;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bitcamp.java110test.cms.annotation.Component;
import bitcamp.java110test.cms.domain.Manager;

@Component("3")
public class ManagerController implements Controller {
    
    private List<Manager> managers = new ArrayList<>();
    
    
    public void service(Scanner keyIn) {
        while(true) {
            System.out.println("매니저 관리> ");
            String command = keyIn.nextLine();
            if(command.equals("list")){
                ptrintManagers();
            } else if (command.equals("add")) {
                inputManagers(keyIn);
            }else if (command.equals("delete")) {
                deleteManager(keyIn);
            }else if (command.equals("detail")) {
                detailManager(keyIn);
            } else if (command.equals("quit")) {
                break;
            } else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        } 
    }
    private void inputManagers(Scanner keyIn) {
        while(true) {
            Manager m=new Manager();
            System.out.println("아이디");
            m.setName(keyIn.nextLine());
            System.out.println("이메일");
            m.setEmail(keyIn.nextLine());
            System.out.println("비밀번호");
            m.setPassword(keyIn.nextLine());
            System.out.println("전화");
            m.setTel(keyIn.nextLine());
            System.out.println("직위");
            m.setPosition(keyIn.nextLine());

            managers.add(m);
            
            System.out.println("계속 입력하시겠습니까??");
            String yn=keyIn.nextLine();
            if(yn.toUpperCase().equals("N"))
                break;

        }
    }

    private void ptrintManagers() {
        for(int i=0;i<managers.size(); i++) {
            Manager m = managers.get(i);

            System.out.printf("%s, %s, %s, %s, %s\n",
                    m.getName(),
                    m.getEmail(),
                    m.getPassword(),
                    m.getTel(),
                    m.getPosition());
        }
    }


    private void deleteManager(Scanner keyIn) {
        System.out.println("삭제할 번호?");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no<0 || no>= managers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }

        managers.remove(no);
        System.out.println("삭제하였습니다.");
    }

    private void detailManager(Scanner keyIn) {
        System.out.println("조회할 번호?");
        int no= Integer.parseInt(keyIn.nextLine());

        if(no<0 || no>= managers.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        Manager manager = managers.get(no);

        System.out.printf("이름: %s\n",manager.getName());
        System.out.printf("이메일: %s\n",manager.getEmail());
        System.out.printf("비번: %s\n",manager.getPassword());
        System.out.printf("전화: %s\n",manager.getTel());
        System.out.printf("직위: %s\n",manager.getPosition());
    }
}
