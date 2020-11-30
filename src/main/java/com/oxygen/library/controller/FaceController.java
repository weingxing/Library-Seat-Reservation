package com.oxygen.library.controller;

import com.github.pagehelper.PageInfo;
import com.oxygen.library.dto.FaceDto;
import com.oxygen.library.dto.LayuiPage;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.dto.Response;
import com.oxygen.library.service.FaceService;
import com.oxygen.library.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/face")
public class FaceController {
    @Autowired
    private FaceService faceService;
    @Autowired
    private FileService fileService;

    @GetMapping(value = "/getFaceByPage", params = {"page", "limit"})
    public LayuiPage getFaceByPage(int page, int limit) throws Exception{
        PageRequest request = new PageRequest(page, limit);
        PageInfo<FaceDto> p = faceService.getAllByPage(request);
        return new LayuiPage(0, "", p.getTotal(), p.getList());
    }

    @GetMapping(value = "/search", params = {"page", "limit", "keyword"})
    public LayuiPage search(int page, int limit, String keyword) throws Exception {
        PageRequest request = new PageRequest(page, limit);
        PageInfo<FaceDto> p = faceService.search(request, keyword);
        return new LayuiPage(0, "", p.getTotal(), p.getList());
    }

    @DeleteMapping(value = "/delete", params = {"stuId"})
    public Response delete(int stuId) throws Exception {
        return new Response(0, "OK", faceService.delete(stuId));
    }
}
