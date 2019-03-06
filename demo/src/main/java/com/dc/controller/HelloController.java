package com.dc.controller;

import com.dc.pojo.User;
import com.dc.util.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.util.*;

/**
 * @Auther: dcf
 * @Date: 2019/2/18
 * @Description:
 */
@Controller
public class HelloController {
    // 创建线程安全的Map
    static Map<Integer, User> users = Collections.synchronizedMap(new HashMap<Integer, User>());

    @RequestMapping("/hello")
    public String index() throws Exception {
        throw new Exception("发生错误");
    }

    @ApiIgnore
    @RequestMapping("/u")
    public String index(ModelMap map) {
        users.put(1,new User((Integer)1,"张三",(Integer)24));
        List<User> r = new ArrayList<User>(users.values());
        // 加入一个属性，用来在模板中读取
        map.addAttribute("users", r);
        // return模板文件的名称，对应src/main/resources/templates/users/index.html
        return "users/index";
    }

    @RequestMapping("/list")
    public String  listUser(Model model) {
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i <10; i++) {
            userList.add(new User(i,"张三"+i,20+i));
        }

        model.addAttribute("users", userList);
        return "users/index";
    }

    @RequestMapping("/json")
    public String json() throws MyException {
        throw new MyException("发生错误2");
    }

    @RequestMapping("/login")
    public String login(String username,String password) {
        if("user".equals(username)){
            return "users/hello";
        }
        System.out.println(username+password);
        return "login";
    }
}
