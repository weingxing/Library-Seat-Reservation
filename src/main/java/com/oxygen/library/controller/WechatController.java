package com.oxygen.library.controller;

import com.github.pagehelper.PageInfo;
import com.oxygen.library.dto.LayuiPage;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.dto.Response;
import com.oxygen.library.dto.WechatSeat;
import com.oxygen.library.entity.ChooseSeat;
import com.oxygen.library.entity.Library;
import com.oxygen.library.entity.Seat;
import com.oxygen.library.entity.Student;
import com.oxygen.library.service.ChooseSeatService;
import com.oxygen.library.service.LibraryService;
import com.oxygen.library.service.SeatService;
import com.oxygen.library.service.StudentService;
import com.oxygen.library.util.WechatUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/wechat")
public class WechatController {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(WechatController.class);
    @Autowired
    private SeatService seatService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ChooseSeatService chooseSeatService;
    @Autowired
    private LibraryService libraryService;

    @Value("${common.max}")
    private int MAX;

    @GetMapping(value = "/login", params = {"code"})
    public String login(String code) throws Exception {
        return WechatUtil.getOpenid(code);
    }

    @GetMapping(value = "/register", params = {"stuId", "name", "openid"})
    public Response register(int stuId, String name, String openid) throws Exception {
        Student student = studentService.getStudentByStuId(stuId);
        if (student.getSname().equals(name) && student.getOpenid()==null) {
            student.setOpenid(openid);
            if (studentService.updateStudent(student))
                return new Response(200, "OK", true);
        }
        return new Response(200, "OK", false);
    }

    @GetMapping(value = "/access", params = {"openid"})
    public Response access(String openid) throws Exception {
        Student student = studentService.getStudentByOpenid(openid);
        if (student == null)
            return new Response(200, "OK", false);
        return new Response(200, "OK", true);
    }

    @GetMapping(value = "/getMyInfo", params = {"openid"})
    public Response getMyInfo(String openid) throws Exception {
        return new Response(200, "OK", studentService.getStudentByOpenid(openid));
    }

    @GetMapping(value = "/getSeatBySid", params = {"sid", "openid"})
    public Response getSeatBySid(int sid, String openid) throws Exception {
        Student student = studentService.getStudentByOpenid(openid);
        if (student == null)
            return new Response(200, "OK", "无权访问");
        return new Response(200, "OK", seatService.getSeatInfoBySid(sid));
    }

    @GetMapping(value = "/getSeats", params = {"lid", "openid"})
    public Response getSeats(int lid, String openid) throws Exception {
        Student student = studentService.getStudentByOpenid(openid);
        if (student == null)
            return new Response(200, "OK", "无权访问");
        PageRequest request = new PageRequest(1, Integer.MAX_VALUE);
        List<Seat> seats = seatService.getSeatByLid(lid);
        List<Integer> x = new ArrayList<>();
        List<Integer> y = new ArrayList<>();
        for (Seat seat : seats) {
            x.add(Integer.parseInt(seat.getPositio().replaceAll("，", ",").split(",")[0]));
            y.add(Integer.parseInt(seat.getPositio().replaceAll("，", ",").split(",")[1]));
        }
        int max_x = Collections.max(x) ;
        int max_y = Collections.max(y) ;

        WechatSeat[][] s = new WechatSeat[max_x][max_y];
        for(int i = 0; i < max_x; i++) {
            for(int j = 0; j < max_y; j++) {
                s[i][j] = new WechatSeat(j+1, "no");
            }
        }

        for(Seat seat : seats) {
            String[] t = seat.getPositio().replaceAll("，", ",").split(",");
            int posX = Integer.parseInt(t[0])-1;
            int posY = Integer.parseInt(t[1])-1;

            if (seat.getAvailable().equals("1"))
                s[posX][posY] = new WechatSeat(s[posX][posY].getNum(), "seat.png");
            else
                s[posX][posY] = new WechatSeat(s[posX][posY].getNum(), "noseat.png");
        }

        return new Response(200, "OK", s);
    }

