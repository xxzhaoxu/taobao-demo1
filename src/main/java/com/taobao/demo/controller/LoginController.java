package com.taobao.demo.controller;

import com.taobao.demo.config.DataBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.util.Map;

/**
 * @author zhaoxu
 */
@Controller
public class LoginController {
    @Autowired
    private DataBase dataBase;
    @GetMapping("/login")
    public String login(Model model) {
        System.out.println("1213123");
        // 这里返回的login指的是src/main/resources/templates目录下的login.html
        //        // 因此，我们需要在src/main/resources/templates目录下新建一个login.html
        //        // 当我们通过浏览器访问localhost:8080/login时即可访问到我们编写的login.html
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@RequestParam(name = "username")String username, @RequestParam(name="password")String password, Model model){

        Map<String,String> user =  dataBase.findUserByName(username);
        if (user.size()>0){
            if (password.equals(user.get(username))){
                Map reMap = dataBase.findAllUser();
                model.addAttribute("userMap",reMap);
                model.addAttribute("bookMap",dataBase.findAllBook());
                model.addAttribute("tag","1");
                return "index";
            }
        }
        model.addAttribute("message","请正确输入用户名和密码！");
        return "login";
    }

    @GetMapping("/registe")
    public String registe(){
        return "registe";
    }
    @PostMapping("/doRegiste")
    public String doRegiste(@RequestParam("username")String username,@RequestParam("password")String password,@RequestParam("p2")String p2, Model model){
        if (StringUtils.isEmpty(username)||password.isEmpty()||p2.isEmpty()){
            model.addAttribute("message","用户名和密码不能为空！");
            return "registe";
        }
        if (!password.equals(p2)){
            model.addAttribute("message","2次输入的密码不一样！");
            return "registe";
        }
        if (dataBase.addUser(username,password)){
            return "login";
        }
        model.addAttribute("message","注册失败！");
       return "registe";
    }

    @GetMapping("/findAllUser")
    public String findAllUser( Model model){
        Map reMap = dataBase.findAllUser();
        model.addAttribute("userMap",reMap);
        return "index";
    }

    @GetMapping("/delUser")
    public String delUser(@RequestParam("username")String username,Model model){
        System.out.println(username);
        if ("admin".equals(username)){
           model.addAttribute("message","管理员不能删除!");
           model.addAttribute("userMap",dataBase.findAllUser());
           return "index";
        }
        boolean re = dataBase.deleteUser(username);
        if (re){
            model.addAttribute("message","操作成功!");
        }else {
            model.addAttribute("message","操作失败！");
        }
        return "index";
    }

    @GetMapping("/delBook")
    public String delBook(@RequestParam("name")String name,Model model){
        boolean re = dataBase.delBook(name);
        if (re){
            model.addAttribute("message","操作成功!");
        }else {
            model.addAttribute("message","操作失败！");
        }
        model.addAttribute("userMap",dataBase.findAllUser());
        model.addAttribute("bookMap",dataBase.findAllBook());
        return "index";
    }

    @GetMapping("/switchTag")
    public String switchTag(@RequestParam("tag")String tag,Model model){
        model.addAttribute("userMap",dataBase.findAllUser());
        model.addAttribute("bookMap",dataBase.findAllBook());
        model.addAttribute("tag",tag);
        return "index";
    }

}
