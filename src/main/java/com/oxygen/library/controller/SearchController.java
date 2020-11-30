package com.oxygen.library.controller;

import com.github.pagehelper.PageInfo;
import com.oxygen.library.dto.ChooseSeatInfo;
import com.oxygen.library.dto.LayuiPage;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.service.ChooseSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    @Autowired
    private ChooseSeatService chooseSeatService;

    @GetMapping(value = "/ChooseSeat/search", params = {"page", "limit", "keyword"})
    public LayuiPage search(int page, int limit, String keyword) throws Exception {
        PageRequest request = new PageRequest(page, limit);
        PageInfo<ChooseSeatInfo> p = chooseSeatService.search(request, keyword);
        return new LayuiPage(0, "", p.getTotal(), p.getList());
    }


}
