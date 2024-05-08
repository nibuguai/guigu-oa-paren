package com.wq.service.impl;

import com.atguigu.model.system.SysRoleMenu;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wq.mapper.SysRoleMenuMapper;
import com.wq.pojo.req.UpdateRoleMenuReq;
import com.wq.service.ISysRoleMenuService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 角色菜单 服务实现类
 * </p>
 *
 * @author 王骞
 * @since 2023-08-15
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements ISysRoleMenuService {

    @Override
    public void addRoleMenu(final SysRoleMenu sysRoleMenu) {
        baseMapper.insert(sysRoleMenu);
    }

    @Override
    public void removeRoleMenu(final Long roleId) {
        baseMapper.delete(Wrappers.<SysRoleMenu>lambdaUpdate().eq(SysRoleMenu::getRoleId, roleId));
    }
    @Transactional
    @Override
    public void updateRoleMenuReq(final UpdateRoleMenuReq updateRoleMenuReq) {
        removeRoleMenu(Long.parseLong(updateRoleMenuReq.getRoleId()));
        String roleId = updateRoleMenuReq.getRoleId();
        List<String> menuIds = updateRoleMenuReq.getMenuIds();
        menuIds.stream()
                .map(menuId -> {
                    SysRoleMenu sysRoleMenu = new SysRoleMenu();
                    sysRoleMenu.setRoleId(Long.parseLong(roleId));
                    sysRoleMenu.setMenuId(Long.parseLong(menuId));
                    return sysRoleMenu;
                })
                .forEach(this::addRoleMenu);
    }
}
