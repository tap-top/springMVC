package com.tww.service;

import com.tww.dao.LoginDAO;
import com.tww.model.TbLogininfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginServiceImpl implements LoginService {
    private LoginDAO loginDAO;

    public LoginDAO getLoginDAO() {
        return loginDAO;
    }

    public void setLoginDAO(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    @Override
    @Transactional
    public String Login(TbLogininfo p) {
        return this.loginDAO.Login(p);
    }
}
