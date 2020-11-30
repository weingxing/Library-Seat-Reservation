package com.oxygen.library.service;

import com.github.pagehelper.PageInfo;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.entity.Student;

import java.util.concurrent.CompletableFuture;

public interface StudentService {

    public Student getStudentByStuId(int stuId) throws Exception;

    public Student getStudentByOpenid(String openid) throws Exception;

    public PageInfo<Student> getStudentByPage(PageRequest request) throws Exception;

    public boolean updateStudent(Student student) throws Exception;

    public boolean deleteStudent(int stuId) throws Exception;

    public boolean addStudent(Student student) throws Exception;

    public PageInfo<Student> search(PageRequest request, String keyword) throws Exception;

    public CompletableFuture<Boolean> batchAdd(String path) throws Exception;
}
