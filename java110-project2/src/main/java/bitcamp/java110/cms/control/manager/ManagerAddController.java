package bitcamp.java110.cms.control.manager;

import java.io.PrintWriter;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;

@Component
public class ManagerAddController { 

    ManagerDao managerDao;
  
    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }
    
    @RequestMapping("manager/add")
    
    public void add(Request request, Response response) {
        while (true) {
            Manager m = new Manager();
            
            m.setName(request.getParamerter("name"));
            m.setEmail(request.getParamerter("email"));
            m.setPassword(request.getParamerter("password"));
            m.setTel(request.getParamerter("tel"));
            m.setPosition(request.getParamerter("position"));
            
            PrintWriter out = response.getWriter();
            if (managerDao.insert(m) > 0) {
                out.println("저장하였습니다.");
            } else {
                out.println("같은 이메일의 매니저가 존재합니다.");
            }
        }
    }
    
}
    
    
    
    
    
    
    
    
    
