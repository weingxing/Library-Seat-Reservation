package com.oxygen.library.controller;


import com.github.pagehelper.PageInfo;
import com.oxygen.library.dto.LayuiPage;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.dto.Response;
import com.oxygen.library.entity.Student;
import com.oxygen.library.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public Response add(@RequestBody Student student) throws Exception {
        student.setReputation(100);
        student.setStatus("normal");
        return new Response(200, "OK", studentService.addStudent(student));
    }

    @PostMapping("/update")
    public Response update(@RequestBody Student student) throws Exception {
        return new Response(200, "OK", studentService.updateStudent(student));
    }

    @DeleteMapping(value = "/delete", params = {"stuId"})
    public Response delete(int stuId) throws Exception {
        return new Response(200, "OK", studentService.deleteStudent(stuId));
    }

    @GetMapping(value = "/getStudentByPage", params = {"page", "limit"})
    public LayuiPage getStudentByPage(int page, int limit) throws Exception {
        PageRequest request = new PageRequest(page, limit);
        PageInfo<Student> p = studentService.getStudentByPage(request);
        return new LayuiPage(0, "", p.getTotal(), p.getList());
    }

    @GetMapping(value = "/search", params = {"page", "limit", "keyword"})
    public LayuiPage search(int page, int limit, String keyword) throws Exception {
        PageRequest request = new PageRequest(page, limit);
        PageInfo<Student> p = studentService.search(request, keyword);
        return new LayuiPage(0, "", p.getTotal(), p.getList());
    }
}
