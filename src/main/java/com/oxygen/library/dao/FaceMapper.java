package com.oxygen.library.dao;

import com.oxygen.library.dto.FaceDto;
import com.oxygen.library.entity.Face;

import java.util.List;

public interface FaceMapper {
    int deleteByPrimaryKey(Integer stuId);

    int insert(Face record);

    int insertSelective(Face record);

    Face selectByPrimaryKey(Integer stuId);

    int updateByPrimaryKeySelective(Face record);

    int updateByPrimaryKeyWithBLOBs(Face record);

    List<Face> selectAll();

    List<FaceDto> selectAllInfo();

    List<FaceDto> search(String keyword);
}