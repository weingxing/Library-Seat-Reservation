package com.oxygen.library.service.impl;

import com.arcsoft.face.FaceInfo;
import com.arcsoft.face.toolkit.ImageFactory;
import com.arcsoft.face.toolkit.ImageInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.oxygen.library.dao.FaceMapper;
import com.oxygen.library.dto.FaceDto;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.entity.Face;
import com.oxygen.library.service.FaceEngineService;
import com.oxygen.library.service.FaceService;
import com.oxygen.library.util.ZipUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class FaceServiceImpl implements FaceService {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(FaceServiceImpl.class);
    @Autowired
    private FaceMapper faceMapper;
    @Autowired
    private FaceEngineService faceEngineService;
    @Value("${common.upload}")
    private String uploadPath;

    @Override
    public boolean add(Face face) throws Exception {
        return faceMapper.insert(face) > 0;
    }

    @Override
    public boolean delete(int stuId) throws Exception {
        return faceMapper.deleteByPrimaryKey(stuId) > 0;
    }

    @Override
    @Async
    public CompletableFuture<Boolean> batchAdd(String path) throws Exception {
        String desc = null;
        if (uploadPath.substring(uploadPath.length()-1, uploadPath.length()).equals("/"))
            desc = uploadPath+"unzip/";
        else
            desc = uploadPath+"/unzip/";
        List<String> pics = ZipUtil.unZipFiles(path, desc);

        Face face = new Face();
        for (String pic : pics) {
            File file = new File(pic);
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] buffer = new byte[51200];
            while ((len = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            byte[] data = bos.toByteArray();
            fis.close();
            bos.close();
            ImageInfo imageInfo = ImageFactory.getRGBData(data);
            List<FaceInfo> faceInfoList = faceEngineService.detectFaces(imageInfo);
            FaceInfo faceInfo = null;
            if (faceInfoList.size() > 0) {
                faceInfo = faceInfoList.get(0);
                byte[] feature = faceEngineService.extractFaceFeature(imageInfo, faceInfo);
                face.setFaceId(feature);
                String[] f = pic.split("/");
                String filename = f[f.length-1];
                face.setStuId(Integer.parseInt(filename.substring(0, filename.length()-4)));
                if (faceMapper.insert(face) > 0) {
                    log.info("添加成功"+pic);
                    file.delete();
                } else
                    log.info("添加失败"+pic);
            }
        }
        return CompletableFuture.completedFuture(true);
    }

    @Override
    public PageInfo<FaceDto> getAllByPage(PageRequest request) throws Exception {
        int pageNum = request.getPageNum();
        int pageSize = request.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<FaceDto> content = faceMapper.selectAllInfo();
        List<FaceDto> data = new ArrayList<>();
        for (FaceDto c : content) {
            if (c.getFaceId() == null)
                c.setHaveFaceId("否");
            else {
                c.setHaveFaceId("是");
                c.setFaceId(null);
            }
            data.add(c);
        }
        return new PageInfo<>(data);
    }

    @Override
    public PageInfo<FaceDto> search(PageRequest request, String keyword) throws Exception {
        int pageNum = request.getPageNum();
        int pageSize = request.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<FaceDto> content = faceMapper.search("%"+keyword+"%");
        List<FaceDto> data = new ArrayList<>();
        for (FaceDto c : content) {
            if (c.getFaceId() == null)
                c.setHaveFaceId("否");
            else {
                c.setHaveFaceId("是");
                c.setFaceId(null);
            }
            data.add(c);
        }
        return new PageInfo<>(data);
    }
}
