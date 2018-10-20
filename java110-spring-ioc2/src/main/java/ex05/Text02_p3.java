//  인스턴스 비교 III : equals()와 hashCode() 
//
package ex05;

public class Text02_p3 {
        
     static class Member{
         String name;
         int age;
         public Member(String name, int age) {
             this.name = name;
             this.age = age;
         }
         
         
         @Override
         public boolean equals(Object obj) {
             // 인스터스 필드의 값이 같을 때 true 를 리턴하도록 재정의 한다.
             if(!(obj.getClass() == Member.class))
                 return false;
             
             Member other = (Member) obj;
             
             if(this == other)
                 return true;
             
             if(!this.name.equals(other.name) ||
             this.age != other.age)
                    return false;
                    
                    return true;
         }

        @Override
        public String toString() {
            return "Member [name=" + name + ", age=" + age + "]";
        }
        
        @Override
        public int hashCode() {
            return this.toString().hashCode();
        }
         
     }
     
        
     public static void main(String[] args) {
         
         Member s1 = new Member("홍길동", 20);
         Member s2 = new Member("홍길동", 20);
         
         // 인스턴스 비교
         // 1) == 연산자는 레퍼런스에 저장된 인스턴스의 주소를 비교한다.
         if (s1 == s2) System.out.println("s1 == s2");
         else System.out.println("s1 != s2");
         
         // 2) equalse() 메서드를 오버라이딩 하여 두 인스턴스의 값을 비교했기 떄문에
         //    인스턴스가 다르더라도 필드의 값이 같다면 true를 리턴할 것이다.
         if (s1.equals(s2)) System.out.println("s1 == s2");
         else System.out.println("s1 != s2");
         
     }

}
