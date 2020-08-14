package com.service.impl;

import com.dao.AdminDao;
import com.dao.ReaderDao;
import com.dao.impl.AdminDaoImpl;
import com.dao.impl.ReaderDaoImpl;
import com.service.ReaderService;

/**
 * @author 17586
 */
public class ReaderServiceImpl implements ReaderService {
    private final ReaderDao readerDao = new ReaderDaoImpl();
    private final AdminDao adminDao = new AdminDaoImpl();
    Object object = null;
    @Override
    public Object login(String username, String password, String type) {
        switch (type){
            case "reader":
                object = readerDao.login(username, password);
                break;
            case "admin":
                object = adminDao.login(username, password);
                break;
            default:
                break;
        }
        return object;
    }
}
