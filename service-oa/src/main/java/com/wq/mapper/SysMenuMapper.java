package com.wq.mapper;


import com.atguigu.model.system.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author 王骞
 * @since 2023-08-11
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> getSysMenuListByUserId(Long userId);
}
