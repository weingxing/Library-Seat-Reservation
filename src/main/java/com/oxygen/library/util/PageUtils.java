package com.oxygen.library.util;

import com.github.pagehelper.PageInfo;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.dto.PageResult;

/**
 * 分页工具类
 * @author Oxygen
 * @since 2020/09/25
 */
public class PageUtils {
    /**
     * 将分页信息封装到统一的接口
     * @param pageRequest
     * @param pageInfo
     * @return
     */
    public static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setData(pageInfo.getList());
        return pageResult;
    }
}
