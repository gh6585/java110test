package bitcamp.java110test.cms.control.manager;

import java.util.List;
import java.util.Scanner;

import bitcamp.java110test.cms.annotation.Autowired;
import bitcamp.java110test.cms.annotation.Component;
import bitcamp.java110test.cms.annotation.RequestMapping;
import bitcamp.java110test.cms.dao.ManagerDao;
import bitcamp.java110test.cms.domain.Manager;

@Component
public class ManagerListController {
    
    ManagerDao managerDao;
    
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
    
    @RequestMapping("manager/list")
    public void list(Scanner keyIn) {
        List<Manager> list = managerDao.findAll();
        for(Manager m : list) {
        
            System.out.printf("%s, %s, %s, %s, %s\n",
                    m.getName(),
                    m.getEmail(),
                    m.getPassword(),
                    m.getTel(),
                    m.getPosition());
        }
    }
}
