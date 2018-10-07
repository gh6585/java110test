package bitcamp.java110test.cms.dao.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110test.cms.annotation.Component;
import bitcamp.java110test.cms.dao.ManagerDao;
import bitcamp.java110test.cms.domain.Manager;

@Component
public class ManagerFile2Dao implements ManagerDao{

    static String defailtFilename = "data/manager2.dat";

    String filename;
    private List<Manager> list = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public ManagerFile2Dao(String filename) {
        this.filename = filename;

        File dataFile = new File(filename);
        try(
                FileInputStream in0 = new FileInputStream(dataFile);
                BufferedInputStream in1 = new BufferedInputStream(in0);
                ObjectInputStream in = new ObjectInputStream(in1);
                ){
            list = (List<Manager>) in.readObject();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ManagerFile2Dao() {
        this(defailtFilename);
    }

    private void save() {
        File dataFile = new File(filename);
        try(
                FileOutputStream out0 = new FileOutputStream(dataFile);
                BufferedOutputStream out1 = new BufferedOutputStream(out0);
                ObjectOutputStream out = new ObjectOutputStream(out1);
                ){
            out.writeObject(list);
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int insert(Manager manager) {
        for(Manager item : list) {
            if (item.getEmail().equals(manager.getEmail())) {
                return 0;
            }
        }
        list.add(manager);
        save();
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
            if(item.getEmail().equals(email)) {
                list.remove(item);
                return 1;
            }
        }
        save();
        return 0;
    }


}
