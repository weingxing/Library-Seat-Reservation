package com.oxygen.library.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oxygen.library.dao.LibraryMapper;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.entity.Library;

import com.oxygen.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    private LibraryMapper libraryMapper;

    @Override
    public boolean addLibrary(Library library) throws Exception {
        return libraryMapper.insert(library) > 0;
    }

    @Override
    public boolean deleteLibrary(int lid) throws Exception {
        return libraryMapper.deleteByPrimaryKey(lid) > 0;
    }

    @Override
    public boolean updateLibrary(Library library) throws Exception {
        return libraryMapper.updateByPrimaryKeySelective(library) > 0;
    }

    @Override
    public PageInfo<Library> getLibraryByPage(PageRequest request) throws Exception {
        int pageNum = request.getPageNum();
        int pageSize = request.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Library> content = libraryMapper.selectAll();
        return new PageInfo<Library>(content);
    }

    @Override
    public Library getLibraryByName(String name) throws Exception {
        return libraryMapper.selectByName(name);
    }
}
