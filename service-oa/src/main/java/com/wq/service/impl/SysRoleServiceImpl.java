package com.wq.service.impl;


import com.atguigu.model.system.SysRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.cj.util.StringUtils;
import com.wq.mapper.SysRoleMapper;
import com.wq.pojo.req.RoleQueryVoReq;
import com.wq.pojo.rsp.SysRoleVoRsp;
import com.wq.service.ISysRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author 王骞
 * @since 2023-06-28
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Override
    public SysRoleVoRsp roleQuery(final RoleQueryVoReq roleQueryVoReq) {
        SysRoleVoRsp sysRoleVoRsp = new SysRoleVoRsp();
        LambdaQueryWrapper<SysRole> objectLambdaQueryWrapper = new LambdaQueryWrapper<>();
        objectLambdaQueryWrapper.like(!StringUtils.isNullOrEmpty(roleQueryVoReq.getRoleName()), SysRole::getRoleName, roleQueryVoReq.getRoleName())
                .like(!StringUtils.isNullOrEmpty(roleQueryVoReq.getRoleCode()), SysRole::getRoleCode, roleQueryVoReq.getRoleCode())
                .like(!StringUtils.isNullOrEmpty(roleQueryVoReq.getDescription()), SysRole::getDescription, roleQueryVoReq.getDescription())
                .eq(roleQueryVoReq.getId() != null, SysRole::getId, roleQueryVoReq.getId());
        List<SysRole> sysRoles;
        int pageNo = roleQueryVoReq.getPage();
        int pageSize = roleQueryVoReq.getLimit();
        if (pageNo > 0 && pageSize > 0) {
            Page<SysRole> sysRolePage = new Page<>();
            sysRolePage.setSize(pageSize);
            sysRolePage.setCurrent(pageNo);
            sysRolePage = baseMapper.selectPage(sysRolePage, objectLambdaQueryWrapper);
            sysRoles = sysRolePage.getRecords();
            long total = sysRolePage.getTotal();
            sysRoleVoRsp.setTotal(total);
        } else {
            sysRoles = baseMapper.selectList(objectLambdaQueryWrapper);
        }
        sysRoleVoRsp.setSysRoles(sysRoles);
        return sysRoleVoRsp;
    }

    @Transactional
    @Override
    public void deleteRoles(final String ids) {
        String[] roleArray = ids.split(",");
        for (String id : roleArray) {
            baseMapper.deleteById(id);
        }
    }

    @Override
    public void renewalRole(final SysRole sysRole) {
        if (sysRole.getId() != null) {
            baseMapper.updateById(sysRole);
        } else {
            baseMapper.insert(sysRole);
        }
    }
}
