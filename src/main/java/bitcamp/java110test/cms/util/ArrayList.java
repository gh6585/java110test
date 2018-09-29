package bitcamp.java110test.cms.util;

public class ArrayList {
    
    Object[] list =new Object[5];
    int index =0;
    
    public void add (Object obj) {
        if(index == list.length) {
            increaseStorage();
        }
        list[index++] = obj;
    }
    
    private void increaseStorage() {
        Object[] newList = new Object[list.length +3];
        for(int i=0;i<list.length;i++) {
            newList[i] = list[i];
        }
        list = newList;
    }
    
    public void remove(int no) {
        if(no<0||no>list.length) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        for(int i=no ; i<list.length-1;i++) {
            list[i] = list[i+1];
        }
        index--;
    }

    public int size() {
        return index;
    }
    
    public Object get(int no) {
        if(no<0||no>list.length) {
            System.out.println("무효한 번호입니다.");
            return null;
        }
        return list[no];
    }
}
