package com.taobao.demo.controller;

import com.taobao.demo.config.DataBase;
import com.taobao.demo.entity.StudentCard;
import com.taobao.demo.entity.User;
import com.taobao.demo.service.StudentCardService;
import com.taobao.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author zhaoxu
 */
@Controller
public class LoginController {
    @Autowired
    private DataBase dataBase;
    @Autowired
    private UserService userService;
    @Autowired
    private StudentCardService studentCardService;
    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @PostMapping("/doLogin")
    public String doLogin(@RequestParam(name = "username")String username, @RequestParam(name="password")String password, Model model){
        User user = userService.findUserByUserNameAndPswd(username,password);
        if (user!=null){
                List<User> userList = userService.findUserListByName(null);
                List<StudentCard> studentCardList  = studentCardService.selectStudentCard(null);
                model.addAttribute("userList",userList);
                model.addAttribute("studentCardList",studentCardList);
                model.addAttribute("tag","1");
                return "index";
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
        User user = new User(username,password);
        if (userService.saveUser(user)==1){
            return "login";
        }
        model.addAttribute("message","注册失败！");
       return "registe";
    }

    @GetMapping("/findAllUser")
    public String findAllUser( Model model){
        List<User> userList = userService.findUserListByName(null);
        model.addAttribute("userList",userList);
        return "index";
    }

    @GetMapping("/delUser")
    public String delUser(@RequestParam("uid")Integer uid, @RequestParam("tag")String  tag,Model model){
        System.out.println(uid);
        model.addAttribute("tag",tag);

        if (uid.equals(1)){
            model.addAttribute("userList",userService.findUserListByName(null));
           model.addAttribute("message","管理员不能删除!");
           return "index";
        }

        if (userService.delUser(uid)==1){
            model.addAttribute("message","操作成功!");
        }else {
            model.addAttribute("message","操作失败！");
        }
        model.addAttribute("userList",userService.findUserListByName(null));
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
        model.addAttribute("userList",userService.findUserListByName(null));
        model.addAttribute("tag",tag);
        model.addAttribute("studentCardList",studentCardService.selectStudentCard(null));
        return "index";
    }

    @GetMapping("/delStudent")
    public String delStudent(@RequestParam("sid")Integer sid,Model model){
         studentCardService.deleteByPrimaryKey(sid);
        model.addAttribute("tag","2");
        model.addAttribute("studentCardList",studentCardService.selectStudentCard(null));
         return "index";
    }

    @GetMapping("/addStudentCard")
    public String addStudentCard(){
        return "addUserCardInfo";
    }
    @PostMapping("doAddStudentCard")
    public String doAddStudentCard(
            @RequestParam("name")String name,
            @RequestParam("sno")String sno,
            @RequestParam("school")String school,
            @RequestParam("professional")String professional,
            @RequestParam("gender")String gender,
            @RequestParam("startTime")  @DateTimeFormat(pattern="yyyy-MM-dd") Date startTime,
            @RequestParam("endTime") @DateTimeFormat(pattern="yyyy-MM-dd") Date endTime,
            @RequestParam("createTime") @DateTimeFormat(pattern="yyyy-MM-dd") Date createTime,
            Model model
    ){
        StudentCard studentCard = new StudentCard(name,sno,startTime,endTime,createTime,school,professional,gender);
        studentCardService.insertSelective(studentCard);
        model.addAttribute("studentCardList",studentCardService.selectStudentCard(null));
        model.addAttribute("tag","2");
        return "index";
    }

    @GetMapping("updateStudentCard")
    public String updateStudentCard(@RequestParam("sid")Integer sid,Model model){
        model.addAttribute("studentCard",studentCardService.selectByPrimaryKey(sid));
        return "updataStudentCard";
    }
    @PostMapping("doUpdataStudentCard")
    public String updataStudentCard(
            @RequestParam("sid")Integer sid,
            @RequestParam("name")String name,
            @RequestParam("sno")String sno,
            @RequestParam("school")String school,
            @RequestParam("professional")String professional,
            @RequestParam("gender")String gender,
            @RequestParam("startTime")@DateTimeFormat(pattern="yyyy-MM-dd") Date startTime,
            @RequestParam("endTime")@DateTimeFormat(pattern="yyyy-MM-dd") Date endTime,
            @RequestParam("createTime")@DateTimeFormat(pattern="yyyy-MM-dd") Date createTime,
            Model model
    ){
        StudentCard studentCard = new StudentCard(name,sno,startTime,endTime,createTime,school,professional,gender);
        studentCard.setSid(sid);
        studentCardService.updateByPrimaryKeySelective(studentCard);
        List<StudentCard> studentCardList = studentCardService.selectStudentCard(null);
        model.addAttribute("studentCardList",studentCardList);
        model.addAttribute("tag","2");
        return "index";
    }

    @PostMapping("findUser")
    public String findUser(@RequestParam("sName")String sName,Model model){
        model.addAttribute("userList",userService.findUserListByName("".endsWith(sName)?null:sName));
        model.addAttribute("tag","1");
        return "index";
    }
    @PostMapping("findStudentCard")
    public String findStudentCard(
            @RequestParam(defaultValue = "0")Integer findType,
            @RequestParam("t")String name,
//            @RequestParam("sno")String sno,
//            @RequestParam("school")String school,
//            @RequestParam("professional")String professional,
//            @RequestParam("gender")String gender,
            Model model
    ){
        if ("".equals(name)){
            findType = 0;
        }
        StudentCard studentCard = new StudentCard();
        switch (findType) {
            case 1:
                studentCard.setName(name);
                break;
            case 2:
                studentCard.setsNo(name);
                break;
            case 3:
                studentCard.setSchool(name);
                break;
            case 4:
                studentCard.setProfessional(name);
                break;
            case 5:
                if ("女".equals(name)){
                    name = "0";
                }
                if ("男".equals(name)){
                    name="1";
                }
                studentCard.setGender(name);
                break;
            default:
                break;
        }
        List<StudentCard> studentCardList = studentCardService.selectStudentCard(studentCard);
        model.addAttribute("studentCardList",studentCardList);
        model.addAttribute("tag","2");
        return "index";
    }

    @GetMapping("backIndex")
    public String backIndex(Model model,String tag){
        List<User> userList = userService.findUserListByName(null);
        List<StudentCard> studentCardList  = studentCardService.selectStudentCard(null);
        model.addAttribute("userList",userList);
        model.addAttribute("studentCardList",studentCardList);
        model.addAttribute("tag",tag);
        return "index";
    }

    @GetMapping("updateUser")
    public String updateUser(@RequestParam("uid")Integer uid, Model model){
        model.addAttribute("user",userService.selectByPrimaryKey(uid));
        model.addAttribute("tag","1");
        return "updateUser";
    }
    @PostMapping("doUpdateUser")
    public String doUpdateUser(@RequestParam("uid")Integer uid,@RequestParam("userName")String userName,@RequestParam("passWord")String passWord,@RequestParam("p2")String p2,Model model){
       if (passWord.length()==0){
           model.addAttribute("user",userService.selectByPrimaryKey(uid));
           model.addAttribute("message","请正确输入密码");
           return "updateUser";
       }
        if (!p2.equals(passWord)){
            model.addAttribute("user",userService.selectByPrimaryKey(uid));
            model.addAttribute("message","两次密码不正确");
            return "updateUser";
        }
         User user = new User(userName,passWord);
         user.setUid(uid);

         userService.updateUser(user);
        List<User> userList = userService.findUserListByName(null);
        model.addAttribute("userList",userList);
        model.addAttribute("tag","1");

         return "index";
    }
}
