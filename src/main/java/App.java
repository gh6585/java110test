import java.util.Scanner;

public class App {
    static class Members{
        protected String name;
        protected String email;
        protected String password;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public String getPassword() {
            return password;
        }
        public void setPassword(String password) {
            this.password = password;
        }
        
        
    }
    
    static Members[] members=new Members[100];  
    static int index=0;
    static Scanner sc=new Scanner(System.in);
       public static void main(String[] args) {
     inputmember();
     ptrintmember();
       
       sc.close();
     
       }
       static void inputmember() {
           while(true) {
               Members m=new Members();
               System.out.println("아이디");
               m.setName(sc.nextLine());
               System.out.println("이메일");
               m.setEmail(sc.nextLine());
               System.out.println("비밀번호");
               m.setPassword(sc.nextLine());
               
               
               members[index++]=m;
               
               System.out.println("계속 입력하시겠습니까??");
               String yn=sc.nextLine();
               if(yn.toUpperCase().equals("N"))
                   break;
               
               }
           
       }
       static void ptrintmember() {
           for(int i=0;i<index;i++) {
               System.out.printf("%s,%s,%s\n"
                       ,members[i].getName(),members[i].getEmail(),members[i].getPassword());
               }
       }
}
