package com.wq.controller;


import com.wq.pojo.req.GetUserListReq;
import com.wq.pojo.rsp.GetUserListVoRsp;
import com.wq.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author 王骞
 * @since 2023-08-04
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    @Autowired
    private ISysUserService sysUserService;

    /**
     * 获取 用户列表信息
     * @param getUserListReq
     * @return
     */
    @PostMapping("/getUserList")
    public GetUserListVoRsp getUserList(@RequestBody GetUserListReq getUserListReq) {
        return sysUserService.getUserList(getUserListReq);
    }








}

