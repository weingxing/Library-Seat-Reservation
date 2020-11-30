package com.oxygen.library.controller;

import com.oxygen.library.dto.Response;
import com.oxygen.library.service.FaceService;
import com.oxygen.library.service.FileService;
import com.oxygen.library.service.SeatService;
import com.oxygen.library.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class BatchController {
    @Autowired
    private FileService fileService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private SeatService seatService;
    @Autowired
    private FaceService faceService;

    @RequestMapping(value = "/batchAddStudent")
    public Response batchAddStudent(@RequestParam("file") MultipartFile file) throws Exception {
        // 保存文件并取得文件路径
        String path = (String)fileService.upload(file).getContent();
        return new Response(200, "OK", studentService.batchAdd(path));
    }

    @RequestMapping(value = "/batchAddSeat")
    public Response batchAddSeat(@RequestParam("file") MultipartFile file) throws Exception {
        // 保存文件并取得文件路径
        String path = (String)fileService.upload(file).getContent();
        return new Response(200, "OK", seatService.batchAdd(path));
    }

    @RequestMapping(value = "/batchAddFaceId")
    public Response batchAddFaceId(@RequestParam("file") MultipartFile file) throws Exception {
        // 保存文件并取得文件路径
        String path = (String)fileService.upload(file).getContent();
        return new Response(200, "OK", faceService.batchAdd(path));
    }
}
