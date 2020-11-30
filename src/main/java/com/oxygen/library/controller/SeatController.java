package com.oxygen.library.controller;

import com.github.pagehelper.PageInfo;
import com.oxygen.library.dto.LayuiPage;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.dto.Response;
import com.oxygen.library.dto.SeatInfo;
import com.oxygen.library.entity.Library;
import com.oxygen.library.entity.Seat;
import com.oxygen.library.service.LibraryService;
import com.oxygen.library.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/seat")
public class SeatController {
    @Autowired
    private SeatService seatService;
    @Autowired
    private LibraryService libraryService;

    @PostMapping("/add")
    public Response add(@RequestBody SeatInfo seatInfo) throws Exception {
        Seat seat = new Seat();
        seat.setSid(seatInfo.getSid());
        seat.setAvailable("1");
        seat.setPositio(seatInfo.getPosition());
        seat.setStatus(seatInfo.getStatus());

        Library library = libraryService.getLibraryByName(seatInfo.getLibraryName());
        if (library != null)
            seat.setLid(library.getLid());
        else {
            Library lib = new Library();
            lib.setLibraryName(seatInfo.getLibraryName());
            if (libraryService.addLibrary(lib)) {
                seat.setLid(libraryService.getLibraryByName(seatInfo.getLibraryName()).getLid());
            }
            else
                return new Response(200, "OK", "ERROR");
        }

        return new Response(200, "OK", seatService.addSeat(seat));
    }

    @DeleteMapping(value = "/delete", params = {"sid"})
    public Response delete(int sid) throws Exception {
        return new Response(200, "OK", seatService.deleteSeat(sid));
    }

    @PostMapping("/update")
    public Response update(@RequestBody SeatInfo seatInfo) throws Exception {
        Seat seat = new Seat();
        seat.setSid(seatInfo.getSid());
        seat.setAvailable(seatInfo.getAvailable());
        seat.setPositio(seatInfo.getPosition());
        seat.setStatus(seatInfo.getStatus());

        Library library = libraryService.getLibraryByName(seatInfo.getLibraryName());
        if (library != null)
            seat.setLid(library.getLid());
        else {
            Library lib = new Library();
            lib.setLibraryName(seatInfo.getLibraryName());
            if (libraryService.addLibrary(lib)) {
                seat.setLid(libraryService.getLibraryByName(seatInfo.getLibraryName()).getLid());
            }
            else
                return new Response(200, "OK", "ERROR");
        }

        return new Response(200, "OK", seatService.updateSeat(seat));
    }

    @GetMapping(value = "/getSeatByPage", params = {"page", "limit"})
    public LayuiPage getSeatByPage(int page, int limit) throws Exception {
        PageRequest request = new PageRequest(page, limit);
        PageInfo<SeatInfo> p = seatService.getSeatByPage(request);
        return new LayuiPage(0, "", p.getTotal(), p.getList());
    }

    @GetMapping(value = "/search", params = {"page", "limit", "keyword"})
    public LayuiPage search(int page, int limit, String keyword) throws Exception {
        PageRequest request = new PageRequest(page, limit);
        PageInfo<SeatInfo> p = seatService.search(request, keyword);
        return new LayuiPage(0, "", p.getTotal(), p.getList());
    }
}
