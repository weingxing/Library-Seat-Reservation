package com.oxygen.library.schedule;

import com.oxygen.library.entity.ChooseSeat;
import com.oxygen.library.entity.Seat;
import com.oxygen.library.entity.Student;
import com.oxygen.library.service.ChooseSeatService;
import com.oxygen.library.service.SeatService;
import com.oxygen.library.service.StudentService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class SeatCheckSchedule {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(SeatCheckSchedule.class);

    @Autowired
    private ChooseSeatService chooseSeatService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private SeatService seatService;

    @Scheduled(cron = "${schedule.check}")
    @Async
    public void check() {
        try {
            log.info("检查是否及时签到...");
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String keyword = sdf.format(date).substring(0, 10);
            List<ChooseSeat> chooseSeats = chooseSeatService.getToday("%" + keyword + "%");
            for (ChooseSeat chooseSeat : chooseSeats) {
                Date start = sdf.parse(chooseSeat.getDate());
                long time = (date.getTime() - start.getTime()) / 1000 / 60;
                if(time > 30 && chooseSeat.getEnterDate() == null) {
                    Student student = studentService.getStudentByStuId(chooseSeat.getStuId());
                    Seat seat = seatService.getSeatBySid(chooseSeat.getSid());
                    // 未按照规定时间签到，扣除2信誉分
                    student.setReputation(student.getReputation() - 2);
                    seat.setAvailable("1");
                    chooseSeat.setLeaveDate("未及时签到，自动释放并扣除2信誉");
                    chooseSeat.setHour("0");
                    chooseSeat.setEnterDate("-");
                    chooseSeat.setLeaveNum("-");
                    studentService.updateStudent(student);
                    chooseSeatService.updateChooseSeat(chooseSeat);
                    seatService.updateSeat(seat);
                    log.info(student.getStuId() + " " + student.getSname() + " 未及时签到，扣除2信誉值");
                }
            }
            log.info("检查完成");
        } catch (Exception e) {
            log.error(e.toString());
        }
    }
}
