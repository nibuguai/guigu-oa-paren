package com.wq.service;

import com.atguigu.model.system.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author 王骞
 * @since 2023-08-11
 */
public interface ISysMenuService extends IService<SysMenu> {

    List<SysMenu> getAll();

    void add(SysMenu sysMenu);

    void update(SysMenu sysMenu);

    void remove(SysMenu sysMenu);

    List<SysMenu> getSysMenuListByUserId(Long userId);
}