    @PostMapping(value = "/chooseSeat", params = {"openid", "x", "y", "lid"})
    public Response chooseSeat(String openid, String x, String y, int lid) throws Exception {
        Student student = studentService.getStudentByOpenid(openid);
        if (student == null)
            return new Response(200, "OK", "无权访问");
        if (!"normal".equals(student.getStatus()))
            return new Response(200, "OK", "帐号状态异常，无法预约");
        else if (student.getReputation() < 60)
            return new Response(200, "OK", "信誉值过低，无法预约");
        else {
            Map<String, Object> param = new HashMap<>();

            param.put("lid", lid);
            param.put("position", x+','+y);
            Seat seat = seatService.getSeatByPosAndLid(param);
            if (seat.getAvailable().equals("1") && seat.getStatus().equals("opening")) {
                ChooseSeat chooseSeat = new ChooseSeat();
                chooseSeat.setSid(seat.getSid());
                chooseSeat.setStuId(student.getStuId());
                chooseSeat.setPause("0");
                Date date = new Date();
                String strDateFormat = "yyyy-MM-dd HH:mm:ss";
                SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
                chooseSeat.setDate(sdf.format(date));
                seat.setAvailable("0");
                List<ChooseSeat> cs = chooseSeatService.getChooseSeatByStuId(student.getStuId());
                ChooseSeat c = null;
                if(cs.size() != 0) {
                    c = cs.get(0);
                    if (c.getLeaveDate() == null)
                        return new Response(200, "OK", "已经预约过其他座位了");
                }
                if(seatService.updateSeat(seat) && chooseSeatService.addChooseSeat(chooseSeat))
                    return new Response(200, "OK", "预约成功");
            }
            return new Response(200, "OK", "预约失败，可能已被他人预约，换个试试吧");
        }
    }

    @GetMapping(value = "/getMyChooseSeat", params = {"openid"})
    public Response myChooseSeat(String openid) throws Exception {
        Student student = studentService.getStudentByOpenid(openid);
        if (student == null)
            return new Response(200, "OK", "无权访问");
        ChooseSeat c = chooseSeatService.getChooseSeatByStuId(student.getStuId()).get(0);
        return new Response(200, "OK", c);
    }

    @GetMapping(value = "/enter", params = {"stuId"})
    public Response enter(int stuId) throws Exception {
        Student student = studentService.getStudentByStuId(stuId);
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        Date date = new Date();

        // 取得最新的预约
        List<ChooseSeat> chooseSeats = chooseSeatService.getChooseSeatByStuId(student.getStuId());
        ChooseSeat chooseSeat = null;
        if(chooseSeats.size() != 0)
            chooseSeat = chooseSeats.get(0);
        else
            return new Response(200, "OK", "未查询到预约");
        // 已经离开或取消
        if (chooseSeat.getLeaveDate() != null)
            return new Response(200, "OK", "未查询到预约");

        // 简单实现幂等性，防止因为网络波动等原因导致错误扣除用户信誉值
        if (chooseSeat.getEnterDate() != null && chooseSeat.getLeaveDate() == null) {
            Date enterTime = sdf.parse(chooseSeat.getEnterDate());
            // 很小概率在签到处停留一分钟，一分钟内提交的相同请求不对数据库做修改
            // 初次签到
            if (date.getTime() - enterTime.getTime() < 60000) {
                return new Response(200, "OK",
                        chooseSeatService.getChooseSeatInfoByCid(chooseSeat.getCid()));
            } else if (chooseSeat.getHour() != null) {
                // 再次进入
                Date t = sdf.parse(chooseSeat.getHour());
                if (date.getTime() - t.getTime() < 60000) {
                    return new Response(200, "OK",
                            chooseSeatService.getChooseSeatInfoByCid(chooseSeat.getCid()));
                }
            }
        }

        // 预约后初次进入
        if (chooseSeat.getEnterDate() == null) {
            chooseSeat.setEnterDate(sdf.format(date));
            chooseSeat.setLeaveNum("0");
        } else {
            Date last = null;
            // 未暂离
            if ("0".equals(chooseSeat.getPause())) {
                last = new Date();
                // 扣除5信誉值
                student.setReputation(student.getReputation() - 5);
                studentService.updateStudent(student);
                log.info(student.getStuId()+"离馆时未设置暂时离开，扣除5信誉值");
            } else {
                // 暂离
                last = sdf.parse(chooseSeat.getHour());
                chooseSeat.setPause("0");
            }

            long time = date.getTime() - last.getTime();
            // 大于预设间隔，扣除2信誉分
            if((time/1000/60) > this.MAX) {
                log.info(String.valueOf(student.getStuId()), "外出时间超过预设值，扣除2信誉值");
                student.setReputation(student.getReputation() - 2);
                studentService.updateStudent(student);
            }
            chooseSeat.setLeaveNum(String.valueOf(Integer.parseInt(chooseSeat.getLeaveNum()) + 1));
            // 最近进入时间
            chooseSeat.setHour(sdf.format(new Date()));
        }

        if (chooseSeatService.updateChooseSeat(chooseSeat)) {
            return new Response(200, "成功",
                    chooseSeatService.getChooseSeatInfoByCid(chooseSeat.getCid()));
        }
        return new Response(200, "OK", null);
    }

