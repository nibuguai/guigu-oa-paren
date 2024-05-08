package com.wq.controller;


import com.wq.pojo.req.UpdateUserRoleReq;
import com.wq.pojo.rsp.GetUserRolesRsp;
import com.wq.service.ISysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户角色 前端控制器
 * </p>
 *
 * @author 王骞
 * @since 2023-08-04
 */
@RestController
@RequestMapping("/sysUserRole")
public class SysUserRoleController {
    @Autowired
    private ISysUserRoleService sysUserRoleService;

    /**
     * 查询用户对应的角色
     * @param userId
     * @return
     */
    @GetMapping("/getUserRoleList/{userId}")
    public List<GetUserRolesRsp> getUserRoleList(@PathVariable("userId") String userId) {
        return sysUserRoleService.getUserRoles(Long.valueOf(userId));
    }

    /**
     * 更新用户对应 的角色
     */
    @PostMapping("/updateUserRole")
    public void updateUserRole(@RequestBody UpdateUserRoleReq updateUserRoleReq) {
        sysUserRoleService.updateUserRole(updateUserRoleReq);
    }



}

