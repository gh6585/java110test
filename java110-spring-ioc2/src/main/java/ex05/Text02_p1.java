// 객체 생성 : XML에 객체 생성을 설정하는 방법과 컨테이너에 보관된 객체 확인하기
// XML 문법
//      <bean id="객체명" class="클래스명">
//          <property name="프로퍼티명" value="파라미터값">
//      </bean>
//
package ex05;

public class Text02_p1 {
        
     static class Member{
         String name;
         int age;
         public Member(String name, int age) {
             this.name = name;
             this.age = age;
         }
         
     }
     
        
     public static void main(String[] args) {
         
         Member obj1 = new Member("홍길동", 20);
         Member obj2 = new Member("홍길동", 20);
         
         // 인스턴스 비교
         // 1) == 연산자는 레퍼런스에 저장된 인스턴스의 주소를 비교한다.
         if (obj1 == obj2) System.out.println("obj1 == obj2");
         else System.out.println("obj1 != obj2");
         
         // 2) Object에서 상속 받은 equals() 메서드는 == 연산자와 같다.
         if (obj1.equals(obj2)) System.out.println("obj1 == obj2");
         else System.out.println("obj1 != obj2");
         
     }

}