    @PostMapping(value = "/leave", params = {"cid", "openid"})
    public Response leave(int cid, String openid) throws Exception {
        Student s = studentService.getStudentByOpenid(openid);
        if(s == null)
            return new Response(200, "OK", "无权访问");


        return release(cid);
    }

    public Response release(int cid) throws Exception {
        ChooseSeat chooseSeat = chooseSeatService.getByCid(cid);
        Seat seat = seatService.getSeatBySid(chooseSeat.getSid());
        seat.setAvailable("1");
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        // 入馆后取消
        if (chooseSeat.getEnterDate()!= null) {
            long start = new Date().getTime();
            if (! "-".equals(chooseSeat.getEnterDate()))
                start = sdf.parse(chooseSeat.getEnterDate()).getTime();
            long end = date.getTime();
            chooseSeat.setHour(String.valueOf((end - start) / 1000 / 60));
            chooseSeat.setLeaveDate(sdf.format(date));
        } else {
            // 未入馆取消
            chooseSeat.setLeaveDate("-");
            chooseSeat.setHour("0");
            chooseSeat.setEnterDate("-");
            chooseSeat.setLeaveNum("-");
        }
        if (chooseSeatService.updateChooseSeat(chooseSeat) && seatService.updateSeat(seat))
            return new Response(200, "OK", "位置释放成功，休息一下吧~");
        return new Response(200, "OK", "位置释放失败");
    }

    @GetMapping("/reservationNum")
    public Response reservationNum() throws Exception {
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        String today = sdf.format(date).substring(0, 10);
        return new Response(200, "OK", chooseSeatService.getTodayCount(today));
    }

    @GetMapping(value = "/getLibrary", params = {"openid"})
    public LayuiPage getLibrary(String openid) throws Exception {
//        Student student = studentService.getStudentByOpenid(openid);
//        if(student == null)
//            return new LayuiPage(0, "无权访问", 0, null);

        PageRequest request = new PageRequest(1, Integer.MAX_VALUE);
        PageInfo<Library> p = libraryService.getLibraryByPage(request);
        return new LayuiPage(0, "", p.getTotal(), p.getList());
    }

    @PostMapping(value = "/pause", params = {"cid", "openid"})
    public Response pause(int cid, String openid) throws Exception {
        Student student = studentService.getStudentByOpenid(openid);
        if(student == null)
            return new Response(200, "OK", "无权访问");
        ChooseSeat chooseSeat = chooseSeatService.getByCid(cid);
        if (chooseSeat.getEnterDate() == null)
            return new Response(200, "OK", "未进入图书馆");
        if("0".equals(chooseSeat.getPause())) {
            Date date = new Date();
            String strDateFormat = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
            chooseSeat.setHour(sdf.format(date));
            chooseSeat.setPause("1");
            if (chooseSeatService.updateChooseSeat(chooseSeat))
                return new Response(200, "OK", "提交成功，记得及时回来~");
        }
        return new Response(200, "OK", "提交失败，请重试");
    }
}
