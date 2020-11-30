package com.oxygen.library.controller;

import com.github.pagehelper.PageInfo;
import com.oxygen.library.dto.LayuiPage;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.dto.Response;
import com.oxygen.library.entity.Library;
import com.oxygen.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/library")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @PostMapping("/add")
    public Response add(@RequestBody Library library) throws Exception {
        return new Response(200, "OK", libraryService.addLibrary(library));
    }

    @DeleteMapping(value = "/delete", params = {"lid"})
    public Response delete(int lid) throws Exception {
        return new Response(200, "OK", libraryService.deleteLibrary(lid));
    }

    @PostMapping("/update")
    public Response update(@RequestBody Library library) throws Exception {
        return new Response(200, "OK", libraryService.updateLibrary(library));
    }

    @GetMapping(value = "/getLibraryByPage", params = {"page", "limit"})
    public LayuiPage getLibraryVyPage(int page, int limit) throws Exception {
        PageRequest request = new PageRequest(page, limit);
        PageInfo<Library> p = libraryService.getLibraryByPage(request);
        return new LayuiPage(0, "", p.getTotal(), p.getList());
    }

}
