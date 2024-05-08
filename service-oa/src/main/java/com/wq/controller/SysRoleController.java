package com.wq.controller;


import com.atguigu.model.system.SysRole;
import com.wq.pojo.req.RoleQueryVoReq;
import com.wq.pojo.rsp.SysRoleVoRsp;
import com.wq.service.ISysRoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author 王骞
 * @since 2023-06-28
 */
@RestController
@RequestMapping("/sysRole")
@Slf4j
public class SysRoleController {
    @Autowired
    private ISysRoleService sysRoleService;

    /**
     * 此接口欧支持条件查询，支持分页。
     * 支持查询指定id的数据。
     */
    @PostMapping("/roleQuery")
    public SysRoleVoRsp roleQuery(@RequestBody RoleQueryVoReq roleQueryVoReq){
        log.info("进入接口：{}",roleQueryVoReq);
        return sysRoleService.roleQuery(roleQueryVoReq);
    }

    /**
     * 删除||批量删除
     */
    @DeleteMapping("/{ids}")
    public void deleteRoles(@PathVariable("ids")String ids) {
        sysRoleService.deleteRoles(ids);
    }

    /**
     * 增加或者修改接口
     */
    @PostMapping("/role")
    public void renewalRole(@RequestBody SysRole sysRole) {
        sysRoleService.renewalRole(sysRole);
    }



}

