package com.oxygen.library.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oxygen.library.dao.StudentMapper;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.entity.Student;
import com.oxygen.library.service.StudentService;
import com.oxygen.library.util.ExcelReaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student getStudentByStuId(int stuId) throws Exception {
        return studentMapper.selectByPrimaryKey(stuId);
    }

    @Override
    public Student getStudentByOpenid(String openid) throws Exception {
        return studentMapper.selectByOpenid(openid);
    }

    @Override
    public PageInfo<Student> getStudentByPage(PageRequest request) throws Exception {
        int pageNum = request.getPageNum();
        int pageSize = request.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Student> content = studentMapper.selectAll();
        return new PageInfo<Student>(content);
    }

    @Override
    public boolean updateStudent(Student student) throws Exception {
        return studentMapper.updateByPrimaryKeySelective(student) > 0;
    }

    @Override
    public boolean deleteStudent(int stuId) throws Exception {
        return studentMapper.deleteByPrimaryKey(stuId) > 0;
    }

    @Override
    public boolean addStudent(Student student) throws Exception {
        return studentMapper.insert(student) > 0;
    }

    @Override
    public PageInfo<Student> search(PageRequest request, String keyword) throws Exception {
        int pageNum = request.getPageNum();
        int pageSize = request.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Student> content = studentMapper.search("%" + keyword + "%");
        return new PageInfo<Student>(content);
    }

    @Override
    @Async
    public CompletableFuture<Boolean> batchAdd(String path) throws Exception {
        // 读取Excel数据
        List<List<String>> lists = ExcelReaderUtil.readExcel(path);
        //解析插入到数据库
        Student student = new Student();
        if (lists == null)
            return CompletableFuture.completedFuture(false);
        for (List<String> list : lists.subList(1, lists.size())) {
            student.setStuId(Integer.parseInt(list.get(0).replaceAll(" ", "")));
            student.setSname(list.get(1));
            student.setReputation(100);
            student.setStatus("normal");
            studentMapper.insert(student);
        }
        return CompletableFuture.completedFuture(true);
    }
}
