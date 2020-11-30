package com.oxygen.library.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oxygen.library.dao.SeatMapper;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.dto.SeatInfo;
import com.oxygen.library.entity.Seat;
import com.oxygen.library.service.SeatService;
import com.oxygen.library.util.ExcelReaderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class SeatServiceImpl implements SeatService {
    @Autowired
    private SeatMapper seatMapper;

    @Override
    public boolean addSeat(Seat seat) throws Exception {
        return seatMapper.insert(seat) > 0;
    }

    @Override
    public boolean deleteSeat(int sid) throws Exception {
        return seatMapper.deleteByPrimaryKey(sid) > 0;
    }

    @Override
    public boolean updateSeat(Seat seat) throws Exception {
        return seatMapper.updateByPrimaryKeySelective(seat) > 0;
    }

    @Override
    public PageInfo<SeatInfo> getSeatByPage(PageRequest request) throws Exception {
        int pageNum = request.getPageNum();
        int pageSize = request.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<SeatInfo> content = seatMapper.selectAll();
        return new PageInfo<SeatInfo>(content);
    }

    @Override
    public List<Seat> getSeatByLid(int lid) throws Exception {
        return seatMapper.selectByLid(lid);
    }

    @Override
    public Seat getSeatByPosAndLid(Map<String, Object> param) throws Exception {
        return seatMapper.selectByLidAndPos(param);
    }

    @Override
    public Seat getSeatBySid(int sid) throws Exception {
        return seatMapper.selectByPrimaryKey(sid);
    }

    @Override
    public SeatInfo getSeatInfoBySid(int sid) throws Exception {
        return seatMapper.selectSeatInfoBySid(sid);
    }

    @Override
    public List<Seat> getAllSeat() throws Exception {
        return seatMapper.selectAllSeat();
    }

    @Override
    public PageInfo<SeatInfo> search(PageRequest request, String keyword) throws Exception {
        int pageNum = request.getPageNum();
        int pageSize = request.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<SeatInfo> content = seatMapper.search("%"+keyword+"%");
        return new PageInfo<SeatInfo>(content);
    }

    @Override
    @Async
    public CompletableFuture<Boolean> batchAdd(String path) throws Exception {
        // 读取Excel数据
        List<List<String>> lists = ExcelReaderUtil.readExcel(path);
        //解析插入到数据库
        Seat seat = new Seat();
        if (lists == null)
            return CompletableFuture.completedFuture(false);
        for (List<String> list : lists.subList(1, lists.size())) {
            seat.setLid(Integer.parseInt(list.get(0)));
            seat.setPositio(list.get(1));
            seat.setStatus(list.get(2));
            seat.setAvailable("1");
            seatMapper.insert(seat);
        }
        return CompletableFuture.completedFuture(true);
    }
}
