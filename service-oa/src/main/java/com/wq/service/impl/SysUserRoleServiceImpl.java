package com.wq.service.impl;


import com.atguigu.model.system.SysUserRole;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wq.mapper.SysUserRoleMapper;
import com.wq.pojo.req.UpdateUserRoleReq;
import com.wq.pojo.rsp.GetUserRolesRsp;
import com.wq.service.ISysUserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户角色 服务实现类
 * </p>
 *
 * @author 王骞
 * @since 2023-08-04
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements ISysUserRoleService {

    @Override
    public List<GetUserRolesRsp> getUserRoles(final Long valueOf) {

        List<GetUserRolesRsp> sysUserRoles = baseMapper.selectList(new LambdaQueryWrapper<SysUserRole>()
                .eq(SysUserRole::getUserId, valueOf)
                .select(SysUserRole::getId))
                .stream().map(
                        userRole -> {
                            GetUserRolesRsp getUserRolesRsp = new GetUserRolesRsp();
                            getUserRolesRsp.setRoleId(userRole.getId());
                            return getUserRolesRsp;
                        }
                ).collect(Collectors.toList());
        return sysUserRoles;
    }

    @Override
    public void updateUserRole(UpdateUserRoleReq req) {
        // 查询是否有 userId 对应的数据
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", req.getUserId());
        List<SysUserRole> existingUserRoles = baseMapper.selectList(queryWrapper);
        if (existingUserRoles.isEmpty()) {
            // 如果没有对应的数据，直接添加 userId 对应的关系 sysRoleIds
            addNewUserRoles(req);
        } else {
            // 如果有对应的数据，先删除 userId 对应的数据，再添加 userId 对应的关系 sysRoleIds
            deleteExistingUserRoles(req);
            addNewUserRoles(req);
        }
    }

    private void addNewUserRoles(UpdateUserRoleReq req) {
        if (!req.getSysRoleIds().isEmpty()) {
            for (String roleId : req.getSysRoleIds()) {
                SysUserRole userRole = new SysUserRole();
                userRole.setRoleId(Long.parseLong(roleId));
                userRole.setUserId(Long.parseLong(req.getUserId()));
                baseMapper.insert(userRole);
            }
        }
    }

    private void deleteExistingUserRoles(UpdateUserRoleReq req) {
        QueryWrapper<SysUserRole> deleteWrapper = new QueryWrapper<>();
        deleteWrapper.eq("user_id", req.getUserId());
        baseMapper.delete(deleteWrapper);
    }
}

