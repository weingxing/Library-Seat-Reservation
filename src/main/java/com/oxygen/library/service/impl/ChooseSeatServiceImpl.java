package com.oxygen.library.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oxygen.library.dao.ChooseSeatMapper;
import com.oxygen.library.dto.ChooseSeatInfo;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.entity.ChooseSeat;
import com.oxygen.library.service.ChooseSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChooseSeatServiceImpl implements ChooseSeatService {
    @Autowired
    private ChooseSeatMapper chooseSeatMapper;

    @Override
    public boolean addChooseSeat(ChooseSeat chooseSeat) throws Exception {
        return chooseSeatMapper.insert(chooseSeat) > 0;
    }

    @Override
    public boolean deleteChooseSeat(int cid) throws Exception {
        return chooseSeatMapper.deleteByPrimaryKey(cid) > 0;
    }

    @Override
    public boolean updateChooseSeat(ChooseSeat chooseSeat) throws Exception {
        return chooseSeatMapper.updateByPrimaryKeySelective(chooseSeat) > 0;
    }

    @Override
    public PageInfo<ChooseSeatInfo> getChooseSeatInfoByPage(PageRequest request) throws Exception {
        int pageNum = request.getPageNum();
        int pageSize = request.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
//        System.out.println(123456);
        List<ChooseSeatInfo> content = chooseSeatMapper.selectAll();
        return new PageInfo<ChooseSeatInfo>(content);
    }

    @Override
    public List<ChooseSeat> getChooseSeatByStuId(int id) throws Exception {
        return chooseSeatMapper.selectByStuId(id);
    }

    @Override
    public ChooseSeat getByCid(int cid) throws Exception {
        return chooseSeatMapper.selectByPrimaryKey(cid);
    }

    @Override
    public int getTodayCount(String keyword) throws Exception {
        return chooseSeatMapper.selectTodayCount("%"+keyword+"%");
    }

    @Override
    public List<ChooseSeat> getToday(String keyword) throws Exception {
        return chooseSeatMapper.selectToday(keyword);
    }

    @Override
    public PageInfo<ChooseSeatInfo> search(PageRequest request, String keyword) throws Exception {
        int pageNum = request.getPageNum();
        int pageSize = request.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<ChooseSeatInfo> content = chooseSeatMapper.search("%"+keyword+"%");
        return new PageInfo<ChooseSeatInfo>(content);
    }

    @Override
    public ChooseSeatInfo getChooseSeatInfoByCid(int cid) throws Exception {
        return chooseSeatMapper.selectChooseSeatInfoByPrimaryKey(cid);
    }
}
