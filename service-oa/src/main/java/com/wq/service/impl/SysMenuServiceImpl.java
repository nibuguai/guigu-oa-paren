package com.wq.service.impl;

import com.atguigu.model.system.SysMenu;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wq.common.exception.CustomException;
import com.wq.mapper.SysMenuMapper;
import com.wq.service.ISysMenuService;
import com.wq.util.GetMenuListUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author 王骞
 * @since 2023-08-11
 */
@Service
@Slf4j
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Override
    public List<SysMenu> getAll() {
        List<SysMenu> sysMenus = baseMapper.selectList(null);
        return GetMenuListUtil.getMenuList(sysMenus);
    }

    @Override
    public void add(final SysMenu sysMenu) {
        baseMapper.insert(sysMenu);
    }

    @Override
    public void update(final SysMenu sysMenu) {
        baseMapper.updateById(sysMenu);
    }

    @Override
    public void remove(final SysMenu sysMenu) {
        if (sysMenu== null) return;
            List<SysMenu> sysMenus = baseMapper.selectList(new QueryWrapper<SysMenu>().lambda().eq(SysMenu::getParentId, sysMenu.getId()));
            if (sysMenus.size() > 1) {
                throw  CustomException.error("存在子节点,不允许删除!");
            }
        baseMapper.deleteById(sysMenu.getId());
    }

    /**
     *
     * @param userId
     * @return
     */
    @Override
    public List<SysMenu> getSysMenuListByUserId(final Long userId) {
        List<SysMenu> sysMenuListByUserId = baseMapper.getSysMenuListByUserId(userId);
        log.info("获取用户菜单列表：{}", sysMenuListByUserId);
        return GetMenuListUtil.getMenuList(sysMenuListByUserId);
    }


}
