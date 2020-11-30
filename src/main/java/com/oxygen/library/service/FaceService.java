package com.oxygen.library.service;

import com.github.pagehelper.PageInfo;
import com.oxygen.library.dto.FaceDto;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.entity.Face;

import java.util.concurrent.CompletableFuture;

public interface FaceService {
    public boolean add(Face face) throws Exception;

    public boolean delete(int stuId) throws Exception;

    public CompletableFuture<Boolean> batchAdd(String path) throws Exception;

    public PageInfo<FaceDto> getAllByPage(PageRequest request) throws Exception;

    public PageInfo<FaceDto> search(PageRequest request, String keyword) throws Exception;
}
