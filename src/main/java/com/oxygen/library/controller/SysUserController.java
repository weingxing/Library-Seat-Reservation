package com.oxygen.library.controller;

import com.github.pagehelper.PageInfo;
import com.oxygen.library.dto.LayuiPage;
import com.oxygen.library.dto.PageRequest;
import com.oxygen.library.dto.Response;
import com.oxygen.library.entity.SysUser;
import com.oxygen.library.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    @PostMapping("/update")
    public Response update(@RequestBody SysUser user) throws Exception {
        return new Response(200, "OK", sysUserService.updateSysUser(user));
    }

    @PostMapping("/add")
    public Response add(@RequestBody SysUser user) throws Exception {
        return new Response(200, "OK", sysUserService.addSysUser(user));
    }

    @DeleteMapping(value = "/delete", params = {"uid"})
    public Response delete(int uid) throws Exception {
        return new Response(200, "OK", sysUserService.deleteSysUserByUid(uid));
    }

    @GetMapping(value = "/getUserByPage", params = {"page", "limit"})
    public LayuiPage getUserByPage(int page, int limit) throws Exception {
        PageRequest request = new PageRequest(page, limit);
        PageInfo<SysUser> p = sysUserService.getSysUserByPage(request);
        return new LayuiPage(0, "", p.getTotal(), p.getList());
    }
}
