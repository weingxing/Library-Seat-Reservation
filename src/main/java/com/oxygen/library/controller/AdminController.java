package com.oxygen.library.controller;

import com.oxygen.library.dto.*;
import com.oxygen.library.entity.SysUser;
import com.oxygen.library.service.ChooseSeatService;
import com.oxygen.library.service.SeatService;
import com.oxygen.library.service.SecurityService;
import com.oxygen.library.service.StudentService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private SecurityService securityService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private SeatService seatService;
    @Autowired
    private ChooseSeatService chooseSeatService;

    @GetMapping("/")
    public String index() throws Exception {
        return "login";
    }

    @GetMapping("/login")
    public String admin() throws Exception {
        return "login";
    }

    @GetMapping("/admin")
    public Object login() throws Exception {
        return "index";
    }

    @PostMapping(value = "/login", params = {"status"})
    @ResponseBody
    public Response loginResult(String status) throws Exception {
        if (status.equals("successful")) {
            SysUser user = securityService.getUserInfo();
            return new Response(200, "登录成功", user);
        } else {
            return new Response(200, "登录失败", null);
        }
    }

    @GetMapping("/menu")
    @ResponseBody
    public Menu menu() throws Exception {
        HomeInfo homeInfo = new HomeInfo("首页", "page/welcome.html");
        LogoInfo logoInfo = new LogoInfo("预约管理", "images/logo.png", "");

        List<MenuInfo> menuInfos = new ArrayList<>();
        menuInfos.add(new MenuInfo("预约记录", "fa fa-chevron-circle-up" ,"page/reservation.html"));
        menuInfos.add(new MenuInfo("学生管理", "fa fa-group" ,"page/student.html"));
        menuInfos.add(new MenuInfo("座位管理", "fa fa-cubes" ,"page/seat.html"));
        menuInfos.add(new MenuInfo("书库管理", "fa fa-book" ,"page/library.html"));
        menuInfos.add(new MenuInfo("人脸信息库", "fa fa-facebook", "page/face.html"));
        menuInfos.add(new MenuInfo("批量导入学生信息", "fa fa-file-zip-o", "page/add.html"));
        menuInfos.add(new MenuInfo("批量导入人脸信息", "fa fa-file-zip-o", "page/addface.html"));
        menuInfos.add(new MenuInfo("批量导入座位信息", "fa fa-file-zip-o", "page/addseat.html"));
//        menuInfos.add(new MenuInfo("用户管理", "fa fa-user" ,"page/user.html"));
        return new Menu(homeInfo, logoInfo, menuInfos);
    }

    @GetMapping("/welcome")
    @ResponseBody
    public Response welcome() throws Exception {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int today = chooseSeatService.getTodayCount(sdf.format(date).substring(0, 10));
        int seat = seatService.getAllSeat().size();
        int student = studentService.
                getStudentByPage(new PageRequest(1, Integer.MAX_VALUE)).getList().size();
        int all = chooseSeatService.
                getChooseSeatInfoByPage(new PageRequest(1, Integer.MAX_VALUE)).
                getList().size();
        return new Response(200, "OK", new Welcome(today, seat, all, student));
    }
}
