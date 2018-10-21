//  인스턴스 비교 IV : equals()와 hashCode() 자동 생성하기 
//
package ex05;

import java.util.HashSet;

public class Text02_p4 {
        
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
        
        
        /*@Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + age;
            result = prime * result + ((name == null) ? 0 : name.hashCode());
            return result;
        }*/
         
     }
     
        
     public static void main(String[] args) {
         
         Member obj1= new Member("홍길동", 20);
         Member obj2= new Member("홍길동", 20);
         
         if(obj1 == obj2) System.out.println("obj1 == obj2");
         else System.out.println("obj1 != obj2");
         
         if(obj1.equals(obj2)) System.out.println("obj == obj2");
         else System.out.println("obj1 != obj2");
         
         HashSet<Member> set2 = new HashSet<>();
         set2.add(obj1);
         set2.add(obj2);
         
         System.out.println("-----------");
         for (Member m : set2) {
             System.out.println(m);
         }
         System.out.println("----------------");
         
         
     }

}














