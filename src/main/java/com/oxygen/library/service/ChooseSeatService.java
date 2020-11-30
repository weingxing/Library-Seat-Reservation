package com.oxygen.library.service;

import com.github.pagehelper.PageInfo;
import com.oxygen.library.dto.ChooseSeatInfo;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.entity.ChooseSeat;

import java.util.List;

public interface ChooseSeatService {

    public boolean addChooseSeat(ChooseSeat chooseSeat) throws Exception;

    public boolean deleteChooseSeat(int cid) throws Exception;

    public boolean updateChooseSeat(ChooseSeat chooseSeat) throws Exception;

    public PageInfo<ChooseSeatInfo> getChooseSeatInfoByPage(PageRequest request) throws Exception;

    public List<ChooseSeat> getChooseSeatByStuId(int id) throws Exception;

    public ChooseSeat getByCid(int cid) throws Exception;

    public int getTodayCount(String keyword) throws Exception;

    public List<ChooseSeat> getToday(String keyword) throws Exception;

    public PageInfo<ChooseSeatInfo> search(PageRequest request, String keyword) throws Exception;

    public ChooseSeatInfo getChooseSeatInfoByCid(int cid) throws Exception;
}
