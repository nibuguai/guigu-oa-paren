package com.wq.util;

import com.atguigu.model.system.SysMenu;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 王骞
 * @Date 2023/8/16 13:47
 * @Version 1.0
 */
@Slf4j
public class GetMenuListUtil {

    public static List<SysMenu> getMenuList(List<SysMenu> menus) {
        List<SysMenu> sysMenus = new ArrayList<>();
        // 以parent_id为0的菜单作为顶级菜单
        for (SysMenu menu : menus) {
            if (menu.getParentId() == 0) {
                sysMenus.add(menu);
                setChildren(menu, menus);
            }
        }
        return sysMenus;
    }

    /**
     * 递归 将子节点数据填充至菜单
     * @param parentMenu
     * @param allMenus
     */
    private static void setChildren(SysMenu parentMenu, List<SysMenu> allMenus) {
        List<SysMenu> children = new ArrayList<>();
        for (SysMenu menu : allMenus) {
            if (menu.getParentId().equals(parentMenu.getId())) {
                children.add(menu);
                setChildren(menu, allMenus);
            }
        }
        parentMenu.setChildren(children);
    }
}
