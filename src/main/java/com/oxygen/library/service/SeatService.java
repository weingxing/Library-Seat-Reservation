package com.oxygen.library.service;

import com.github.pagehelper.PageInfo;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.dto.SeatInfo;
import com.oxygen.library.entity.Seat;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public interface SeatService {

    public boolean addSeat(Seat seat) throws Exception;

    public boolean deleteSeat(int sid) throws Exception;

    public boolean updateSeat(Seat seat) throws Exception;

    public PageInfo<SeatInfo> getSeatByPage(PageRequest request) throws Exception;

    public List<Seat> getSeatByLid(int lid) throws Exception;

    public Seat getSeatByPosAndLid(Map<String, Object> param) throws Exception;

    public Seat getSeatBySid(int sid) throws Exception;

    public SeatInfo getSeatInfoBySid(int sid) throws Exception;

    public List<Seat> getAllSeat() throws Exception;

    public PageInfo<SeatInfo> search(PageRequest request, String keyword) throws Exception;

    public CompletableFuture<Boolean> batchAdd(String path) throws Exception;
}
