package com.oxygen.library.schedule;

import com.oxygen.library.controller.WechatController;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.dto.Response;
import com.oxygen.library.entity.ChooseSeat;
import com.oxygen.library.entity.Library;
import com.oxygen.library.service.ChooseSeatService;
import com.oxygen.library.service.LibraryService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class LibrarySchedule {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(LibrarySchedule.class);
    @Autowired
    private LibraryService libraryService;
    @Autowired
    private ChooseSeatService chooseSeatService;
    @Autowired
    private WechatController wechatController;

    @Scheduled(cron = "${schedule.close}")
    @Async
    public void libraryClose() {
        try {
            log.info("关闭书库...");
            PageRequest request = new PageRequest(1, Integer.MAX_VALUE);
            List<Library> libraries = libraryService.getLibraryByPage(request).getList();
            for(Library library : libraries) {
                if(library.getStatus().equals("opening"))
                    library.setStatus("open");
                libraryService.updateLibrary(library);
            }
            log.info("关闭完成");
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    @Scheduled(cron = "${schedule.open}")
    @Async
    public void libraryOpen() {
        try {
            log.info("打开书库...");
            PageRequest request = new PageRequest(1, Integer.MAX_VALUE);
            List<Library> libraries = libraryService.getLibraryByPage(request).getList();
            for(Library library : libraries) {
                if(library.getStatus().equals("open"))
                    library.setStatus("opening");
                libraryService.updateLibrary(library);
            }
            log.info("打开完成");
        } catch (Exception e) {
            log.error(e.toString());
        }
    }

    @Scheduled(cron = "${schedule.release}")
    @Async
    public void release() {
        try {
            log.info("释放座位...");
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String keyword = sdf.format(date).substring(0, 10);
            List<ChooseSeat> chooseSeats = chooseSeatService.getToday("%"+keyword+"%");

            for (ChooseSeat chooseSeat : chooseSeats) {
                Response response = wechatController.release(chooseSeat.getCid());
                log.info("释放结果: " + response.toString());
            }
            log.info("---------------释放完成---------------");
        } catch (Exception e) {
            log.error(e.toString());
        }
    }
}
