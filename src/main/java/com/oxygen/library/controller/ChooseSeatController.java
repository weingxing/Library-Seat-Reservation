package com.oxygen.library.controller;

import com.github.pagehelper.PageInfo;
import com.oxygen.library.dto.ChooseSeatInfo;
import com.oxygen.library.dto.LayuiPage;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.dto.Response;
import com.oxygen.library.entity.ChooseSeat;
import com.oxygen.library.service.ChooseSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ChooseSeat")
public class ChooseSeatController {
    @Autowired
    private ChooseSeatService chooseSeatService;

    @PostMapping("/add")
    private Response add(@RequestBody ChooseSeat chooseSeat) throws Exception {
        return new Response(200, "OK", chooseSeatService.addChooseSeat(chooseSeat));
    }

    @DeleteMapping(value = "/delete", params = {"cid"})
    private Response delete(int cid) throws Exception {
        return new Response(200, "OK", chooseSeatService.deleteChooseSeat(cid));
    }

    @PostMapping("/update")
    private Response update(@RequestBody ChooseSeat chooseSeat) throws Exception {
        return new Response(200, "OK", chooseSeatService.updateChooseSeat(chooseSeat));
    }

    @GetMapping(value = "/getChooseSeatByPage", params = {"page", "limit"})
    private LayuiPage getChooseSeatByPage(int page, int limit) throws Exception {
        PageRequest request = new PageRequest(page, limit);
        PageInfo<ChooseSeatInfo> p = chooseSeatService.getChooseSeatInfoByPage(request);
        return new LayuiPage(0, "", p.getTotal(), p.getList());
    }
}
