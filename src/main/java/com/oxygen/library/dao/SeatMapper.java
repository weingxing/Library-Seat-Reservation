package com.oxygen.library.dao;

import com.oxygen.library.dto.SeatInfo;
import com.oxygen.library.entity.Seat;

import java.util.List;
import java.util.Map;

public interface SeatMapper {
    int deleteByPrimaryKey(Integer sid);

    int insert(Seat record);

    int insertSelective(Seat record);

    Seat selectByPrimaryKey(Integer sid);

    SeatInfo selectSeatInfoBySid(Integer sid);

    Seat selectByLidAndPos(Map<String, Object> param);

    List<SeatInfo> selectAll();

    List<Seat> selectByLid(Integer lid);

    List<Seat> selectAllSeat();

    int updateByPrimaryKeySelective(Seat record);

    int updateByPrimaryKey(Seat record);

    List<SeatInfo> search(String keyword);

}