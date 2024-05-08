package com.wq.controller;


import com.atguigu.model.system.SysMenu;
import com.wq.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author 王骞
 * @since 2023-08-11
 */
@RestController
@RequestMapping("/sysMenu")
public class SysMenuController {
    @Autowired
    private ISysMenuService sysMenuService;

    /**
     * 获取全部菜单
     * @return
     */
    @GetMapping("/getAll")
    public List<SysMenu> getAll() {
        return sysMenuService.getAll();
    }

    /**
     * 添加菜单
     */
    @PostMapping("/save")
    public void add(@RequestBody SysMenu sysMenu) {
        sysMenuService.add(sysMenu);
    }

    /**
     * 修改 菜单
     */
    @PutMapping("/update")
    public void edit(@RequestBody SysMenu sysMenu) {
        sysMenuService.update(sysMenu);
    }

    /**
     * 删除 菜单
     */
    @DeleteMapping("/remove")
    public void remove(@RequestBody SysMenu sysMenu) {
        sysMenuService.remove(sysMenu);
    }


    /**
     * 根据角色id获取菜单列表
     */
    @GetMapping("/{roleId}")
    public List<SysMenu> getSysMenuListByRoleId(@PathVariable("roleId") Long userId) {
        return sysMenuService.getSysMenuListByUserId(userId);
    }


}

