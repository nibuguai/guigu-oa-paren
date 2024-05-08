package com.wq.controller;


import com.atguigu.model.system.SysRoleMenu;
import com.wq.pojo.req.UpdateRoleMenuReq;
import com.wq.service.ISysRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色菜单 前端控制器
 * </p>
 *
 * @author 王骞
 * @since 2023-08-15
 */
@RestController
@RequestMapping("/sysRoleMenu")
public class SysRoleMenuController {
    @Autowired
    private ISysRoleMenuService sysMenuService;

    /**
     * 给角色添加菜单
     */
    @PostMapping("/addRoleMenu")
    public void addRoleMenu(@RequestBody SysRoleMenu sysRoleMenu) {
        sysMenuService.addRoleMenu(sysRoleMenu);
    }
    /**
     * 删除 角色所有菜单
     */
    @DeleteMapping("/{roleId}")
    public void removeRoleMenu(@PathVariable("roleId") Long roleId) {
        sysMenuService.removeRoleMenu(roleId);
    }
    /**
     * 修改角色所有菜单
     */
    @PutMapping("/updateRoleMenu")
    public void updateRoleMenu(@RequestBody UpdateRoleMenuReq updateRoleMenuReq) {
        sysMenuService.updateRoleMenuReq(updateRoleMenuReq);
    }




}

