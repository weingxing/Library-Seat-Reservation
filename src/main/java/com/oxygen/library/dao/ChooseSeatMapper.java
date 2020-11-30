package com.oxygen.library.dao;

import com.oxygen.library.dto.ChooseSeatInfo;
import com.oxygen.library.entity.ChooseSeat;

import java.util.List;

public interface ChooseSeatMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(ChooseSeat record);

    int insertSelective(ChooseSeat record);

    ChooseSeat selectByPrimaryKey(Integer cid);

    ChooseSeatInfo selectChooseSeatInfoByPrimaryKey(Integer cid);

    List<ChooseSeatInfo> selectAll();

    List<ChooseSeat> selectByStuId(Integer id);

    int updateByPrimaryKeySelective(ChooseSeat record);

    int updateByPrimaryKey(ChooseSeat record);

    int selectTodayCount(String keyword);

    List<ChooseSeat> selectToday(String keyword);

    List<ChooseSeatInfo> search(String keyword);
}