package bitcamp.java110test.cms.dao;

import java.util.List;

import bitcamp.java110test.cms.domain.Manager;

public interface ManagerDao {
    int insert(Manager manager);
    List<Manager> findAll();
    Manager findByEmail(String email);
    int delete(String email);
}
