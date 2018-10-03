package bitcamp.java110test.cms.control.manager;

import java.util.Scanner;

import bitcamp.java110test.cms.App;
import bitcamp.java110test.cms.annotation.Component;
import bitcamp.java110test.cms.annotation.RequestMapping;
import bitcamp.java110test.cms.domain.Manager;

@Component
public class ManagerListController {
    @RequestMapping("manager/list")
    public void list(Scanner keyIn) {
        for(int i=0;i<App.managers.size(); i++) {
            Manager m = App.managers.get(i);

            System.out.printf("%s, %s, %s, %s, %s\n",
                    m.getName(),
                    m.getEmail(),
                    m.getPassword(),
                    m.getTel(),
                    m.getPosition());
        }
    }
}
