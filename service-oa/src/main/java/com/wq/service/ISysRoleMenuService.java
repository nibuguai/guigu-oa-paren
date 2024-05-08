package com.wq.service;

import com.atguigu.model.system.SysRoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wq.pojo.req.UpdateRoleMenuReq;

/**
 * <p>
 * 角色菜单 服务类
 * </p>
 *
 * @author 王骞
 * @since 2023-08-15
 */
public interface ISysRoleMenuService extends IService<SysRoleMenu> {

    void addRoleMenu(SysRoleMenu sysRoleMenu);

    void removeRoleMenu(Long roleId);

    void updateRoleMenuReq(UpdateRoleMenuReq updateRoleMenuReq);

}
