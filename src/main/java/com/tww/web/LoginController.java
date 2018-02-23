package com.tww.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tww.model.TbLogininfo;
import com.tww.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller()
public class LoginController {

    private LoginService loginService;

    @Autowired(required=true)
    @Qualifier(value="loginService")
    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }

//    @RequestMapping(value = "/login", method = RequestMethod.GET, produces={"text/html;charset=UTF-8;","application/json;"})
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public @ResponseBody String Login(
            @RequestParam(required = true) String name,
            @RequestParam(required = true) String password ) {
        ObjectMapper mapper = new ObjectMapper();
        TbLogininfo a = new TbLogininfo();
        a.setName(name);
        a.setPassword(password);
        return loginService.Login(a);
    }

}
