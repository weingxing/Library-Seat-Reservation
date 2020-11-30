package com.oxygen.library.dao;

import com.oxygen.library.entity.Library;

import java.util.List;

public interface LibraryMapper {
    int deleteByPrimaryKey(Integer lid);

    int insert(Library record);

    int insertSelective(Library record);

    Library selectByPrimaryKey(Integer lid);

    Library selectByName(String name);

    List<Library> selectAll();

    int updateByPrimaryKeySelective(Library record);

    int updateByPrimaryKey(Library record);
}