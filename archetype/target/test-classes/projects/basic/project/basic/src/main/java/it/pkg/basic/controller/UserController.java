package it.pkg.basic.controller;

import it.pkg.basic.model.User;
import it.pkg.basic.service.IUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Author：linlin.yang
 * Date：2017/6/29 16:12
 */
@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger = Logger.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    /**
     * 返回逻辑视图名
     * @param model
     * @return
     */
    @RequestMapping("/queryUserCount")
    public String queryUserCount(Model model){
        Integer count=userService.getUserCount();
        model.addAttribute("message", count);
        return "success";
    }

    /**
     * 返回json数据
     * @return
     */
    @RequestMapping(value = "/queryUserCount2",method = RequestMethod.GET)
    @ResponseBody
    public Integer queryUserCount2(){
        Integer count=userService.getUserCount();
        return count;
    }

    @RequestMapping(value = "/queryUserByName")
    @ResponseBody
    public List<User> queryUserByName(@RequestParam(value = "name") String name){
        List<User> user=userService.getUserByName(name);
        return user;
    }
}
