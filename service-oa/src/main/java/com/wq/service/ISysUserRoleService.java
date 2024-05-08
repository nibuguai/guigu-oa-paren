package com.wq.service;


import com.atguigu.model.system.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wq.pojo.req.UpdateUserRoleReq;
import com.wq.pojo.rsp.GetUserRolesRsp;

import java.util.List;

/**
 * <p>
 * 用户角色 服务类
 * </p>
 *
 * @author 王骞
 * @since 2023-08-04
 */
public interface ISysUserRoleService extends IService<SysUserRole> {

    List<GetUserRolesRsp> getUserRoles(Long valueOf);

    void updateUserRole(UpdateUserRoleReq updateUserRoleReq);
}
