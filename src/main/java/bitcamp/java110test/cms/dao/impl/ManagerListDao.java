package bitcamp.java110test.cms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import bitcamp.java110test.cms.dao.ManagerDao;
import bitcamp.java110test.cms.domain.Manager;

public class ManagerListDao implements ManagerDao{
    private List<Manager> list = new ArrayList<>();
    
    @Override
    public int insert(Manager manager) {
        for (Manager item : list) {
            if(item.getEmail().equals(manager.getEmail())) {
                return 0;
            }
        }
        list.add(manager);
        return 1;
    }

    @Override
    public List<Manager> findAll() {
        return list;
    }

    @Override
    public Manager findByEmail(String email) {
        for (Manager item : list) {
            if (item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public int delete(String email) {
        for (Manager item : list) {
            if (item.getEmail().equals(email)) {
                list.remove(item);
                return 1;
            }
        }
        return 0;
    }
    
    
    
}
